package base;

import java.text.DecimalFormat;

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

public class Menu
{
    public static int nbHumains = 1;
    public static int nbIA = 1;
    public static int typeGrille = 0;
    public static int tailleGrille = 13;
    
	public static void affichageEcranDebut (Stage primaryStage)
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
		
		Text btnTitleText = new Text("Veuillez choisir les param�tres de jeu :");
		btnTitleText.setFont(Font.font("Comic sans ms", 50));
		btnTitleText.setBoundsType(TextBoundsType.VISUAL); 
		btnTitleText.setFill(Color.BLACK);
		
		btnTitleSP.setLayoutX(Grille.width / 2 - btnTitle.getWidth() / 2);
		btnTitleSP.setLayoutY(Grille.height / 7 - btnTitle.getHeight() / 2);
		btnTitleSP.getChildren().addAll(btnTitle, btnTitleText);
		
		root.getChildren().add(btnTitleSP);
		
		StackPane btnPlayerSP = new StackPane();
		
		Rectangle btnPlayer = new Rectangle(Grille.width, 100);
		btnPlayer.setFill(Color.TRANSPARENT);
		
		Text btnPlayerText = new Text("Choisissez le nombre de joueurs :");
		btnPlayerText.setFont(Font.font("Comic sans ms", 35));
		btnPlayerText.setBoundsType(TextBoundsType.VISUAL); 
		btnPlayerText.setFill(Color.BLACK);
		
		btnPlayerSP.setLayoutX(Grille.width / 2 - btnPlayer.getWidth() / 2);
		btnPlayerSP.setLayoutY(Grille.height / 6 * 1.5 - btnPlayer.getHeight() / 2);
		btnPlayerSP.getChildren().addAll(btnPlayer, btnPlayerText);
		
		root.getChildren().add(btnPlayerSP);
		
		StackPane btn1PlayerSP = new StackPane();
		
		Rectangle btn1Player = new Rectangle(120, 80);    	
		btn1Player.setFill(Color.WHITE);
		btn1Player.setStroke(selectedStroke);
		btn1Player.setArcWidth(10);
		btn1Player.setArcHeight(10);
		
		Text btn1PlayerText = new Text("1");
		btn1PlayerText.setFont(Font.font("Arial", 50));
		btn1PlayerText.setBoundsType(TextBoundsType.VISUAL); 
		btn1PlayerText.setFill(selectedFill);
		btn1PlayerText.setStroke(Color.BLACK);
		
		btn1PlayerSP.setLayoutX(Grille.width / 5 - btn1Player.getWidth() / 2);
		btn1PlayerSP.setLayoutY(Grille.height / 6 * 2 - btn1Player.getHeight() / 2);
		btn1PlayerSP.getChildren().addAll(btn1Player, btn1PlayerText);
		
		StackPane btn2PlayerSP = new StackPane();
		
		Rectangle btn2Player = new Rectangle(120, 80);    	
		btn2Player.setFill(Color.WHITE);
		btn2Player.setStroke(defaultStroke);
		btn2Player.setArcWidth(10);
		btn2Player.setArcHeight(10);
		
		Text btn2PlayerText = new Text("2");
		btn2PlayerText.setFont(Font.font("Arial", 50));
		btn2PlayerText.setBoundsType(TextBoundsType.VISUAL); 
		btn2PlayerText.setFill(defaultFill);
		btn2PlayerText.setStroke(Color.BLACK);
		
		btn2PlayerSP.setLayoutX(Grille.width / 5 * 2 - btn2Player.getWidth() / 2);
		btn2PlayerSP.setLayoutY(Grille.height / 6 * 2 - btn2Player.getHeight() / 2);
		btn2PlayerSP.getChildren().addAll(btn2Player, btn2PlayerText);
		
		StackPane btn3PlayerSP = new StackPane();
		
		Rectangle btn3Player = new Rectangle(120, 80);    	
		btn3Player.setFill(Color.WHITE);
		btn3Player.setStroke(defaultStroke);
		btn3Player.setArcWidth(10);
		btn3Player.setArcHeight(10);
		
