package github.sivagtr.C_Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ------------------------------------------------------------
 * <br>
 * Problem: Implementation of tasks using Multithreading with Pool (Executors) -- Single Threaded
 * <br>
 * Solution: Use SingleThreadExecutor
 * <p>
 * Note:
 * <br>
 * A Single Thread is created. The same thread is used for executing all the tasks.
 * <br>
 * The application doesn't end, since Executors will be continuously running.
 * It creates the thread pool and waits so that it reduces expensive thread creation.
 * (Expensive: JVM need to create Thread Stack Memory and thread related operations).
 * So the executors must perform shutdown.
 *
 * <br>
 * If a Thread is killed, A new Thread will be automatically spawned and takes the work of that thread.
 * </p>
 * ============================================================
 * <p>
 * Further Problem: NA
 * </p>
 * ------------------------------------------------------------
 */
public class T13_SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for(int i = 0; i<10; i++){
			executorService.execute(new SingleThreadWorker(i));
		}

		/**
		 * Executors will be still running. The application doesn't exit
		 */
		executorService.shutdown();
	}
}
class SingleThreadWorker implements Runnable{
	private int id;

	public SingleThreadWorker(int id){
		this.id = id;
	}

	public void run(){
		System.out.printf("<<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is %d, Thread Name %s\n", id, Thread.currentThread().getName());
		long duration = (long) (Math.random() * 10);
		System.out.println("Duration: "+duration);
		/**
		 * Uncomment the code for:
		 * Testing of automatic creation of new thread and continue execution.
		 */
//		if(id == 1){
//			throw new NullPointerException();
//		}
		try {
			TimeUnit.SECONDS.sleep(duration); // Similar to Thread.sleep()
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf(">>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is %d, Thread Name %s\n", id, Thread.currentThread().getName());
	}
}
/**
 * Output:
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 0, Thread Name pool-1-thread-1
 * Duration: 7
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 0, Thread Name pool-1-thread-1
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 1, Thread Name pool-1-thread-1
 * Duration: 4
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 1, Thread Name pool-1-thread-1
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 2, Thread Name pool-1-thread-1
 * Duration: 1
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 2, Thread Name pool-1-thread-1
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 3, Thread Name pool-1-thread-1
 * Duration: 5
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 3, Thread Name pool-1-thread-1
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 4, Thread Name pool-1-thread-1
 * Duration: 8
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 4, Thread Name pool-1-thread-1
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 5, Thread Name pool-1-thread-1
 * Duration: 7
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 5, Thread Name pool-1-thread-1
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 6, Thread Name pool-1-thread-1
 * Duration: 8
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 6, Thread Name pool-1-thread-1
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 7, Thread Name pool-1-thread-1
 * Duration: 5
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 7, Thread Name pool-1-thread-1
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 8, Thread Name pool-1-thread-1
 * Duration: 8
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 8, Thread Name pool-1-thread-1
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 9, Thread Name pool-1-thread-1
 * Duration: 2
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 9, Thread Name pool-1-thread-1
 *
 *
 *
 * Output: If there is exception, Uncommented output
 *
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 0, Thread Name pool-1-thread-1
 * Duration: 5
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 0, Thread Name pool-1-thread-1
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 1, Thread Name pool-1-thread-1
 * Duration: 2
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 2, Thread Name pool-1-thread-2
 * Duration: 6
 * Exception in thread "pool-1-thread-1" java.lang.NullPointerException
 * 	at github.sivagtr.C_Executors.SingleThreadWorker.run(T13_SingleThreadExecutor.java:61)
 * 	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
 * 	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
 * 	at java.lang.Thread.run(Thread.java:748)
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 2, Thread Name pool-1-thread-2
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 3, Thread Name pool-1-thread-2
 * Duration: 4
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 3, Thread Name pool-1-thread-2
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 4, Thread Name pool-1-thread-2
 * Duration: 1
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 4, Thread Name pool-1-thread-2
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 5, Thread Name pool-1-thread-2
 * Duration: 5
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 5, Thread Name pool-1-thread-2
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 6, Thread Name pool-1-thread-2
 * Duration: 5
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 6, Thread Name pool-1-thread-2
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 7, Thread Name pool-1-thread-2
 * Duration: 9
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 7, Thread Name pool-1-thread-2
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 8, Thread Name pool-1-thread-2
 * Duration: 2
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 8, Thread Name pool-1-thread-2
 * <<<<<<<<<<<<<<<<<<  Start -- Executing the worker: Id is 9, Thread Name pool-1-thread-2
 * Duration: 4
 * >>>>>>>>>>>>>>>>>>  End ---- Executing the worker: Id is 9, Thread Name pool-1-thread-2
 */