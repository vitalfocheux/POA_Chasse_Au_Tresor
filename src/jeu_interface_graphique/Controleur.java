/**
 * The Controleur class represents the controller in a graphical interface game.
 * It implements the ActionListener interface to handle user actions.
 */
package jeu_interface_graphique;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import jeu_console.*;

/**
 * The Controleur class represents the controller for a graphical interface game.
 * It implements the ActionListener interface to handle UI events.
 * @author Vital FOCHEUX
 */
public class Controleur implements ActionListener{
	
	private Game game;
	private Window window;
	private ArrayList<Integer> stats;


	/**
	 * Constructs a `Controleur` object with the specified `Game` and `Window`.
	 * @param game the game instance to control
	 * @param window the graphical window instance
	 */
	public Controleur(Game game, Window window) {
		this.game = game;
		stats = game.getStats();
		this.window = window;
		window.addListener(this);
	}
	
	/**
	 * Updates the graphical representation of the game grid based on the provided `Grille`.
	 * @param grille the grid to update the graphical representation for
	 */
	private void update(Grille grille) {
		for(int i = 1; i < 15; ++i) {
			for(int j = 1; j < 30; ++j) {
				Position pos = new Position(i,j);
				if(grille.getOccupant(pos, grille.getSizeListOccupant(pos) - 1) == null) {
					try {
			            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Tiles/Path.png"));

			           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
			        } catch (IOException ex) {
			            ex.printStackTrace();
			        }
				}else {
					Occupant o = grille.getOccupant(pos, grille.getSizeListOccupant(pos) - 1);
					if(o instanceof Stone) {
						try {
				            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Tiles/Wall.png"));

				           window.updateMap(new ImageIcon(smallImage),(i-1), (j-1));
				        } catch (IOException ex) {
				            ex.printStackTrace();
				        }
					}else if(o instanceof Treasure) {
						try {
				            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Tiles/treasure.png"));

				           window.updateMap(new ImageIcon(smallImage),(i-1), (j-1));
				        } catch (IOException ex) {
				            ex.printStackTrace();
				        }
					}else if(o instanceof Ladder) {
						try {
				            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Tools/Ladder.png"));

				           window.updateMap(new ImageIcon(smallImage),(i-1), (j-1));
				        } catch (IOException ex) {
				            ex.printStackTrace();
				        }
					}else if(o instanceof Pickaxe) {
						try {
				            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Tools/Pickaxe.png"));

				           window.updateMap(new ImageIcon(smallImage),(i-1), (j-1));
				        } catch (IOException ex) {
				            ex.printStackTrace();
				        }
					}else if(o instanceof Glue) {
						try {
				            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Tiles/Glue.png"));

				           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
				        } catch (IOException ex) {
				            ex.printStackTrace();
				        }
					}else if(o instanceof Hunter) {
						if(grille.getOccupant(pos, 0) instanceof Stone && ((Hunter)(o)).haveUseLadder()) {
							try {
					            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Characters/Hunter/Hunter_on_wall.png"));

					           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
					        } catch (IOException ex) {
					            ex.printStackTrace();
					        }
						}else if(grille.getOccupant(pos, 0) instanceof Glue) {
							try {
					            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Characters/Hunter/Hunter_on_glue.png"));

					           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
					        } catch (IOException ex) {
					            ex.printStackTrace();
					        }
						}else {
							try {
					            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Characters/Hunter/Hunter_on_path.png"));

					           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
					        } catch (IOException ex) {
					            ex.printStackTrace();
					        }
						}
					}else if(o instanceof Cheater) {
						if(grille.getOccupant(pos, 0) instanceof Stone && ((Cheater)(o)).haveUseLadder()) {
							try {
					            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Characters/Cheater/Cheater_on_wall.png"));

					           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
					        } catch (IOException ex) {
					            ex.printStackTrace();
					        }
						}else if(grille.getOccupant(pos, 0) instanceof Glue) {
							try {
					            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Characters/Cheater/Cheater_on_glue.png"));

					           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
					        } catch (IOException ex) {
					            ex.printStackTrace();
					        }
						}else {
							try {
					            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Characters/Cheater/Cheater_on_path.png"));

					           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
					        } catch (IOException ex) {
					            ex.printStackTrace();
					        }
						}
					}else if(o instanceof Wise) {
						if(grille.getOccupant(pos, 0) instanceof Stone && ((Wise)(o)).haveUseLadder()) {
							try {
					            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Characters/Wise/Wise_on_wall.png"));

					           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
					        } catch (IOException ex) {
					            ex.printStackTrace();
					        }
						}else if(grille.getOccupant(pos, 0) instanceof Glue) {
							try {
					            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Characters/Wise/Wise_on_glue.png"));

					           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
					        } catch (IOException ex) {
					            ex.printStackTrace();
					        }
						}else {
							try {
					            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Characters/Wise/Wise_on_path.png"));

					           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
					        } catch (IOException ex) {
					            ex.printStackTrace();
					        }
						}
					}else if(o instanceof RoadMap) {
						try {
				            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Tiles/Roadmap.png"));

				           window.updateMap(new ImageIcon(smallImage), (i-1), (j-1));
				        } catch (IOException ex) {
				            ex.printStackTrace();
				        }
					}
				}
			}
		}
	}

	/**
	 * ActionListener implementation. Handles the events triggered by the UI.
	 * @param e The action event triggered
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch(command) {
			case "Nouvelle partie":
				window.cleanHistory();
				game = new Game(stats);
				game.initialisation();
				update(game.getGrille());
				window.enabledNewGame(false);
				window.enabledPlayManual(true);
				window.enabledPlayAuto(true);
				window.updateHistory("Carte lors de l'initialisation");
				break;
			case "Mode manuel":
				window.enabledPlayAuto(false);
				window.enabledPlayManual(false);
				window.enabledNextRound(true);
				break;
			case "Mode automatique":
				window.enabledPlayManual(false);
				window.enabledPlayAuto(false);
				window.enabledNextRound(false);
				new Thread(() -> {
			        while (!game.treasureIsFind() && game.getRound() <= 1000) {
			            game.playARound();
			            update(game.getGrille());
			            window.updateHistory("");
			            window.updateHistory("Tour n°"+(game.getRound()-1));
			            window.updateHistory("");
			            for(String str : game.getHistory()) {
							window.updateHistory(str);
						}
			        }
			        window.enabledNewGame(true);
			        game.results();
			        for(String str : game.getHistory()) {
						window.updateHistory(str);
					}
			    }).start();				
				break;
			case "Tour suivant":
				if(game.treasureIsFind()) {
					window.enabledNextRound(false);
					window.enabledNewGame(true);
					game.results();
					for(String str : game.getHistory()) {
						window.updateHistory(str);
					}
				}
				game.playARound();
				update(game.getGrille());
				window.updateHistory("");
				window.updateHistory("Tour n°"+(game.getRound()-1));
				window.updateHistory("");
				for(String str : game.getHistory()) {
					window.updateHistory(str);
				}
			default:
				break;
		}
	}

}
