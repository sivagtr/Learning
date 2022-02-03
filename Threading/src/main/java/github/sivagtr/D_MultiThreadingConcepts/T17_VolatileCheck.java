package github.sivagtr.D_MultiThreadingConcepts;
/**
 * ------------------------------------------------------------
 * <br>
 * Problem: if there is a hot loop (No delay continuous infinite loop) during multi-threading, there is inconsistency during read and write of shared variables.
 * <br>
 * Solution: Using volatile can solve this.
 * <p>
 * Note:
 * <br>
 * Each Thread using different CPU's, each CPU uses its own cache inorder to reduce delay of reading the data from main memory.
 * <br>
 * If there are shared variables, the data will be accessed through cache especially during hot loop (No delay continuous infinite loop)
 * <br>
 * In such cases, the data will not be appropriate. Using volatile keyword, forces to always read/write from the main memory.
 * <br>
 * <br>
 * This has a major impact in the performance, however consistency is guaranteed.
 * </p>
 * ============================================================
 * <p>
 * Further Problem: Rearrangement of statements are performed during compilation and only volatile keyword is not sufficient.
 * </p>
 * ------------------------------------------------------------
 */
public class T17_VolatileCheck {

	/**
	 * Remove volatile keyword and test
	 */
	private static volatile int counter = 0;

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			int localCounter = counter;
			while(localCounter < 10) {
				if(localCounter != counter) {
					System.out.println("Thread 1: Counter changed, updating the counter" + counter);
					localCounter = counter;
				}
			}
		});
		Thread t2 = new Thread(() -> {
			int localCounter = counter;
			while(localCounter < 10) {
				counter = ++localCounter;
				System.out.println("Thread 2: Incrementing the counter" + counter);
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
}

/**
 * OUTPUT: WITH VOLATILE KEYWORD --- PROPER EXPECTED OUTPUT
 *
 * Thread 1: Counter changed, updating the counter1
 * Thread 2: Incrementing the counter1
 * Thread 2: Incrementing the counter2
 * Thread 1: Counter changed, updating the counter2
 * Thread 2: Incrementing the counter3
 * Thread 1: Counter changed, updating the counter3
 * Thread 2: Incrementing the counter4
 * Thread 1: Counter changed, updating the counter4
 * Thread 1: Counter changed, updating the counter5
 * Thread 2: Incrementing the counter5
 * Thread 1: Counter changed, updating the counter6
 * Thread 2: Incrementing the counter6
 * Thread 1: Counter changed, updating the counter7
 * Thread 2: Incrementing the counter7
 * Thread 2: Incrementing the counter8
 * Thread 1: Counter changed, updating the counter8
 * Thread 2: Incrementing the counter9
 * Thread 1: Counter changed, updating the counter9
 * Thread 1: Counter changed, updating the counter10
 * Thread 2: Incrementing the counter10
 *
 *
 *
 * WITHOUT VOLATILE
 *
 * Thread 1: Counter changed, updating the counter1
 * Thread 2: Incrementing the counter1
 * Thread 2: Incrementing the counter2
 * Thread 2: Incrementing the counter3
 * Thread 2: Incrementing the counter4
 * Thread 2: Incrementing the counter5
 * Thread 2: Incrementing the counter6
 * Thread 2: Incrementing the counter7
 * Thread 2: Incrementing the counter8
 * Thread 2: Incrementing the counter9
 * Thread 2: Incrementing the counter10
 *
 */