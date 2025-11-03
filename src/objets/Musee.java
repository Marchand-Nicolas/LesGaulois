package objets;

import personnages.Gaulois;
import personnages.Romain;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Trophee nouveauTrophee) {
		assert nbTrophee < trophees.length;
		trophees[nbTrophee] = nouveauTrophee;
		nbTrophee++;
	}

	public String extraireInstructionsOCaml() {
		String resultat = "let musee = [\n";
		for (int i = 0; i < nbTrophee; i++) {
			Trophee trophee = trophees[i];
			resultat += "\t\"" + trophee.donnerNom() + "\", \"" + trophee.toString() + "\"";
			if (i != nbTrophee - 1)
				resultat += ";";
			resultat += "\n";
		}
		resultat += "]";
		return resultat;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 12);
		Romain cesar = new Romain("César", 2);
		cesar.sEquiper(Equipement.CASQUE);
		asterix.boirePotion(12);
		asterix.frapper(cesar);
		Musee musee = new Musee();
		asterix.faireUneDonnation(musee);
		System.out.println(musee.extraireInstructionsOCaml());
	}
}
