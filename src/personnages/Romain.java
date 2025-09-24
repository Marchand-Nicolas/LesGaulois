package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
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

	public static void main(String[] args) {
		Romain jules = new Romain("Jules", 10);
		jules.parler("Bonjour!");
	}
}
