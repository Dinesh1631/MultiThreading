package ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        long start = System.currentTimeMillis();
        long result = pool.invoke(new ComputeSum(1, 1_000_000_000L));
        long end = System.currentTimeMillis();

        System.out.println("ForkJoin sum: " + result);
        System.out.println("Time: " + (end - start) + " ms");

        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (long i = 1; i <= 1000000000; i++)
            sum += i;
        System.out.println("Normal sum : " + sum);
        long endTime = System.currentTimeMillis();
        System.out.println("Normal Loop Time Taken: " + (endTime - startTime) + " ms");
        pool.shutdown();
    }
}

class ComputeSum extends RecursiveTask<Long> {
    private static final long THRESHOLD = 10_000_000;
    private final long start, end;

    ComputeSum(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }

        long mid = (start + end) >>> 1;

        ComputeSum left = new ComputeSum(start, mid);
        ComputeSum right = new ComputeSum(mid + 1, end);

        left.fork(); // fork one
        long rightResult = right.compute(); // compute one
        long leftResult = left.join();

        return leftResult + rightResult;
    }
}
