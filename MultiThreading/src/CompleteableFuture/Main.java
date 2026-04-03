package CompleteableFuture;

import java.util.concurrent.CompletableFuture;

public class Main {

	public static void main(String[] args) {

		CompletableFuture<Integer> userIdFuture = login("dinesh");

		userIdFuture.thenCompose(userId -> fetchUserDetails(userId));

		// prevent JVM from exiting early
		sleep(4000);
	}

	// async login method
	static CompletableFuture<Integer> login(String username) {
		return CompletableFuture.supplyAsync(() -> {
			sleep(1000); // simulate DB / API call
			return 42; // userId
		});
	}

	// async fetch user details
	static CompletableFuture<String> fetchUserDetails(Integer userId) {
		return CompletableFuture.supplyAsync(() -> {
			sleep(2000); // simulate DB / API call
			return "user with id " + userId + " has name dinesh";
		});
	}

	static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
