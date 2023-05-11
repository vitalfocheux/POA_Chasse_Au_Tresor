package jeu_console;

import java.util.*;

public class Wall{
	
	private LinkedList<Stone> stones;
	private int orientation; //0 : horizontal / 1 : vertical

	public Wall(LinkedList<Stone> stones, int orientation) {
		this.stones = stones;
		this.orientation = orientation;
	}
	
	public Wall() {
		stones = new LinkedList<Stone>();
	}
	
	public void addStone(Stone stone) {
		stones.add(stone);
		Collections.sort(stones);
	}
	
	/*public boolean isInWall(Stone stone) {
		for(Stone st : stones) {
			if(st.getPos().equals(stone.getPos())) {
				return true;
			}
		}
		return false;
	}*/
	
	public int getOrientation() {
		return orientation;
	}
	
	public int getDirectionTemp(Stone stone) {
		if(orientation == 0) {
			if(Math.abs(stones.getLast().getPos().getCol() - stone.getPos().getCol()) < Math.abs(stones.getFirst().getPos().getCol() - stone.getPos().getCol())) {
				return 1;
			}else {
				return 5;
			}
		}else {
			if(Math.abs(stones.getLast().getPos().getRow() - stone.getPos().getRow()) < Math.abs(stones.getFirst().getPos().getRow() - stone.getPos().getRow())) {
				return 3;
			}else {
				return 7;
			}
		}
	}
	
}
