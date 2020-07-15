package model;

import java.util.ArrayList;
import java.util.List;

public class Echiquier implements BoardGames {
	
	private Jeu JeuBlanc;
	private Jeu JeuNoir;
	private Jeu JeuCourant;
	private Jeu JeuNonCourant;
	private String message;
	
	
	public Echiquier() {
		this.JeuBlanc = new Jeu(Couleur.BLANC);
		this.JeuNoir = new Jeu(Couleur.NOIR);
		this.JeuCourant = JeuBlanc;
		this.JeuNonCourant = JeuNoir;
		this.message = "";

	}

	public void switchJoueur() {
		if (this.JeuCourant == JeuBlanc) {
			this.JeuCourant = JeuNoir;
			this.JeuNonCourant = JeuBlanc;		
		}
		
		else {
			this.JeuCourant = JeuBlanc;		
			this.JeuNonCourant = JeuNoir;		
		}
	}

	public List<PieceIHM> getPiecesIHM(){
		List <PieceIHM> pieces = new ArrayList();
		List <PieceIHM> piecesNoir = this.JeuNoir.getPiecesIHM();
		List <PieceIHM> piecesBlanc = this.JeuBlanc.getPiecesIHM();
		
		for (PieceIHM piece : piecesNoir) {
			pieces.add(piece);
		}
		
		for (PieceIHM piece : piecesBlanc) {
			pieces.add(piece);
		}
		
		return pieces;
		
	}
	
	public boolean isMoveOk(int	xInit, int yInit, int xFinal, int yFinal) {
		// si pièce aux coordonnées initiales
		if (this.JeuCourant.isPieceHere(xInit, yInit)) {
			// si coordonnées finales différentes des initiales
			if (!(xFinal == xInit && yFinal == yInit)) {
				// si coordonnées finales valides
				if (Coord.coordonnees_valides(xFinal, yFinal)) {
					// si algo de déplacement respecté
					if (this.JeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal)) {
						this.setMessage("déplacement OK");
						return true;
						
					}
				}
			}
		}
		this.setMessage("déplacement interdit");
		return false;
	}
	
	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if (this.isMoveOk(xInit, yInit, xFinal, yFinal)) {
			return this.JeuCourant.move(xInit, yInit, xFinal, yFinal);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.JeuBlanc.toString() + "\n" + this.JeuNoir.toString();
	}
	
	@Override
	public Couleur getColorCurrentPlayer() {
		return JeuCourant.getCouleur();
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		return this.JeuCourant.getPieceColor(x, y);
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	private void setMessage(String message) {
		this.message = message;
		
	}
	
	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {		
		Echiquier Echec = new Echiquier();
		System.out.println(Echec);
		System.out.println(Echec.getPieceColor(1, 0));
		System.out.println(Echec.move(0, 7, 0, 1));

	}
	
	
}
