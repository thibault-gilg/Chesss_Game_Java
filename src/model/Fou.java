package model;
import java.lang.Math;

public class Fou extends AbstractPiece {

	public Fou(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	public boolean isMoveOk(int xFinal, int yFinal) {
		if (Math.abs(this.getX() - xFinal) == Math.abs(this.getY() - yFinal)) {
			return true;
		}
		
		return false;
	}

}
