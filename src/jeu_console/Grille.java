/**
 * 
 */
package jeu_console;

import java.util.*;

/**
 * Describe a grille on a map by means of a list of occupants
 * @author Vital FOCHEUX
 *
 */
public class Grille {
	
	private int X = 16;
	private int Y = 31;

	private Map<Position, List<Occupant>> grille;
	
	/**
	 * 
	 * @param occupants the list of occupants on the map
	 */
	public Grille(List<Occupant> occupants) {
		grille = new TreeMap<Position, List<Occupant>>();
		for(Occupant occupant : occupants) {
			ArrayList<Occupant> liste = new ArrayList<Occupant>();
			liste.add(occupant);
			grille.put(occupant.getPos(), liste);
		}
	}
	
	/**
	 * Display the grid as a map
	 */
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
	
	/**
	 * 
	 * @param pos the position of the occupant
	 * @param i the index of the occupant in the list
	 * @return the occupant at index <i>i</i> if it exists, otherwise returns null 
	 */
	public Occupant getOccupant(Position pos, int i) {
		if(!grille.get(pos).isEmpty()) {
			return grille.get(pos).get(i);
		}
		return null;
	}
	
	/**
	 * Remove the occupant at index <i>i</i>
	 * @param pos the position of the occupant
	 * @param i the index of the occupant in the list
	 */
	public void removeOccupant(Position pos, int i) {
		grille.get(pos).remove(i);
	}
	
	/**
	 * Add the occupant <i>o</i> in the list
	 * @param pos the position of the occupant
	 * @param o the occupant
	 */
	public void addOccupant(Position pos, Occupant o) {
		if(!grille.containsKey(pos)) {
			grille.put(pos, new ArrayList<Occupant>());
		}
		grille.get(pos).add(o);
	}
	
	/**
	 * 
	 * @param pos the position of the occupant
	 * @return the size of the occupants list at position <i>pos</i>
	 */
	public int getSizeListOccupant(Position pos){
		if(!grille.containsKey(pos)) {
			grille.put(pos,new ArrayList<Occupant>());
		}
		return grille.get(pos).size();
	}
}
