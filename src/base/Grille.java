package base;

import java.awt.Dimension;

import base.Case.Couleur;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grille
{
	private Case [][] grille;
	
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
				grille[i][j] = Case.randomInitCase();
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
				System.out.print(grille[i][j].getCouleur().name() + "\t");
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
		
		for(x = 0; x < grille.length; x ++)
		{
			for(y = 0; y < grille[0].length; y ++)
			{
				Rectangle rectangle = new Rectangle();

				if (grille[x][y].getCouleur() == Couleur.Rouge)
				{
					rectangle.setFill(Color.RED);
				}
				else if (grille[x][y].getCouleur() == Couleur.Jaune)
				{
					rectangle.setFill(Color.YELLOW);
				}
				else if (grille[x][y].getCouleur() == Couleur.Orange)
				{
					rectangle.setFill(Color.ORANGE);
				}
				else if (grille[x][y].getCouleur() == Couleur.Vert)
				{
					rectangle.setFill(Color.GREEN);
				}
				else if (grille[x][y].getCouleur() == Couleur.Bleu)
				{
					rectangle.setFill(Color.BLUE);
				}
				else if (grille[x][y].getCouleur() == Couleur.Violet)
				{
					rectangle.setFill(Color.VIOLET);
				}

				rectangle.setX(width * 0.80 /  (grille.length + 1) * (x + 0.5));
				rectangle.setY(height / (grille.length + 1) * (y + 0.5));

				rectangle.setWidth((width * 0.80) / (grille.length + 1));
				rectangle.setHeight(height / (grille.length + 1));
				rectangle.setStroke(Color.BLACK);
		        
		        root.getChildren().add(rectangle);
			}
		}
		
		Rectangle rectangle = new Rectangle();
		
		rectangle.setX(width * 0.80 /  (grille.length + 1) * 12);
		rectangle.setY(height / (grille.length + 1)* 1);

		rectangle.setWidth((width * 0.80) / (grille.length + 1));
		rectangle.setHeight(height / (grille.length + 1));
		rectangle.setFill(Color.VIOLET);
		rectangle.setStroke(Color.BLACK);
		
		root.getChildren().add(rectangle);
		
		return scene;
	}
}