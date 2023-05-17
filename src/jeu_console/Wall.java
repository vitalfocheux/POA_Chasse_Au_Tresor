package jeu_console;

import java.util.*;

public class Wall{
	
	private LinkedList<Stone> stones;
	private int orientation; //0 : horizontal / 1 : vertical

	public Wall(int orientation) {
		this.stones = new LinkedList<Stone>();
		this.orientation = orientation;
	}
	
	public void addStone(Stone stone) {
		stones.add(stone);
		Collections.sort(stones);
	}
	
	public LinkedList<Stone> getStones(){
		return stones;
	}
	
	public int getOrientation() {
		return orientation;
	}
	
}
