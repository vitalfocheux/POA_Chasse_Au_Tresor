package jeu_console;

import java.util.LinkedList;

public class Stone extends Fixed implements Comparable<Stone>{
	
	private Wall wall;
	
	public Stone(Position pos) {
		super(pos);
	}
	
	public void addWall(Wall wall) {
		this.wall = wall;
	}
	
	@Override
	public String toString() {
		return"#";
	}

	@Override
	public void process(Character c) {
		if(c.haveAlreadyLadder()) {
			c.walk(c.getNextPosition(c.getDir()));
			c.setUseLadder(true);
		}else if(c.haveAlreadyPickaxe()) {
			c.walk(c.getNextPosition(c.getDir()));
			c.usePickaxe();
			c.setUsePickaxe(true);
		}else {
			int orientation = wall.getOrientation();
			LinkedList<Stone> stones = wall.getStones();
			if(orientation == 0) {
				if(stones.getFirst().getPos().equals(this.getPos())) {
					if(c.getDir() == 1 || c.getDir() == 2) {
						c.setDirTemp(3);
					}else if(c.getDir() == 3 || c.getDir() == 4 || c.getDir() == 6 || c.getDir() == 7) {
						c.setDirTemp(5);
					}else if(c.getDir() == 8) {
						c.setDirTemp(7);
					}
				}else if(stones.getLast().getPos().equals(this.getPos())) {
					if(c.getDir() == 2 || c.getDir() == 3 || c.getDir() == 7 || c.getDir() == 8) {
						c.setDirTemp(1);
					}else if(c.getDir() == 4 || c.getDir() == 5) {
						c.setDirTemp(3);
					}else if(c.getDir() == 6) {
						c.setDirTemp(7);
					}
				}else if(Math.abs(stones.getLast().getPos().getCol() - this.getPos().getCol()) < Math.abs(stones.getFirst().getPos().getCol() - this.getPos().getCol())) {
					c.setDirTemp(1);
				}else {
					c.setDirTemp(5);
				}
			}else {
				if(stones.getFirst().getPos().equals(this.getPos())) {
					if(c.getDir() == 1 || c.getDir() == 2 || c.getDir() == 4 || c.getDir() == 5) {
						c.setDirTemp(3);
					}else if(c.getDir() == 6 || c.getDir() == 7) {
						c.setDirTemp(5);
					}else if(c.getDir() == 8) {
						c.setDirTemp(1);
					}
				}else if(stones.getLast().getPos().equals(this.getPos())) {
					if(c.getDir() == 1 || c.getDir() == 5 || c.getDir() == 6 || c.getDir() == 8) {
						c.setDirTemp(7);
					}else if(c.getDir() == 2 || c.getDir() == 3) {
						c.setDirTemp(1);
					}else if(c.getDir() == 4) {
						c.setDirTemp(5);
					}
				}else if(Math.abs(stones.getLast().getPos().getRow() - this.getPos().getRow()) < Math.abs(stones.getFirst().getPos().getRow() - this.getPos().getRow())) {
					c.setDirTemp(3);
				}else {
					c.setDirTemp(7);
				}
			}
		}
	}

	@Override
	public int compareTo(Stone o) {
		return this.getPos().compareTo(o.getPos());
	}

}
