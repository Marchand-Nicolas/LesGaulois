package personnages;

import objets.Equipement;
import objets.Musee;
import objets.Trophee;

public class Gaulois {
	private String nom;
	private int force;
	private Village village;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;
	private static final String INTRODUCTION = "Bonjour, je m'appelle ";

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void sePresenter() {
		if (village != null) {
			if (village.getChef() == this) {
				parler(INTRODUCTION + nom + ". Je suis le chef le village " + village.getNom() + ".");
			} else {
				parler(INTRODUCTION + nom + ". J'habite le village " + village.getNom() + ".");
			}
		} else {
			parler(INTRODUCTION + nom + ". Je voyage de villages en villages");
		}
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force * effetPotion / 3);
//		if (effetPotion > 1) {
//			effetPotion--;
//		}
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] nouveauTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; nouveauTrophees != null && i < nouveauTrophees.length
				&& nbTrophees < trophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = nouveauTrophees[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void faireUneDonnation(Musee musee) {
		String message = "Je donne au musée tous mes trophées: ";
		for (int i = 0; i < nbTrophees; i++) {
			Equipement equipement = trophees[i];
			message += "\n - " + equipement.toString();
			Trophee trophee = new Trophee(this, equipement);
			musee.donnerTrophees(this, trophee);
		}
		parler(message);
	}

	public String toString() {
		return nom;
	}

	public String getNom() {
		return nom;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}
}
