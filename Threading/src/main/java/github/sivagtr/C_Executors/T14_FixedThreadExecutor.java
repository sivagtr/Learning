package github.sivagtr.C_Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ------------------------------------------------------------
 * <br>
 * Problem: Implementation of tasks using Multithreading with Pool (Executors) -- Fixed Threaded
 * <br>
 * Solution: Use FixedThreadExecutor
 * <p>
 * Note:
 * <br>
 * A Fixed number of threads are created. The same threads are used for executing all the tasks.
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
public class T14_FixedThreadExecutor {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for(int i = 0; i<100; i++){
			executorService.execute(new FixedThreadWorker(i));
		}
		executorService.shutdown();
	}
}
class FixedThreadWorker implements Runnable{
	private int id;

	public FixedThreadWorker(int id){
		this.id = id;
	}

	public void run(){
		System.out.printf(">>>>>>>>>>> START: Execution of worker, Id is %d, Worker is %s\n", id, Thread.currentThread().getName());
		long duration = (long)(Math.random() * 5);
		System.out.println("Duration: "+duration);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("<<<<<<<<<<< END:   Execution of worker, Id is %d, Worker is %s\n", id, Thread.currentThread().getName());
	}
}


/**
 * OUTPUT:
 *
 * >>>>>>>>>>> START: Execution of worker, Id is 1, Worker is pool-1-thread-2
 * >>>>>>>>>>> START: Execution of worker, Id is 9, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 8, Worker is pool-1-thread-9
 * >>>>>>>>>>> START: Execution of worker, Id is 7, Worker is pool-1-thread-8
 * Duration: 2
 * >>>>>>>>>>> START: Execution of worker, Id is 6, Worker is pool-1-thread-7
 * >>>>>>>>>>> START: Execution of worker, Id is 5, Worker is pool-1-thread-6
 * >>>>>>>>>>> START: Execution of worker, Id is 4, Worker is pool-1-thread-5
 * >>>>>>>>>>> START: Execution of worker, Id is 2, Worker is pool-1-thread-3
 * >>>>>>>>>>> START: Execution of worker, Id is 3, Worker is pool-1-thread-4
 * Duration: 2
 * >>>>>>>>>>> START: Execution of worker, Id is 0, Worker is pool-1-thread-1
 * Duration: 1
 * Duration: 1
 * Duration: 3
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 6, Worker is pool-1-thread-7
 * Duration: 2
 * >>>>>>>>>>> START: Execution of worker, Id is 10, Worker is pool-1-thread-7
 * Duration: 1
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 9, Worker is pool-1-thread-10
 * Duration: 2
 * Duration: 2
 * >>>>>>>>>>> START: Execution of worker, Id is 11, Worker is pool-1-thread-10
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 4, Worker is pool-1-thread-5
 * >>>>>>>>>>> START: Execution of worker, Id is 12, Worker is pool-1-thread-5
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 8, Worker is pool-1-thread-9
 * >>>>>>>>>>> START: Execution of worker, Id is 13, Worker is pool-1-thread-9
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 2, Worker is pool-1-thread-3
 * >>>>>>>>>>> START: Execution of worker, Id is 14, Worker is pool-1-thread-3
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 7, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 15, Worker is pool-1-thread-8
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 1, Worker is pool-1-thread-2
 * >>>>>>>>>>> START: Execution of worker, Id is 16, Worker is pool-1-thread-2
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 10, Worker is pool-1-thread-7
 * <<<<<<<<<<< END:   Execution of worker, Id is 3, Worker is pool-1-thread-4
 * >>>>>>>>>>> START: Execution of worker, Id is 17, Worker is pool-1-thread-7
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 17, Worker is pool-1-thread-7
 * >>>>>>>>>>> START: Execution of worker, Id is 19, Worker is pool-1-thread-7
 * <<<<<<<<<<< END:   Execution of worker, Id is 11, Worker is pool-1-thread-10
 * <<<<<<<<<<< END:   Execution of worker, Id is 0, Worker is pool-1-thread-1
 * >>>>>>>>>>> START: Execution of worker, Id is 20, Worker is pool-1-thread-10
 * Duration: 4
 * >>>>>>>>>>> START: Execution of worker, Id is 18, Worker is pool-1-thread-4
 * Duration: 4
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 20, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 22, Worker is pool-1-thread-10
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 22, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 23, Worker is pool-1-thread-10
 * Duration: 4
 * >>>>>>>>>>> START: Execution of worker, Id is 21, Worker is pool-1-thread-1
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 21, Worker is pool-1-thread-1
 * >>>>>>>>>>> START: Execution of worker, Id is 24, Worker is pool-1-thread-1
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 5, Worker is pool-1-thread-6
 * >>>>>>>>>>> START: Execution of worker, Id is 25, Worker is pool-1-thread-6
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 12, Worker is pool-1-thread-5
 * <<<<<<<<<<< END:   Execution of worker, Id is 14, Worker is pool-1-thread-3
 * >>>>>>>>>>> START: Execution of worker, Id is 27, Worker is pool-1-thread-3
 * Duration: 1
 * >>>>>>>>>>> START: Execution of worker, Id is 26, Worker is pool-1-thread-5
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 15, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 28, Worker is pool-1-thread-8
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 25, Worker is pool-1-thread-6
 * >>>>>>>>>>> START: Execution of worker, Id is 29, Worker is pool-1-thread-6
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 27, Worker is pool-1-thread-3
 * >>>>>>>>>>> START: Execution of worker, Id is 30, Worker is pool-1-thread-3
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 13, Worker is pool-1-thread-9
 * <<<<<<<<<<< END:   Execution of worker, Id is 28, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 32, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 31, Worker is pool-1-thread-9
 * Duration: 1
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 32, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 33, Worker is pool-1-thread-8
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 33, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 34, Worker is pool-1-thread-8
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 30, Worker is pool-1-thread-3
 * >>>>>>>>>>> START: Execution of worker, Id is 35, Worker is pool-1-thread-3
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 16, Worker is pool-1-thread-2
 * >>>>>>>>>>> START: Execution of worker, Id is 36, Worker is pool-1-thread-2
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 19, Worker is pool-1-thread-7
 * >>>>>>>>>>> START: Execution of worker, Id is 37, Worker is pool-1-thread-7
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 18, Worker is pool-1-thread-4
 * >>>>>>>>>>> START: Execution of worker, Id is 38, Worker is pool-1-thread-4
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 23, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 39, Worker is pool-1-thread-10
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 24, Worker is pool-1-thread-1
 * >>>>>>>>>>> START: Execution of worker, Id is 40, Worker is pool-1-thread-1
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 29, Worker is pool-1-thread-6
 * >>>>>>>>>>> START: Execution of worker, Id is 41, Worker is pool-1-thread-6
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 31, Worker is pool-1-thread-9
 * >>>>>>>>>>> START: Execution of worker, Id is 42, Worker is pool-1-thread-9
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 26, Worker is pool-1-thread-5
 * >>>>>>>>>>> START: Execution of worker, Id is 43, Worker is pool-1-thread-5
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 40, Worker is pool-1-thread-1
 * >>>>>>>>>>> START: Execution of worker, Id is 44, Worker is pool-1-thread-1
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 43, Worker is pool-1-thread-5
 * >>>>>>>>>>> START: Execution of worker, Id is 45, Worker is pool-1-thread-5
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 44, Worker is pool-1-thread-1
 * >>>>>>>>>>> START: Execution of worker, Id is 46, Worker is pool-1-thread-1
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 35, Worker is pool-1-thread-3
 * >>>>>>>>>>> START: Execution of worker, Id is 47, Worker is pool-1-thread-3
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 37, Worker is pool-1-thread-7
 * <<<<<<<<<<< END:   Execution of worker, Id is 36, Worker is pool-1-thread-2
 * >>>>>>>>>>> START: Execution of worker, Id is 48, Worker is pool-1-thread-7
 * >>>>>>>>>>> START: Execution of worker, Id is 49, Worker is pool-1-thread-2
 * Duration: 2
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 34, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 50, Worker is pool-1-thread-8
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 38, Worker is pool-1-thread-4
 * >>>>>>>>>>> START: Execution of worker, Id is 51, Worker is pool-1-thread-4
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 39, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 52, Worker is pool-1-thread-10
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 41, Worker is pool-1-thread-6
 * >>>>>>>>>>> START: Execution of worker, Id is 53, Worker is pool-1-thread-6
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 42, Worker is pool-1-thread-9
 * >>>>>>>>>>> START: Execution of worker, Id is 54, Worker is pool-1-thread-9
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 46, Worker is pool-1-thread-1
 * >>>>>>>>>>> START: Execution of worker, Id is 55, Worker is pool-1-thread-1
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 49, Worker is pool-1-thread-2
 * <<<<<<<<<<< END:   Execution of worker, Id is 48, Worker is pool-1-thread-7
 * >>>>>>>>>>> START: Execution of worker, Id is 56, Worker is pool-1-thread-2
 * Duration: 3
 * >>>>>>>>>>> START: Execution of worker, Id is 57, Worker is pool-1-thread-7
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 45, Worker is pool-1-thread-5
 * >>>>>>>>>>> START: Execution of worker, Id is 58, Worker is pool-1-thread-5
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 58, Worker is pool-1-thread-5
 * >>>>>>>>>>> START: Execution of worker, Id is 59, Worker is pool-1-thread-5
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 55, Worker is pool-1-thread-1
 * >>>>>>>>>>> START: Execution of worker, Id is 60, Worker is pool-1-thread-1
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 60, Worker is pool-1-thread-1
 * >>>>>>>>>>> START: Execution of worker, Id is 61, Worker is pool-1-thread-1
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 52, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 62, Worker is pool-1-thread-10
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 62, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 63, Worker is pool-1-thread-10
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 63, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 64, Worker is pool-1-thread-10
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 64, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 65, Worker is pool-1-thread-10
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 47, Worker is pool-1-thread-3
 * >>>>>>>>>>> START: Execution of worker, Id is 66, Worker is pool-1-thread-3
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 61, Worker is pool-1-thread-1
 * >>>>>>>>>>> START: Execution of worker, Id is 67, Worker is pool-1-thread-1
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 54, Worker is pool-1-thread-9
 * >>>>>>>>>>> START: Execution of worker, Id is 68, Worker is pool-1-thread-9
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 68, Worker is pool-1-thread-9
 * >>>>>>>>>>> START: Execution of worker, Id is 69, Worker is pool-1-thread-9
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 50, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 70, Worker is pool-1-thread-8
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 53, Worker is pool-1-thread-6
 * >>>>>>>>>>> START: Execution of worker, Id is 71, Worker is pool-1-thread-6
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 71, Worker is pool-1-thread-6
 * >>>>>>>>>>> START: Execution of worker, Id is 72, Worker is pool-1-thread-6
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 70, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 73, Worker is pool-1-thread-8
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 73, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 74, Worker is pool-1-thread-8
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 66, Worker is pool-1-thread-3
 * >>>>>>>>>>> START: Execution of worker, Id is 75, Worker is pool-1-thread-3
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 67, Worker is pool-1-thread-1
 * >>>>>>>>>>> START: Execution of worker, Id is 76, Worker is pool-1-thread-1
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 51, Worker is pool-1-thread-4
 * >>>>>>>>>>> START: Execution of worker, Id is 77, Worker is pool-1-thread-4
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 56, Worker is pool-1-thread-2
 * >>>>>>>>>>> START: Execution of worker, Id is 78, Worker is pool-1-thread-2
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 57, Worker is pool-1-thread-7
 * >>>>>>>>>>> START: Execution of worker, Id is 79, Worker is pool-1-thread-7
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 69, Worker is pool-1-thread-9
 * >>>>>>>>>>> START: Execution of worker, Id is 80, Worker is pool-1-thread-9
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 77, Worker is pool-1-thread-4
 * >>>>>>>>>>> START: Execution of worker, Id is 81, Worker is pool-1-thread-4
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 65, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 82, Worker is pool-1-thread-10
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 74, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 83, Worker is pool-1-thread-8
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 59, Worker is pool-1-thread-5
 * >>>>>>>>>>> START: Execution of worker, Id is 84, Worker is pool-1-thread-5
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 76, Worker is pool-1-thread-1
 * >>>>>>>>>>> START: Execution of worker, Id is 85, Worker is pool-1-thread-1
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 78, Worker is pool-1-thread-2
 * >>>>>>>>>>> START: Execution of worker, Id is 86, Worker is pool-1-thread-2
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 79, Worker is pool-1-thread-7
 * >>>>>>>>>>> START: Execution of worker, Id is 87, Worker is pool-1-thread-7
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 72, Worker is pool-1-thread-6
 * >>>>>>>>>>> START: Execution of worker, Id is 88, Worker is pool-1-thread-6
 * Duration: 4
 * <<<<<<<<<<< END:   Execution of worker, Id is 81, Worker is pool-1-thread-4
 * >>>>>>>>>>> START: Execution of worker, Id is 89, Worker is pool-1-thread-4
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 82, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 90, Worker is pool-1-thread-10
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 90, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 91, Worker is pool-1-thread-10
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 86, Worker is pool-1-thread-2
 * <<<<<<<<<<< END:   Execution of worker, Id is 80, Worker is pool-1-thread-9
 * >>>>>>>>>>> START: Execution of worker, Id is 93, Worker is pool-1-thread-9
 * Duration: 4
 * >>>>>>>>>>> START: Execution of worker, Id is 92, Worker is pool-1-thread-2
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 75, Worker is pool-1-thread-3
 * >>>>>>>>>>> START: Execution of worker, Id is 94, Worker is pool-1-thread-3
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 91, Worker is pool-1-thread-10
 * >>>>>>>>>>> START: Execution of worker, Id is 95, Worker is pool-1-thread-10
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 83, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 96, Worker is pool-1-thread-8
 * Duration: 0
 * <<<<<<<<<<< END:   Execution of worker, Id is 96, Worker is pool-1-thread-8
 * >>>>>>>>>>> START: Execution of worker, Id is 97, Worker is pool-1-thread-8
 * Duration: 3
 * <<<<<<<<<<< END:   Execution of worker, Id is 94, Worker is pool-1-thread-3
 * >>>>>>>>>>> START: Execution of worker, Id is 98, Worker is pool-1-thread-3
 * Duration: 2
 * <<<<<<<<<<< END:   Execution of worker, Id is 84, Worker is pool-1-thread-5
 * >>>>>>>>>>> START: Execution of worker, Id is 99, Worker is pool-1-thread-5
 * Duration: 1
 * <<<<<<<<<<< END:   Execution of worker, Id is 85, Worker is pool-1-thread-1
 * <<<<<<<<<<< END:   Execution of worker, Id is 89, Worker is pool-1-thread-4
 * <<<<<<<<<<< END:   Execution of worker, Id is 87, Worker is pool-1-thread-7
 * <<<<<<<<<<< END:   Execution of worker, Id is 88, Worker is pool-1-thread-6
 * <<<<<<<<<<< END:   Execution of worker, Id is 92, Worker is pool-1-thread-2
 * <<<<<<<<<<< END:   Execution of worker, Id is 99, Worker is pool-1-thread-5
 * <<<<<<<<<<< END:   Execution of worker, Id is 98, Worker is pool-1-thread-3
 * <<<<<<<<<<< END:   Execution of worker, Id is 95, Worker is pool-1-thread-10
 * <<<<<<<<<<< END:   Execution of worker, Id is 97, Worker is pool-1-thread-8
 * <<<<<<<<<<< END:   Execution of worker, Id is 93, Worker is pool-1-thread-9
 */