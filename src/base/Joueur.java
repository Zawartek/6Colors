package base;

import base.Case.Couleur;

public class Joueur
{
	private String nom;
	private Couleur couleur;
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public Couleur getCouleur()
	{
		return couleur;
	}
	
	public void setCouleur(Couleur couleur)
	{
		this.couleur = couleur;
	}
}