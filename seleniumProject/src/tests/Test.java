package tests;

public class Test {

	public static void main(String[] args) throws Exception {

		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0; i<10; i++) {
					System.out.println("Run-1");
				}
			}
		};


		Thread t2 = new Thread() {
			@Override
			public void run() {

				for(int i=0; i<10; i++) {
					System.out.println("Run-2");
				}
			}
		};

		t1.start();

		t2.start();

		t2.join();
		t1.join();


	}

}
