package net.xaviersala.combatcavallers.lluitador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import net.xaviersala.combatcavallers.LlocOnPicar;

/**
 * Classe que implementa el comportament d'un boxejador trampós en un combat. 
 * Aquest jugador fa servir el cop il·legal i com a mínim sempre es protegeix el cap
 *
 * @author maribel
 *
 */
public class LluitadorTrampos implements ILluitador{
	
	private Random aleatori = new Random();
	
	private String nom;
	
	private int Força = 1;
	
	List<LlocOnPicar> copsPossibles;
	
	/**
	 * Construeix un boxejador que utilitza el cop il·legal quan pica i es protegeix el cap
	 *
	 * @param nomBoxejador nom del boxejador
	 */
	public LluitadorTrampos(String nomBoxejador) {
		nom = nomBoxejador;
		copsPossibles = new ArrayList<>(Arrays.asList(LlocOnPicar.values()));
	}

	/**
	 * El boxejador pica en una de les posicions de l'altre boxejador
	 *
	 * @return posició on pica
	 */
	public LlocOnPicar Pica() {
		return copsPossibles.get(aleatori.nextInt(copsPossibles.size()));
		// sempre il·legal
		//return LlocOnPicar.CopIlegal;
	}

	/**
	 * El boxejador no protegeix una de les posicions en les que pot rebre un cop, excepte el cap
	 *
	 * @return posició no protegida
	 */
	public List<LlocOnPicar> Protegeix() {		
		
		List<LlocOnPicar> proteccio = copsPossibles;		
		
		// el cap sempre es protegeix
		proteccio.remove(LlocOnPicar.Cap);
		
		LlocOnPicar noProtegeix = proteccio.get(aleatori.nextInt(proteccio.size()));

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
