package base;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Joueur
{
	private String nom;
	private Color color;
	private ArrayList<Case> caseOwn = new ArrayList<Case>();
	private ArrayList<Case> caseTest = new ArrayList<Case>();
	
	public Joueur(String nomP, Case caseP)
	{
		this.nom = nomP;
		this.color = caseP.getCouleur();
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
			if (joueurP.getColor().equals(getColor()) && (joueurP != this))
			{
				this.setColor();
			}
		}
		
	}
	
	public void majCaseColor (Color colorP)
	{
		ArrayList<Case> caseOwn = getCaseOwn();
		
		for (Case caseP : caseOwn)
		{
			caseP.setCouleur(colorP);
		}
	}
	
	public void assocJoueurCase(Case caseP)
	{
		setCaseOwn(caseP);
		caseP.setJoueur(this);
	}
}