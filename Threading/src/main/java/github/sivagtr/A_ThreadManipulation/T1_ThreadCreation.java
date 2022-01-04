package github.sivagtr.A_ThreadManipulation;
/**
 * ------------------------------------------------------------
 * <br>
 * Problem: Serial processing, doesn't utilize CPU fully.
 * <br>
 * Solution: Use Threading
 * <br>
 * <br>
 *     Thread Creation example
 *     <ol>
 *         <li>With Extending Thread</li>
 *         <li>With Implements Runnable</li>
 *         <li>With Lambda</li>
 *     </ol>
 *
 * ============================================================
 * <br>
 * Further Problem: Critical sections have issues.
 * <br>
 * ------------------------------------------------------------
 */

public class T1_ThreadCreation {
	public static void main(String... args){
		Thread t1 = new Thread(new ThreadCreationWithExtending());
		Thread t2 = new Thread(new ThreadWithImplements());
		t1.start();
		t2.start();

		new Thread(()->{
			Thread.currentThread().setName("With Implementing Runnable, Lambda");
			System.out.printf("[%s] : This is thread created with implements Runnable\n", Thread.currentThread().getName());
		}).start();
	}
}

class ThreadCreationWithExtending extends Thread{
	@Override
	public void run() {
		Thread.currentThread().setName("With Extending Thread");
		System.out.printf("[%s] : This is thread created with extending Thread class\n", Thread.currentThread().getName());
	}
}

class ThreadWithImplements implements Runnable{

	@Override
	public void run() {
		Thread.currentThread().setName("With Implementing Runnable");
		System.out.printf("[%s] : This is thread created with implements Runnable\n", Thread.currentThread().getName());
	}
}