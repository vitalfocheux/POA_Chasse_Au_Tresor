package jeu_console;

import java.io.*;
import java.util.*;

/**
 * Describe the game
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
	private int qte_roadmap;
	private int qte_pickaxe;
	private int qte_ladder;
	private int qte_wall;
	private int qte_glue;
	private final int X = 16;
	private final int Y = 31;
	private ArrayList<String> histo;
	

	/**
	 * 
	 */
	public Game(int qte_hunter, int qte_wise, int qte_cheater, int qte_roadmap, int qte_pickaxe, int qte_ladder, int qte_wall,  int qte_glue) {
		round = 1;
		occupants = new ArrayList<Occupant>();
		this.qte_hunter = qte_hunter;
		tabString(prHunter, "src/jeu_console/prenom_hunter.txt");
		this.qte_wise = qte_wise;
		tabString(prWise, "src/jeu_console/prenom_wise.txt");
		this.qte_cheater = qte_cheater;
		tabString(prCheater, "src/jeu_console/prenom_cheater.txt");
		this.qte_roadmap = qte_roadmap;
		this.qte_pickaxe = qte_pickaxe;
		this.qte_ladder = qte_ladder;
		this.qte_wall = qte_wall;
		this.qte_glue = qte_glue;	
		histo = new ArrayList<String>();
	}
	
	public Game() {
		this(5,5,5,1,1,1,5,1);
	}
	
	public Game(ArrayList<Integer> stats) {
		this(stats.get(0),stats.get(1),stats.get(2),stats.get(3),stats.get(4),stats.get(5),stats.get(6),stats.get(7));
	}
	
	public ArrayList<Integer> getStats(){
		ArrayList<Integer> stats = new ArrayList<Integer>();
		stats.add(qte_hunter);
		stats.add(qte_wise);
		stats.add(qte_cheater);
		stats.add(qte_roadmap);
		stats.add(qte_pickaxe);
		stats.add(qte_ladder);
		stats.add(qte_wall);
		stats.add(qte_glue);
		return stats;
	}
	
	/**
	 * 
	 * @param pr the list of the names
	 * @param src the source of the file
	 */
	private void tabString(ArrayList<String> pr, String src) {
		try(BufferedReader br = new BufferedReader(new FileReader(new File(src)))){
			while(br.ready()) {
				pr.add(br.readLine());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Occupant> getOccupants(){
		return occupants;
	}
	
	public Grille getGrille(){
		return grille;
	}
	
	/**
	 * Initialize the game
	 */
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
			Position pos = getFreeRandomWallPosition();
			if(pos.getCol() == 0 && pos.getRow() == 0) {
				continue;
			}
			int t =(int)(Math.random() * (X-7) + 2);
			int o = (int)(Math.random() * 2);
			Wall w = new Wall(o);
			ArrayList<Stone> stones = new ArrayList<Stone>();
			
			stones.add(new Stone(pos));
			w.addStone(stones.get(0));
			int j = 0;
			int k = 0;
			int u = 0;
			if(o == 0) {
				while((j + k + u) <= t) {
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
				while((j + k + u) <= t) {
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
			if(stones.size() > 1) {
				for(Stone st : stones) {
					st.addWall(w);
					occupants.add(st);
				}
			}
			
		}
		
		Treasure treasure = new Treasure(getFreeRandomPosition());
		
		occupants.add(treasure);
		
		for(int i = 0; i < qte_roadmap; ++i) {
			occupants.add(new RoadMap(getFreeRandomPosition(), treasure));
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
		
		
		grille = new Grille(occupants);
	}
	
	/**
	 * 
	 * @param c the representation of the hunter with toString
	 * @return a hunter with random position
	 */
	private Hunter createHunter(char c) {
		return new Hunter(getFreeRandomPosition(), prHunter.get((int)( Math.random() * prHunter.size())), c);
	}
	
	/**
	 * @param treasure the treasure of the map
	 * @param c the representation of the wise  with toString
	 * @return a wise with random position
	 */
	private Wise createWise(Treasure treasure, char c) {
		return new Wise(getFreeRandomPosition(), prWise.get((int)( Math.random() * prWise.size())), c, treasure);
	}
	
	/**
	 * @param treasure the treasure of the map
	 * @param c the representation of the cheater with toString
	 * @return a cheater with random position
	 */
	private Cheater createCheater(Treasure treasure, char c) {
		return new Cheater(getFreeRandomPosition(), prCheater.get((int)( Math.random() * prCheater.size())), c, treasure);
	}
	
	/**
	 * 
	 * @return the position of a stone that is neither to another stone nor to a border
	 */
	private Position getFreeRandomWallPosition() {
		Position pos;
		int i = 0;
		do {
			pos = new Position((int)(Math.random() * (X-3) + 1), (int)(Math.random() * (Y-3) + 1));
			++i;
		}while(!posIsFree(pos) || (posIsNextToStone(pos) || ((pos.getCol()== 1 || pos.getCol()== Y - 2 || pos.getRow() == 1 || pos.getRow() == X - 2))) && i < (Y-1)*(X-1));
		if(i >= (Y-1)*(X-1)) {
			return new Position(0,0);
		}
		return pos;
	}
	
	/**
	 * 
	 * @return a random available position
	 */
	private Position getFreeRandomPosition() {
		Position pos;
		do { pos = getRandomPosition(); }
		while (!posIsFree(pos));
		return pos;
	}
	
	/**
	 * 
	 * @return a random position
	 */
	private Position getRandomPosition() {
		int x = (int)(Math.random() * (X-2) + 1);
		int y = (int)(Math.random() * (Y-2) + 1);
		return new Position(x,y);
	}
	
	/**
	 * 
	 * @param pos the position
	 * @return whether the position is next to a stone or not
	 */
	private boolean posIsNextToStone(Position pos) {
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
	
	/**
	 * 
	 * @param pos the position
	 * @return whether the position is available or not
	 */
	private boolean posIsFree(Position pos) {
		for (Occupant o : occupants) {
			if (o.getPos().equals(pos)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @return whether a hunter has found the treasure or not
	 */
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
	
	public int getRound() {
		return round;
	}
	
	public ArrayList<String> getHistory() {
		return histo;
	}
	
	public void playARound() {
		histo = new ArrayList<String>();
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
						histo.add(pr.getHistoProcess());
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
		if(histo.size() == 0) {
			histo.add("Il ne s'est rien passé de particuliers ce tour ci");
		}
		++round;
		
	}
	
	public void results() {
		histo = new ArrayList<String>();
		String str = "Fin du jeu : \n";
		if(round >= 1000) {
			str += "Personne n'a gagné la partie";
		}else {
			for(Occupant o : occupants) {
				if(o instanceof Hunter) {
					if(((Hunter)(o)).haveTreasure()) {
						Character c = (Hunter)o;
						str += c.getNom()+ " le chasseur ("+c+") a gagné la partie";
					}
				}
			}
		}
		histo.add(str);
	}
	
}
