/**
 * 
 */
package jeu_console;

import java.util.*;

/**
 * @author Vital FOCHEUX
 *
 */
public class Grille {
	
	private int X = 16;
	private int Y = 31;

	private Map<Position, List<Occupant>> grille;
	
	public Grille(List<Occupant> occupants) {
		grille = new TreeMap<Position, List<Occupant>>();
		for(Occupant occupant : occupants) {
			ArrayList<Occupant> liste = new ArrayList<Occupant>();
			liste.add(occupant);
			grille.put(occupant.getPos(), liste);
		}
	}
	
	public void afficher() {
		for(int x = 0; x < X; ++x) {
			for(int y = 0; y < Y; ++y) {
				Position pos = new Position(x, y);
				if(!grille.containsKey(pos) || grille.get(pos).size() == 0) {
					System.out.print(" ");
				}else {
					System.out.print(grille.get(pos).get(grille.get(pos).size() - 1));
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public Occupant getOccupant(Position pos, int i) {
		if(!grille.get(pos).isEmpty()) {
			return grille.get(pos).get(i);
		}
		return null;
	}
	
	public void removeOccupant(Position pos, int i) {
		grille.get(pos).remove(i);
	}
	
	public void addOccupant(Position pos, Occupant o) {
		if(!grille.containsKey(pos)) {
			grille.put(pos, new ArrayList<Occupant>());
		}
		grille.get(pos).add(o);
	}
	
	public int getSizeListOccupant(Position pos){
		if(!grille.containsKey(pos)) {
			grille.put(pos,new ArrayList<Occupant>());
			
		}
		return grille.get(pos).size();
	}
	
	public boolean isFree(Position pos) {
		if(!grille.containsKey(pos)) {
			return true;
		}
		if(grille.get(pos).size() == 2) {
			return false;
		}else if(grille.get(pos).size() == 1 && (grille.get(pos).get(0) instanceof Character || grille.get(pos).get(0) instanceof Border)) {
			return false;
		}
		return true;
	}
}
