package github.sivagtr;

/**
 * ------------------------------------------------------------
 * <p>
 * Problem: How to Avoid Intrinsic Locks (Monitor)
 * <br>
 * Solution: Create a separate Object for locking and use it for synchronization
 * </p>
 * ============================================================
 * <br>
 * Further Problem: NA
 * <br>
 * ------------------------------------------------------------
 */
public class T7_LockingWithCustomObject {
	private int counter1 = 0;
	private int counter2 = 0;

	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	public static void main(String[] args) {
		T7_LockingWithCustomObject monitor = new T7_LockingWithCustomObject();
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

	private void increment1() {
		synchronized(lock1) {
			System.out.println("Increment1 : " + counter1);
			try {
				Thread.sleep(10000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			counter1++;
		}
	}

	private void increment2() {
		synchronized(lock2) {
			System.out.println("Increment2 : " + counter2);
			counter2++;
		}
	}
}
