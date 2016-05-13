package base;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    	Scene scene = grille.graphicalShow();

    	primaryStage.setTitle("Six Couleurs");
    	primaryStage.setScene(scene);

        primaryStage.show();
    }
}