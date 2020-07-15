package model;

import java.util.LinkedList;
import java.util.List;
import tools.ChessPiecesFactory;
import tools.ChessSinglePieceFactory;

public class Jeu {
	
	private Couleur couleur;
	private List<Pieces> pieces = null;
	
	public Jeu(Couleur couleur) {
		this.couleur = couleur;
		this.pieces = ChessPiecesFactory.newPieces(couleur);
		
	}
	
	private Pieces findPiece(int x, int y) {
		Pieces foundPiece = null;
		 for (Pieces piece : this.pieces) {
	            if (piece.getX() == x && piece.getY() == y) {
	                foundPiece = piece;
	            }
	        }
		 return foundPiece;
	}
	
	public boolean isPieceHere(int x, int y) {
		if(this.findPiece(x,y) != null) {
				return true;
			}
		return false;
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		Pieces piece = this.findPiece(xInit, yInit);
		if (piece != null && piece.isMoveOk(xFinal, yFinal)) {
			return true;
		}
		return false;
	}
	
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		Pieces piece = this.findPiece(xInit, yInit);	
		if (piece == null) {
			return false;
		}
		return piece.move(xFinal, yFinal);
	}
	
	public void setPossibleCapture() {
		
	}
	
	public boolean capture(int xCatch, int yCatch) {
		return false;
	}
	
	public Couleur getPieceColor(int x, int y) {
		Pieces piece = this.findPiece(x, y);
		if (piece != null) {
			return piece.getCouleur();
		}
		return Couleur.NOIRBLANC;
	}
	
	public String getPieceType(int x, int y) {
		Pieces piece = this.findPiece(x, y);
		return piece.getClass().getSimpleName();
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
		/**
		* @return une vue de la liste des pièces en cours
		* ne donnant que des accès en lecture sur des PieceIHM
		* (type piece + couleur + liste de coordonnées)
		*/
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		
		for (Pieces piece : pieces){
			
			boolean existe = false;
			// si le type de piece existe déjà dans la liste de PieceIHM
			// ajout des coordonnées de la pièce dans la liste de Coord de ce type
			// si elle est toujours en jeu (x et y != -1)
			for ( PieceIHM pieceIHM : list){
				if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
					existe = true;
					if (piece.getX() != -1){
						pieceIHM.add(new Coord(piece.getX(), piece.getY()));
						}
				}
			}
			// sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
			if (! existe) {
				if (piece.getX() != -1){
					newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
					piece.getCouleur());
					newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					list.add(newPieceIHM);
				}
			}
		}
		return list;
	}
	
	public void setCastling() {
		
	}
	
	//TODO
	public void undoMove() {
		
	}

	public void undoCapture() {
		
	}
	
	public boolean isPawnPromotion(int xFinal, int yFinal) {
		Pieces piece = findPiece(xFinal, yFinal);
		if (this.getPieceType(xFinal, yFinal) == "Pion"){
			if ((piece.getCouleur().equals(Couleur.BLANC) && piece.getY() == 0) 
					|| (piece.getCouleur().equals(Couleur.NOIR) && piece.getY() == 7)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean pawnPromotion(int xFinal, int yFinal, String type) {
		if (this.isPawnPromotion(xFinal, yFinal)) {
			Pieces piece = this.findPiece(xFinal, yFinal);
			piece.setX(-1);
			piece.setY(-1);
			
			// nouvelle pièce du type renseigné
			Pieces newPiece = ChessSinglePieceFactory.newPiece(piece.getCouleur(), type, xFinal, yFinal);
			this.pieces.add(newPiece);
			return true;
		}
		return false;
	}
		
	
	public Coord getKingCoord() {
		Coord coord = new Coord(0,0);
		for (int i = 0; i < this.pieces.size(); i++) {
			if (this.pieces.get(i).getClass().getSimpleName() == "Roi" ){
				coord.x = this.pieces.get(i).getX();
				coord.y = this.pieces.get(i).getY();
			}
		}
		return coord;
	}
	
	
	@Override
	public String toString() {
		return "Jeu " + getCouleur() + " : " + this.pieces.toString();
	}
	
	public static void main(String[] args) {
		Jeu jeu = new Jeu(Couleur.NOIR);
		System.out.println(jeu);
	}

}
