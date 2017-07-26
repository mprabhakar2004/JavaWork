package com.home.threadsizecalculator;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author manishkumar
 * @since 04/10/2017.
 */
public class MyPoolSizeCalculator extends PoolSizeCalculator {
	public static void main(String[] args) throws InterruptedException,
			InstantiationException,
			IllegalAccessException,
			ClassNotFoundException {
		MyPoolSizeCalculator calculator = new MyPoolSizeCalculator();
		calculator.calculateBoundaries(new BigDecimal(1.0),
				new BigDecimal(10000000));
	}

	protected long getCurrentThreadCPUTime() {
		return ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
	}

	protected Runnable creatTask() {
		BlockingQueue<Runnable> mailQueue = new LinkedBlockingQueue<>();
		return new MyRunnable(1, mailQueue);
	}

	protected BlockingQueue<Runnable> createWorkQueue() {
		return new LinkedBlockingQueue<>();
	}
}
