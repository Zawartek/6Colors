package base;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class IntelligenceA
{
	public static Color BasicIA (Joueur [] joueurs)
	{
		ArrayList<Color> choosableColor = Grille.choosableColor(joueurs);
		return Case.randomColor(choosableColor);
	}
}
