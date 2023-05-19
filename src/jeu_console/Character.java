/**
 * 
 */
package jeu_console;

import java.util.*;

/**
 * @author Vital FOCHEUX
 *
 */
public abstract class Character extends Occupant implements Moveable{
	
	private Set<String> tools;
	private boolean haveUseLadder, haveUsePickaxe;
	private String nom;
	private char c;
	private int dir, dirTemp, roundWait;

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
	
	public String getNom() {
		return nom;
	}
	
	
	
	/**
	 * @return the dirPos
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

	public int getRoundWait() {
		return roundWait;
	}
	
	public void downRoundWait() {
		--roundWait;
	}
	
	public void upRoundWait() {
		++roundWait;
	}
	
	public int getDir() {
		return dir;
	}
	
	public void setDir(int dir) {
		this.dir = dir;
	}
	
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
	
	@Override
	public void walk(Position pos) {
		super.setPos(pos);
	}
	
	public boolean haveAlreadyLadder() {
		return tools.contains("Ladder");
	}
	
	public void useLadder() {
		tools.remove("Ladder");
	}
	
	public void takeLadder() {
		if(!tools.contains("Ladder")) {
			tools.add("Ladder");
		}
	}
	
	public boolean haveUseLadder() {
		return haveUseLadder;
	}
	
	public void setUseLadder(boolean b) {
		haveUseLadder = b;
	}
	
	public boolean haveAlreadyPickaxe() {
		return tools.contains("Pickaxe");
	}
	
	public void usePickaxe() {
		tools.remove("Pickaxe");
	}
	
	public void takePickaxe() {
		tools.add("Pickaxe");
	}
	
	public boolean haveUsePickaxe() {
		return haveUsePickaxe;
	}
	
	public void setUsePickaxe(boolean b) {
		haveUsePickaxe = b;
	}
	
	@Override
	public String toString() {
		return c+"";
	}
	
	public String tools() {
		return "Tools : "+(haveAlreadyLadder() ? "Ladder" : "")+"; "+(haveAlreadyPickaxe() ? "Pickaxe" : "");
	}
}
