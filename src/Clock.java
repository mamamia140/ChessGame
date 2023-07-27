
public class Clock extends Thread{
	
	private volatile boolean running = true;
	
	
	public void terminate() {
		running = false;
	}
	@Override
	public void run() {
		for(int i=300; running && i>=0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
		}
		//burasý deðiþcek
	}
	
	
}
