package github.sivagtr.B_InterThreadCommunication;

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
/**
 * Output:
 *
 * Increment1 : 0
 * Increment2 : 0
 * Increment2 : 1
 * Increment2 : 2
 * Increment2 : 3
 * Increment2 : 4
 * Increment2 : 5
 * Increment2 : 6
 * Increment2 : 7
 * Increment2 : 8
 * Increment2 : 9
 * Increment2 : 10
 * Increment2 : 11
 * Increment2 : 12
 * Increment2 : 13
 * Increment2 : 14
 * Increment2 : 15
 * Increment2 : 16
 * Increment2 : 17
 * Increment2 : 18
 * Increment2 : 19
 * Increment2 : 20
 * Increment2 : 21
 * Increment2 : 22
 * Increment2 : 23
 * Increment2 : 24
 * Increment2 : 25
 * Increment2 : 26
 * Increment2 : 27
 * Increment2 : 28
 * Increment2 : 29
 * Increment2 : 30
 * Increment2 : 31
 * Increment2 : 32
 * Increment2 : 33
 * Increment2 : 34
 * Increment2 : 35
 * Increment2 : 36
 * Increment2 : 37
 * Increment2 : 38
 * Increment2 : 39
 * Increment2 : 40
 * Increment2 : 41
 * Increment2 : 42
 * Increment2 : 43
 * Increment2 : 44
 * Increment2 : 45
 * Increment2 : 46
 * Increment2 : 47
 * Increment2 : 48
 * Increment2 : 49
 * Increment2 : 50
 * Increment2 : 51
 * Increment2 : 52
 * Increment2 : 53
 * Increment2 : 54
 * Increment2 : 55
 * Increment2 : 56
 * Increment2 : 57
 * Increment2 : 58
 * Increment2 : 59
 * Increment2 : 60
 * Increment2 : 61
 * Increment2 : 62
 * Increment2 : 63
 * Increment2 : 64
 * Increment2 : 65
 * Increment2 : 66
 * Increment2 : 67
 * Increment2 : 68
 * Increment2 : 69
 * Increment2 : 70
 * Increment2 : 71
 * Increment2 : 72
 * Increment2 : 73
 * Increment2 : 74
 * Increment2 : 75
 * Increment2 : 76
 * Increment2 : 77
 * Increment2 : 78
 * Increment2 : 79
 * Increment2 : 80
 * Increment2 : 81
 * Increment2 : 82
 * Increment2 : 83
 * Increment2 : 84
 * Increment2 : 85
 * Increment2 : 86
 * Increment2 : 87
 * Increment2 : 88
 * Increment2 : 89
 * Increment2 : 90
 * Increment2 : 91
 * Increment2 : 92
 * Increment2 : 93
 * Increment2 : 94
 * Increment2 : 95
 * Increment2 : 96
 * Increment2 : 97
 * Increment2 : 98
 * Increment2 : 99
 * Increment1 : 1
 * Increment1 : 2
 * Increment1 : 3
 * Increment1 : 4
 * Increment1 : 5
 * Increment1 : 6
 * Increment1 : 7
 * Increment1 : 8
 * Increment1 : 9
 * Increment1 : 10
 * Increment1 : 11
 * Increment1 : 12
 * Increment1 : 13
 * Increment1 : 14
 * Increment1 : 15
 * Increment1 : 16
 * Increment1 : 17
 * Increment1 : 18
 * Increment1 : 19
 * Increment1 : 20
 * Increment1 : 21
 * Increment1 : 22
 * Increment1 : 23
 * Increment1 : 24
 * Increment1 : 25
 * Increment1 : 26
 * Increment1 : 27
 * Increment1 : 28
 * Increment1 : 29
 * Increment1 : 30
 * Increment1 : 31
 * Increment1 : 32
 * Increment1 : 33
 * Increment1 : 34
 * Increment1 : 35
 * Increment1 : 36
 * Increment1 : 37
 * Increment1 : 38
 * Increment1 : 39
 * Increment1 : 40
 * Increment1 : 41
 * Increment1 : 42
 * Increment1 : 43
 * Increment1 : 44
 * Increment1 : 45
 * Increment1 : 46
 * Increment1 : 47
 * Increment1 : 48
 * Increment1 : 49
 * Increment1 : 50
 * Increment1 : 51
 * Increment1 : 52
 * Increment1 : 53
 * Increment1 : 54
 * Increment1 : 55
 * Increment1 : 56
 * Increment1 : 57
 * Increment1 : 58
 * Increment1 : 59
 * Increment1 : 60
 * Increment1 : 61
 * Increment1 : 62
 * Increment1 : 63
 * Increment1 : 64
 * Increment1 : 65
 * Increment1 : 66
 * Increment1 : 67
 * Increment1 : 68
 * Increment1 : 69
 * Increment1 : 70
 * Increment1 : 71
 * Increment1 : 72
 * Increment1 : 73
 * Increment1 : 74
 * Increment1 : 75
 * Increment1 : 76
 * Increment1 : 77
 * Increment1 : 78
 * Increment1 : 79
 * Increment1 : 80
 * Increment1 : 81
 * Increment1 : 82
 * Increment1 : 83
 * Increment1 : 84
 * Increment1 : 85
 * Increment1 : 86
 * Increment1 : 87
 * Increment1 : 88
 * Increment1 : 89
 * Increment1 : 90
 * Increment1 : 91
 * Increment1 : 92
 * Increment1 : 93
 * Increment1 : 94
 * Increment1 : 95
 * Increment1 : 96
 * Increment1 : 97
 * Increment1 : 98
 * Increment1 : 99
 */