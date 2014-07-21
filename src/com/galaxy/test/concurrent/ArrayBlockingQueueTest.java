package com.galaxy.test.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTest
{
	private static BlockingQueue<String> queue;
	
	public static void main(String[] args)
	{
		queue = new ArrayBlockingQueue<String>(2, true);
		
		Thread t1 = new Thread1(queue);
		Thread t2 = new Thread2(queue);
		
		t2.start();
		t1.start();
	}
	
	static class Thread1 extends Thread
	{
		private final BlockingQueue<String> queue;
		
		public Thread1(BlockingQueue<String> queue)
		{
			this.queue = queue;
		}
		
		@Override
		public void run()
		{
			for (int i = 0; i < 10; i++)
			{
				try
				{
					queue.put("" + i);
					System.out.println("put data: " + i);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	static class Thread2 extends Thread
	{
		private final BlockingQueue<String> queue;
		
		public Thread2(BlockingQueue<String> queue)
		{
			this.queue = queue;
		}
		
		@Override
		public void run()
		{
			for (int i = 0; i < 12; i++)
			{
				try
				{
					String data = queue.take();
					System.out.println("get data: " + data);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
