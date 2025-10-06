package personnages;

import java.util.Arrays;

import objets.Equipement;

public class Romain {
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + ", equipements=" + Arrays.toString(equipements)
				+ ", nbEquipement=" + nbEquipement + "]";
	}

	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");

	}

	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			} else
				ajouterEquipement(equipement);
			break;

		default:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int force_debut = force;
		force -= forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
		assert force < force_debut;
	}

//	public Equipement[] recevoirCoup(int forceCoup) {
//		Equipement[] equipementEjecte = null;
//		forceCoup = calculResistanceEquipement(forceCoup);
//		force -= forceCoup;
//		if (force == 0) {
//
//			parler("Aïe");
//		} else {
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//		}
//		return equipementEjecte;
//	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public static void main(String[] args) {
		Romain jules = new Romain("Jules", 10);
		jules.parler("Bonjour!");
		Romain minus = new Romain("Minus", 1);
		System.out.println(Equipement.CASQUE + " " + Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
