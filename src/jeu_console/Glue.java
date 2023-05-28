/**
 * 
 */
package jeu_console;

/**
 * Describe a glue on a map by means of a position
 * @author Vital FOCHEUX
 *
 */
public class Glue extends Fixed {
	
	/**
	 * 
	 * @param pos the position of the glue
	 */
	public Glue(Position pos) {
		super(pos);
	}

	/**
	 * @return the String representation of the glue
	 */
	@Override
	public String toString() {
		return "~";
	}

	/**
	 * Perform the process that character <i>c</i> must perform
	 * when encountering glue by incrementing its waiting laps by one
	 */
	@Override
	public void process(Character c) {
		String str = c.getNom();
		if(c instanceof Hunter) {
			str += " le chasseur ";
		}else if(c instanceof Wise) {
			str += " le mage ";
		}else if(c instanceof Cheater) {
			str += " le tricheur ";
		}
		str += "("+c+") s'est retrouvé dans la colle";
		c.upRoundWait();		
		this.setHistoProcess(str);
	}
	
}
