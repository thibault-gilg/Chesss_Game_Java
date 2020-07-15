package model;

public class Reine extends AbstractPiece {

	public Reine(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	public boolean isMoveOk(int xFinal, int yFinal) {
		if ((Math.abs(this.getX() - xFinal) == Math.abs(this.getY() - yFinal))
			|| (this.getX() == xFinal || this.getY() == yFinal)) {
			return true;
		}
		
		return false;
	}
	
}
