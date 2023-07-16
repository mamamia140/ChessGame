import java.util.Scanner;

public class Controller {
	private Scanner sc;
	
	public Controller() {
		this.sc = new Scanner(System.in);
	}
	
	public String getTheNextMove(){
		return this.sc.nextLine();
	}
	
}
