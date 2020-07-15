package model;

public class Cavalier extends AbstractPiece {

	public Cavalier(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		if ((Math.abs(this.getX() - xFinal) == 1 && Math.abs(this.getY() - yFinal) == 2) || 
			(Math.abs(this.getX() - xFinal) == 2 && Math.abs(this.getY() - yFinal) == 1)) {
			return true;
		}
		
		return false;
	}

}
