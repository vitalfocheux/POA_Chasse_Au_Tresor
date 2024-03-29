/**
 * 
 */
package jeu_console;

/**
 * Describe a hunter on a map by means of a position, a name and a character
 * @author Vital FOCHEUX
 *
 */
public class Hunter extends Character {
	
	private boolean treasure;

	/**
	 * 
	 * @param pos  the position of the hunter
	 * @param nom the name of the hunter
	 * @param c the representation of the hunter with toString
	 */
	public Hunter(Position pos, String nom, char c) {
		super(pos, nom, c);
		treasure = false;
	}

	

	/**
	 * Perform the process that the character <i>c</i> must perform
	 * when encountering a hunter by randomly changing its direction.
	 */
	@Override
	public void process(Character c) {
		String str = this.getNom()+" le chasseur ("+this+") a redirigé "+c.getNom();
		if(c instanceof Hunter) {
			str += " le chasseur ";
		}else if(c instanceof Wise) {
			str += " le mage ";
		}else if(c instanceof Cheater) {
			str += " le tricheur ";
		}
		int dir = c.getDir();
		do {
			c.setDir( (int)(Math.random() * (7) + 1));
		}while(c.getDir() == dir);
		str += "("+c+") dans la direction aléatoire "+c.getDir();
		this.setHistoProcess(str);
	}
	
	/**
	 * 
	 * @return if the hunter have got the treasure or not
	 */
	public boolean haveTreasure() {
		return treasure;
	}
	
	/**
	 * Pick up the treasure
	 */
	public void gotTreasure() {
		treasure = true;
	}
}
