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
	private Grille grille;
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
		qte_hunter = 2;
		qte_pickaxe = 1;
		qte_ladder = 1;
		//qte_wall = 1;
		qte_glue = 1;
		
		
		/*for (int i = 0; i < qte_wall; ++i) {
			Position pos = getFreeRandomPosition();
			Wall w = new Wall(pos);
			occupants.add(w);
		}*/
		
	}
	
	public void initialisation() {
		for (int y = 0; y < Y; ++y) {
			occupants.add(new Border(new Position(0, y)));
			occupants.add(new Border(new Position((X-1), y)));
		}
		for (int x = 0; x < X; ++x) {
			occupants.add(new Border(new Position(x, 0)));
			occupants.add(new Border(new Position(x, (Y-1))));
		}
		occupants.add(new Treasure(getFreeRandomPosition()));
		for (int i = 0; i < qte_hunter; ++i) {
			char c = (char)('A'+ i);
			occupants.add(new Hunter(getFreeRandomPosition(), "Jean",c));
		}
		for (int i = 0; i < qte_pickaxe; ++i) {
			occupants.add(new Pickaxe(getFreeRandomPosition()));
		}
		for (int i = 0; i < qte_ladder; ++i) {
			occupants.add(new Ladder(getFreeRandomPosition()));
		}
		for (int i = 0; i < qte_glue; ++i) {
			occupants.add(new Glue(getFreeRandomPosition()));
		}
		grille = new Grille(occupants);
		System.out.println("Grille lors de l'initialisation du jeu :\n");
		afficher();
		for(Occupant o : occupants) {
			if(o instanceof Character) {
				System.out.println(o+" "+o.getPos()+" "+((Character)(o)).getDir());
			}
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
	
	public void afficher() {
		grille.afficher();
	}
	
	public void play() {
		/*
		System.out.println("Grille lors de l'initialisation du jeu :\n");
		afficher();*/
		for(;round < 4; ++round) {
			for(Occupant o : occupants) {
				if(o instanceof Hunter) {
					Character c = (Character)o;
					//System.out.println(c+" "+c.getPos()+" "+c.getDir()+" rd : "+(round-1));
					Position pos = c.getPos();
					Position next = ((Hunter) o).getNextPosition(c.getDir());
					Occupant pr = null;
					if(!grille.isFree(next)) {
						pr = grille.getOccupant(next, 0);
					}
					if(pr != null) {
						//System.out.println("process");
						pr.process(c);
					}
					
					
					if(pr == null) {
						int i = grille.getSizeListOccupant(pos);
						grille.removeOccupant(pos, (i-1));
						c.walk(next);
						grille.addOccupant(next, o);
					}
					
				}
			}
			System.out.println("\nTour n°"+round+" :\n");
			afficher();
			for(Occupant o : occupants) {
				if(o instanceof Character) {
					System.out.println(o+" "+o.getPos()+" "+((Character)(o)).getDir());
				}
			}
		}
		/*do {
			System.out.println("\nTour n°"+round+" :\n");
			win = true;
		}while(!win);*/
	}
	
}
