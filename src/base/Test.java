package base;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
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
    	Group root =  new Group();
    	
    	Rectangle button1 = new Rectangle(150, 100);
    	button1.setX(Grille.width / 4 - button1.getWidth() / 2);
    	button1.setY(Grille.height / 2 - button1.getHeight() / 2);
    	button1.setFill(Color.WHITE);
    	button1.setStroke(Color.BLACK);
    	
    	Rectangle picRectangle = new Rectangle(75, 50);
    	picRectangle.setX(button1.getX() + picRectangle.getWidth() / 2);
    	picRectangle.setY(button1.getY() + picRectangle.getHeight() / 2);
    	picRectangle.setFill(Color.RED);
    	picRectangle.setStroke(Color.BLACK);
    	
    	root.getChildren().addAll(button1, picRectangle);
    	
    	Rectangle button2 = new Rectangle(150, 100);
    	button2.setLayoutX(Grille.width / 4 * 2 - button2.getWidth() / 2);
    	button2.setLayoutY(Grille.height / 2 - button2.getHeight() / 2);
    	button2.setFill(Color.WHITE);
    	button2.setStroke(Color.BLACK);
    	
    	/*Rectangle picRectangle2 = new Rectangle(75, 50);
    	picRectangle2.setX(button2.getX() + picRectangle2.getWidth() / 2);
    	picRectangle2.setY(button2.getY() + picRectangle2.getHeight() / 2);
    	picRectangle2.setFill(Color.RED);
    	picRectangle2.setStroke(Color.BLACK);*/
    	
    	Hexagon picHexa = new Hexagon(1.1);
    	picHexa.setLayoutX(button2.getLayoutX() + button2.getWidth() / 2 - 27.5);
    	picHexa.setLayoutY(button2.getLayoutY() + button2.getHeight() / 2 - 27.5);
    	picHexa.setFill(Color.RED);
    	picHexa.setStroke(Color.BLACK);
    	
    	root.getChildren().addAll(button2, picHexa);
    	
    	Rectangle button3 = new Rectangle(150, 100);
    	button3.setX(Grille.width / 4 * 3 - button3.getWidth() / 2);
    	button3.setY(Grille.height / 2 - button3.getHeight() / 2);
    	button3.setFill(Color.WHITE);
    	button3.setStroke(Color.BLACK);
    	
    	root.getChildren().add(button3);
    	
    	Scene scene = new Scene(root, Grille.width, Grille.height, Color.WHITE);
    	primaryStage.setScene(scene);
        primaryStage.show();
       
    	
    	/*primaryStage.setTitle("Six Couleurs");
    	
        Grille grille =  new Grille();
    	grille.initGrid(10);
    	//grille.showGrid();
    	
    	int indiceJoueur = 0;
    	Joueur joueurs [] =  new Joueur [2];
    	joueurs[0] = new Joueur("Zawartek", grille.getGrille()[0][0]);
    	//joueurs[1] = new Joueur("Apocaliptika", grille.getGrille()[grille.getGrille()[0].length - 1][0]);
    	//joueurs[2] = new Joueur("J3", grille.getGrille()[0][grille.getGrille()[0].length - 1]);
    	joueurs[1] = new Joueur("J4", grille.getGrille()[grille.getGrille()[0].length - 1][grille.getGrille()[0].length - 1]);
    	
    	for (int x = 0; x < joueurs.length; x++)
    	{
    		joueurs[x].checkSameColor(joueurs);
    	}
    	
    	for (int q = 0; q < joueurs.length; q ++)
    	{
    		grille.majCaseJoueur(joueurs[q]);
    	}
    	Joueur joueurCourant = joueurs[indiceJoueur];
    	
    	build (grille, joueurCourant, joueurs, primaryStage, indiceJoueur);*/
    }
    
    public static void build (Grille grille, Joueur joueurCourant, Joueur [] joueurs, Stage primaryStage, int indiceJoueur)
    {
    	grille.endGame(joueurs);
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