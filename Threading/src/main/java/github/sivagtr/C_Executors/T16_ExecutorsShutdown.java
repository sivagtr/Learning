package github.sivagtr.C_Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ------------------------------------------------------------
 * <br>
 * Problem: How to stop the executor
 * <br>
 * Solution: Using Executor.shutdown() or shutdownNow();
 * <p>
 * Note:
 * <br>
 * Executor Shutdown() will make sure all the currently running tasks are completed. It doesn't accepts any new tasks.
 * <br>
 * Executor ShutdownNow() will immediately start shutting down the tasks. Interrupted Exception is raised for all the tasks that are running.
 * <br>
 * Executor isAwaitTermination() checks for certain period of time and returns true or false.
 * </p>
 * ============================================================
 * <p>
 * Further Problem: NA
 * </p>
 * ------------------------------------------------------------
 */
public class T16_ExecutorsShutdown {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for(int i = 0; i<100;i++){
			executorService.execute(new ExecutorShutdownWorker(i));
		}
		executorService.shutdown();
		System.out.println("$$$$$  Executing Shutdown..");
		try{
			if(!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)){
//				executorService.shutdownNow();
//				System.out.println("#####  Executing Shutdown Now..");
			}
		}catch(InterruptedException e){
			executorService.shutdownNow();
		}
		System.out.println("END OF APPLICATION");
	}
}
class ExecutorShutdownWorker implements Runnable{
	private int id;

	public ExecutorShutdownWorker(int id){
		this.id = id;
	}

