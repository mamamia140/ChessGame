package Game;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
	private Scanner sc;
	private String input;
	private Pattern regex;
	
	public Controller() {
		this.sc = new Scanner(System.in);
		this.regex = Pattern.compile("((?:(?:O-O[-0]?)|(?:[KQNBR][a-h]?x?[a-h]x?[1-8])|(?:[a-h]x?[a-h]?[1-8]))\\+?)");
	}
	
	public String getCommandLineInput(){
		
		input = this.sc.nextLine();
		while(!regex.matcher(input).find() && !input.equals("quit") && !input.equals("change")) {
			System.out.println("Not a valid notation.");
			input =  this.sc.nextLine();
		}
		return input;
	}
	
	public Move getTheNextMove() {
		//bussy wait the next move
		return null;
	}
	
}
