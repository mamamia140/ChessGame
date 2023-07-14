package main;

public class Game {
	private Clock[] clocks;
	private int duration;
	private Player players;
	private Board board;
	private Move[][] moveHistory;
	private String turn;
	
	public Game() {
		this.clocks = new Clock[2];
		
	}
}
