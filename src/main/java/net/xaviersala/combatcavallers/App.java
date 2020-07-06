package net.xaviersala.combatcavallers;

import net.xaviersala.combatcavallers.combat.Ring;
import net.xaviersala.combatcavallers.lluitador.ILluitador;
import net.xaviersala.combatcavallers.lluitador.LLuitadorRandom;
import net.xaviersala.combatcavallers.lluitador.LluitadorTrampos;

/**
 * Programa que simula el funcionament de la 'boxa entre cavallers'.
 *
 * @author xavier
 *
 */
public class App {

	public static void main(String[] args) {

		// Un lluitador trampós s'enfronta a un lluitador random
		// Lluitador random
		ILluitador lluitador1 = new LLuitadorRandom("Random");
		// Lluitador tramós
		ILluitador lluitador2 = new LluitadorTrampos("Dolentot");

		// Poso els dos boxejadors en el combat
		Ring combat = new Ring();

		combat.EntradaLluitadors(lluitador1, lluitador2);
		combat.Lluiteu();

	}

}
