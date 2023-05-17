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
	private Grille grille;
	private int qte_hunter;
	private int qte_pickaxe;
	private int qte_ladder;
	private int qte_wall;
	private int qte_glue;
	private final int X = 10;
	private final int Y = 10;
	
	public Game() {
		round = 1;
		win = false;
		occupants = new ArrayList<Occupant>();
		qte_hunter = 2;
		qte_pickaxe = 1;
		qte_ladder = 1;
		qte_wall = 1;
		qte_glue = 1;
		
		
		/*for (int i = 0; i < qte_wall; ++i) {
			Position pos = getFreeRandomPosition();
			Wall w = new Wall(pos);
			occupants.add(w);
		}*/
		
	}
	
	public void initialisation() {
		for (int y = 0; y < Y; ++y) {
			occupants.add(new Border(new Position(0, y)));
			occupants.add(new Border(new Position((X-1), y)));
		}
		for (int x = 0; x < X; ++x) {
			occupants.add(new Border(new Position(x, 0)));
			occupants.add(new Border(new Position(x, (Y-1))));
		}
		
		
		occupants.add(new Treasure(new Position(4,2)));
		occupants.add(new RoadMap(new Position(5,5), (Treasure)occupants.get(occupants.size() - 1)));
		occupants.add(new Hunter(new Position(6,5), "Jean", 'A'));
		
		/*
		for(int i = 0; i < qte_wall; ++i) {
			int t = (int)(Math.random() * (X-5) + 2);
			int o = (int)(Math.random() * 2);
			Wall w = new Wall(o);
			ArrayList<Stone> stones = new ArrayList<Stone>();
			Position pos = getFreeRandomWallPosition();
			stones.add(new Stone(pos));
			w.addStone(stones.get(0));
			int j = 0;
			int k = 0;
			if(o == 0) {
				while((j + k) < (t-1)) {
					if(pos.getCol() + j == Y - 3) {
						++k;
						stones.add(new Stone(new Position(pos.getRow(), pos.getCol() - k)));
						w.addStone(stones.get((j + k)));
					}else {
						++j;
						stones.add(new Stone(new Position(pos.getRow(), pos.getCol() + j)));
						w.addStone(stones.get((j + k)));
					}
				}
			}else {
				while((j + k) < (t- 1)) {
					System.out.println((j+k));
					if(pos.getRow() + j == X - 3) {
						++k;
						stones.add(new Stone(new Position(pos.getRow() - k, pos.getCol())));
						w.addStone(stones.get((j + k)));
					}else {
						++j;
						stones.add(new Stone(new Position(pos.getRow() + j, pos.getCol())));
						w.addStone(stones.get((j + k)));
					}
				}
			}
			for(Stone st : stones) {
				st.addWall(w);
				occupants.add(st);
			}
		}
		
		
		occupants.add(new Treasure(getFreeRandomPosition()));
		occupants.add(new RoadMap(getFreeRandomPosition(), (Treasure)occupants.get(occupants.size() - 1)));
		for (int i = 0; i < qte_hunter; ++i) {
			char c = (char)('A'+ i);
			occupants.add(new Hunter(getFreeRandomPosition(), "Jean",c));
		}
		for (int i = 0; i < qte_pickaxe; ++i) {
			occupants.add(new Pickaxe(getFreeRandomPosition()));
		}
		for (int i = 0; i < qte_ladder; ++i) {
			occupants.add(new Ladder(getFreeRandomPosition()));
		}
		for (int i = 0; i < qte_glue; ++i) {
			occupants.add(new Glue(getFreeRandomPosition()));
		}*/
		
		grille = new Grille(occupants);
		System.out.println("Grille lors de l'initialisation du jeu :\n");
		afficher();
		for(Occupant o : occupants) {
			if(o instanceof Character) {
				System.out.println(o+" "+o.getPos()+" "+((Character)(o)).getDir());
			}
		}
	}
	
	public Position getFreeRandomWallPosition() {
		Position pos;
		do {
			pos = new Position((int)(Math.random() * (X-4) + 1), (int)(Math.random() * (Y-4) + 1));
			
		}while(!posIsFree(pos) || posIsNextToStone(pos));
		System.out.println(pos);
		return pos;
	}
	
	public Position getFreeRandomPosition() {
		Position pos;
		do { pos = getRandomPosition(); }
		while (!posIsFree(pos));
		return pos;
	}
	
	public Position getRandomPosition() {
		int x = (int)(Math.random() * (X-2) + 1);
		int y = (int)(Math.random() * (Y-2) + 1);
		return new Position(x,y);
	}
	
	public boolean posIsNextToStone(Position pos) {
		int posCol = pos.getCol();
		int posRow = pos.getRow();
		for(Occupant o : occupants) {
			int oCol = o.getPos().getCol();
			int oRow = o.getPos().getRow();
			if(o instanceof Border) {
				return (posCol == 1 || posCol == Y - 2 || posRow == 1 || posRow == X - 2);
			}
			if(oCol + 1 == posCol || oCol - 1 == posCol || oRow + 1 == posRow || oRow - 1 == posRow) {
				return true;
			}
		}
		return false;
	}
	
	public boolean posIsFree(Position pos) {
		for (Occupant o : occupants) {
			if (o.getPos().equals(pos)) {
				return false;
			}
		}
		return true;
	}
	
	public void afficher() {
		grille.afficher();
	}
	
	public void play() {
		for(;round < 3; ++round) {
			for(Occupant o : occupants) {
				if(o instanceof Hunter) {
					Character c = (Character)o;
					Position pos = c.getPos();
					Position next = ((Hunter) o).getNextPosition(c.getDir());
					
					if(( grille.getOccupant(next, grille.getSizeListOccupant(next) - 1) instanceof Stone) && c.getDirTemp() != 0 && (!c.haveAlreadyLadder() || !c.haveAlreadyPickaxe())) {
						next = ((Hunter)o).getNextPosition(c.getDirTemp());
					}else {
						c.setDirTemp(0);
					}
					
					Occupant pr = grille.getOccupant(next, grille.getSizeListOccupant(next)-1);

					boolean canWalk = (pr instanceof Tool || pr instanceof Glue || pr instanceof Treasure || pr instanceof RoadMap || pr == null || (pr instanceof Stone && (c.haveAlreadyLadder() || c.haveAlreadyPickaxe()))) ? true : false;
					
					if(pr != null) {
						Occupant act = grille.getOccupant(pos, 0);
						if(act != null && act instanceof Stone) {
							if(c.haveUsePickaxe()) {
								pr.process(c);
								c.setUsePickaxe(false);
							}
						}else {
							pr.process(c);
						}
					}
					if(canWalk) {
						int i = grille.getSizeListOccupant(pos);
						grille.removeOccupant(pos, (i-1));
						c.walk(next);
						if(c.haveUseLadder()) {
							if(!(grille.getOccupant(next, grille.getSizeListOccupant(next) - 1) instanceof Stone)) {
								c.useLadder();
								c.setUseLadder(false);
							}
						}
						grille.addOccupant(next, o);
					}
					
				}
			}
			System.out.println("\nTour n°"+round+" :\n");
			afficher();
			for(Occupant o : occupants) {
				if(o instanceof Character) {
					System.out.println(o+"  "+o.getPos()+" dir : "+((Character)(o)).getDir()+" dirT : "+((Character)(o)).getDirTemp()+"\n"+((Character)(o)).tools());
				}
			}
		}
	}
	
}
