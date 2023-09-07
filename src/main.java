import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Controller c = new Controller();
		boolean menu = true;
		int input;
		Scanner sc = new Scanner(System.in);
		System.out.println("1-Play");
		System.out.println("2-Quit");
		
		while(menu) {
			input = sc.nextInt();
			switch(input) {
				case 1:
					Game game = new Game(300);
					game.start(c);
				case 2:
					menu = false;
					break;
					
				default:
					System.out.println("No match. Please try again.");
			}
			
		}
		System.out.println("Goodbye :)");
		sc.close();
		
	}

}
