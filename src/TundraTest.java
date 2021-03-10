import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TundraTest {

    @Test
    public void testConstructor() {
        Tundra tundra = new Tundra("B.1", 680, true);
        assertNotNull(tundra);
    }

    @Test
    public void testEqualsSameObject() {
        Tundra tundra = new Tundra("B.1", 680, true);
        assertEquals(tundra, tundra);
    }

    @Test
    public void testEqualsEqualsObject() {
        Tundra tundra1 = new Tundra("B.1", 680, true);
        Tundra tundra2 = new Tundra("B.1", 680, true);
        assertEquals(tundra1, tundra2);
    }

    @Test
    public void testEqualsDifferentObject() {
        Tundra tundra1 = new Tundra("B.1", 680, true);
        Tundra tundra2 = new Tundra("B.2", 700, true);
        assertNotEquals(tundra1, tundra2);
    }

    @Test
    public void readTundra() {
        Scanner sc = new Scanner("B.1 680 True");
        Tundra tundra = new Tundra("B.1", 680, true);
        assertEquals(tundra, Tundra.readTundra(sc));
    }

    @Test
    public void testToString() {
        Tundra tundra = new Tundra("B.1", 680, true);
        String result = "Tundra Shelter\n" +
                "ID: B.1 - Volume: 680 m3 - Available: true";
        assertEquals(result, tundra.toString());
    }

    @Test
    public void testToStringConstant() {
        String result = "Tundra Shelter\n" +
                "Cool Eutrophic Water - Polar Climate\n";
        assertEquals(result, Tundra.toStringConstant());
    }

}