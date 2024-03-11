package Game;

import java.util.Scanner;

import GUI.Screen;

public class main {

	public static void main(String[] args) {
		Game game = new Game(300);
		Screen screen = new Screen(game);
		game.start();
	}

}
