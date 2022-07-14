package com.manish.interview.threadsizecalculator;

import java.util.concurrent.BlockingQueue;

/**
 * @author manishkumar
 * @since 04/10/2017.
 */
public class MyRunnable implements Runnable {
	private final int number;
	private BlockingQueue<Runnable> myMailler;

	public MyRunnable(int number) {
		this.number = number;
	}

	public MyRunnable(int number, BlockingQueue<Runnable> myMailler) {
		this.number = number;
		this.myMailler = myMailler;
	}

	@Override
	public void run() {
		runTask();
	}

	private void runTask() {
		waitForMe(15000, "Service Call");
		for (int i = 1; i <= 6; i++) {
			if (i % 2 == 0) {
				myMailler.offer(new Runnable() {
					@Override
					public void run() {
						waitForMe(600, "Sending Mail");
					}
				});
			} else {
				waitForMe(600, "Processing");
			}
		}
		waitForMe(10000,"Write to DB");
	}

	private void waitForMe(int waitTime, String completionMsg) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(completionMsg);
	}
}
