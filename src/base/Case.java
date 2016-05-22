package base;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Case
{
	public static ArrayList<Color> getListColor ()
	{
		ArrayList<Color> listColor = new ArrayList<Color>();
		
		listColor.add(Color.RED);
		listColor.add(Color.YELLOW);
		listColor.add(Color.ORANGE);
		listColor.add(Color.GREEN);
		listColor.add(Color.BLUE);
		listColor.add(Color.VIOLET);
		
		return listColor;
	}
	
	private Color couleur;
	private Joueur joueur;
	private int coordX;
	private int coordY;
	
	public Case(int coordXP, int coordYP)
	{
		this.couleur = Color.RED;
		this.joueur = null;
		this.coordX = coordXP;
		this.coordY = coordYP;
	}

	public Color getCouleur()
	{
		return couleur;
	}

	public void setCouleur(Color couleurP)
	{
		this.couleur = couleurP;
	}
	
	public Joueur getJoueur()
	{
		return joueur;
	}

	public void setJoueur(Joueur joueur)
	{
		this.joueur = joueur;
		//joueur.setCaseOwn(this);
	}

	public int getCoordX()
	{
		return coordX;
	}

	public void setCoordX(int coordX)
	{
		this.coordX = coordX;
	}

	public int getCoordY() 
	{
		return coordY;
	}

	public void setCoordY(int coordY)
	{
		this.coordY = coordY;
	}

	public static Case randomInitCase(int coordX, int coordY)
	{
		Case caseR = new Case(coordX, coordY);
		int rand = (int)(Math.random() * (6));
		
		caseR.setCouleur(getListColor().get(rand));
		
		return caseR;
	}
}