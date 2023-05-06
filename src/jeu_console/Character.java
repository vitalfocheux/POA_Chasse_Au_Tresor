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
	
	private Position tempPos;
	private Set<String> tools;
	private String nom;
	private char c;
	private int dir, roundWait;

	public Character(Position pos, String nom, char c) {
		super(pos);
		tempPos = null;
		tools = new TreeSet<String>();
		this.nom = nom;
		this.c = c;
		roundWait = 0;
		dir = (int)(Math.random() * 8 + 1);
		// TODO Auto-generated constructor stub
	}
	
	public String getNom() {
		return nom;
	}
	
	
	
	/**
	 * @return the tempPos
	 */
	public Position getTempPos() {
		return tempPos;
	}

	/**
	 * @param tempPos the tempPos to set
	 */
	public void setTempPos(Position tempPos) {
		this.tempPos = tempPos;
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
	public void newDirection(int dir) {
		if(dir < 5) {
			setDir(dir+4);
		}else {
			setDir(dir-4);
		}
	}
	
	@Override
	public void walk(Position pos) {
		super.setPos(pos);
	}
	
	@Override
	public int distanceBetween(Position from, Position to) {
		return (int)Math.pow((int)Math.abs(from.getCol() - to.getCol()), 2) + (int)Math.pow((int)Math.abs(from.getRow() - to.getRow()), 2);
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
	
	public boolean haveAlreadyPickaxe() {
		return tools.contains("Pickaxe");
	}
	
	public void usePickaxe() {
		tools.remove("Pickaxe");
	}
	
	public void takePickaxe() {
		tools.add("Pickaxe");
	}
	
	@Override
	public String toString() {
		return c+"";
	}
	

}
