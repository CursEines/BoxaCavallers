package net.xaviersala.combatcavallers.lluitador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import net.xaviersala.combatcavallers.LlocOnPicar;

/**
 * Classe que implementa el comportament d'un entreandor en un combat.
 *
 * @author xavier
 *
 */
public class LLuitadorEntrenat implements ILluitador {

	private Random aleatori = new Random();

	private String nom;

	private int Toogle = 0;
	private int Força = 1;

	List<LlocOnPicar> copsPossibles;

	/**
	 * Construeix un boxejador que pica Cap/Panxa, i es protegeix de forma aleatòria
	 *
	 * @param nomBoxejador nom del boxejador
	 */
	public LLuitadorEntrenat(String nomBoxejador) {
		nom = nomBoxejador;
		copsPossibles = new ArrayList<>(Arrays.asList(LlocOnPicar.values()));
		copsPossibles.remove(LlocOnPicar.CopIlegal);
	}

	/**
	 * El boxejador pica en una de les posicions de l'altre boxejador
	 * Només picarà al cap o a la panxa...
	 *
	 * @return posició on pica
	 */
	public LlocOnPicar Pica() {
		if (Toogle == 0){
			Toogle = 1;
			return copsPossibles.get(0); //Cap
		}
		else{
			Toogle = 0;
			return copsPossibles.get(3); //Panxa
		}
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

	@Override
	public int ForçaDelCop() {
		return Força;
	}

}