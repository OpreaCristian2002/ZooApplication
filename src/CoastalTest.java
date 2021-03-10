

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CoastalTest {

    @Test
    public void testConstructor() {
        Coastal coastal = new Coastal("A.1", 470, false, 40);
        assertNotNull(coastal);
    }

    @Test
    public void testGetterId() {
        Coastal coastal1 = new Coastal("A.1", 470, false, 40);
        assertEquals("A.1", coastal1.getId());
    }

    @Test
    public void testGetterVolume() {
        Coastal coastal1 = new Coastal("A.1", 470, false, 40);
        assertEquals(470, coastal1.getVolume());
    }

    @Test
    public void testGetterAvailability() {
        Coastal coastal1 = new Coastal("A.1", 470, false, 40);
        assertEquals(false, coastal1.getAvailability());
    }

    @Test
    public void testGetterLandSurface() {
        Coastal coastal1 = new Coastal("A.1", 470, false, 40);
        assertEquals(40, coastal1.getLandSurface());
    }

    @Test
    public void testSetter() {
        Coastal coastal1 = new Coastal("A.1", 470, false, 0);
        coastal1.setLandSurface(40);
        assertEquals(40, coastal1.getLandSurface());
    }


    @Test
    public void testEqualsSameObject() {
        Coastal coastal1 = new Coastal("A.1", 470, false, 40);
        assertEquals(coastal1, coastal1);
    }

    @Test
    public void testEqualsEqualObjects() {
        Coastal coastal1 = new Coastal("A.1", 470, false, 40);
        Coastal coastal2 = new Coastal("A.1", 470, false, 40);
        assertEquals(coastal1, coastal2);
    }

    @Test
    public void testEqualsDifferentObjects() {
        Coastal coastal1 = new Coastal("A.1", 470, false, 40);
        Coastal coastal2 = new Coastal("A.2", 470, true, 40);
        assertNotEquals(coastal1, coastal2);
    }

    @Test
    public void testReadCoastal() {
        Scanner sc = new Scanner("A.1 470 False 40");
        Coastal coastal = new Coastal("A.1", 470, false, 40);
        assertEquals(coastal, Coastal.readCoastal(sc));
    }

    @Test
    public void testToString() {
        Coastal coastal = new Coastal("A.1", 470, false, 40);
        String result = "Coastal Shelter\n" +
                "ID: A.1 - Volume: 470 m3 - Available: false - Land surface: 40 m2";
        assertEquals(result, coastal.toString());
    }

    @Test
    public void testToStringConstant() {
        String result = "Coastal Shelter\n" +
                "Cool Eutrophic Water - Temperate Climate\n";
        assertEquals(result, Coastal.toStringConstant());
    }

}