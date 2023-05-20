/**
 * 
 */
package jeu_console;

import java.util.*;

/**
 * Describe a character on a map by means of a position, a name and a character
 * @author Vital FOCHEUX
 *
 */
public abstract class Character extends Occupant implements Moveable{
	
	private Set<String> tools;
	private boolean haveUseLadder, haveUsePickaxe;
	private String nom;
	private char c;
	private int dir, dirTemp, roundWait;
	
	/**
	 * Builds a character with <i>pos</i> as the position,
	 * <i>nom</i> as the name and <i>c</i> as the char.
	 * @param pos the position of the character
	 * @param nom the name of the character
	 * @param c the representation of the character with toString
	 */
	public Character(Position pos, String nom, char c) {
		super(pos);
		dirTemp = 0;
		tools = new TreeSet<String>();
		haveUseLadder = false;
		haveUsePickaxe = false;
		this.nom = nom;
		this.c = c;
		roundWait = 0;
		dir = (int)(Math.random() * 8 + 1);
	}
	
	/**
	 * 
	 * @return the name of the character
	 */	
	public String getNom() {
		return nom;
	}
	
	/**
	 * @return the dirTemp of the character
	 */
	public int getDirTemp() {
		return dirTemp;
	}

	/**
	 * @param dirTemp the dirTemp to set
	 */
	public void setDirTemp(int dirTemp) {
		this.dirTemp= dirTemp;
	}

	/**
	 * 
	 * @return the roundWait of the character
	 */
	public int getRoundWait() {
		return roundWait;
	}
	
	/**
	 * Decrease the number of laps to wait by one
	 */
	public void downRoundWait() {
		--roundWait;
	}
	
	/**
	 * Increase the number of laps to wait by one
	 */
	public void upRoundWait() {
		++roundWait;
	}
	
	/**
	 * 
	 * @return the direction of the character
	 */
	public int getDir() {
		return dir;
	}
	
	/**
	 * 
	 * @param dir the direction to set
	 */
	public void setDir(int dir) {
		this.dir = dir;
	}
	
	/**
	 * @return the next position based on the character's direction.
	 */
	@Override
	public Position getNextPosition(int dir) {
		switch(dir) {
			case 1:
				return new Position(this.getPos().getRow(), this.getPos().getCol()+1);
			case 2:
				return new Position(this.getPos().getRow()-1, this.getPos().getCol()+1);
			case 3:
				return new Position(this.getPos().getRow()-1, this.getPos().getCol());
			case 4:
				return new Position(this.getPos().getRow()-1, this.getPos().getCol()-1);
			case 5:
				return new Position(this.getPos().getRow(), this.getPos().getCol()-1);
			case 6:
				return new Position(this.getPos().getRow()+1, this.getPos().getCol()-1);
			case 7:
				return new Position(this.getPos().getRow()+1, this.getPos().getCol());
			case 8:
				return new Position(this.getPos().getRow()+1, this.getPos().getCol()+1);
			}
		return null;
	}
	
	/**
	 * @param pos the position to walk for the character
	 */
	@Override
	public void walk(Position pos) {
		super.setPos(pos);
	}
	
	/**
	 * 
	 * @return whether the character has a ladder or not.
	 */
	public boolean haveAlreadyLadder() {
		return tools.contains("Ladder");
	}
	
	/**
	 * Use the ladder that the character has
	 */
	public void useLadder() {
		tools.remove("Ladder");
	}
	
	/**
	 * Pick up the ladder when he doesn't have one.
	 */
	public void takeLadder() {
		if(!tools.contains("Ladder")) {
			tools.add("Ladder");
		}
	}
	
	/**
	 * 
	 * @return whether the character used a ladder or not
	 */
	public boolean haveUseLadder() {
		return haveUseLadder;
	}
	
	/**
	 * 
	 * @param b the used of the ladder to set
	 */
	public void setUseLadder(boolean b) {
		haveUseLadder = b;
	}
	
	/**
	 * 
	 * @return whether the character has a pickaxe or not.
	 */
	public boolean haveAlreadyPickaxe() {
		return tools.contains("Pickaxe");
	}
	
	/**
	 * Use the pickaxe that the character has
	 */
	public void usePickaxe() {
		tools.remove("Pickaxe");
	}
	
	/**
	 * Pick up the ladder when he doesn't have one.
	 */
	public void takePickaxe() {
		if(!tools.contains("Pickaxe")) {
			tools.add("Pickaxe");
		}
	}
	
	/**
	 * 
	 * @return whether the character used a ladder or not
	 */
	public boolean haveUsePickaxe() {
		return haveUsePickaxe;
	}
	
	/**
	 * 
	 * @param b the used of the pickaxe to set
	 */
	public void setUsePickaxe(boolean b) {
		haveUsePickaxe = b;
	}
	
	/**
	 * 
	 * @return the String representation of the character
	 */
	@Override
	public String toString() {
		return c+"";
	}
}
