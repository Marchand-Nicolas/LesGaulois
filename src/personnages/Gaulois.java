package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private Village village;

	public Gaulois(String nom, int force) {
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

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		asterix.parler("Salut!");
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void sePresenter() {
		if (village != null) {
			if (village.getChef() == this) {
				parler("Bonjour, je m'appelle " + nom + ". Je suis le chef le village " + village.getNom() + ".");
			} else {
				parler("Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".");
			}
		} else {
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages");
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", village=" + village + "]";
	}

	// TODO: Ajouter ToString()
}
