import java.time.*;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.TimeZone;

public class Clock extends Thread {

	private volatile boolean RUNNING = true;
	private volatile Player player;
	private volatile Instant start;
	private volatile Instant end;

	public void terminate() {
		RUNNING = false;
	}

	public void changeTurn() {
		
	}

	@Override
	public void run() {
		
		java.time.Clock clock = java.time.Clock.tickMinutes(TimeZone.getDefault().toZoneId());
		while(RUNNING) {
			System.out.println(LocalTime.now(clock).withNano(0).getSecond());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
//			System.out.println("Player " + player.getSide() + " has " + player.getTimeLeft() + "seconds left.");

