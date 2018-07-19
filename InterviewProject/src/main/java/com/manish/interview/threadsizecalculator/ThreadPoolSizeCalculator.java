package com.manish.interview.threadsizecalculator;

import java.util.concurrent.*;

/**
 * @author manishkumar
 * @since 04/10/2017.
 */
public class ThreadPoolSizeCalculator {
	private final int size;
	private BlockingQueue<Runnable> mailQueue = new LinkedBlockingQueue<>();

	public ThreadPoolSizeCalculator(int n) {
		new ForkJoinPool().execute(new MyConsumer());
		size = n;
	}

	private void execute(ExecutorService executorService) {
		for (int i=0;i<size;i++){
			executorService.submit(new MyRunnable(i, mailQueue));
		}
		shutdownAndAwaitTermination(executorService);
	}
	private void shutdownAndAwaitTermination(ExecutorService pool) {
		pool.shutdown(); // Disable new tasks from being submitted
		try {
			// Wait a while for existing tasks to terminate
			while (!pool.awaitTermination(600, TimeUnit.SECONDS)) {
				Thread.sleep(60000);
			}
			pool.shutdownNow(); // Cancel currently executing tasks
		} catch (InterruptedException ie) {
			// (Re-)Cancel if current thread also interrupted
			pool.shutdownNow();
			// Preserve interrupt status
			Thread.currentThread().interrupt();
		}
		System.out.println("Job Completed");
	}

	private class MyConsumer extends RecursiveAction {
		@Override
		protected void compute() {
			Runnable runnable = null;
			try {
				runnable = mailQueue.take();
				new MyConsumer().fork().join();
				System.out.println("send");
				runnable.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();
		new ThreadPoolSizeCalculator(6000).execute(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1));
		System.out.println("Job Completed in : " + stopWatch.getElapsedTime() + "seconds");
	}
}

