package tests;

public class Run2 extends Thread {
	
	@Override
	public void run() {

		for(int i=0; i<10; i++) {
			System.out.println("Run-2");
		}
	}
}
