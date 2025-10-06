package test_fonctionnel;

import objets.Chaudron;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		asterix.parler("Bonjour Obélix.");
		Gaulois obelix = new Gaulois("Obélix", 0);
		obelix.parler("Bonjour Astérix, ça te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée");
		Romain minus = new Romain("Minus", 6);
		System.out.println("Dans la forêt " + asterix.toString() + " et " + obelix.toString() + " tombent nez à\n"
				+ "nez sur le romain " + minus.getNom());
		for (int i = 0; i < 3; i++) {
			asterix.frapper(minus);
		}

		Romain brutus = new Romain("Brutus", 14);
		Chaudron chaudron = new Chaudron();
		Druide panoramix = new Druide("Panoramix", 2, chaudron);
		panoramix.fabriquerPotion(4, 3);
		panoramix.boosterGaulois(obelix);
		panoramix.boosterGaulois(asterix);

		for (int i = 0; i < 3; i++) {
			asterix.frapper(brutus);
		}
	}
}
