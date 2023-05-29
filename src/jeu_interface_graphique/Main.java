/**
 * 
 */
package jeu_interface_graphique;

import jeu_console.Game;

/**
 * Describe the Main class
 * @author Vital FOCHEUX
 *
 */
public class Main {
	/**
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new Controleur(new Game(5,5,5,3,3,3,5,3), new Window());
	}

}