		Text btn3PlayerText = new Text("3");
		btn3PlayerText.setFont(Font.font("Arial", 50));
		btn3PlayerText.setBoundsType(TextBoundsType.VISUAL); 
		btn3PlayerText.setFill(defaultFill);
		btn3PlayerText.setStroke(Color.BLACK);
		
		btn3PlayerSP.setLayoutX(Grille.width / 5 * 3 - btn3Player.getWidth() / 2);
		btn3PlayerSP.setLayoutY(Grille.height / 6 * 2 - btn3Player.getHeight() / 2);
		btn3PlayerSP.getChildren().addAll(btn3Player, btn3PlayerText);
		
		StackPane btn4PlayerSP = new StackPane();
		
		Rectangle btn4Player = new Rectangle(120, 80);    	
		btn4Player.setFill(Color.WHITE);
		btn4Player.setStroke(defaultStroke);
		btn4Player.setArcWidth(10);
		btn4Player.setArcHeight(10);
		
		Text btn4PlayerText = new Text("4");
		btn4PlayerText.setFont(Font.font("Arial", 50));
		btn4PlayerText.setBoundsType(TextBoundsType.VISUAL); 
		btn4PlayerText.setFill(defaultFill);
		btn4PlayerText.setStroke(Color.BLACK);
		
		btn4PlayerSP.setLayoutX(Grille.width / 5 * 4 - btn4Player.getWidth() / 2);
		btn4PlayerSP.setLayoutY(Grille.height / 6 * 2 - btn4Player.getHeight() / 2);
		btn4PlayerSP.getChildren().addAll(btn4Player, btn4PlayerText);
		
		root.getChildren().addAll(btn1PlayerSP, btn2PlayerSP, btn3PlayerSP, btn4PlayerSP);
		
		
		// Partie nb IA
		StackPane btnIASP = new StackPane();
		
		Rectangle btnIA = new Rectangle(Grille.width, 100);
		btnIA.setFill(Color.TRANSPARENT);
		
		Text btnIAText = new Text("Choisissez le nombre de d'ordinateurs :");
		btnIAText.setFont(Font.font("Comic sans ms", 35));
		btnIAText.setBoundsType(TextBoundsType.VISUAL); 
		btnIAText.setFill(Color.BLACK);
		
		btnIASP.setLayoutX(Grille.width / 2 - btnIA.getWidth() / 2);
		btnIASP.setLayoutY(Grille.height / 6 * 2.5 - btnIA.getHeight() / 2);
		btnIASP.getChildren().addAll(btnIA, btnIAText);
		
		root.getChildren().add(btnIASP);
		
		StackPane btn0IASP = new StackPane();
		
		Rectangle btn0IA = new Rectangle(120, 80);    	
		btn0IA.setFill(Color.WHITE);
		btn0IA.setStroke(defaultStroke);
		btn0IA.setArcWidth(10);
		btn0IA.setArcHeight(10);
		
		Text btn0IAText = new Text("0");
		btn0IAText.setFont(Font.font("Arial", 50));
		btn0IAText.setBoundsType(TextBoundsType.VISUAL); 
		btn0IAText.setFill(defaultFill);
		btn0IAText.setStroke(Color.BLACK);
		
		btn0IASP.setLayoutX(Grille.width / 5 - btn0IA.getWidth() / 2);
		btn0IASP.setLayoutY(Grille.height / 6 * 3 - btn0IA.getHeight() / 2);
		btn0IASP.getChildren().addAll(btn0IA, btn0IAText);
		btn0IASP.setOpacity(0);
		btn0IASP.setDisable(true);
		
		StackPane btn1IASP = new StackPane();
		
		Rectangle btn1IA = new Rectangle(120, 80);    	
		btn1IA.setFill(Color.WHITE);
		btn1IA.setStroke(selectedStroke);
		btn1IA.setArcWidth(10);
		btn1IA.setArcHeight(10);
		
