package github.sivagtr;

/**
 * ------------------------------------------------------------
 * <br>
 * Problem: How to communicate with other threads. Instead of intrinsic locks, we can use Object lock
 * <br>
 * Solution: Using Wait/Notify
 *
 * <br>
 * <br>
 * NOTE:
 * <ol>
 *     <li>Wait/Notify can be used only in the Synchronized Block or Method.</li>
 *     <li>Notify doesn't immediately release the access to other threads.</li>
 *     <li>All the statements in the synchronized block/method should be executed.</li>
 *     <li>Then control will notify the thread.</li>
 * </ol>
 * ============================================================
 * <br>
 * Further Problem: Same Object need to be used for Wait and Notify
 * <br>
 * ------------------------------------------------------------
 */
public class T9_Wait_Notify_With_Separate_Lock {

	private final Object lock = new Object();

	public static void main(String[] args) {
		T9_Wait_Notify_With_Separate_Lock wait_notify = new T9_Wait_Notify_With_Separate_Lock();
		Thread t1 = new Thread(() -> {
			try {
				wait_notify.WaitingMethod();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				wait_notify.NotifyMethod();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();
	}

	private void WaitingMethod() throws InterruptedException {
		synchronized(lock) {
			System.out.println("Before Wait in WaitingMethod..");
			lock.wait();
			System.out.println("After Wait.. Executing Further Steps");
		}
	}

	private void NotifyMethod() throws InterruptedException {
		Thread.sleep(1000); // To make sure that this is called after Waiting Method.
		synchronized(lock) {
			System.out.println("Before Notify in NotifyMethod..");
			lock.notify();
			System.out.println("Still this is executed, Lock not released until exiting of synchronized block");
			Thread.sleep(5000);
			System.out.println("Exiting NotifyMethod");
		}
	}
}
