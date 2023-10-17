package Game;

public class Clock extends Thread {

	private volatile boolean RUNNING = true;
	private volatile Player player;

	public void terminate() {
		RUNNING = false;
	}

	public void changeTurn() {

	}

	@Override
	public void run() {

//		while (RUNNING) {
//			try {
//				Thread.sleep(1000);
//				player = Game.getCurrentPlayer();
//				long timeLeft = player.getTimeLeft();
//				player.setTimeLeft(--timeLeft);
//				System.out.println("Player " + player.getColor() + " has " + player.getTimeLeft() + "seconds left.");
//
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
}
