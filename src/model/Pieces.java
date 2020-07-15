package model;

public interface Pieces {
	
	public int getX();
	
	public int getY();
	
	void setX(int x);
	
	void setY(int y);
	
	public Couleur getCouleur();
	
	public boolean capture();
	
	public boolean isMoveOk(int xFinal, int yFinal);
	
	public boolean	move(int xFinal, int yFinal);
}

