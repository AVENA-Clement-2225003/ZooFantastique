package tests.enclos;

import includes.enclos.EnclosAquarium;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnclosAquariumTest {
    @Test
    public void testEnclosAquariumSimple() {
        EnclosAquarium E1 = new EnclosAquarium("Enclos1", 140, 25, 12);
        assertEquals("Enclos{nom='Enclos1', superficie=140, capaciteEnclos=20, nbCreaturesDansEnclos=0, listeCreatures=[], proprete=BON}", E1.toString());
    }
    @Test
    public void testEnclosAquariumToutParametre() {
        EnclosAquarium E1 = new EnclosAquarium("Enclos1", 140, 25, includes.enclos.PropreteEnum.BON, new ArrayList<>(), 12);
        assertEquals("Enclos{nom='Enclos1', superficie=140, capaciteEnclos=20, nbCreaturesDansEnclos=0, listeCreatures=[], proprete=BON}", E1.toString());
    }
}