package progs;

public class OddEvenMultithreading {

	public static void main(String[] s) {

		Runnable r = new MyThread();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}

}

class MyThread implements Runnable {

	static int counter;
	Object lock = new Object();

	@Override
	public void run() {

		try {
			synchronized (lock) {
				while (counter < 100) {
					counter++;
					System.out.println(Thread.currentThread().getName() + "   " + counter);
					lock.notify();
					lock.wait();
				}
				lock.notifyAll();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
