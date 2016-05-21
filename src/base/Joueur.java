package base;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Joueur
{
	private String nom;
	private Color color;
	private ArrayList<Case> caseOwn = new ArrayList<Case>();
	private ArrayList<Case> caseTest = new ArrayList<Case>();
	
	public Joueur(String nomP, Color colorP)
	{
		this.nom = nomP;
		this.color = colorP;
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

	public static void joue(Color colorP, Joueur joueurP, Grille grille)
	{
		joueurP.setColor(colorP);
		ArrayList<Case> caseOwn = joueurP.getCaseOwn();
		
		for (Case caseP : caseOwn)
		{
			grille.newCase(caseP, joueurP);
		}
		
		Test.build(grille, joueurP, joueurs, primaryStage);
	}
}