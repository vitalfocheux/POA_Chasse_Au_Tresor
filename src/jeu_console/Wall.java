package jeu_console;

import java.util.*;

/**
 * Describe a wall on a map by means of list of stones
 * @author Vital FOCHEUX
 *
 */
public class Wall{
	
	private LinkedList<Stone> stones;
	private int orientation; //0 : horizontal / 1 : vertical

	/**
	 * 
	 * @param orientation the orientation of the wall, 0  is horizontal, 1 is vertical
	 */
	public Wall(int orientation) {
		this.stones = new LinkedList<Stone>();
		this.orientation = orientation;
	}
	
	/**
	 * 
	 * @param stone the stone to add of the wall
	 */
	public void addStone(Stone stone) {
		stones.add(stone);
		Collections.sort(stones);
	}
	
	/**
	 * 
	 * @return the list of stones
	 */
	public LinkedList<Stone> getStones(){
		return stones;
	}
	
	/**
	 * 
	 * @return the orientation of the wall
	 */
	public int getOrientation() {
		return orientation;
	}
	
}
