package jeu_interface_graphique;

import jeu_console.Game;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Window();
		new Controleur(new Game(5,5,5,3,3,3,5,3), new Window());
	}

}