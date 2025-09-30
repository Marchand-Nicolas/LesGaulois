package personnages;

public class Romain {
	private String nom;
	private int force;

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

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public static void main(String[] args) {
		Romain jules = new Romain("Jules", 10);
		jules.parler("Bonjour!");
		new Romain("Minus", -6);
	}

	// TODO: Ajouter ToString()
}
