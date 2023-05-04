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
		for(int x = 0; x < 10; ++x) {
			for(int y = 0; y < 10; ++y) {
				Position pos = new Position(x, y);
				if(grille.containsKey(pos)) {
					System.out.print(" ");
				}else {
					System.out.print(grille.get(pos).get(0));
				}
			}
			System.out.println();
		}
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
		grille.get(pos).add(o);
	}
}
