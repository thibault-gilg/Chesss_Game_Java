package model;

public final class Tour extends AbstractPiece implements Pieces {
		
	public Tour(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece,coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if ((this.getX() == xFinal || this.getY() == yFinal)) {
			return true;
		}
		
		return false;
	}

}
