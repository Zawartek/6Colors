package base;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application
{
    public static void main(String[] args)
    {
    	Application.launch(Test.class, args);
    }

    public void start(Stage primaryStage)
    {
    	primaryStage.setTitle("Six Couleurs");
    	
        Grille grille =  new Grille();
    	grille.initGrid(10);
    	//grille.showGrid();
    	
    	int indiceJoueur = 0;
    	Joueur joueurs [] =  new Joueur [2];
    	joueurs[0] = new Joueur("J1", grille.getGrille()[0][0]);
    	joueurs[1] = new Joueur("J2", grille.getGrille()[0][grille.getGrille()[0].length - 1]);
    	
    	for (int q = 0; q < joueurs.length; q ++)
    	{
    		grille.majCaseJoueur(joueurs[q]);
    	}
    	Joueur joueurCourant = joueurs[indiceJoueur];
    	
    	build (grille, joueurCourant, joueurs, primaryStage, indiceJoueur);
    }
    
    public static void build (Grille grille, Joueur joueurCourant, Joueur [] joueurs, Stage primaryStage, int indiceJoueur)
    {
    	joueurCourant = joueurs[indiceJoueur];
    	Group gridGroup = grille.graphicalShow();
    	Group buttonGroup = grille.generateButton(joueurs, joueurCourant, primaryStage, indiceJoueur);
    	
    	Group root =  new Group();
    	root.getChildren().addAll(gridGroup, buttonGroup);
    	
    	Scene scene = new Scene(root, Grille.width, Grille.height, Color.WHITE);
    	primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}