		Text btn1IAText = new Text("1");
		btn1IAText.setFont(Font.font("Arial", 50));
		btn1IAText.setBoundsType(TextBoundsType.VISUAL); 
		btn1IAText.setFill(selectedFill);
		btn1IAText.setStroke(Color.BLACK);
		
		btn1IASP.setLayoutX(Grille.width / 5 * 2 - btn1IA.getWidth() / 2);
		btn1IASP.setLayoutY(Grille.height / 6 * 3 - btn1IA.getHeight() / 2);
		btn1IASP.getChildren().addAll(btn1IA, btn1IAText);
		
		StackPane btn2IASP = new StackPane();
		
		Rectangle btn2IA = new Rectangle(120, 80);    	
		btn2IA.setFill(Color.WHITE);
		btn2IA.setStroke(defaultStroke);
		btn2IA.setArcWidth(10);
		btn2IA.setArcHeight(10);
		
		Text btn2IAText = new Text("2");
		btn2IAText.setFont(Font.font("Arial", 50));
		btn2IAText.setBoundsType(TextBoundsType.VISUAL); 
		btn2IAText.setFill(defaultFill);
		btn2IAText.setStroke(Color.BLACK);
		
		btn2IASP.setLayoutX(Grille.width / 5 * 3 - btn2IA.getWidth() / 2);
		btn2IASP.setLayoutY(Grille.height / 6 * 3 - btn2IA.getHeight() / 2);
		btn2IASP.getChildren().addAll(btn2IA, btn2IAText);
		
		StackPane btn3IASP = new StackPane();
		
		Rectangle btn3IA = new Rectangle(120, 80);    	
		btn3IA.setFill(Color.WHITE);
		btn3IA.setStroke(defaultStroke);
		btn3IA.setArcWidth(10);
		btn3IA.setArcHeight(10);
		
		Text btn3IAText = new Text("3");
		btn3IAText.setFont(Font.font("Arial", 50));
		btn3IAText.setBoundsType(TextBoundsType.VISUAL); 
		btn3IAText.setFill(defaultFill);
		btn3IAText.setStroke(Color.BLACK);
		
		btn3IASP.setLayoutX(Grille.width / 5 * 4 - btn3IA.getWidth() / 2);
		btn3IASP.setLayoutY(Grille.height / 6 * 3 - btn3IA.getHeight() / 2);
		btn3IASP.getChildren().addAll(btn3IA, btn3IAText);
		
		root.getChildren().addAll(btn0IASP, btn1IASP, btn2IASP, btn3IASP);
		
		btn1PlayerSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			nbHumains = 1;
			nbIA = 1;
			
			btn1Player.setStroke(selectedStroke);
			btn1PlayerText.setFill(selectedFill);
			
			btn2Player.setStroke(defaultStroke);
			btn2PlayerText.setFill(defaultFill);
			
			btn3Player.setStroke(defaultStroke);
			btn3PlayerText.setFill(defaultFill);
			
			btn4Player.setStroke(defaultStroke);
			btn4PlayerText.setFill(defaultFill);
			
			btn1IA.setStroke(selectedStroke);
			btn1IAText.setFill(selectedFill);
			
			btn2IA.setStroke(defaultStroke);
			btn2IAText.setFill(defaultFill);
			
			btn3IA.setStroke(defaultStroke);
			btn3IAText.setFill(defaultFill);
			
