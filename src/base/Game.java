package base;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game
{	
	public static void initGame (int nbHumains, int nbIA, int tailleGrille, Stage primaryStage)
    {
    	int nbJoueurs = nbHumains + nbIA;
    	Grille grille =  new Grille();
    	grille.initGrid(tailleGrille);
    	
    	Menu.typeGrille = (Menu.typeGrille == 2) ? (int)(Math.random() * 2) : Menu.typeGrille;
    	grille.setTypeGrille(Menu.typeGrille);
    	
    	Joueur joueurs [] =  new Joueur [nbJoueurs];
    	
    	ArrayList<Case> startingCase = Case.startingCase(grille, nbJoueurs);
    	
    	for (int i = 0; i < nbJoueurs; i ++)
    	{
    		if (i < nbHumains)
    		{
    			joueurs[i] = new Joueur("J" + (i + 1), startingCase.get(i), 1);
    		}
    		else
    		{
    			joueurs[i] = new Joueur("O" + (i + 1), startingCase.get(i), 0);
    		}
    	}
    	
    	for (int x = 0; x < joueurs.length; x++)
    	{
    		joueurs[x].checkSameColor(joueurs);
    	}
    	
    	for (int q = 0; q < joueurs.length; q ++)
    	{
    		if (grille.getTypeGrille() == 0)
    		{
    			grille.captureSquare(joueurs[q]);
    		}
    		else
    		{
    			grille.captureHexa(joueurs[q]);
    		}    		
    	}
    	
    	int indiceJoueur = 0;
    	Joueur joueurCourant = joueurs[indiceJoueur];
    	
    	build (grille, joueurCourant, joueurs, primaryStage, indiceJoueur);
    }
	
	public static void build (Grille grille, Joueur joueurCourant, Joueur [] joueurs, Stage primaryStage, int indiceJoueur)
    {
    	if(endGame(joueurs, grille, primaryStage))
    	{
    		return;
    	}
    	
    	joueurCourant = joueurs[indiceJoueur];
    	
    	if (joueurCourant.getType() == 0)
    	{
    		Color chosenColor;
    		
    		if (joueurs.length % 2 == 1)
    		{
    			chosenColor = IntelligenceA.BasicIA(joueurs);
    		}
    		else
    		{
    			chosenColor = IntelligenceA.NormalIA(joueurCourant, joueurs, grille);
    		}
    		
    		joueurCourant.setColor(chosenColor);
			joueurCourant.majCaseColor(chosenColor);
			
			if (grille.getTypeGrille() == 0)
			{
				grille.captureSquare(joueurCourant);
			}
			else
			{
				grille.captureHexa(joueurCourant);
			}
			
			int newIndiceJoueur = (indiceJoueur + 1) % joueurs.length;
			build(grille, joueurCourant, joueurs, primaryStage, newIndiceJoueur);
    	}
    	else
    	{
    		Group gridGroup;
    		
    		if (grille.getTypeGrille() == 0)
			{
    			gridGroup = grille.graphicalShowSquare();
			}
			else
			{
				gridGroup = grille.graphicalShowHexa();
			}
    		
	    	Group buttonGroup = grille.generateButton(joueurs, joueurCourant, primaryStage, indiceJoueur);
	    	
	    	Group root =  new Group();
	    	root.getChildren().addAll(gridGroup, buttonGroup);
	    	
	    	Scene scene = new Scene(root, Grille.width, Grille.height, Color.WHITE);
	    	primaryStage.setScene(scene);
	        primaryStage.show();
    	}
    }
	
	public static boolean endGame (Joueur [] joueurs, Grille grille, Stage primaryStage)
	{
		int nbCaseJoueur, nbCaseRestante, nbCasePrise = 0;
		
		Joueur premierJoueur = new Joueur();
		Joueur secondJoueur = new Joueur();
		
		for (int i = 0; i < joueurs.length; i ++)
		{
			nbCaseJoueur = joueurs[i].getNbCase();
			premierJoueur = (nbCaseJoueur > premierJoueur.getNbCase()) ? joueurs[i] : premierJoueur;
			nbCasePrise += nbCaseJoueur;
		}
		
		nbCaseRestante = grille.getGrille().length * grille.getGrille().length  - nbCasePrise;
		
		for (int i = 0; i < joueurs.length; i ++)
		{
			secondJoueur = ((joueurs[i].getNbCase() > secondJoueur.getNbCase()) && !(joueurs[i].equals(premierJoueur))) ? joueurs[i] : secondJoueur;
		}
		
		if (((secondJoueur.getNbCase() + nbCaseRestante) < premierJoueur.getNbCase()) || nbCaseRestante == 0)
		{
			Menu.affichageEcranFin(joueurs, premierJoueur, secondJoueur, primaryStage);
			return true;
		}
		
		return false;
	}
}
