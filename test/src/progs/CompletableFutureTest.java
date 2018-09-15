package progs;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {

	public static void main(String[] s) throws InterruptedException, ExecutionException {
		CompletableFuture result = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Knolders!";

		}).thenApply(name -> "Hello " + name).thenApply(greeting -> greeting + " Welcome to Knoldus Inc!")
				.thenAccept(n -> System.out.println(n + "byee"));

		result.get();
	}
}