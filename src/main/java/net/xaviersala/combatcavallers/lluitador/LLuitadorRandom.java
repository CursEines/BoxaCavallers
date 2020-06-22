package net.xaviersala.combatcavallers.lluitador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import net.xaviersala.combatcavallers.LlocOnPicar;

/**
 * Classe que implementa el comportament d'un boxejador en un combat.
 *
 * @author xavier
 *
 */
public class LLuitadorRandom implements ILluitador {

	private Random aleatori = new Random();

	private String nom;

	List<LlocOnPicar> copsPossibles;

	/**
	 * Construeix un boxejador que pica i es protegeix de forma aleatòria
	 *
	 * @param nomBoxejador nom del boxejador
	 */
	public LLuitadorRandom(String nomBoxejador) {
		nom = nomBoxejador;
		copsPossibles = new ArrayList<LlocOnPicar>(
				Arrays.asList(LlocOnPicar.Cap, LlocOnPicar.CostatDret, LlocOnPicar.CostatEsquerra, LlocOnPicar.Panxa));
	}

	/**
	 * El boxejador pica en una de les posicions de l'altre boxejador
	 *
	 * @return posició on pica
	 */
	public LlocOnPicar Pica() {
		return copsPossibles.get(aleatori.nextInt(copsPossibles.size()));
	}

	/**
	 * El boxejador no protegeix una de les posicions en les que pot rebre un cop.
	 *
	 * @return posició no protegida
	 */
	public List<LlocOnPicar> Protegeix() {
		List<LlocOnPicar> proteccio = copsPossibles;

		LlocOnPicar noProtegeix = copsPossibles.get(aleatori.nextInt(copsPossibles.size()));

		return proteccio.stream().filter(item -> item != noProtegeix).collect(Collectors.toList());
	}

	/**
	 * @return retorna el nom del boxejador.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Imatge del boxejador en text.
	 */
	public String toString() {
		return nom;
	}

}
