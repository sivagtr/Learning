package github.sivagtr.C_Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * ------------------------------------------------------------
 * <br>
 * Problem: Implementation of tasks using Multithreading with Pool (Executors) -- When there is delay/auto trigger
 * <br>
 * Solution: Use ScheduledThreadExecutor
 * <p>
 * Note:
 * <br>
 * A Fixed number of threads are created. The Tasks are performed with Certain time criteria like Initial Delay, How much Interval.
 * <br>
 * One Thread is executed with      ID: 1, Initial Delay: 1, Interval/Period: 3
 * <br>
 * Second Thread is executed with   ID: 2, Initial Delay: 2, Interval/Period: 7
 * </p>
 * ============================================================
 * <p>
 * Further Problem: NA
 * </p>
 * ------------------------------------------------------------
 */
public class T15_ScheduledThreadExecutor {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
		scheduledExecutorService.scheduleAtFixedRate(new ScheduledStockMarketFetcher(1), 1,3, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleAtFixedRate(new ScheduledStockMarketFetcher(2), 2,7, TimeUnit.SECONDS);
	}
}
class ScheduledStockMarketFetcher implements Runnable{
	private int id;
	public ScheduledStockMarketFetcher(int id){
		this.id = id;
	}
	public void run(){
		System.out.printf(">>>>>>>>>>>> START: Execution of work, Id is %d, Thread Name is %s\n", id, Thread.currentThread().getName());
		// Fetching of data
		System.out.printf("<<<<<<<<<<<< END:   Execution of work, Id is %d, Thread Name is %s\n", id, Thread.currentThread().getName());
	}
}
/**
 * OUTPUT:
 *
 * >>>>>>>>>>>> START: Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * <<<<<<<<<<<< END:   Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * >>>>>>>>>>>> START: Execution of work, Id is 2, Thread Name is pool-1-thread-2
 * <<<<<<<<<<<< END:   Execution of work, Id is 2, Thread Name is pool-1-thread-2
 * >>>>>>>>>>>> START: Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * <<<<<<<<<<<< END:   Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * >>>>>>>>>>>> START: Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * <<<<<<<<<<<< END:   Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * >>>>>>>>>>>> START: Execution of work, Id is 2, Thread Name is pool-1-thread-2
 * <<<<<<<<<<<< END:   Execution of work, Id is 2, Thread Name is pool-1-thread-2
 * >>>>>>>>>>>> START: Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * <<<<<<<<<<<< END:   Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * >>>>>>>>>>>> START: Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * <<<<<<<<<<<< END:   Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * >>>>>>>>>>>> START: Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * <<<<<<<<<<<< END:   Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * >>>>>>>>>>>> START: Execution of work, Id is 2, Thread Name is pool-1-thread-2
 * <<<<<<<<<<<< END:   Execution of work, Id is 2, Thread Name is pool-1-thread-2
 * >>>>>>>>>>>> START: Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * <<<<<<<<<<<< END:   Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * >>>>>>>>>>>> START: Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * <<<<<<<<<<<< END:   Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * >>>>>>>>>>>> START: Execution of work, Id is 2, Thread Name is pool-1-thread-2
 * <<<<<<<<<<<< END:   Execution of work, Id is 2, Thread Name is pool-1-thread-2
 * >>>>>>>>>>>> START: Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * <<<<<<<<<<<< END:   Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * >>>>>>>>>>>> START: Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * <<<<<<<<<<<< END:   Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * >>>>>>>>>>>> START: Execution of work, Id is 2, Thread Name is pool-1-thread-2
 * <<<<<<<<<<<< END:   Execution of work, Id is 2, Thread Name is pool-1-thread-2
 * >>>>>>>>>>>> START: Execution of work, Id is 1, Thread Name is pool-1-thread-1
 * <<<<<<<<<<<< END:   Execution of work, Id is 1, Thread Name is pool-1-thread-1
 */