			active(btn0IASP, 0);
			active(btn1IASP, 1);
			active(btn2IASP, 1);
			active(btn3IASP, 1);
	    });
		
		btn2PlayerSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			nbHumains = 2;
			nbIA = 0;
			
			btn1Player.setStroke(defaultStroke);
			btn1PlayerText.setFill(defaultFill);
			
			btn2Player.setStroke(selectedStroke);
			btn2PlayerText.setFill(selectedFill);
			
			btn3Player.setStroke(defaultStroke);
			btn3PlayerText.setFill(defaultFill);
			
			btn4Player.setStroke(defaultStroke);
			btn4PlayerText.setFill(defaultFill);
			
			btn0IA.setStroke(selectedStroke);
			btn0IAText.setFill(selectedFill);
			
			btn1IA.setStroke(defaultStroke);
			btn1IAText.setFill(defaultFill);
			
			btn2IA.setStroke(defaultStroke);
			btn2IAText.setFill(defaultFill);
			
			active(btn0IASP, 1);
			active(btn1IASP, 1);
			active(btn2IASP, 1);
			active(btn3IASP, 0);
	    });
		
		btn3PlayerSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			nbHumains = 3;
			nbIA = 0;
			
			btn1Player.setStroke(defaultStroke);
			btn1PlayerText.setFill(defaultFill);
			
			btn2Player.setStroke(defaultStroke);
			btn2PlayerText.setFill(defaultFill);
			
			btn3Player.setStroke(selectedStroke);
			btn3PlayerText.setFill(selectedFill);
			
			btn4Player.setStroke(defaultStroke);
			btn4PlayerText.setFill(defaultFill);
			
			btn0IA.setStroke(selectedStroke);
			btn0IAText.setFill(selectedFill);
			
			btn1IA.setStroke(defaultStroke);
			btn1IAText.setFill(defaultFill);
			
			active(btn0IASP, 1);
			active(btn1IASP, 1);
			active(btn2IASP, 0);
			active(btn3IASP, 0);
	    });
		
		btn4PlayerSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			nbHumains = 4;
			nbIA = 0;
			
			btn1Player.setStroke(defaultStroke);
			btn1PlayerText.setFill(defaultFill);
			
			btn2Player.setStroke(defaultStroke);
			btn2PlayerText.setFill(defaultFill);
			
			btn3Player.setStroke(defaultStroke);
			btn3PlayerText.setFill(defaultFill);
			
			btn4Player.setStroke(selectedStroke);
			btn4PlayerText.setFill(selectedFill);
			
			active(btn0IASP, 0);
			active(btn1IASP, 0);
			active(btn2IASP, 0);
			active(btn3IASP, 0);
	    });
		
		btn0IASP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			btn0IA.setStroke(selectedStroke);
			btn0IAText.setFill(selectedFill);
			btn1IA.setStroke(defaultStroke);
			btn1IAText.setFill(defaultFill);
			
			btn2IA.setStroke(defaultStroke);
			btn2IAText.setFill(defaultFill);
			
			btn3IA.setStroke(defaultStroke);
			btn3IAText.setFill(defaultFill);
	    });
		
		btn1IASP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			nbIA = 1;
			
			btn0IA.setStroke(defaultStroke);
			btn0IAText.setFill(defaultFill);
			
			btn1IA.setStroke(selectedStroke);
			btn1IAText.setFill(selectedFill);
			
			btn2IA.setStroke(defaultStroke);
			btn2IAText.setFill(defaultFill);
			
			btn3IA.setStroke(defaultStroke);
			btn3IAText.setFill(defaultFill);
	    });
		
		btn2IASP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			nbIA = 2;
			
			btn0IA.setStroke(defaultStroke);
			btn0IAText.setFill(defaultFill);
			
			btn1IA.setStroke(defaultStroke);
			btn1IAText.setFill(defaultFill);
			
			btn2IA.setStroke(selectedStroke);
			btn2IAText.setFill(selectedFill);
			
			btn3IA.setStroke(defaultStroke);
			btn3IAText.setFill(defaultFill);
	    });
		
		btn3IASP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			nbIA = 3;
			
			btn0IA.setStroke(defaultStroke);
			btn0IAText.setFill(defaultFill);
			
			btn1IA.setStroke(defaultStroke);
			btn1IAText.setFill(defaultFill);
			
			btn2IA.setStroke(defaultStroke);
			btn2IAText.setFill(defaultFill);
			
			btn3IA.setStroke(selectedStroke);
			btn3IAText.setFill(selectedFill);
	    });
		
		// Menu choix de la grille
		StackPane btnGrilleSP = new StackPane();
		
		Rectangle btnGrille = new Rectangle(Grille.width, 100);
		btnGrille.setFill(Color.TRANSPARENT);
		
		Text btnGrilleText = new Text("Choisissez le type de grille :");
		btnGrilleText.setFont(Font.font("Comic sans ms", 35));
		btnGrilleText.setBoundsType(TextBoundsType.VISUAL); 
		btnGrilleText.setFill(Color.BLACK);
		
		btnGrilleSP.setLayoutX(Grille.width / 2 - btnGrille.getWidth() / 2);
		btnGrilleSP.setLayoutY(Grille.height / 6 * 3.5 - btnGrille.getHeight() / 2);
		btnGrilleSP.getChildren().addAll(btnGrille, btnGrilleText);
		
		root.getChildren().add(btnGrilleSP);
		
		
		StackPane btnCarreSP = new StackPane();
		StackPane btnHexaSP = new StackPane();
		StackPane btnRandSP = new StackPane();
		
		Rectangle btnCarre = new Rectangle(120, 80);
		btnCarre.setFill(Color.WHITE);
		btnCarre.setStroke(selectedStroke);
		btnCarre.setArcWidth(10);
		btnCarre.setArcHeight(10);
		
		Rectangle btnCarreImg = new Rectangle(60, 40);
		btnCarreImg.setFill(selectedFill);
		btnCarreImg.setStroke(Color.BLACK);
		
		btnCarreSP.getChildren().addAll(btnCarre, btnCarreImg);
		btnCarreSP.setLayoutX(Grille.width / 4 - btnCarre.getWidth() / 2);
		btnCarreSP.setLayoutY(Grille.height / 6 * 4 - btnCarre.getHeight() / 2);
		
		
		Rectangle btnHexa = new Rectangle(120, 80);
		btnHexa.setFill(Color.WHITE);
		btnHexa.setStroke(defaultStroke);
		btnHexa.setArcWidth(10);
		btnHexa.setArcHeight(10);
		
		Hexagon btnHexaImg = new Hexagon(1);
		btnHexaImg.setFill(defaultFill);
		btnHexaImg.setStroke(Color.BLACK);
		
		btnHexaSP.getChildren().addAll(btnHexa, btnHexaImg);
		btnHexaSP.setLayoutX(Grille.width / 4 * 2 - btnHexa.getWidth() / 2);
		btnHexaSP.setLayoutY(Grille.height / 6 * 4 - btnHexa.getHeight() / 2);
		
		
		Rectangle btnRand = new Rectangle(120, 80);
		
		btnRand.setFill(Color.WHITE);
		btnRand.setStroke(defaultStroke);
		btnRand.setArcWidth(10);
		btnRand.setArcHeight(10);
		
		btnRandSP.setLayoutX(Grille.width / 4 * 3 - btnRand.getWidth() / 2);
		btnRandSP.setLayoutY(Grille.height / 6 * 4 - btnRand.getHeight() / 2);	
		
		Group btnRandGroupImg = new Group();
		
		Rectangle btnRandImg1 = new Rectangle(30, 25);
		btnRandImg1.setLayoutX(btnRand.getWidth() / 2 - btnRandImg1.getWidth());
		btnRandImg1.setLayoutY(btnRand.getHeight() / 2 - btnRandImg1.getHeight() / 2 - 10);
		btnRandImg1.setFill(defaultFill);
		btnRandImg1.setStroke(Color.BLACK);
		
		Polygon btnRandImg2 = new Polygon(0, 60, 4, 60, 10, 0, 6, 0);
		btnRandImg2.setLayoutX(btnRand.getWidth() / 2 + 10);
		btnRandImg2.setLayoutY(btnRand.getHeight() / 2 - 30);
		btnRandImg2.setFill(defaultFill);
		btnRandImg2.setStroke(Color.BLACK);
		
		Hexagon btnRandImg3 = new Hexagon(0.6);
		btnRandImg3.setLayoutX(btnRand.getWidth() - 50 * 0.6);
		btnRandImg3.setLayoutY(btnRand.getHeight() / 2 - 25 * 0.6 + 10);
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
		
		// Gestion de la taille de la grille
		StackPane btnTailleGrilleSP = new StackPane();
		
		Rectangle btnTailleGrille = new Rectangle(Grille.width, 100);
		btnTailleGrille.setFill(Color.TRANSPARENT);
		
		Text btnTailleGrilleText = new Text("Choississez la taille de la grille :");
		btnTailleGrilleText.setFont(Font.font("Comic sans ms", 35));
		btnTailleGrilleText.setBoundsType(TextBoundsType.VISUAL); 
		btnTailleGrilleText.setFill(Color.BLACK);
		
		btnTailleGrilleSP.setLayoutX(Grille.width / 2 - btnTailleGrille.getWidth() / 2);
		btnTailleGrilleSP.setLayoutY(Grille.height / 7 * 5.5 - btnTailleGrille.getHeight() / 2);
		btnTailleGrilleSP.getChildren().addAll(btnTailleGrille, btnTailleGrilleText);
		
		root.getChildren().add(btnTailleGrilleSP);
		
		StackPane btnTailleGrilleValeurSP = new StackPane();
		
		Rectangle btnTailleGrilleValeur = new Rectangle(40, 40);
		btnTailleGrilleValeur.setFill(Color.TRANSPARENT);
		
		Text btnTailleGrilleValeurText = new Text("13");
		btnTailleGrilleValeurText.setFont(Font.font("Comic sans ms", 35));
		btnTailleGrilleValeurText.setBoundsType(TextBoundsType.VISUAL); 
		btnTailleGrilleValeurText.setFill(Color.BLACK);
		
		btnTailleGrilleValeurSP.setLayoutX(Grille.width / 2 + 290 - btnTailleGrilleValeur.getWidth() / 2);
		btnTailleGrilleValeurSP.setLayoutY(Grille.height / 7 * 5.5 - 5 - btnTailleGrilleValeur.getHeight() / 2);
		btnTailleGrilleValeurSP.getChildren().addAll(btnTailleGrilleValeur, btnTailleGrilleValeurText);
		
		root.getChildren().add(btnTailleGrilleValeurSP);
		
		StackPane btnTaillePlusSP = new StackPane();
		
		Rectangle btnTaillePlus = new Rectangle(40, 40);
		btnTaillePlus.setFill(Color.WHITE);
		btnTaillePlus.setStroke(Color.BLACK);
		btnTaillePlus.setArcWidth(10);
		btnTaillePlus.setArcHeight(10);
		
		Text btnTaillePlusText = new Text("+");
		btnTaillePlusText.setFont(Font.font("Comic sans ms", 35));
		btnTaillePlusText.setBoundsType(TextBoundsType.VISUAL); 
		btnTaillePlusText.setFill(Color.BLACK);
		
		btnTaillePlusSP.setLayoutX(Grille.width / 2 + 340 - btnTaillePlus.getWidth() / 2);
		btnTaillePlusSP.setLayoutY(Grille.height / 7 * 5.5 - btnTaillePlus.getHeight() / 2 - 5);
		btnTaillePlusSP.getChildren().addAll(btnTaillePlus, btnTaillePlusText);
		
		root.getChildren().add(btnTaillePlusSP);
		
		StackPane btnTailleMoinsSP = new StackPane();
		
		Rectangle btnTailleMoins = new Rectangle(40, 40);
		btnTailleMoins.setFill(Color.WHITE);
		btnTailleMoins.setStroke(Color.BLACK);
		btnTailleMoins.setArcWidth(10);
		btnTailleMoins.setArcHeight(10);
		
		Text btnTailleMoinsText = new Text("-");
		btnTailleMoinsText.setFont(Font.font("Comic sans ms", 35));
		btnTailleMoinsText.setBoundsType(TextBoundsType.VISUAL); 
		btnTailleMoinsText.setFill(Color.BLACK);
		
		btnTailleMoinsSP.setLayoutX(Grille.width / 2 + 395 - btnTailleMoins.getWidth() / 2);
		btnTailleMoinsSP.setLayoutY(Grille.height / 7 * 5.5 - btnTailleMoins.getHeight() / 2 - 5);
		btnTailleMoinsSP.getChildren().addAll(btnTailleMoins, btnTailleMoinsText);
		
		root.getChildren().add(btnTailleMoinsSP);
		
		btnTaillePlusSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			if (tailleGrille + 1 <= 30)
			{
				tailleGrille ++;
				btnTailleMoinsText.setFill(Color.BLACK);
				btnTailleMoins.setStroke(Color.BLACK);
			}
			else
			{
				btnTaillePlusText.setFill(Color.RED);
				btnTaillePlus.setStroke(Color.RED);
			}
			
			btnTailleGrilleValeurText.setText(tailleGrille + "");
	    });
		
		btnTailleMoinsSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			if (tailleGrille - 1 >= 9)
			{
				tailleGrille --;
				btnTaillePlusText.setFill(Color.BLACK);
				btnTaillePlus.setStroke(Color.BLACK);
			}
			else
			{
				btnTailleMoinsText.setFill(Color.RED);
				btnTailleMoins.setStroke(Color.RED);
			}
			
			btnTailleGrilleValeurText.setText(tailleGrille + "");
	    });
		
		// Bouton de d�marrage
		StackPane btnStartSP = new StackPane();
		
		Rectangle btnStart = new Rectangle(200, 100);
		btnStart.setFill(Color.WHITE);
		btnStart.setStroke(Color.BLACK);
		btnStart.setArcWidth(10);
		btnStart.setArcHeight(10);
		
		Text btnStartText = new Text("Go !");
		btnStartText.setFont(Font.font("Comic sans ms", 50));
		btnStartText.setBoundsType(TextBoundsType.VISUAL); 
		btnStartText.setFill(Color.BLACK);
		btnStartText.setStroke(Color.BLACK);
		
		btnStartSP.setLayoutX(Grille.width / 2 - btnStart.getWidth() / 2);
		btnStartSP.setLayoutY(Grille.height / 6 * 5.3 - btnStart.getHeight() / 2);
		btnStartSP.getChildren().addAll(btnStart, btnStartText);
		
		root.getChildren().add(btnStartSP);
		
		btnStartSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			Game.initGame (nbHumains, nbIA, tailleGrille, primaryStage);
	    });
				
		Scene scene = new Scene(root, Grille.width, Grille.height, Color.WHITE);
		primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public static void active (StackPane pane, int etat)
    {
    	if (etat == 1)
    	{
    		pane.setOpacity(1);
    		pane.setDisable(false);
    	}
    	else
    	{
    		pane.setOpacity(0);
    		pane.setDisable(true);
    	}
    }
	public static void affichageEcranFin (Joueur [] joueurs, Joueur premierJoueur, Joueur secondJoueur, Stage primaryStage)
	{
		primaryStage.setTitle("Six Couleurs");
		Group root = new Group();
		
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(1);
		f.setMinimumFractionDigits(1);
		
		StackPane btnTitleSP = new StackPane();
		
		Rectangle btnTitle = new Rectangle(Grille.width, 100);
		btnTitle.setFill(Color.TRANSPARENT);
		
		Text btnTitleText = new Text("Partie termin�e");
		btnTitleText.setFont(Font.font("Arial", 60));
		btnTitleText.setBoundsType(TextBoundsType.VISUAL); 
		btnTitleText.setFill(Color.BLACK);
		
		btnTitleSP.setLayoutX(Grille.width / 2 - btnTitle.getWidth() / 2);
		btnTitleSP.setLayoutY(Grille.height / 7 - btnTitle.getHeight() / 2);
		btnTitleSP.getChildren().addAll(btnTitle, btnTitleText);
		
		root.getChildren().add(btnTitleSP);
		
		StackPane btnVictoireSP = new StackPane();
		
		Rectangle btnVictoire = new Rectangle(Grille.width, 100);
		btnVictoire.setFill(Color.TRANSPARENT);
		
		Text btnVictoireText;
		
		if (premierJoueur.getCaseOwn() == secondJoueur.getCaseOwn())
		{
			btnVictoireText = new Text(premierJoueur.getNom() + " et " + secondJoueur.getNom() + " ont gagn� !");
		}
		else
		{
			btnVictoireText = new Text(premierJoueur.getNom() + " a gagn� !");
		}
		
		btnVictoireText.setFont(Font.font("Arial", 60));
		btnVictoireText.setBoundsType(TextBoundsType.VISUAL); 
		btnVictoireText.setFill(Color.BLACK);
		
		btnVictoireSP.setLayoutX(Grille.width / 2 - btnVictoire.getWidth() / 2);
		btnVictoireSP.setLayoutY(Grille.height / 7 * 2 - btnVictoire.getHeight() / 2);
		btnVictoireSP.getChildren().addAll(btnVictoire, btnVictoireText);
		
		root.getChildren().add(btnVictoireSP);
		
		for (int i = 0; i < joueurs.length; i ++)
		{
			StackPane btnPourcentageJoueurSP = new StackPane();
			
			Rectangle btnPourcentageJoueur = new Rectangle(Grille.width, 100);
			btnPourcentageJoueur.setFill(Color.TRANSPARENT);
			
			Text btnPourcentageJoueurText = new Text(joueurs[i].getNom() + " : " + f.format((joueurs[i].getNbCase() / (double) (tailleGrille * tailleGrille)) * 100) + " %");
			btnPourcentageJoueurText.setFont(Font.font("Arial", 40));
			btnPourcentageJoueurText.setBoundsType(TextBoundsType.VISUAL); 
			btnPourcentageJoueurText.setFill(Color.BLACK);
			
			btnPourcentageJoueurSP.setLayoutX(Grille.width / 2 - btnPourcentageJoueur.getWidth() / 2);
			btnPourcentageJoueurSP.setLayoutY(Grille.height / 7 * (3 + 0.5 * i) - btnPourcentageJoueur.getHeight() / 2);
			btnPourcentageJoueurSP.getChildren().addAll(btnPourcentageJoueur, btnPourcentageJoueurText);
			
			root.getChildren().add(btnPourcentageJoueurSP);
		}
		
		// Bouton de red�marrage de la partie avec les m�mes param�tres
		StackPane btnRestartSP = new StackPane();
		
		Rectangle btnRestart = new Rectangle(250, 100);
		btnRestart.setFill(Color.WHITE);
		btnRestart.setStroke(Color.BLACK);
		btnRestart.setArcWidth(10);
		btnRestart.setArcHeight(10);
		
		Text btnRestartText = new Text("Relancer");
		btnRestartText.setFont(Font.font("Comic sans ms", 50));
		btnRestartText.setBoundsType(TextBoundsType.VISUAL); 
		btnRestartText.setFill(Color.BLACK);
		btnRestartText.setStroke(Color.BLACK);
				
		btnRestartSP.setLayoutX(Grille.width / 2 - btnRestart.getWidth() / 2);
		btnRestartSP.setLayoutY(Grille.height / 6 * 5 - btnRestart.getHeight() / 2);
		btnRestartSP.getChildren().addAll(btnRestart, btnRestartText);
				
		root.getChildren().add(btnRestartSP);
				
		btnRestartSP.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			Game.initGame (nbHumains, nbIA, tailleGrille, primaryStage);
		});
		
		Scene scene = new Scene(root, Grille.width, Grille.height, Color.WHITE);
		primaryStage.setScene(scene);
	    primaryStage.show();
	}
}