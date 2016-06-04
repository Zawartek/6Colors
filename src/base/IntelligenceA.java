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
	
	public static Color NormalIA (Joueur joueur, Joueur [] joueurs, Grille grille)
	{
		ArrayList<Color> choosableColor = Grille.choosableColor(joueurs);
		int gain, gainMax = 0;
		Color color = Case.randomColor(choosableColor);
		
		for (int i = 0; i < choosableColor.size(); i ++)
		{
			gain = grille.simuCaptureSquare(joueur, choosableColor.get(i));
			
			if (gainMax < gain)
			{
				gainMax = gain;
				color = choosableColor.get(i);
			}
		}
		
		return color;
	}
}