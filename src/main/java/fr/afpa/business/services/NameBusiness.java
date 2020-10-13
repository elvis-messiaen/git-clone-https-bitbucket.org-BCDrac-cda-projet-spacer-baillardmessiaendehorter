package fr.afpa.business.services;


public class NameBusiness {
	private String nom;

	public NameBusiness(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return   nom ;
	}
	
}
