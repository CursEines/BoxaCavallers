package net.xaviersala.combatcavallers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.xaviersala.combatcavallers.combat.Ring;
import net.xaviersala.combatcavallers.lluitador.ILluitador;
import net.xaviersala.combatcavallers.lluitador.LLuitadorRandom;
import net.xaviersala.combatcavallers.lluitador.LluitadorCap;

/**
 * Programa que simula el funcionament de la 'boxa entre cavallers'.
 *
 * @author xavier
 *
 */
public class App {

  public static void main(String[] args) {

    // Creo dos boxejadors
    LLuitadorRandom lluitador1 = new LLuitadorRandom("MatxacaCaps");
    LLuitadorRandom lluitador2 = new LLuitadorRandom("DestrossaPilotes");

    // Creo boxejador que sempre pica al cap
    LluitadorCap lluitador3 = new LluitadorCap("PicaCaps");

    // Poso els dos boxejadors en el combat
    Ring combat = new Ring();

    // Creo procés random per a designar els combatents
    List<ILluitador> llistaLluitadors = new ArrayList<ILluitador>();
    
    // Omplo llista de lluitadors per a després ordenar-la aleatòriament i agafar els 2 primers que seran els qui lluitaran
    llistaLluitadors.add(lluitador1);
    llistaLluitadors.add(lluitador2);
    llistaLluitadors.add(lluitador3);

    Collections.shuffle(llistaLluitadors);
    
    combat.EntradaLluitadors(llistaLluitadors.get(0),llistaLluitadors.get(1));    
    combat.Lluiteu();

  }

}
