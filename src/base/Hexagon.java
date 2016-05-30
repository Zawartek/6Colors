package base;

import javafx.scene.shape.Polygon;

public class Hexagon extends Polygon
{
	public Hexagon (double taille)
	{
		super(25 * taille, 0, 50 * taille, 12 * taille, 50 * taille, 38 * taille, 25 * taille, 50 * taille, 0, 38 * taille, 0, 12 * taille);
	}
}
