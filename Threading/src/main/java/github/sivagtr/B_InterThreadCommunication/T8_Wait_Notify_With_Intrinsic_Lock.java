package github.sivagtr.B_InterThreadCommunication;
/**
 * ------------------------------------------------------------
 * <br>
 * Problem: How to communicate with other threads.
 * <br>
 * Solution: Using Wait/Notify
 *
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
 * Further Problem: Intrinsic lock.
 * <br>
 * ------------------------------------------------------------
 */
public class T8_Wait_Notify_With_Intrinsic_Lock {

	public static void main(String[] args) {
		T8_Wait_Notify_With_Intrinsic_Lock wait_notify = new T8_Wait_Notify_With_Intrinsic_Lock();
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
		synchronized(this) {
			System.out.println("Before Wait in WaitingMethod..");
			wait();
			System.out.println("After Wait.. Executing Further Steps");
		}
	}

	private void NotifyMethod() throws InterruptedException {
		Thread.sleep(1000); // To make sure that this is called after Waiting Method.
		synchronized(this) {
			System.out.println("Before Notify in NotifyMethod..");
			notify();
			System.out.println("Still this is executed, Lock not released until exiting of synchronized block");
			Thread.sleep(5000);
			System.out.println("Exiting NotifyMethod");
		}
	}
}
/**
 * Output:
 *
 * Before Wait in WaitingMethod..
 * Before Notify in NotifyMethod..
 * Still this is executed, Lock not released until exiting of synchronized block
 * Exiting NotifyMethod
 * After Wait.. Executing Further Steps
 */