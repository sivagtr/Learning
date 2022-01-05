package github.sivagtr.A_ThreadManipulation;

import static java.lang.Thread.sleep;
/**
 * ------------------------------------------------------------
 * <p>
 * Problem: Threading need to execute in background
 * <br>
 * Solution: Use demon thread flag to make thread execute in background
 * </p>
 * <br>
 * <p>
 *     Note: Demon Threads will get killed if there are no worker threads.
 * </p>
 * ============================================================
 * <br>
 * Further Problem: If there are NO Working threads, Demon threads will get killed
 * <br>
 * ------------------------------------------------------------
 */

public class T3_DemonThread {
	public static void main(String[] args) {
		T3_DemonThread threadDemonTest = new T3_DemonThread();
		threadDemonTest.exec();
	}

	private void exec() {
		Thread w1 = new Thread(new Worker1());
		Thread d1 = new Thread(new Demon1());
		d1.setDaemon(true);
		w1.start();
		d1.start();
		try {
			w1.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Demon will be killed after all worker threads are done...");
	}

	class Worker1 implements Runnable{
		@Override
		public void run() {
			try {
				sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("End of Worker Thread");
		}
	}
	class Demon1 implements  Runnable{
		@Override
		public void run() {
			while(true){
				try {
					sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Running Demon Thread...!!!");
			}
		}
	}
}
/**
 * Output:
 * Running Demon Thread...!!!
 * Running Demon Thread...!!!
 * Running Demon Thread...!!!
 * Running Demon Thread...!!!
 * Running Demon Thread...!!!
 * Running Demon Thread...!!!
 * Running Demon Thread...!!!
 * Running Demon Thread...!!!
 * Running Demon Thread...!!!
 * End of Worker Thread
 * Demon will be killed after all worker threads are done...
 */