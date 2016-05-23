package base;

import java.awt.Dimension;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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
				grille[i][j] = new Case(i, j, Case.randomColor());
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
	
	public void showOwner()
	{
		int i,j;
		
		for (i = 0; i < grille.length; i ++)
		{
			for (j = 0; j < grille[0].length; j ++)
			{
				if (grille[i][j].getJoueur() != null)
				{
					System.out.print(grille[i][j].getJoueur().getNom() + "\t");
				}
			}
			
			System.out.println();
		}
	}
	
	public Group graphicalShow()
	{
		int x, y;
		Group gridGroup = new Group();
		
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
					rectangle.setStroke(Color.GRAY);
				}
				else
				{
					rectangle.setStroke(Color.BLACK);
				}
		        
				gridGroup.getChildren().add(rectangle);
			}
		}
		
		return gridGroup;
	}
	
	public static ArrayList<Color> choosableColor (Joueur joueurs [])
	{
		int i, y;
		
		ArrayList<Color> choosableColor = Case.getListColor();
		
		for (i = 0; i <joueurs.length; i ++)
		{
			for (y = 0; y <choosableColor.size(); y ++)
			{
				if (joueurs[i].getColor().equals(choosableColor.get(y)))
				{
					choosableColor.remove(y);
				}
			}
		}
		
		return choosableColor;
	}
	
	public Group generateButton(Joueur [] joueurs, Joueur  joueurCourant, Stage primaryStage, int indiceJoueur)
	{
		int i, y = 0;
		Group buttonGroup = new Group();
		
		ArrayList<Color> choosableColor = choosableColor(joueurs);
		
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
				Color colorP = Color.valueOf(rectangle.getFill() + "");
				joueurCourant.setColor(colorP);
				joueurCourant.majCaseColor(colorP);
				
				majCaseJoueur(joueurCourant);
				
				int newIndiceJoueur = (indiceJoueur + 1) % joueurs.length;
				Test.build(this, joueurCourant, joueurs, primaryStage, newIndiceJoueur);
	        });
			
			buttonGroup.getChildren().add(rectangle);
			
			y ++;
		}
		
		return buttonGroup;
	}
	
	public void majCaseJoueur (Joueur joueurCourant)
	{
		ArrayList<Case> caseOwn = joueurCourant.getCaseOwn();
		
		for (int z = 0; z < caseOwn.size(); z ++)
		{
			newCase(caseOwn.get(z), joueurCourant);
		}
	}
	
	public void newCase (Case caseP, Joueur joueurCourant)
	{
		int x, y;
		
		x = caseP.getCoordX();
		y = caseP.getCoordY();
			
		if ((x - 1 >= 0) && (getGrille()[x - 1][y].getJoueur() == null) && (getGrille()[x - 1][y].getCouleur().equals(joueurCourant.getColor())))
		{
			joueurCourant.assocJoueurCase(getGrille()[x - 1][y]);
		}
		if ((x + 1 < grille.length) && (getGrille()[x + 1][y].getJoueur() == null) && (getGrille()[x + 1][y].getCouleur().equals(joueurCourant.getColor())))
		{
			joueurCourant.assocJoueurCase(getGrille()[x + 1][y]);
		}
		if ((y - 1 >= 0) && (getGrille()[x][y - 1].getJoueur() == null) && (getGrille()[x][y - 1].getCouleur().equals(joueurCourant.getColor())))
		{
			joueurCourant.assocJoueurCase(getGrille()[x][y - 1]);
		}
		if ((y + 1 < grille.length) && (getGrille()[x][y + 1].getJoueur() == null) && (getGrille()[x][y + 1].getCouleur().equals(joueurCourant.getColor())))
		{
			joueurCourant.assocJoueurCase(getGrille()[x][y + 1]);
		}
	}
}