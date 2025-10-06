package personnages;

import objets.Equipement;

public class Gaulois {
	private String nom;
	private int force;
	private Village village;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
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
		String debut = "Bonjour, je m'appelle ";
		if (village != null) {
			if (village.getChef() == this) {
				parler(debut + nom + ". Je suis le chef le village " + village.getNom() + ".");
			} else {
				parler(debut + nom + ". J'habite le village " + village.getNom() + ".");
			}
		} else {
			parler(debut + nom + ". Je voyage de villages en villages");
		}
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force * effetPotion / 3);
		if (effetPotion > 1) {
			effetPotion--;
		}
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		Equipement nouveauTrophees[] = romain.recevoirCoup((force / 3) * effetPotion);
//		for (int i = 0; nouveauTrophees != null && i < nouveauTrophees.length; i++, nbTrophees++) {
//			this.trophees[nbTrophees] = nouveauTrophees[i];
//		}
//	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	@Override
	public String toString() {
		return nom;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}
}
