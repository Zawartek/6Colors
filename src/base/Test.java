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
        Grille grille =  new Grille();
    	grille.initGrid(10);
    	grille.showGrid();
    	
    	Group root = new Group();
    	root = grille.graphicalShow(root);
    	
    	Joueur joueurs [] =  new Joueur [1];
    	
    	joueurs[0] = new Joueur("Zaza", grille.getGrille()[0][0].getCouleur());
    	
    	Joueur joueurCourant = joueurs[0];
    	joueurCourant.setCaseOwn(grille.getGrille()[0][0]);
    	
    	root = grille.generateButton(Grille.choosableColor(joueurs), root, joueurCourant);
    	
    	primaryStage.setTitle("Six Couleurs");
    	Scene scene = new Scene(root, Grille.width, Grille.height, Color.WHITE);
    	primaryStage.setScene(scene);

        primaryStage.show();
    }
}