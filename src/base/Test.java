package base;

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
    	grille.showGrid();
    	
    	Joueur joueurs [] =  new Joueur [1];
    	joueurs[0] = new Joueur("Zaza", grille.getGrille()[0][0].getCouleur());
    	Joueur joueurCourant = joueurs[0];
    	
    	joueurCourant.setCaseOwn(grille.getGrille()[0][0]);
   
    	build (grille, joueurCourant, joueurs, primaryStage);
    }
    
    public static void build (Grille grille, Joueur joueurCourant, Joueur [] joueurs, Stage primaryStage)
    {
    	Group gridGroup = grille.graphicalShow();
    	Group buttonGroup = grille.generateButton(joueurs, joueurCourant, primaryStage);
    	
    	Group root =  new Group();
    	root.getChildren().addAll(gridGroup, buttonGroup);
    	
    	Scene scene = new Scene(root, Grille.width, Grille.height, Color.WHITE);
    	primaryStage.setScene(scene);
        primaryStage.show();
    }
}