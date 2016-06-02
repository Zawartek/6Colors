package base;

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
    
	public static void affichageMenu (Stage primaryStage)
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
		btnTitleSP.setLayoutY(Grille.height / 7 - btnTitle.getHeight() / 2);
		btnTitleSP.getChildren().addAll(btnTitle, btnTitleText);
		
		root.getChildren().add(btnTitleSP);
		
		StackPane btnPlayerSP = new StackPane();
		
		Rectangle btnPlayer = new Rectangle(Grille.width, 100);
		btnPlayer.setFill(Color.TRANSPARENT);
		
		Text btnPlayerText = new Text("Choisissez le nombre de joueurs :");
		btnPlayerText.setFont(Font.font("Arial", 40));
		btnPlayerText.setBoundsType(TextBoundsType.VISUAL); 
		btnPlayerText.setFill(Color.BLACK);
		
		btnPlayerSP.setLayoutX(Grille.width / 2 - btnPlayer.getWidth() / 2);
		btnPlayerSP.setLayoutY(Grille.height / 6 * 1.4 - btnPlayer.getHeight() / 2);
		btnPlayerSP.getChildren().addAll(btnPlayer, btnPlayerText);
		
		root.getChildren().add(btnPlayerSP);
		
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
		
		
		// Partie nb IA
		StackPane btn0IASP = new StackPane();
		
		Rectangle btn0IA = new Rectangle(150, 100);    	
		btn0IA.setFill(Color.WHITE);
		btn0IA.setStroke(defaultStroke);
		
		Text btn0IAText = new Text("0");
		btn0IAText.setFont(Font.font("Arial", 80));
		btn0IAText.setBoundsType(TextBoundsType.VISUAL); 
		btn0IAText.setFill(defaultFill);
		btn0IAText.setStroke(Color.BLACK);
		
		btn0IASP.setLayoutX(Grille.width / 5 - btn0IA.getWidth() / 2);
		btn0IASP.setLayoutY(Grille.height / 6 * 3 - btn0IA.getHeight() / 2);
		btn0IASP.getChildren().addAll(btn0IA, btn0IAText);
		btn0IASP.setOpacity(0);
		btn0IASP.setDisable(true);
		
		StackPane btn1IASP = new StackPane();
		
		Rectangle btn1IA = new Rectangle(150, 100);    	
		btn1IA.setFill(Color.WHITE);
		btn1IA.setStroke(selectedStroke);
		
		Text btn1IAText = new Text("1");
		btn1IAText.setFont(Font.font("Arial", 80));
		btn1IAText.setBoundsType(TextBoundsType.VISUAL); 
		btn1IAText.setFill(selectedFill);
		btn1IAText.setStroke(Color.BLACK);
		
		btn1IASP.setLayoutX(Grille.width / 5 * 2 - btn1IA.getWidth() / 2);
		btn1IASP.setLayoutY(Grille.height / 6 * 3 - btn1IA.getHeight() / 2);
		btn1IASP.getChildren().addAll(btn1IA, btn1IAText);
		
		StackPane btn2IASP = new StackPane();
		
		Rectangle btn2IA = new Rectangle(150, 100);    	
		btn2IA.setFill(Color.WHITE);
		btn2IA.setStroke(defaultStroke);
		
		Text btn2IAText = new Text("2");
		btn2IAText.setFont(Font.font("Arial", 80));
		btn2IAText.setBoundsType(TextBoundsType.VISUAL); 
		btn2IAText.setFill(defaultFill);
		btn2IAText.setStroke(Color.BLACK);
		
		btn2IASP.setLayoutX(Grille.width / 5 * 3 - btn2IA.getWidth() / 2);
		btn2IASP.setLayoutY(Grille.height / 6 * 3 - btn2IA.getHeight() / 2);
		btn2IASP.getChildren().addAll(btn2IA, btn2IAText);
		
		StackPane btn3IASP = new StackPane();
		
		Rectangle btn3IA = new Rectangle(150, 100);    	
		btn3IA.setFill(Color.WHITE);
		btn3IA.setStroke(defaultStroke);
		
		Text btn3IAText = new Text("3");
		btn3IAText.setFont(Font.font("Arial", 80));
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
		btnStartStack.setLayoutY(Grille.height / 6 * 5.3 - btnStart.getHeight() / 2);
		btnStartStack.getChildren().addAll(btnStart, btnStartText);
		
		root.getChildren().add(btnStartStack);
		
		btnStartStack.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) ->
		{
			System.out.println(nbHumains+" "+ nbIA+" "+typeGrille);
			Game.initGame (nbHumains, nbIA, typeGrille, primaryStage);
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
}