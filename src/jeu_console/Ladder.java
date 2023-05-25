/**
 * 
 */
package jeu_console;

/**
 * Describe a ladder on a map by means of a position
 * @author Vital FOCHEUX
 *
 */
public class Ladder extends Tool {

	private String str = "";
	
	/**
	 * 
	 * @param pos the position of the ladder
	 */
	public Ladder(Position pos) {
		super(pos);
	}
	
	public String whoTookLadder() {
		return str;
	}
	
	private void tookLadder(String str) {
		this.str = str;
	}
	
	/**
	 * Perform the process that chracter <i>c</i> must perform when encountering 
	 * a ladder by adding it to their inventory if they don't have one.
	 */
	@Override
	public void process(Character c) {
		if(!c.haveAlreadyLadder()) {
			String str = "";
			str += c.getNom();
			if(c instanceof Hunter) {
				str += " le chasseur ";
			}else if(c instanceof Wise) {
				str += " le mage ";
			}else if(c instanceof Cheater) {
				str += " le tricheur ";
			}
			str += "("+c+") a recupéré une échelle";
			System.out.println(str);
			tookLadder(str);
			c.takeLadder();
		}
		
	}

	/**
	 * @return the String representation of the ladder
	 */
	@Override
	public String toString() {
		return "l";
	}
	
}
