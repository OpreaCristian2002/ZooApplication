import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ReefTest {

    @Test
    void testConstructor() {
        Reef reef = new Reef("C.1", 745, true, 38);
        assertNotNull(reef);
    }

    @Test
    void testGetNCorals() {
        Reef reef = new Reef("C.1", 745, true, 38);
        assertEquals(38, reef.getNCorals());
    }

    @Test
    void testSetNCorals() {
        Reef reef = new Reef("C.1", 745, true, 0);
        reef.setNCorals(38);
        assertEquals(38, reef.getNCorals());
    }

    @Test
    void testEqualsSameObject() {
        Reef reef = new Reef("C.1", 745, true, 38);
        assertEquals(reef, reef);
    }

    @Test
    void testEqualsEqualObject() {
        Reef reef1 = new Reef("C.1", 745, true, 38);
        Reef reef2 = new Reef("C.1", 745, true, 38);
        assertEquals(reef1, reef2);
    }

    @Test
    void testEqualsDifferentObject() {
        Reef reef1 = new Reef("C.1", 745, true, 38);
        Reef reef2 = new Reef("C.1", 745, false, 40);
        assertNotEquals(reef1, reef2);
    }

    @Test
    void readReef() {
        Scanner sc = new Scanner("C.1 745 True 38");
        Reef reef = new Reef("C.1", 745, true, 38);
        assertEquals(reef, Reef.readReef(sc));
    }

    @Test
    void testToString() {
        Reef reef = new Reef("C.1", 745, true, 38);
        String result = "Reef Shelter\n" +
                "ID: C.1 - Volume: 745 m3 - Available: true - Number of unique coral types: 38";
        assertEquals(result, reef.toString());
    }

    @Test
    void testToStringConstant() {
        String result = "Reef Shelter\n" +
                "Warm Trophic Water - Tropical Climate\n";
        assertEquals(result, Reef.toStringConstant());
    }
}