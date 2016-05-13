package base;

public class Case
{
	public enum Couleur {Rouge, Jaune, Orange, Vert, Bleu, Violet;}
	private Couleur couleur;
	
	private Joueur joueur;
	
	public Case(Couleur couleurP)
	{
		couleur = couleurP;
	}
	
	public Case()
	{
		couleur = Couleur.Rouge;
	}

	public Couleur getCouleur()
	{
		return couleur;
	}

	public void setCouleur(Couleur couleurP)
	{
		this.couleur = couleurP;
	}
	
	public Joueur getJoueur()
	{
		return joueur;
	}

	public void setJoueur(Joueur joueur)
	{
		this.joueur = joueur;
	}

	public static Case randomInitCase()
	{
		Case caseR = new Case();
		int rand = (int)(Math.random() * (7));
		
		switch (rand)
		{
			case 1:
				caseR.setCouleur(Couleur.Rouge);
				break;
			case 2:
				caseR.setCouleur(Couleur.Jaune);
				break;
			case 3:
				caseR.setCouleur(Couleur.Orange);
				break;
			case 4:
				caseR.setCouleur(Couleur.Vert);
				break;
			case 5:
				caseR.setCouleur(Couleur.Bleu);
				break;
			case 6:
				caseR.setCouleur(Couleur.Violet);
				break;
		}
		return caseR;
	}
}