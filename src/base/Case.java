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
		listColor.add(Color.BLUE);
		listColor.add(Color.PURPLE);
		listColor.add(Color.GREEN);
		
		return listColor;
	}
	
	private Color color;
	private Joueur joueur;
	private int coordX;
	private int coordY;
	
	public Case(int coordXP, int coordYP, Color colorP)
	{
		this.joueur = null;
		this.color = colorP;
		this.coordX = coordXP;
		this.coordY = coordYP;
	}

	public Color getColor()
	{
		return color;
	}

	public void setColor(Color couleurP)
	{
		this.color = couleurP;
	}
	
	public Joueur getJoueur()
	{
		return joueur;
	}

	public void setJoueur(Joueur joueur)
	{
		this.joueur = joueur;
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

	public static Color randomColor(ArrayList<Color> listColor)
	{
		int rand = (int)(Math.random() * (listColor.size()));
		Color color = listColor.get(rand);
		
		return color;
	}
}