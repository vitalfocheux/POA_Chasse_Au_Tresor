package jeu_console;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Vital FOCHEUX
 *
 */

public class Game {

	private int round;
	private List<Occupant> occupants;
	private Grille grille;
	private int qte_hunter;
	private ArrayList<String> prHunter = new ArrayList<String>();
	private int qte_wise;
	private ArrayList<String> prWise = new ArrayList<String>();
	private int qte_cheater;
	private ArrayList<String> prCheater = new ArrayList<String>();
	private int qte_pickaxe;
	private int qte_ladder;
	private int qte_wall;
	private int qte_glue;
	private final int X = 16;
	private final int Y = 31;
	
	public Game() {
		round = 1;
		occupants = new ArrayList<Occupant>();
		qte_hunter = 20;
		tabString(prHunter, "src/jeu_console/prenom_hunter.txt");
		qte_wise = 1;
		tabString(prWise, "src/jeu_console/prenom_wise.txt");
		qte_cheater = 1;
		tabString(prCheater, "src/jeu_console/prenom_cheater.txt");
		qte_pickaxe = 1;
		qte_ladder = 1;
		qte_wall = 3;
		qte_glue = 1;		
	}
	
	public void tabString(ArrayList<String> pr, String src) {
		try(BufferedReader br = new BufferedReader(new FileReader(new File(src)))){
			while(br.ready()) {
				pr.add(br.readLine());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
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
			int u = 0;
			if(o == 0) {
				while((j + k + u) < (t-1)) {
					if(pos.getCol() + j == Y - 3) {
						if(!posIsNextToStone(new Position(pos.getRow(), pos.getCol() - (k+1)))) {
							++k;
							stones.add(new Stone(new Position(pos.getRow(), pos.getCol() - k)));
							w.addStone(stones.get((j + k)));
						}else {
							++u;
						}
						
					}else {
						if(!posIsNextToStone(new Position(pos.getRow(), pos.getCol() + (j+1)))) {
							++j;
							stones.add(new Stone(new Position(pos.getRow(), pos.getCol() + j)));
							w.addStone(stones.get((j + k)));
						}else {
							++u;
						}
						
					}
				}
			}else {
				while((j + k + u) < (t- 1)) {
					if(pos.getRow() + j == X - 3) {
						if(!posIsNextToStone(new Position(pos.getRow() - (k+1), pos.getCol()))) {
							++k;
							stones.add(new Stone(new Position(pos.getRow() - k, pos.getCol())));
							w.addStone(stones.get((j + k)));
						}else {
							++u;
						}
						
					}else {
						if(!posIsNextToStone(new Position(pos.getRow() + (j+1), pos.getCol()))) {
							++j;
							stones.add(new Stone(new Position(pos.getRow() + j, pos.getCol())));
							w.addStone(stones.get((j + k)));
						}else {
							++u;
						}
						
					}
				}
			}
			for(Stone st : stones) {
				st.addWall(w);
				occupants.add(st);
			}
		}
		
		Treasure treasure = new Treasure(getFreeRandomPosition());
		
		occupants.add(treasure);
		
		for (int i = 0; i < (qte_hunter+qte_wise+qte_cheater); ++i) {
			char c = (char)('A'+ i);
			if(i < qte_hunter) {
				occupants.add(createHunter(c));
			}else if(i < (qte_hunter + qte_wise)) {
				occupants.add(createWise(treasure, c));
			}else {
				occupants.add(createCheater(treasure, c));
			}
			
		}
		for (int i = 0; i < qte_pickaxe; ++i) {
			occupants.add(new Pickaxe(getFreeRandomPosition()));
		}
		for (int i = 0; i < qte_ladder; ++i) {
			occupants.add(new Ladder(getFreeRandomPosition()));
		}
		for (int i = 0; i < qte_glue; ++i) {
			occupants.add(new Glue(getFreeRandomPosition()));
		}
		
		grille = new Grille(occupants);
		System.out.println("Grille lors de l'initialisation du jeu :\n");
		afficher();
		for(Occupant o : occupants) {
			if(o instanceof Character) {
				System.out.println(o+" "+o.getPos()+" "+((Character)(o)).getDir());
			}
		}
	}
	
	public Hunter createHunter(char c) {
		return new Hunter(getFreeRandomPosition(), prHunter.get((int)( Math.random() * prHunter.size())), c);
	}
	
	public Wise createWise(Treasure treasure, char c) {
		return new Wise(getFreeRandomPosition(), prWise.get((int)( Math.random() * prWise.size())), c, treasure);
	}
	
	public Cheater createCheater(Treasure treasure, char c) {
		return new Cheater(getFreeRandomPosition(), prCheater.get((int)( Math.random() * prCheater.size())), c, treasure);
	}
	
	public Position getFreeRandomWallPosition() {
		Position pos;
		do {
			pos = new Position((int)(Math.random() * (X-4) + 1), (int)(Math.random() * (Y-4) + 1));
			
		}while(!posIsFree(pos) || posIsNextToStone(pos) || ((pos.getCol()== 1 || pos.getCol()== Y - 2 || pos.getRow() == 1 || pos.getRow() == X - 2)));
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
			if(o instanceof Stone && (oCol + 1 == posCol || oCol - 1 == posCol || oRow + 1 == posRow || oRow - 1 == posRow)) {
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
	
	public boolean treasureIsFind() {
		for(Occupant o : occupants) {
			if(o instanceof Hunter) {
				if(((Hunter)(o)).haveTreasure()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void play() {
		do{
			for(Occupant o : occupants) {
				if(o instanceof Hunter || o instanceof Wise || o instanceof Cheater) {
					Character c = (Character)o;
					Position pos = c.getPos();
					Position next = c.getNextPosition(c.getDir());
					
					if(( grille.getOccupant(next, grille.getSizeListOccupant(next) - 1) instanceof Stone) && c.getDirTemp() != 0 && (!c.haveAlreadyLadder() || !c.haveAlreadyPickaxe())) {
						next = c.getNextPosition(c.getDirTemp());
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
						if(c.getRoundWait() == 0 || (c.getRoundWait() == 1 && pr instanceof Glue)) {
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
						}else {
							
							c.downRoundWait();
						}
						
					}
					
				}
			}
			System.out.println("\nTour n°"+round+" :\n");
			afficher();
			/*
			for(Occupant o : occupants) {
				if(o instanceof Character) {
					System.out.println(((Character)(o)).getNom()+"  "+o.getPos()+" dir : "+((Character)(o)).getDir()+" dirT : "+((Character)(o)).getDirTemp()+"RW : "+((Character)(o)).getRoundWait()+"\n"+((Character)(o)).tools());
				}
			}*/
			++round;
		}while(!treasureIsFind());
		
		for(Occupant o : occupants) {
			if(o instanceof Hunter) {
				if(((Hunter)(o)).haveTreasure()) {
					Character c = (Hunter)o;
					System.out.println(c.getNom()+ " le chasseur ("+c+") a gagné la partie");
				}
			}
		}
	}
	
}
