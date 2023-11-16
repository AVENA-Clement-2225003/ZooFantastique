package tests.enclos;

import includes.enclos.EnclosStandard;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class EnclosStandardTest {
    @Test
    public void testEnclosStandard() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 140, 25);
        assertEquals("Enclos{nom='Enclos1', superficie=140, capaciteEnclos=20, nbCreaturesDansEnclos=0, listeCreatures=[], proprete=BON}", E1.toString());
    }
    @Test
    public void testEnclosStandard() {
        EnclosStandard E1 = new EnclosStandard("Enclos1", 140, 25, includes.enclos.PropreteEnum.BON, new ArrayList<>());
        assertEquals("Enclos{nom='Enclos1', superficie=140, capaciteEnclos=20, nbCreaturesDansEnclos=0, listeCreatures=[], proprete=BON}", E1.toString());
    }
}
