package base;

import java.awt.Dimension;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;

public class Grille
{
	private Case [][] grille;
	
	static Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	static int height = (int)(dimension.getHeight() * 0.9);
	static int width = (int)(dimension.getWidth() * 0.9);
	
	public Case[][] getGrille()
	{
		return grille;
	}
	
	public void setGrille(Case[][] grille)
	{
		this.grille = grille;
	}

	public void initGrid(int tailleGrille)
	{
		grille = new Case[tailleGrille][tailleGrille];
		
		int i,j;
		
		for (i = 0; i < tailleGrille; i ++)
		{
			for (j = 0; j < tailleGrille; j ++)
			{
				grille[i][j] = Case.randomInitCase(i, j);
			}
		}
	}
	
	public void showGrid()
	{
		int i,j;
		
		for (i = 0; i < grille.length; i ++)
		{
			for (j = 0; j < grille[0].length; j ++)
			{
				System.out.print(grille[i][j].getCouleur() + "\t");
			}
			
			System.out.println();
		}
	}
	
	public Group graphicalShow(Group root)
	{		
		int x, y;
		
		for(x = 0; x < grille.length; x ++)
		{
			for(y = 0; y < grille[0].length; y ++)
			{
				Rectangle rectangle = new Rectangle();
				
				rectangle.setFill(grille[x][y].getCouleur());

				rectangle.setX(width * 0.9 / (grille.length + 1) * (x + 0.5));
				rectangle.setY(height / (grille.length + 1) * (y + 0.5));

				rectangle.setWidth((width * 0.9) / (grille.length + 1));
				rectangle.setHeight(height / (grille.length + 1));
				
				if (grille[x][y].getJoueur() != null)
				{
					rectangle.setStroke(Color.WHITE);
				}
				else
				{
					rectangle.setStroke(Color.BLACK);
				}
		        
		        root.getChildren().add(rectangle);
			}
		}
		
		return root;
	}
	
	public static ArrayList<Color> choosableColor (Joueur joueurs [])
	{
		int i, y;
		
		ArrayList<Color> choosableColor = Case.getListColor();
		
		for (i = 0; i <joueurs.length; i ++)
		{
			for (y = 0; y <choosableColor.size(); y ++)
			{
				if (joueurs[i].getColor() == choosableColor.get(y))
				{
					choosableColor.remove(y);
				}
			}
		}
		
		return choosableColor;
	}
	
	public Group generateButton(ArrayList<Color> choosableColor, Group root, Joueur  joueurCourant)
	{
		int i, y = 0;
		
		for (i =  0; i < choosableColor.size(); i ++)
		{
			Rectangle rectangle = new Rectangle();
			
			rectangle.setX(width * 0.88);
			rectangle.setY(height / (grille.length + 1) * (y + 0.5));

			rectangle.setWidth((width * 0.9) / (grille.length + 1));
			rectangle.setHeight(height / (grille.length + 1));
			rectangle.setFill(choosableColor.get(i));
			rectangle.setStroke(Color.BLACK);
			
			rectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
			{
				Joueur.joue(Color.valueOf(rectangle.getFill() + ""), joueurCourant);
	        });
			
			root.getChildren().add(rectangle);
			
			
			y ++;
		}
		
		return root;
	}
	
	public void newCase (Case caseP, Joueur joueurCourant)
	{
		int x, y;
		
		x= caseP.getCoordX();
		y = caseP.getCoordY();
			
		if ((x - 1 >= 0) && (getGrille()[x - 1][y].getCouleur() == joueurCourant.getColor()) && (getGrille()[x - 1][y].getJoueur() == null))
		{
			getGrille()[x - 1][y].setJoueur(joueurCourant);
			newCase(getGrille()[x - 1][y], joueurCourant);
		}
		if ((x + 1 >= 0) && (getGrille()[x + 1][y].getCouleur() == joueurCourant.getColor()) && (getGrille()[x + 1][y].getJoueur() == null))
		{
			getGrille()[x + 1][y].setJoueur(joueurCourant);
			newCase(getGrille()[x + 1][y], joueurCourant);
		}
		if ((y - 1 >= 0) && (getGrille()[x][y - 1].getCouleur() == joueurCourant.getColor()) && (getGrille()[x][y - 1].getJoueur() == null))
		{
			getGrille()[x][y - 1].setJoueur(joueurCourant);
			newCase(getGrille()[x][y - 1], joueurCourant);
		}
		if ((y + 1 >= 0) && (getGrille()[x][y + 1].getCouleur() == joueurCourant.getColor()) && (getGrille()[x][y + 1].getJoueur() == null))
		{
			getGrille()[x][y + 1].setJoueur(joueurCourant);
			newCase(getGrille()[x][y + 1], joueurCourant);
		}
	}
}