	public void run() {
		System.out.printf(">>>>>>>>>>> START: Execution of work: Id is %d, Thread id is %d\n", id, Thread.currentThread().getId());
		long duration = (long)(Math.random() * 5);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch(InterruptedException e) {
			System.out.println("Task Interrupted, Id is "+id);
			Thread.currentThread().interrupt();
		}
		System.out.printf(">>>>>>>>>>> END:   Execution of work: Id is %d, Thread id is %d\n", id, Thread.currentThread().getId());
	}
}
/**
 * OUTPUT: IF UNCOMMENTED THE CODE (EXECUTES SHUTDOWN NOW AND APPLICATION STOPS)
 *
 * IF ExecutorService.ShutdownNow() Executed when there is awaitTermination False
 *
 * >>>>>>>>>>> START: Execution of work: Id is 0, Thread id is 10
 * $$$$$  Executing Shutdown..
 * >>>>>>>>>>> START: Execution of work: Id is 9, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 2, Thread id is 12
 * >>>>>>>>>>> START: Execution of work: Id is 1, Thread id is 11
 * >>>>>>>>>>> START: Execution of work: Id is 3, Thread id is 13
 * >>>>>>>>>>> START: Execution of work: Id is 5, Thread id is 15
 * >>>>>>>>>>> START: Execution of work: Id is 8, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 4, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 4, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 6, Thread id is 16
 * >>>>>>>>>>> START: Execution of work: Id is 7, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 10, Thread id is 14
 * Task Interrupted, Id is 9
 * Task Interrupted, Id is 1
 * Task Interrupted, Id is 0
 * Task Interrupted, Id is 8
 * >>>>>>>>>>> END:   Execution of work: Id is 8, Thread id is 18
 * Task Interrupted, Id is 5
 * Task Interrupted, Id is 2
 * >>>>>>>>>>> END:   Execution of work: Id is 2, Thread id is 12
 * Task Interrupted, Id is 10
 * >>>>>>>>>>> END:   Execution of work: Id is 10, Thread id is 14
 * Task Interrupted, Id is 7
 * >>>>>>>>>>> END:   Execution of work: Id is 7, Thread id is 17
 * Task Interrupted, Id is 3
 * >>>>>>>>>>> END:   Execution of work: Id is 3, Thread id is 13
 * Task Interrupted, Id is 6
 * #####  Executing Shutdown Now..
 * END OF APPLICATION
 * >>>>>>>>>>> END:   Execution of work: Id is 6, Thread id is 16
 * >>>>>>>>>>> END:   Execution of work: Id is 5, Thread id is 15
 * >>>>>>>>>>> END:   Execution of work: Id is 0, Thread id is 10
 * >>>>>>>>>>> END:   Execution of work: Id is 1, Thread id is 11
 * >>>>>>>>>>> END:   Execution of work: Id is 9, Thread id is 19
 *
 *
 *
 * OUTPUT: IF COMMENTED (ALLOWS TO EXECUTE ALL THE TASKS AND EXITS)
 *
 * >>>>>>>>>>> START: Execution of work: Id is 0, Thread id is 10
 * $$$$$  Executing Shutdown..
 * >>>>>>>>>>> START: Execution of work: Id is 9, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 8, Thread id is 18
 * >>>>>>>>>>> END:   Execution of work: Id is 8, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 7, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 2, Thread id is 12
 * >>>>>>>>>>> START: Execution of work: Id is 1, Thread id is 11
 * >>>>>>>>>>> START: Execution of work: Id is 5, Thread id is 15
 * >>>>>>>>>>> START: Execution of work: Id is 3, Thread id is 13
 * >>>>>>>>>>> START: Execution of work: Id is 6, Thread id is 16
 * >>>>>>>>>>> START: Execution of work: Id is 4, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 1, Thread id is 11
 * >>>>>>>>>>> START: Execution of work: Id is 10, Thread id is 18
 * >>>>>>>>>>> END:   Execution of work: Id is 9, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 12, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 11, Thread id is 11
 * >>>>>>>>>>> END:   Execution of work: Id is 0, Thread id is 10
 * END OF APPLICATION
 * >>>>>>>>>>> START: Execution of work: Id is 13, Thread id is 10
 * >>>>>>>>>>> END:   Execution of work: Id is 7, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 2, Thread id is 12
 * >>>>>>>>>>> START: Execution of work: Id is 14, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 15, Thread id is 12
 * >>>>>>>>>>> END:   Execution of work: Id is 6, Thread id is 16
 * >>>>>>>>>>> END:   Execution of work: Id is 10, Thread id is 18
 * >>>>>>>>>>> END:   Execution of work: Id is 5, Thread id is 15
 * >>>>>>>>>>> START: Execution of work: Id is 17, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 16, Thread id is 16
 * >>>>>>>>>>> START: Execution of work: Id is 18, Thread id is 15
 * >>>>>>>>>>> END:   Execution of work: Id is 13, Thread id is 10
 * >>>>>>>>>>> END:   Execution of work: Id is 3, Thread id is 13
 * >>>>>>>>>>> START: Execution of work: Id is 19, Thread id is 10
 * >>>>>>>>>>> START: Execution of work: Id is 20, Thread id is 13
 * >>>>>>>>>>> END:   Execution of work: Id is 20, Thread id is 13
 * >>>>>>>>>>> START: Execution of work: Id is 21, Thread id is 13
 * >>>>>>>>>>> END:   Execution of work: Id is 15, Thread id is 12
 * >>>>>>>>>>> START: Execution of work: Id is 22, Thread id is 12
 * >>>>>>>>>>> END:   Execution of work: Id is 12, Thread id is 19
 * >>>>>>>>>>> END:   Execution of work: Id is 4, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 24, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 24, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 25, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 23, Thread id is 19
 * >>>>>>>>>>> END:   Execution of work: Id is 23, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 26, Thread id is 19
 * >>>>>>>>>>> END:   Execution of work: Id is 11, Thread id is 11
 * >>>>>>>>>>> START: Execution of work: Id is 27, Thread id is 11
 * >>>>>>>>>>> END:   Execution of work: Id is 27, Thread id is 11
 * >>>>>>>>>>> START: Execution of work: Id is 28, Thread id is 11
 * >>>>>>>>>>> END:   Execution of work: Id is 21, Thread id is 13
 * >>>>>>>>>>> END:   Execution of work: Id is 17, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 30, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 29, Thread id is 13
 * >>>>>>>>>>> END:   Execution of work: Id is 18, Thread id is 15
 * >>>>>>>>>>> START: Execution of work: Id is 31, Thread id is 15
 * >>>>>>>>>>> END:   Execution of work: Id is 22, Thread id is 12
 * >>>>>>>>>>> START: Execution of work: Id is 32, Thread id is 12
 * >>>>>>>>>>> END:   Execution of work: Id is 32, Thread id is 12
 * >>>>>>>>>>> START: Execution of work: Id is 33, Thread id is 12
 * >>>>>>>>>>> END:   Execution of work: Id is 29, Thread id is 13
 * >>>>>>>>>>> START: Execution of work: Id is 34, Thread id is 13
 * >>>>>>>>>>> END:   Execution of work: Id is 14, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 35, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 35, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 25, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 37, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 36, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 26, Thread id is 19
 * >>>>>>>>>>> END:   Execution of work: Id is 16, Thread id is 16
 * >>>>>>>>>>> START: Execution of work: Id is 38, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 39, Thread id is 16
 * >>>>>>>>>>> END:   Execution of work: Id is 39, Thread id is 16
 * >>>>>>>>>>> START: Execution of work: Id is 40, Thread id is 16
 * >>>>>>>>>>> END:   Execution of work: Id is 38, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 41, Thread id is 19
 * >>>>>>>>>>> END:   Execution of work: Id is 31, Thread id is 15
 * >>>>>>>>>>> START: Execution of work: Id is 42, Thread id is 15
 * >>>>>>>>>>> END:   Execution of work: Id is 19, Thread id is 10
 * >>>>>>>>>>> START: Execution of work: Id is 43, Thread id is 10
 * >>>>>>>>>>> END:   Execution of work: Id is 28, Thread id is 11
 * >>>>>>>>>>> START: Execution of work: Id is 44, Thread id is 11
 * >>>>>>>>>>> END:   Execution of work: Id is 30, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 45, Thread id is 18
 * >>>>>>>>>>> END:   Execution of work: Id is 44, Thread id is 11
 * >>>>>>>>>>> END:   Execution of work: Id is 41, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 47, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 46, Thread id is 11
 * >>>>>>>>>>> END:   Execution of work: Id is 33, Thread id is 12
 * >>>>>>>>>>> START: Execution of work: Id is 48, Thread id is 12
 * >>>>>>>>>>> END:   Execution of work: Id is 40, Thread id is 16
 * >>>>>>>>>>> START: Execution of work: Id is 49, Thread id is 16
 * >>>>>>>>>>> END:   Execution of work: Id is 45, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 50, Thread id is 18
 * >>>>>>>>>>> END:   Execution of work: Id is 34, Thread id is 13
 * >>>>>>>>>>> START: Execution of work: Id is 51, Thread id is 13
 * >>>>>>>>>>> END:   Execution of work: Id is 48, Thread id is 12
 * >>>>>>>>>>> START: Execution of work: Id is 52, Thread id is 12
 * >>>>>>>>>>> END:   Execution of work: Id is 37, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 53, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 53, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 54, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 36, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 55, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 42, Thread id is 15
 * >>>>>>>>>>> START: Execution of work: Id is 56, Thread id is 15
 * >>>>>>>>>>> END:   Execution of work: Id is 43, Thread id is 10
 * >>>>>>>>>>> START: Execution of work: Id is 57, Thread id is 10
 * >>>>>>>>>>> END:   Execution of work: Id is 54, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 58, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 46, Thread id is 11
 * >>>>>>>>>>> START: Execution of work: Id is 59, Thread id is 11
 * >>>>>>>>>>> END:   Execution of work: Id is 50, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 60, Thread id is 18
 * >>>>>>>>>>> END:   Execution of work: Id is 60, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 61, Thread id is 18
 * >>>>>>>>>>> END:   Execution of work: Id is 55, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 62, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 62, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 63, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 49, Thread id is 16
 * >>>>>>>>>>> START: Execution of work: Id is 64, Thread id is 16
 * >>>>>>>>>>> END:   Execution of work: Id is 56, Thread id is 15
 * >>>>>>>>>>> START: Execution of work: Id is 65, Thread id is 15
 * >>>>>>>>>>> END:   Execution of work: Id is 52, Thread id is 12
 * >>>>>>>>>>> START: Execution of work: Id is 66, Thread id is 12
 * >>>>>>>>>>> END:   Execution of work: Id is 47, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 67, Thread id is 19
 * >>>>>>>>>>> END:   Execution of work: Id is 67, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 68, Thread id is 19
 * >>>>>>>>>>> END:   Execution of work: Id is 51, Thread id is 13
 * >>>>>>>>>>> START: Execution of work: Id is 69, Thread id is 13
 * >>>>>>>>>>> END:   Execution of work: Id is 68, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 70, Thread id is 19
 * >>>>>>>>>>> END:   Execution of work: Id is 57, Thread id is 10
 * >>>>>>>>>>> START: Execution of work: Id is 71, Thread id is 10
 * >>>>>>>>>>> END:   Execution of work: Id is 61, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 72, Thread id is 18
 * >>>>>>>>>>> END:   Execution of work: Id is 63, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 73, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 59, Thread id is 11
 * >>>>>>>>>>> START: Execution of work: Id is 74, Thread id is 11
 * >>>>>>>>>>> END:   Execution of work: Id is 65, Thread id is 15
 * >>>>>>>>>>> START: Execution of work: Id is 75, Thread id is 15
 * >>>>>>>>>>> END:   Execution of work: Id is 69, Thread id is 13
 * >>>>>>>>>>> START: Execution of work: Id is 76, Thread id is 13
 * >>>>>>>>>>> END:   Execution of work: Id is 58, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 71, Thread id is 10
 * >>>>>>>>>>> START: Execution of work: Id is 78, Thread id is 10
 * >>>>>>>>>>> END:   Execution of work: Id is 64, Thread id is 16
 * >>>>>>>>>>> START: Execution of work: Id is 79, Thread id is 16
 * >>>>>>>>>>> END:   Execution of work: Id is 79, Thread id is 16
 * >>>>>>>>>>> START: Execution of work: Id is 77, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 77, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 81, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 80, Thread id is 16
 * >>>>>>>>>>> END:   Execution of work: Id is 73, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 82, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 82, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 83, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 83, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 84, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 84, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 85, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 85, Thread id is 17
 * >>>>>>>>>>> START: Execution of work: Id is 86, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 66, Thread id is 12
 * >>>>>>>>>>> START: Execution of work: Id is 87, Thread id is 12
 * >>>>>>>>>>> END:   Execution of work: Id is 72, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 88, Thread id is 18
 * >>>>>>>>>>> END:   Execution of work: Id is 76, Thread id is 13
 * >>>>>>>>>>> START: Execution of work: Id is 89, Thread id is 13
 * >>>>>>>>>>> END:   Execution of work: Id is 78, Thread id is 10
 * >>>>>>>>>>> START: Execution of work: Id is 90, Thread id is 10
 * >>>>>>>>>>> END:   Execution of work: Id is 81, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 91, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 70, Thread id is 19
 * >>>>>>>>>>> START: Execution of work: Id is 92, Thread id is 19
 * >>>>>>>>>>> END:   Execution of work: Id is 91, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 93, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 93, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 94, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 94, Thread id is 14
 * >>>>>>>>>>> START: Execution of work: Id is 95, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 88, Thread id is 18
 * >>>>>>>>>>> START: Execution of work: Id is 96, Thread id is 18
 * >>>>>>>>>>> END:   Execution of work: Id is 74, Thread id is 11
 * >>>>>>>>>>> START: Execution of work: Id is 97, Thread id is 11
 * >>>>>>>>>>> END:   Execution of work: Id is 80, Thread id is 16
 * >>>>>>>>>>> START: Execution of work: Id is 98, Thread id is 16
 * >>>>>>>>>>> END:   Execution of work: Id is 75, Thread id is 15
 * >>>>>>>>>>> START: Execution of work: Id is 99, Thread id is 15
 * >>>>>>>>>>> END:   Execution of work: Id is 92, Thread id is 19
 * >>>>>>>>>>> END:   Execution of work: Id is 87, Thread id is 12
 * >>>>>>>>>>> END:   Execution of work: Id is 96, Thread id is 18
 * >>>>>>>>>>> END:   Execution of work: Id is 86, Thread id is 17
 * >>>>>>>>>>> END:   Execution of work: Id is 98, Thread id is 16
 * >>>>>>>>>>> END:   Execution of work: Id is 89, Thread id is 13
 * >>>>>>>>>>> END:   Execution of work: Id is 90, Thread id is 10
 * >>>>>>>>>>> END:   Execution of work: Id is 99, Thread id is 15
 * >>>>>>>>>>> END:   Execution of work: Id is 95, Thread id is 14
 * >>>>>>>>>>> END:   Execution of work: Id is 97, Thread id is 11
 */