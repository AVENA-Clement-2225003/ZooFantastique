package tests.enclos;

import includes.creatures.Lycanthrope;
import includes.creatures.LycanthropeMale;
import includes.enclos.EnclosStandard;
import includes.enclos.PropreteEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class EnclosStandardTest {
    @Test
    public void testEnclosStandardSimple() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 140, 25);
        assertEquals("Enclos{nom='Enclos1', superficie=140, capaciteEnclos=20, nbCreaturesDansEnclos=0, listeCreatures=[], proprete=BON}", E1.toString());
    }
    @Test
    public void testEnclosStandardToutParametre() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 140, 25, includes.enclos.PropreteEnum.BON, new ArrayList<>());
        assertEquals("Enclos{nom='Enclos1', superficie=140, capaciteEnclos=20, nbCreaturesDansEnclos=0, listeCreatures=[], proprete=BON}", E1.toString());
    }
    @Test
    void entretientEnclos() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 120, 22);
        LycanthropeMale L1 = new LycanthropeMale(80, 170, 21, "James");
        E1.setProprete(PropreteEnum.CORRECT);
        assertEquals(0, E1.entretientEnclos(), "L'enclos est vide et devrait être néttoyé");
        E1.setProprete(PropreteEnum.CORRECT);
        E1.ajouterCreature(L1);
        assertEquals(1, E1.entretientEnclos(), "L'enclos n'est pas vide et ne devrait pas être néttoyé");
    }
}