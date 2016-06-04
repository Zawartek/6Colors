package base;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class Grille
{
	private Case [][] grille;
	private int typeGrille; // 0 : Carre, 1 : Hexagone
	
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

	public int getTypeGrille()
	{
		return typeGrille;
	}

	public void setTypeGrille(int typeGrille)
	{
		this.typeGrille = typeGrille;
	}

	public void initGrid(int tailleGrille)
	{
		grille = new Case[tailleGrille][tailleGrille];
		
		int i,j;
		
		for (i = 0; i < tailleGrille; i ++)
		{
			for (j = 0; j < tailleGrille; j ++)
			{
				grille[i][j] = new Case(i, j, Case.randomColor(Case.getListColor()));
			}
		}
	}
	
	public void showGridSquare()
	{
		int i,j;
		
		for (i = 0; i < grille.length; i ++)
		{
			for (j = 0; j < grille[0].length; j ++)
			{
				System.out.print(grille[i][j].getColor() + "\t");
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
	
	public Group graphicalShowSquare()
	{
		int x, y;
		Group gridGroup = new Group();
		
		for(x = 0; x < grille.length; x ++)
		{
			for(y = 0; y < grille[0].length; y ++)
			{
				StackPane rectangleSP = new StackPane();
				
				Rectangle rectangle = new Rectangle(width / (grille.length + 2.5), height / (grille.length + 1));
				
				rectangleSP.setLayoutX(rectangle.getWidth() * (x + 0.5));
				rectangleSP.setLayoutY(rectangle.getHeight() * (y + 0.5));
				
				rectangle.setOpacity((grille[x][y].getJoueur() != null) ? 0.7 : 1);
				rectangle.setFill(grille[x][y].getColor());				
				rectangle.setStroke(Color.BLACK);
				
				Text rectangleText = (grille[x][y].getJoueur() != null) ? new Text(grille[x][y].getJoueur().getNom()) : new Text();
				rectangleText.setFont(Font.font("Arial", FontWeight.BOLD, 15));
				rectangleText.setBoundsType(TextBoundsType.VISUAL); 
				rectangleText.setFill(Color.BLACK);
				
				rectangleSP.getChildren().addAll(rectangle, rectangleText);
				
				gridGroup.getChildren().add(rectangleSP);
			}
		}
		
		return gridGroup;
	}
	
	public Group graphicalShowHexa()
	{
		int x, y;
		double tailleHexa = (double) height / ((grille.length + 1) * 40);

		Group gridGroup = new Group();
		
		for(x = 0; x < grille.length; x ++)
		{
			for(y = 0; y < grille[0].length; y ++)
			{
				StackPane hexagoneSP = new StackPane();
				
				Hexagon hexagone = new Hexagon(tailleHexa);
				
				hexagoneSP.setLayoutX(50 * tailleHexa * (x + 0.5) + ((y % 2 == 0) ? 0 : 25 * tailleHexa));
				hexagoneSP.setLayoutY(50 * tailleHexa * (y + 0.5) - 12 * tailleHexa* y);
				
				hexagone.setOpacity((grille[x][y].getJoueur() != null) ? 0.7 : 1);
				hexagone.setFill(grille[x][y].getColor());				
				hexagone.setStroke(Color.BLACK);
				
				Text hexagoneText = (grille[x][y].getJoueur() != null) ? new Text(grille[x][y].getJoueur().getNom()) : new Text();
				hexagoneText.setFont(Font.font("Arial", FontWeight.BOLD, 15));
				hexagoneText.setBoundsType(TextBoundsType.VISUAL); 
				hexagoneText.setFill(Color.BLACK);
				
				hexagoneSP.getChildren().addAll(hexagone, hexagoneText);
				
				gridGroup.getChildren().add(hexagoneSP);
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
		int i, y = 0, z = 0;
		double tailleGrille = getGrille().length * getGrille().length;
		
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(1);
		f.setMinimumFractionDigits(1);
		
		Group buttonGroup = new Group();
		
		ArrayList<Color> choosableColor = choosableColor(joueurs);
		
		for (i =  0; i < choosableColor.size(); i ++)
		{
			Rectangle rectangle = new Rectangle(width / (grille.length + 2.5), height / (grille.length + 1));
			
			rectangle.setX(width / (grille.length + 2.5) * (grille.length + 1));
			rectangle.setY(height / (grille.length + 1) * (y + 0.5));
			
			rectangle.setFill(choosableColor.get(i));
			rectangle.setStroke(Color.BLACK);			
			
			rectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
			{
				Color colorP = Color.valueOf(rectangle.getFill() + "");
				joueurCourant.setColor(colorP);
				joueurCourant.majCaseColor(colorP);
				
				if (getTypeGrille() == 0)
				{
					captureSquare(joueurCourant);
				}
				else
				{
					captureHexa(joueurCourant);
				}
				
				int newIndiceJoueur = (indiceJoueur + 1) % joueurs.length;
				Game.build(this, joueurCourant, joueurs, primaryStage, newIndiceJoueur);
	        });
			
			buttonGroup.getChildren().add(rectangle);
			
			y ++;
		}
		
		StackPane btnJoueurCourantSP = new StackPane();
    	
    	Rectangle btnJoueurCourant = new Rectangle(width / (grille.length + 2.5), height / (grille.length + 1));
    	btnJoueurCourant.setFill(Color.TRANSPARENT);
    	
    	Text btnJoueurCourantText = new Text("Actuel : " + joueurCourant.getNom());
    	btnJoueurCourantText.setFont(Font.font("Arial", 30 * 13 / getGrille().length));
    	btnJoueurCourantText.setBoundsType(TextBoundsType.VISUAL); 
    	btnJoueurCourantText.setFill(Color.BLACK);
    	
    	btnJoueurCourantSP.setLayoutX(width / (grille.length + 2.5) * (grille.length + 1));
    	btnJoueurCourantSP.setLayoutY(height / (grille.length + 1) * (7.5 - joueurs.length));
    	btnJoueurCourantSP.getChildren().addAll(btnJoueurCourant, btnJoueurCourantText);
    	
    	buttonGroup.getChildren().add(btnJoueurCourantSP);
		
		Rectangle rectangle = new Rectangle(width / (grille.length + 2.5), height / (grille.length + 1));
		
		rectangle.setX(width / (grille.length + 2.5) * (grille.length + 1));
		rectangle.setY(height / (grille.length + 1) * (8.5 - joueurs.length));
		
		rectangle.setFill(joueurCourant.getColor());
		rectangle.setStroke(Color.BLACK);
		rectangle.setOpacity(0.7);
		
		for (z = 0; z < joueurs.length; z ++)
		{			
			StackPane btnJoueurSP = new StackPane();
	    	
	    	Rectangle btnJoueur = new Rectangle(width / (grille.length + 2.5), height / (grille.length + 1));
	    	btnJoueur.setFill(Color.TRANSPARENT);
	    	
	    	Text btnJoueurText = new Text(joueurs[z].getNom() + " : " + f.format((joueurs[z].getNbCase() / tailleGrille) * 100) + " %");
	    	btnJoueurText.setFont(Font.font("Arial", 30 * 13 / getGrille().length));
	    	btnJoueurText.setBoundsType(TextBoundsType.VISUAL); 
	    	btnJoueurText.setFill(Color.BLACK);
	    	
	    	btnJoueurSP.setLayoutX(width / (grille.length + 2.5) * (grille.length + 1));
	    	btnJoueurSP.setLayoutY(height / (grille.length + 1) * (9.5 - joueurs.length + z));
	    	btnJoueurSP.getChildren().addAll(btnJoueur, btnJoueurText);
	    	
	    	buttonGroup.getChildren().add(btnJoueurSP);
		}
		
		buttonGroup.getChildren().add(rectangle);
		
		return buttonGroup;
	}
	
	public void captureSquare (Joueur joueurCourant)
	{
		ArrayList<Case> caseOwn = joueurCourant.getCaseOwn();
		int x, y, z;
		
		for (z = 0; z < caseOwn.size(); z ++)
		{			
			x = caseOwn.get(z).getCoordX();
			y = caseOwn.get(z).getCoordY();
				
			if ((x - 1 >= 0) && (getGrille()[x - 1][y].getJoueur() == null) && (getGrille()[x - 1][y].getColor().equals(joueurCourant.getColor())))
			{
				joueurCourant.assocJoueurCase(getGrille()[x - 1][y]);
			}
			if ((x + 1 < grille.length) && (getGrille()[x + 1][y].getJoueur() == null) && (getGrille()[x + 1][y].getColor().equals(joueurCourant.getColor())))
			{
				joueurCourant.assocJoueurCase(getGrille()[x + 1][y]);
			}
			if ((y - 1 >= 0) && (getGrille()[x][y - 1].getJoueur() == null) && (getGrille()[x][y - 1].getColor().equals(joueurCourant.getColor())))
			{
				joueurCourant.assocJoueurCase(getGrille()[x][y - 1]);
			}
			if ((y + 1 < grille.length) && (getGrille()[x][y + 1].getJoueur() == null) && (getGrille()[x][y + 1].getColor().equals(joueurCourant.getColor())))
			{
				joueurCourant.assocJoueurCase(getGrille()[x][y + 1]);
			}
		}
	}
	
	public int simuCaptureSquare (Joueur joueurCourant, Color color)
	{
		ArrayList<Case> caseOwn = new ArrayList<Case> (joueurCourant.getCaseOwn());
		int x, y, z, nbCase = 0;		
		
		for (z = 0; z < caseOwn.size(); z ++)
		{			
			x = caseOwn.get(z).getCoordX();
			y = caseOwn.get(z).getCoordY();
				
			if ((x - 1 >= 0) && (getGrille()[x - 1][y].getJoueur() == null) && (getGrille()[x - 1][y].getColor().equals(color)))
			{
				nbCase ++;
				caseOwn.add(getGrille()[x - 1][y]);
			}
			if ((x + 1 < grille.length) && (getGrille()[x + 1][y].getJoueur() == null) && (getGrille()[x + 1][y].getColor().equals(color)))
			{
				nbCase ++;
			}
			if ((y - 1 >= 0) && (getGrille()[x][y - 1].getJoueur() == null) && (getGrille()[x][y - 1].getColor().equals(color)))
			{
				nbCase ++;
			}
			if ((y + 1 < grille.length) && (getGrille()[x][y + 1].getJoueur() == null) && (getGrille()[x][y + 1].getColor().equals(color)))
			{
				nbCase ++;
			}
		}
		
		return nbCase ++;
	}
	
	public void captureHexa (Joueur joueurCourant)
	{
		ArrayList<Case> caseOwn = joueurCourant.getCaseOwn();
		int x, y, z;
		
		for (z = 0; z < caseOwn.size(); z ++)
		{
			x = caseOwn.get(z).getCoordX();
			y = caseOwn.get(z).getCoordY();
			
			if ((y - 1 >= 0) && (getGrille()[x][y - 1].getJoueur() == null) && (getGrille()[x][y - 1].getColor().equals(joueurCourant.getColor())))
			{
				joueurCourant.assocJoueurCase(getGrille()[x][y - 1]);
			}
			if ((y + 1 < grille.length) && (getGrille()[x][y + 1].getJoueur() == null) && (getGrille()[x][y + 1].getColor().equals(joueurCourant.getColor())))
			{
				joueurCourant.assocJoueurCase(getGrille()[x][y + 1]);
			}
			if ((x - 1 >= 0) && (getGrille()[x - 1][y].getJoueur() == null) && (getGrille()[x - 1][y].getColor().equals(joueurCourant.getColor())))
			{
				joueurCourant.assocJoueurCase(getGrille()[x - 1][y]);
			}
			if ((x + 1 < grille.length) && (getGrille()[x + 1][y].getJoueur() == null) && (getGrille()[x + 1][y].getColor().equals(joueurCourant.getColor())))
			{
				joueurCourant.assocJoueurCase(getGrille()[x + 1][y]);
			}
			
			if (y % 2 == 0)
			{
				if ((x - 1 >= 0) && (y + 1 < grille.length) && (getGrille()[x - 1][y + 1].getJoueur() == null) && (getGrille()[x - 1][y + 1].getColor().equals(joueurCourant.getColor())))
				{
					joueurCourant.assocJoueurCase(getGrille()[x - 1][y + 1]);
				}
				if ((x - 1 >= 0) && (y - 1 >= 0) && (getGrille()[x - 1][y - 1].getJoueur() == null) && (getGrille()[x - 1][y - 1].getColor().equals(joueurCourant.getColor())))
				{
					joueurCourant.assocJoueurCase(getGrille()[x - 1][y - 1]);
				}
			}
			else
			{
				if ((x + 1 < grille.length) && (y + 1 < grille.length) && (getGrille()[x + 1][y + 1].getJoueur() == null) && (getGrille()[x + 1][y + 1].getColor().equals(joueurCourant.getColor())))
				{
					joueurCourant.assocJoueurCase(getGrille()[x + 1][y + 1]);
				}
				if ((x + 1 < grille.length) && (y - 1 >= 0) && (getGrille()[x + 1][y - 1].getJoueur() == null) && (getGrille()[x + 1][y - 1].getColor().equals(joueurCourant.getColor())))
				{
					joueurCourant.assocJoueurCase(getGrille()[x + 1][y - 1]);
				}			
			}
		}
	}
}