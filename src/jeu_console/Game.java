package jeu_console;

import java.util.*;

/**
 * 
 * @author Vital FOCHEUX
 *
 */

public class Game {

	private int round;
	private boolean win;
	private List<Occupant> occupants;
	private int qte_hunter;
	private int qte_pickaxe;
	private int qte_ladder;
	//private int qte_wall;
	private int qte_glue;
	private final int X = 10;
	private final int Y = 10;
	
	public Game() {
		round = 1;
		win = false;
		occupants = new ArrayList<Occupant>();
		qte_hunter = 1;
		qte_pickaxe = 1;
		qte_ladder = 1;
		//qte_wall = 1;
		qte_glue = 1;
		
		for (int y = 0; y < Y; ++y) {
			Position pos0 = new Position(0,y);
			Position posX = new Position(X,y);
			Border bord0 = new Border(pos0);
			Border bordX = new Border(posX);
			occupants.add(bord0);
			occupants.add(bordX);
		}
		for (int x = 1; x < X-1; ++x) {
			Position pos0 = new Position(x,0);
			Position posY = new Position(x,Y);
			Border bord0 = new Border(pos0);
			Border bordY = new Border(posY);
			occupants.add(bord0);
			occupants.add(bordY);
		}
		{
			Position pos = getFreeRandomPosition();
			Treasure t = new Treasure(pos);
			occupants.add(t);
		}
		for (int i = 0; i < qte_hunter; ++i) {
			Position pos = getFreeRandomPosition();
			Hunter h = new Hunter(pos, new String('A'+ i + ""));
			occupants.add(h);
		}
		for (int i = 0; i < qte_pickaxe; ++i) {
			Position pos = getFreeRandomPosition();
			Pickaxe p = new Pickaxe(pos);
			occupants.add(p);
		}
		for (int i = 0; i < qte_ladder; ++i) {
			Position pos = getFreeRandomPosition();
			Ladder p = new Ladder(pos);
			occupants.add(p);
		}
		/*for (int i = 0; i < qte_wall; ++i) {
			Position pos = getFreeRandomPosition();
			Wall w = new Wall(pos);
			occupants.add(w);
		}*/
		for (int i = 0; i < qte_glue; ++i) {
			Position pos = getFreeRandomPosition();
			Glue p = new Glue(pos);
			occupants.add(p);
		}
		
		
	}
	
	public Position getFreeRandomPosition() {
		Position pos;
		do { pos = getRandomPosition(); }
		while (!posIsFree(pos));
		return pos;
	}
	
	public Position getRandomPosition() {
		int x = (int)(Math.random() * (X-2) + 1);
		int y = (int)(Math.random() * (Y-2) + 1);
		return new Position(x,y);
	}
	
	public boolean posIsFree(Position pos) {
		for (Occupant o : occupants) {
			if (o.getPos().equals(pos)) {
				return false;
			}
		}
		return true;
	}
	
}
