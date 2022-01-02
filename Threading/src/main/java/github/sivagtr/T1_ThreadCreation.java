package github.sivagtr;

/**
 * Thread Creation example
 *      1. With Extending Thread
 *      2. With Implements Runnable
 *      3. With Lambda
 */
class ThreadCreation {
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