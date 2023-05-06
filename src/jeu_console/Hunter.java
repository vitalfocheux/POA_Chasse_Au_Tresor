/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public class Hunter extends Character {
	
	private boolean treasure;

	public Hunter(Position pos, String nom, char c) {
		super(pos, nom, c);
		treasure = false;
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void process(Character c) {
		int dir = c.getDir();
		do {
			c.setDir( (int)(Math.random() * (7) + 1));
		}while(c.getDir() == dir);
	}
	
	public boolean haveTreasure() {
		return treasure;
	}
	
	public void gotTreasure() {
		treasure = true;
	}

}
