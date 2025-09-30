package personnages;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private int NB_VILLAGEOIS_MAX;
	private Gaulois[] villageois;

	public Village(String nom, Gaulois chef, int max_villageois) {
		this.nom = nom;
		this.chef = chef;
		chef.setVillage(this);
		this.NB_VILLAGEOIS_MAX = max_villageois;
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois >= NB_VILLAGEOIS_MAX) {
			System.out.println("Max d'habitants atteint!");
		}
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);

	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois > nbVillageois) {
			System.out.println("Il n’y a pas autant d’habitants dans notre village !");
			return null;
		}
		return villageois[numVillageois - 1];
	}

	public void afficherVillageois() {
		System.out.println(
				"Dans le village \"" + nom + "\" du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			System.out.println(" - " + gaulois.getNom());
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village d'Abraracourcix", abraracourcix, 30);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		Gaulois doublePolemix = new Gaulois("Doublepolemix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
	}
}
