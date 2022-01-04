package github.sivagtr;

/**
 * ------------------------------------------------------------
 * <p>
 * Problem: Entire method have to be locked.
 * <br>
 * Solution: Have synchronized block to lock only critical sections
 * </p>
 * ============================================================
 * <br>
 * Further Problem:
 * <br>Still the lock is at object/class level, which will still wait for other thread to complete even when there is no dependency
 * <br>
 * ------------------------------------------------------------
 */

public class T6_SynchronizedBlock {
	private int counter1 = 0;
	private int counter2 = 0;

	public static void main(String[] args) {
		T6_SynchronizedBlock monitor = new T6_SynchronizedBlock();
		Thread t1 = new Thread(() -> {
			for(int i = 0; i < 100; i++) {
				monitor.increment1();
			}
		});
		Thread t2 = new Thread(() -> {
			for(int i = 0; i < 100; i++) {
				monitor.increment2();
			}
		});
		t1.start();
		t2.start();
	}

	/**
	 * Test 1:
	 * Remove synchronized keyword for any method and test
	 * <p>
	 * Test 2:
	 * Try changing the sleep value to 100ms and test
	 */

	private void increment1() {
		synchronized(this) {
			System.out.println("Increment1 : " + counter1);
			try {
				Thread.sleep(10000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			counter1++;
		}
	}

	/**
	 * synchronized(SynchronizedBlock.class){
	 *     // If it is static
	 * }
	 */
	private void increment2() {
		synchronized(this) {
			System.out.println("Increment2 : " + counter2);
			counter2++;
		}
	}
}
