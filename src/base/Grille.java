package base;

import java.awt.Dimension;

import base.Case.Couleur;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grille
{
	private Case [][] Grille;
	
	public Case[][] getGrille()
	{
		return Grille;
	}
	
	public void setGrille(Case[][] grille)
	{
		this.Grille = grille;
	}

	public void initGrid(int tailleGrille)
	{
		Grille = new Case[tailleGrille][tailleGrille];
		
		int i,j;
		
		for (i = 0; i < tailleGrille; i ++)
		{
			for (j = 0; j < tailleGrille; j ++)
			{
				Grille[i][j] = Case.randomInitCase();
			}
		}
	}
	
	public void showGrid()
	{
		int i,j;
		
		for (i = 0; i < Grille.length; i ++)
		{
			for (j = 0; j < Grille[0].length; j ++)
			{
				System.out.print(Grille[i][j].getCouleur().name() + "\t");
			}
			
			System.out.println();
		}
	}
	
	public Scene graphicalShow()
	{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)(dimension.getHeight() * 0.9);
		int width = (int)(dimension.getWidth() * 0.9);
		
		Group root = new Group();
		Scene scene = new Scene(root, width, height, Color.WHITE);
		
		int x, y;
		
		for(x = 0; x < Grille.length; x ++)
		{
			for(y = 0; y < Grille[0].length; y ++)
			{
				Rectangle rectangle = new Rectangle();

				if (Grille[x][y].getCouleur() == Couleur.Rouge)
				{
					rectangle.setFill(Color.RED);
				}
				else if (Grille[x][y].getCouleur() == Couleur.Jaune)
				{
					rectangle.setFill(Color.YELLOW);
				}
				else if (Grille[x][y].getCouleur() == Couleur.Orange)
				{
					rectangle.setFill(Color.ORANGE);
				}
				else if (Grille[x][y].getCouleur() == Couleur.Vert)
				{
					rectangle.setFill(Color.GREEN);
				}
				else if (Grille[x][y].getCouleur() == Couleur.Bleu)
				{
					rectangle.setFill(Color.BLUE);
				}
				else if (Grille[x][y].getCouleur() == Couleur.Violet)
				{
					rectangle.setFill(Color.VIOLET);
				}

				rectangle.setX(width * 0.80 / (Grille.length + 1) * (x + 0.5));
				rectangle.setY(height / (Grille.length + 1) * (y + 0.5));

				rectangle.setWidth((width * 0.80) / (Grille.length + 1));
				rectangle.setHeight((height) / (Grille.length + 1));
				rectangle.setStroke(Color.BLACK);
		        
		        root.getChildren().add(rectangle);
			}
		}
		return scene;
	}
}