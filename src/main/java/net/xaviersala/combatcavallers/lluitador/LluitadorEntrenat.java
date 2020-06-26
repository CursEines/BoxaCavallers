
package net.xaviersala.combatcavallers.lluitador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import net.xaviersala.combatcavallers.LlocOnPicar;

/**
 * Classe que implementa el comportament d'un lluitador acostumat a 
 * entrenar en un combat.
 * Pica alternativament cap, panxa, cap, panxa, cap, panxa ....
 * Es protegeix de forma aleatòria
 * @author roser
 */
public class LluitadorEntrenat implements ILluitador{
        private LlocOnPicar darrerCop;

	private String nom;

	private int Força = 1;

	List<LlocOnPicar> copsPossibles;
        
       
    /**
     * Construeix un boxejador que pica cap i panxa alternativament
     * i es protegeix de forma aleatòria
     *
     * @param nomBoxejador nom del boxejador
     */
    public LluitadorEntrenat(String nomBoxejador) {
	nom = nomBoxejador;
        darrerCop = LlocOnPicar.Cap;
	copsPossibles = new ArrayList<>(Arrays.asList(LlocOnPicar.Cap, LlocOnPicar.Panxa));
	
    }
        
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public List<LlocOnPicar> Protegeix() {
        Random aleatori = new Random(); 

        List<LlocOnPicar> proteccio = new ArrayList<>(Arrays.asList(LlocOnPicar.values()));
        proteccio.remove(LlocOnPicar.CopIlegal);

        LlocOnPicar noProtegeix = proteccio.get(aleatori.nextInt(proteccio.size()));

        return proteccio.stream().filter(item -> item != noProtegeix).collect(Collectors.toList());
	
    }

    @Override
    public LlocOnPicar Pica() {
        LlocOnPicar pica = darrerCop;
        switch (darrerCop){
            case Cap:
                pica = LlocOnPicar.Panxa;
                break;
            case Panxa:
                pica = LlocOnPicar.Cap;
                break;
            default:
        }
        darrerCop = pica;
        return pica;
    }

    @Override
    public int ForçaDelCop() {
        return Força;
    }
    
}
