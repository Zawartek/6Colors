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
    	
    	Rectangle btnCarre = new Rectangle(150, 100);
    	btnCarre.setX(Grille.width / 4 - btnCarre.getWidth() / 2);
    	btnCarre.setY(Grille.height / 2 - btnCarre.getHeight() / 2);
    	btnCarre.setFill(Color.WHITE);
    	btnCarre.setStroke(Color.BLACK);
    	
    	Rectangle btnCarreImg = new Rectangle(75, 50);
    	btnCarreImg.setX(btnCarre.getX() + btnCarreImg.getWidth() / 2);
    	btnCarreImg.setY(btnCarre.getY() + btnCarreImg.getHeight() / 2);
    	btnCarreImg.setFill(Color.RED);
    	btnCarreImg.setStroke(Color.BLACK);
    	
    	root.getChildren().addAll(btnCarre, btnCarreImg);
    	
    	Rectangle btnHexa = new Rectangle(150, 100);
    	btnHexa.setLayoutX(Grille.width / 4 * 2 - btnHexa.getWidth() / 2);
    	btnHexa.setLayoutY(Grille.height / 2 - btnHexa.getHeight() / 2);
    	btnHexa.setFill(Color.WHITE);
    	btnHexa.setStroke(Color.BLACK);
    	
    	Hexagon btnHexaImg = new Hexagon(1.1);
    	btnHexaImg.setLayoutX(btnHexa.getLayoutX() + btnHexa.getWidth() / 2 - 25 * 1.1);
    	btnHexaImg.setLayoutY(btnHexa.getLayoutY() + btnHexa.getHeight() / 2 - 25 * 1.1);
    	btnHexaImg.setFill(Color.RED);
    	btnHexaImg.setStroke(Color.BLACK);
    	
    	root.getChildren().addAll(btnHexa, btnHexaImg);
    	
    	Rectangle btnRand = new Rectangle(150, 100);
    	btnRand.setLayoutX(Grille.width / 4 * 3 - btnRand.getWidth() / 2);
    	btnRand.setLayoutY(Grille.height / 2 - btnRand.getHeight() / 2);
    	btnRand.setFill(Color.WHITE);
    	btnRand.setStroke(Color.BLACK);
    	
    	Rectangle btnRandImg1 = new Rectangle(50, 34);
    	btnRandImg1.setLayoutX(btnRand.getLayoutX() + btnRand.getWidth() / 2 - btnRandImg1.getWidth());
    	btnRandImg1.setLayoutY(btnRand.getLayoutY() + btnRand.getHeight() / 2 - btnRandImg1.getHeight() / 2);
    	btnRandImg1.setFill(Color.RED);
    	btnRandImg1.setStroke(Color.BLACK);
    	
    	Hexagon btnRandImg2 = new Hexagon(0.7);
    	btnRandImg2.setLayoutX(btnRand.getLayoutX() + btnRand.getWidth() / 2 - 25 * 0.7 + 20);
    	btnRandImg2.setLayoutY(btnRand.getLayoutY() + btnRand.getHeight() / 2 - 25 * 0.7);
    	btnRandImg2.setFill(Color.RED);
    	btnRandImg2.setStroke(Color.BLACK);
    	
    	root.getChildren().addAll(btnRand, btnRandImg1, btnRandImg2);
    	
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