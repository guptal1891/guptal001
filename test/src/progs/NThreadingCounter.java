package progs;

/**
 * Using 3 threads, print increasing sequence 1 to n
 * @author Lovely
 *
 */
public class NThreadingCounter {

	public static void main(String[] s) throws InterruptedException {
		Runnable r1 = new MyThread1(0);
		Runnable r2 = new MyThread1(1);
		Runnable r3 = new MyThread1(2);
		MyThread1.numOfThread = 3;
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
	}
}

class MyThread1 implements Runnable {
	static volatile int counter = 1;
	static Object lock = new Object();
	private int mod;
	static int numOfThread = 3;

	MyThread1(int mod) {

		this.mod = mod;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {
				while (counter < 10) {
					if (counter % numOfThread == mod)
						System.out.println(Thread.currentThread().getName() + "   " + counter++);
					lock.notifyAll();
					lock.wait();
				}
				lock.notifyAll();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}
}
