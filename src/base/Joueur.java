package base;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Joueur
{
	private String nom;
	private Color color;
	private ArrayList<Case> caseOwn = new ArrayList<Case>();
	private int type;
	
	public Joueur(String nomP, Case caseP)
	{
		this.nom = nomP;
		this.color = caseP.getColor();
		assocJoueurCase(caseP);
	}

	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nomP)
	{
		this.nom = nomP;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color colorP)
	{
		this.color = colorP;
	}
	
	public ArrayList<Case> getCaseOwn()
	{
		return caseOwn;
	}

	public void setCaseOwn(Case caseOwnP)
	{
		this.caseOwn.add(caseOwnP);
	}
	
	public void checkSameColor(Joueur [] joueurs)
	{
		for (Joueur joueurP : joueurs)
		{
			while ((joueurP != this) && (joueurP.getColor().equals(this.getColor())))
			{
				System.out.println(Grille.choosableColor(joueurs).size());
				Color newColor = Case.randomColor(Grille.choosableColor(joueurs));
				this.setColor(newColor);
				this.majCaseColor(newColor);
			}
		}
	}
	
	public void majCaseColor (Color colorP)
	{
		ArrayList<Case> caseOwn = getCaseOwn();
		
		for (Case caseP : caseOwn)
		{
			caseP.setColor(colorP);
		}
	}
	
	public void assocJoueurCase(Case caseP)
	{
		setCaseOwn(caseP);
		caseP.setJoueur(this);
	}
	
	public int getNbCase()
	{
		return this.getCaseOwn().size();
	}
}