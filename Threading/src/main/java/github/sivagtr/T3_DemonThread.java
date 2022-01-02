package github.sivagtr;

import static java.lang.Thread.sleep;

/**
 * Example for Demon Threads
 *
 * Demon Threads will get killed if there are no worker threads.
 */
class ThreadDemonTest {
	public static void main(String[] args) {
		ThreadDemonTest threadDemonTest = new ThreadDemonTest();
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
