package jeu_console;

public class Stone extends Fixed implements Comparable<Stone>{
	
	private Wall wall;
	
	public Stone(Position pos) {
		super(pos);
	}
	
	public void addWall(Wall wall) {
		this.wall = wall;
	}
	
	@Override
	public String toString() {
		return"#";
	}

	@Override
	public void process(Character c) {
		if(c.haveAlreadyLadder()) {
			c.walk(c.getNextPosition(c.getDir()));
		}else if(c.haveAlreadyPickaxe()) {
			c.walk(c.getNextPosition(c.getDir()));
			c.usePickaxe();
		}else {
			c.setDirTemp(wall.getDirectionTemp(this));
		}
	}

	@Override
	public int compareTo(Stone o) {
		return this.getPos().compareTo(o.getPos());
	}

}
