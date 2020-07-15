package model;

public class Pion extends AbstractPiece implements Pions {
	
	private boolean hasMoved =  false; 
	
	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	public boolean isMoveOk(int xFinal, int yFinal) {
		if (this.getCouleur().equals(Couleur.NOIR)) {
			if (xFinal == this.getX() && yFinal == this.getY() + 1) {
				return true;
			}
			else if (!hasMoved && xFinal == this.getX() && yFinal == this.getY() + 2) {
				return true;
			}

		}
		else {
			if (xFinal == this.getX() && yFinal == this.getY() - 1) {
				return true;
			}
			else if (!hasMoved && xFinal == this.getX() && yFinal == this.getY() - 2) {
				return true;
			}
		}
		return false;
	}
	
	public boolean move(int xFinal, int yFinal) {
		boolean move =super.move(xFinal, yFinal);
		if (move)
			this.hasMoved = true;
		return move;
	}
	
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		return false;
	}
}
