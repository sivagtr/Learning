package github.sivagtr.A_ThreadManipulation;

import java.util.stream.IntStream;


/**
 * ------------------------------------------------------------
 * <br>
 * Problem: How to execute statements after thread execution completed
 * <br>
 * Solution: Use Join, this waits for the thread to complete execution
 * <br>
 * <br>
 * The statements will be executed after certain thread completes execution.
 * ============================================================
 * <br>
 * Further Problem: NA
 * <br>
 * ------------------------------------------------------------
 */

public class T2_ThreadJoin {
	public static void main(String[] args) {
		T2_ThreadJoin main = new T2_ThreadJoin();
		main.exec();
	}

	private void exec() {
		/**
		 *      Thread w1 = new Thread(new Worker1());
		 * 		Thread w2 = new Thread(new Worker2());
		 * 		w1.start();
		 * 		w2.start();
		 * 		System.out.println("This will print immediately, Doesn't wait for worker threads to complete");
		 */
		Thread w1 = new Thread(new Worker1());
		Thread w2 = new Thread(new Worker2());
		w1.start();
		w2.start();
		try {
			w1.join(); // Waits for w1 to complete and execute next statements.
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Executing the next statements !!!!!");
	}

	class Worker1 implements Runnable {
		@Override
		public void run() {
			IntStream.range(1, 10).forEach(value -> {
				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("[%s] : Value : %d \n", Thread.currentThread().getName(), value);
			});
		}
	}

	class Worker2 implements Runnable {
		@Override
		public void run() {
			IntStream.range(100, 110).forEach(value -> {
				try {
					Thread.sleep(300);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("[%s] : Value : %d \n", Thread.currentThread().getName(), value);
			});
		}
	}
}
/**
 * Output:
 * [Thread-0] : Value : 1
 * [Thread-0] : Value : 2
 * [Thread-1] : Value : 100
 * [Thread-0] : Value : 3
 * [Thread-0] : Value : 4
 * [Thread-0] : Value : 5
 * [Thread-1] : Value : 101
 * [Thread-0] : Value : 6
 * [Thread-0] : Value : 7
 * [Thread-0] : Value : 8
 * [Thread-1] : Value : 102
 * [Thread-0] : Value : 9
 * Executing the next statements !!!!!
 * [Thread-1] : Value : 103
 * [Thread-1] : Value : 104
 * [Thread-1] : Value : 105
 * [Thread-1] : Value : 106
 * [Thread-1] : Value : 107
 * [Thread-1] : Value : 108
 * [Thread-1] : Value : 109
 */
