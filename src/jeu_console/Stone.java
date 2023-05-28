package jeu_console;

import java.util.LinkedList;

/**
 * Describe a stone on a map by means of the position
 * @author Vital FOCHEUX
 *
 */
public class Stone extends Fixed implements Comparable<Stone>{
	
	private Wall wall;
	
	/**
	 * 
	 * @param pos the position of the stone
	 */
	public Stone(Position pos) {
		super(pos);
	}
	
	/**
	 * @param wall the wall to wich the stone belongs
	 */
	public void addWall(Wall wall) {
		this.wall = wall;
	}
	
	/**
	 * @return the String representation of the stone
	 */
	@Override
	public String toString() {
		return"#";
	}

	/**
	 * Perform the process that the character <i>c</i> must perform
	 * when encountering a wall by changing its temp direction
	 */
	@Override
	public void process(Character c) {
		String str = c.getNom();
		if(c instanceof Hunter) {
			str += " le chasseur ";
		}else if(c instanceof Wise) {
			str += " le mage ";
		}else if(c instanceof Cheater) {
			str += " le tricheur ";
		}
		str += "("+c+")";
		if(c.haveAlreadyLadder()) {
			str += " a utilisé une échelle pour grimper le mur";
			c.walk(c.getNextPosition(c.getDir()));
			c.setUseLadder(true);
		}else if(c.haveAlreadyPickaxe()) {
			str += " a utilisé une pioche pour casser la pierre";
			c.walk(c.getNextPosition(c.getDir()));
			c.usePickaxe();
			c.setUsePickaxe(true);
		}else {
			int orientation = wall.getOrientation();
			LinkedList<Stone> stones = wall.getStones();
			if(orientation == 0) {
				if(stones.getFirst().getPos().equals(this.getPos())) {
					if(c.getDir() == 1 || c.getDir() == 2) {
						str += " a été redirigé temporairement dans la direction 3";
						c.setDirTemp(3);
					}else if(c.getDir() == 3 || c.getDir() == 4 || c.getDir() == 6 || c.getDir() == 7) {
						str += " a été redirigé temporairement dans la direction 5";
						c.setDirTemp(5);
					}else if(c.getDir() == 8) {
						str += " a été redirigé temporairement dans la direction 7";
						c.setDirTemp(7);
					}
				}else if(stones.getLast().getPos().equals(this.getPos())) {
					if(c.getDir() == 2 || c.getDir() == 3 || c.getDir() == 7 || c.getDir() == 8) {
						str += " a été redirigé temporairement dans la direction 1";
						c.setDirTemp(1);
					}else if(c.getDir() == 4 || c.getDir() == 5) {
						str += " a été redirigé temporairement dans la direction 3";
						c.setDirTemp(3);
					}else if(c.getDir() == 6) {
						str += " a été redirigé temporairement dans la direction 7";
						c.setDirTemp(7);
					}
				}else if(Math.abs(stones.getLast().getPos().getCol() - this.getPos().getCol()) < Math.abs(stones.getFirst().getPos().getCol() - this.getPos().getCol())) {
					str += " a été redirigé temporairement dans la direction 1";
					c.setDirTemp(1);
				}else {
					str += " a été redirigé temporairement dans la direction 5";
					c.setDirTemp(5);
				}
			}else {
				if(stones.getFirst().getPos().equals(this.getPos())) {
					if(c.getDir() == 1 || c.getDir() == 2 || c.getDir() == 4 || c.getDir() == 5) {
						str += " a été redirigé temporairement dans la direction 3";
						c.setDirTemp(3);
					}else if(c.getDir() == 6 || c.getDir() == 7) {
						str += " a été redirigé temporairement dans la direction 5";
						c.setDirTemp(5);
					}else if(c.getDir() == 8) {
						str += " a été redirigé temporairement dans la direction 1";
						c.setDirTemp(1);
					}
				}else if(stones.getLast().getPos().equals(this.getPos())) {
					if(c.getDir() == 1 || c.getDir() == 5 || c.getDir() == 6 || c.getDir() == 8) {
						str += " a été redirigé temporairement dans la direction 7";
						c.setDirTemp(7);
					}else if(c.getDir() == 2 || c.getDir() == 3) {
						str += " a été redirigé temporairement dans la direction 1";
						c.setDirTemp(1);
					}else if(c.getDir() == 4) {
						str += " a été redirigé temporairement dans la direction 5";
						c.setDirTemp(5);
					}
				}else if(Math.abs(stones.getLast().getPos().getRow() - this.getPos().getRow()) < Math.abs(stones.getFirst().getPos().getRow() - this.getPos().getRow())) {
					str += " a été redirigé temporairement dans la direction 3";
					c.setDirTemp(3);
				}else {
					str += " a été redirigé temporairement dans la direction 7";
					c.setDirTemp(7);
				}
			}
		}
		this.setHistoProcess(str);
	}

	/**
	 * Compare the stone <i>this</i> with the stone <i>o</i>
	 * by comparing their positions
	 */
	@Override
	public int compareTo(Stone o) {
		return this.getPos().compareTo(o.getPos());
	}

}
