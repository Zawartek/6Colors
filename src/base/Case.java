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
	
	public Case(Color couleurP)
	{
		couleur = couleurP;
	}
	
	public Case()
	{
		couleur = Color.RED;
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
	}

	public static Case randomInitCase()
	{
		Case caseR = new Case();
		int rand = (int)(Math.random() * (6));
		
		caseR.setCouleur(getListColor().get(rand));
		
		return caseR;
	}
}