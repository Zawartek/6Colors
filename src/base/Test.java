package base;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class Test extends Application
{
    public static void main(String[] args)
    {
    	Application.launch(Test.class, args);
    }
    
    public static int nbPlayer = 1;
    public static int typeGrille = 0;

    public void start(Stage primaryStage)
    {
    	primaryStage.setTitle("Six Couleurs");
    	Group root =  new Group();
    	
    	Color defaultFill = Color.RED;
    	Color defaultStroke = Color.BLACK;
    	
    	Color selectedFill = Color.BLUE;    	
    	Color selectedStroke = Color.BLUE;
    	
    	StackPane btnTitleSP = new StackPane();
    	
    	Rectangle btnTitle = new Rectangle(Grille.width, 100);
    	btnTitle.setFill(Color.TRANSPARENT);
    	
    	Text btnTitleText = new Text("Veuillez choisir les paramètres de jeu :");
    	btnTitleText.setFont(Font.font("Arial", 60));
    	btnTitleText.setBoundsType(TextBoundsType.VISUAL); 
    	btnTitleText.setFill(Color.BLACK);
    	
    	btnTitleSP.setLayoutX(Grille.width / 2 - btnTitle.getWidth() / 2);
    	btnTitleSP.setLayoutY(Grille.height / 6 - btnTitle.getHeight() / 2);
    	btnTitleSP.getChildren().addAll(btnTitle, btnTitleText);
    	
    	root.getChildren().add(btnTitleSP);
    	
    	StackPane btn1PlayerSP = new StackPane();
    	
    	Rectangle btn1Player = new Rectangle(150, 100);    	
    	btn1Player.setFill(Color.WHITE);
    	btn1Player.setStroke(selectedStroke);
    	
    	Text btn1PlayerText = new Text("1");
    	btn1PlayerText.setFont(Font.font("Arial", 80));
    	btn1PlayerText.setBoundsType(TextBoundsType.VISUAL); 
    	btn1PlayerText.setFill(selectedFill);
    	btn1PlayerText.setStroke(Color.BLACK);
    	
    	btn1PlayerSP.setLayoutX(Grille.width / 5 - btn1Player.getWidth() / 2);
    	btn1PlayerSP.setLayoutY(Grille.height / 6 * 2 - btn1Player.getHeight() / 2);
    	btn1PlayerSP.getChildren().addAll(btn1Player, btn1PlayerText);
    	
    	StackPane btn2PlayerSP = new StackPane();
    	
    	Rectangle btn2Player = new Rectangle(150, 100);    	
    	btn2Player.setFill(Color.WHITE);
    	btn2Player.setStroke(defaultStroke);
    	
    	Text btn2PlayerText = new Text("2");
    	btn2PlayerText.setFont(Font.font("Arial", 80));
    	btn2PlayerText.setBoundsType(TextBoundsType.VISUAL); 
    	btn2PlayerText.setFill(defaultFill);
    	btn2PlayerText.setStroke(Color.BLACK);
    	
    	btn2PlayerSP.setLayoutX(Grille.width / 5 * 2 - btn2Player.getWidth() / 2);
    	btn2PlayerSP.setLayoutY(Grille.height / 6 * 2 - btn2Player.getHeight() / 2);
    	btn2PlayerSP.getChildren().addAll(btn2Player, btn2PlayerText);
    	
    	StackPane btn3PlayerSP = new StackPane();
    	
    	Rectangle btn3Player = new Rectangle(150, 100);    	
    	btn3Player.setFill(Color.WHITE);
    	btn3Player.setStroke(defaultStroke);
    	
    	Text btn3PlayerText = new Text("3");
    	btn3PlayerText.setFont(Font.font("Arial", 80));
    	btn3PlayerText.setBoundsType(TextBoundsType.VISUAL); 
    	btn3PlayerText.setFill(defaultFill);
    	btn3PlayerText.setStroke(Color.BLACK);
    	
    	btn3PlayerSP.setLayoutX(Grille.width / 5 * 3 - btn3Player.getWidth() / 2);
    	btn3PlayerSP.setLayoutY(Grille.height / 6 * 2 - btn3Player.getHeight() / 2);
    	btn3PlayerSP.getChildren().addAll(btn3Player, btn3PlayerText);
    	
    	StackPane btn4PlayerSP = new StackPane();
    	
    	Rectangle btn4Player = new Rectangle(150, 100);    	
    	btn4Player.setFill(Color.WHITE);
    	btn4Player.setStroke(defaultStroke);
    	
    	Text btn4PlayerText = new Text("4");
    	btn4PlayerText.setFont(Font.font("Arial", 80));
    	btn4PlayerText.setBoundsType(TextBoundsType.VISUAL); 
    	btn4PlayerText.setFill(defaultFill);
    	btn4PlayerText.setStroke(Color.BLACK);
    	
    	btn4PlayerSP.setLayoutX(Grille.width / 5 * 4 - btn4Player.getWidth() / 2);
    	btn4PlayerSP.setLayoutY(Grille.height / 6 * 2 - btn4Player.getHeight() / 2);
    	btn4PlayerSP.getChildren().addAll(btn4Player, btn4PlayerText);
    	
    	root.getChildren().addAll(btn1PlayerSP, btn2PlayerSP, btn3PlayerSP, btn4PlayerSP);
    	
    	btn1PlayerSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			nbPlayer = 1;
			
			btn1Player.setStroke(selectedStroke);
			btn1PlayerText.setFill(selectedFill);
			
			btn2Player.setStroke(defaultStroke);
			btn2PlayerText.setFill(defaultFill);
			
			btn3Player.setStroke(defaultStroke);
			btn3PlayerText.setFill(defaultFill);
			
			btn4Player.setStroke(defaultStroke);
			btn4PlayerText.setFill(defaultFill);
        });
    	
    	btn2PlayerSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			nbPlayer = 2;
			
			btn1Player.setStroke(defaultStroke);
			btn1PlayerText.setFill(defaultFill);
			
			btn2Player.setStroke(selectedStroke);
			btn2PlayerText.setFill(selectedFill);
			
			btn3Player.setStroke(defaultStroke);
			btn3PlayerText.setFill(defaultFill);
			
			btn4Player.setStroke(defaultStroke);
			btn4PlayerText.setFill(defaultFill);
        });
    	
    	btn3PlayerSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			nbPlayer = 3;
			
			btn1Player.setStroke(defaultStroke);
			btn1PlayerText.setFill(defaultFill);
			
			btn2Player.setStroke(defaultStroke);
			btn2PlayerText.setFill(defaultFill);
			
			btn3Player.setStroke(selectedStroke);
			btn3PlayerText.setFill(selectedFill);
			
			btn4Player.setStroke(defaultStroke);
			btn4PlayerText.setFill(defaultFill);
        });
    	
    	btn4PlayerSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			nbPlayer = 4;
			
			btn1Player.setStroke(defaultStroke);
			btn1PlayerText.setFill(defaultFill);
			
			btn2Player.setStroke(defaultStroke);
			btn2PlayerText.setFill(defaultFill);
			
			btn3Player.setStroke(defaultStroke);
			btn3PlayerText.setFill(defaultFill);
			
			btn4Player.setStroke(selectedStroke);
			btn4PlayerText.setFill(selectedFill);
        });
    	
    	// Menu choix de la grille
    	StackPane btnCarreSP = new StackPane();
    	StackPane btnHexaSP = new StackPane();
    	StackPane btnRandSP = new StackPane();
    	
    	
    	Rectangle btnCarre = new Rectangle(150, 100);
    	btnCarre.setFill(Color.WHITE);
    	btnCarre.setStroke(selectedStroke);
    	
    	Rectangle btnCarreImg = new Rectangle(75, 50);
    	btnCarreImg.setFill(selectedFill);
    	btnCarreImg.setStroke(Color.BLACK);
    	
    	btnCarreSP.getChildren().addAll(btnCarre, btnCarreImg);
    	btnCarreSP.setLayoutX(Grille.width / 4 - btnCarre.getWidth() / 2);
    	btnCarreSP.setLayoutY(Grille.height / 6 * 4 - btnCarre.getHeight() / 2);
    	
    	
    	Rectangle btnHexa = new Rectangle(150, 100);
    	btnHexa.setFill(Color.WHITE);
    	btnHexa.setStroke(defaultStroke);
    	
    	Hexagon btnHexaImg = new Hexagon(1.1);
    	btnHexaImg.setFill(defaultFill);
    	btnHexaImg.setStroke(Color.BLACK);
    	
    	btnHexaSP.getChildren().addAll(btnHexa, btnHexaImg);
    	btnHexaSP.setLayoutX(Grille.width / 4 * 2 - btnHexa.getWidth() / 2);
    	btnHexaSP.setLayoutY(Grille.height / 6 * 4 - btnHexa.getHeight() / 2);
    	
    	
    	Rectangle btnRand = new Rectangle(150, 100);
    	
    	btnRand.setFill(Color.WHITE);
    	btnRand.setStroke(defaultStroke);
    	
    	btnRandSP.setLayoutX(Grille.width / 4 * 3 - btnRand.getWidth() / 2);
    	btnRandSP.setLayoutY(Grille.height / 6 * 4 - btnRand.getHeight() / 2);	
    	
    	Group btnRandGroupImg = new Group();
    	
    	Rectangle btnRandImg1 = new Rectangle(40, 33);
    	btnRandImg1.setLayoutX(btnRand.getWidth() / 2 - btnRandImg1.getWidth() - 15);
    	btnRandImg1.setLayoutY(btnRand.getHeight() / 2 - btnRandImg1.getHeight() / 2 - 12);
    	btnRandImg1.setFill(defaultFill);
    	btnRandImg1.setStroke(Color.BLACK);
    	
    	Polygon btnRandImg2 = new Polygon(0, 80, 4, 80, 10, 0, 6, 0);
    	btnRandImg2.setLayoutX(btnRand.getWidth() / 2 - 5);
    	btnRandImg2.setLayoutY(btnRand.getHeight() / 2 - 40);
    	btnRandImg2.setFill(defaultFill);
    	btnRandImg2.setStroke(Color.BLACK);
    	
    	Hexagon btnRandImg3 = new Hexagon(0.7);
    	btnRandImg3.setLayoutX(btnRand.getWidth() - 50 * 0.7 - 20);
    	btnRandImg3.setLayoutY(btnRand.getHeight() / 2 - 25 * 0.7 + 12);
    	btnRandImg3.setFill(defaultFill);
    	btnRandImg3.setStroke(Color.BLACK);
    	
    	
    	btnRandGroupImg.getChildren().addAll(btnRandImg1, btnRandImg2, btnRandImg3);
    	btnRandSP.getChildren().addAll(btnRand, btnRandGroupImg);
    	
    	
    	root.getChildren().addAll(btnCarreSP, btnHexaSP, btnRandSP);
    	
    	btnCarreSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			typeGrille = 0;
			
			btnCarre.setStroke(selectedStroke);
			btnCarreImg.setFill(selectedFill);
			
			btnHexa.setStroke(defaultStroke);
			btnHexaImg.setFill(defaultFill);
			
			btnRand.setStroke(defaultStroke);
			btnRandImg1.setFill(defaultFill);
			btnRandImg2.setFill(defaultFill);
			btnRandImg3.setFill(defaultFill);
        });
    	
    	btnHexaSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			typeGrille = 1;
			
			btnCarre.setStroke(defaultStroke);
			btnCarreImg.setFill(defaultFill);
			
			btnHexa.setStroke(selectedStroke);
			btnHexaImg.setFill(selectedFill);
			
			btnRand.setStroke(defaultStroke);
			btnRandImg1.setFill(defaultFill);
			btnRandImg2.setFill(defaultFill);
			btnRandImg3.setFill(defaultFill);
        });
    	    	
    	btnRandSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			typeGrille = 2;
			
			btnCarre.setStroke(defaultStroke);
			btnCarreImg.setFill(defaultFill);
			
			btnHexa.setStroke(defaultStroke);
			btnHexaImg.setFill(defaultFill);
			
			btnRand.setStroke(selectedStroke);
			btnRandImg1.setFill(selectedFill);
			btnRandImg2.setFill(selectedFill);
			btnRandImg3.setFill(selectedFill);
        });   	
    	
    	StackPane btnStartStack = new StackPane();
    	
    	Rectangle btnStart = new Rectangle(200, 100);
    	btnStart.setFill(Color.WHITE);
    	btnStart.setStroke(Color.BLACK);
    	
    	Text btnStartText = new Text("Go !");
    	btnStartText.setFont(Font.font("Arial", 80));
    	btnStartText.setBoundsType(TextBoundsType.VISUAL); 
    	btnStartText.setFill(Color.BLACK);
    	btnStartText.setStroke(Color.BLACK);
    	
    	btnStartStack.setLayoutX(Grille.width / 2 - btnStart.getWidth() / 2);
    	btnStartStack.setLayoutY(Grille.height / 6 * 5 - btnStart.getHeight() / 2);
    	btnStartStack.getChildren().addAll(btnStart, btnStartText);
    	
    	root.getChildren().add(btnStartStack);
    	
    	
    	btnStartStack.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			System.out.println("Grille : " + typeGrille + " avec " + nbPlayer + " joueurs");
        });
    	
    	Scene scene = new Scene(root, Grille.width, Grille.height, Color.WHITE);
    	primaryStage.setScene(scene);
        primaryStage.show();
       
        //initGame (4, 0, 1, primaryStage);
        
        
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
    
    public void initGame (int nbHumains, int nbIA, int typeGrille, Stage primaryStage)
    {
    	int nbJoueurs = nbHumains + nbIA;
    	Grille grille =  new Grille();
    	grille.initGrid(10);
    	
    	Joueur joueurs [] =  new Joueur [nbHumains];
    	
    	ArrayList<Case> startingCase = Case.startingCase(grille, nbHumains);
    	
    	for (int i = 0; i < nbJoueurs; i ++)
    	{
    		joueurs[i] = new Joueur("J" + i, startingCase.get(i));
    	}
    	
    	for (int x = 0; x < joueurs.length; x++)
    	{
    		joueurs[x].checkSameColor(joueurs);
    	}
    	
    	for (int q = 0; q < joueurs.length; q ++)
    	{
    		grille.majCaseJoueur(joueurs[q]);
    	}
    	
    	int indiceJoueur = 0;
    	Joueur joueurCourant = joueurs[indiceJoueur];
    	
    	build (grille, joueurCourant, joueurs, primaryStage, indiceJoueur);
    }
}