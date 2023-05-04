package jeu_console;

import java.util.*;



public class Main {
	
	public static final int X = 10;
	public static final int Y = 10;
	
	public static void afficherGrille(Map<Position, List<Occupant>> grille) {

		//Character o = (Character)grille.get(new Position(1,1)).get(0);
		//System.out.println(o+" "+o.getPos()+" "+o.getDir());
	    // Parcourir la grille en ordre de y décroissant (pour avoir les éléments les plus hauts en premier)
	   for(int x = 0; x < X; ++x) {
		   for(int y = 0; y < Y; ++y) {
	            Position p = new Position(x, y);
	           if(grille.get(p).isEmpty()) {
	        	   System.out.print(" ");
	           }else {
	        	   System.out.print(grille.get(p).get(0));
	           }
	        }
	        System.out.println();
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Position, List<Occupant>> m = new TreeMap<Position, List<Occupant>>();
		List<Occupant> li = new ArrayList<Occupant>();
		int x = (int)(Math.random() * (X-2) + 1);
		int y = (int)(Math.random() * (Y-2) + 1);
		for(int i = 0; i < X; ++i) {
			for(int j = 0; j < Y; ++j) {
				List<Occupant> a = new ArrayList<Occupant>();
				Position p = new Position(i, j);
				if(i == x && j == y) {
					a.add(new Hunter(p, "Jean"));
					li.add(a.get(0));
				}else if(i == 0 || j == 0 || i == X-1 || j == Y-1) {
					a.add(new Border(p));
				}
				m.put(p, a);
			}
		}

		//System.out.println(m);
		
		
		System.out.println("Grille d'initialisation");
		
		afficherGrille(m);
		
		Character o = (Character)li.get(0);
		System.out.println(o+" "+o.getPos()+" "+o.getDir());
		
		
		for(int i = 0; i < 12; ++i) {
			System.out.println("Tour n°"+(i+1));
			Character c = (Character)li.get(0);
			Position pos = c.getPos();
			List<Occupant> l = m.get(pos);
			
			if(!l.isEmpty()) {
				
				
				
					Position next = c.getNextPosition(c.getDir());
					Occupant pr = null;
					if(!m.get(next).isEmpty()){
						pr = m.get(next).get(0);
					}
					if(pr != null) {
						pr.process(c);
					}
					m.get(pos).remove(0);
					if(pr == null) {
						c.walk(c.getNextPosition(c.getDir()));
					}
					m.get(c.getPos()).add(c);
					afficherGrille(m);
					System.out.println(c+" "+c.getPos()+" "+c.getDir()+"\n");
				
			}
			
		}
		
		
	}

}
