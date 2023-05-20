package jeu_console;


/**
 * Describe the main
 * @author Vital FOCHEUX
 *
 */
public class Main {

	/**
	 * 
	 * @param args the arguments of the main
	 */
	public static void main(String[] args) {
			
		Game g = new Game();
		g.initialisation();
		g.play();
	}

}
