package jeu_interface_graphique;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import jeu_console.*;

public class Controleur implements ActionListener{
	
	private Game game;
	private Window window;


	public Controleur(Game game, Window window) {
		this.game = game;
		this.window = window;
		window.addListener(this);
	}
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch(command) {
			case "Nouvelle partie":
				game = new Game();
				game.initialisation();
				update(game.getGrille());
				window.enabledNewGame(false);
				window.enabledPlayManual(true);
				window.enabledPlayAuto(true);
				window.enabledNextRound(true);
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
			           window.updateHistory("Tour n°"+(game.getRound()-1));
			           window.updateHistory(game.getHistory());
			        }
			        window.enabledNewGame(true);
			        game.results();
					window.updateHistory(game.getHistory());
			    }).start();				
				break;
			case "Tour suivant":
				if(game.treasureIsFind()) {
					window.enabledNextRound(false);
					window.enabledNewGame(true);
					game.results();
					window.updateHistory(game.getHistory());
				}
				game.playARound();
				update(game.getGrille());
				window.updateHistory("Tour n°"+(game.getRound()-1));
			default:
				break;
		}
	}

}
