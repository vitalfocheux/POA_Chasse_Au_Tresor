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
	
	public Game() {
		round = 1;
		win = false;
		occupants = new ArrayList<Occupant>();
	}
	
}
