import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ShelterCatalogTest {

    @Test
    void testConstructor() {

        ShelterCatalog shelters = new ShelterCatalog();
        assertEquals(0, shelters.getShelters().size());
    }

    @Test
    void addShelter() {
        ShelterCatalog shelters = new ShelterCatalog();
        Tundra tundra = new Tundra("B.1", 680, true);
        Coastal coastal = new Coastal("A.1", 470, false, 40);
        shelters.addShelter(tundra);
        shelters.addShelter(coastal);
        assertEquals(2, shelters.getShelters().size());
    }

    @Test
    void getShelters() {
        ShelterCatalog shelters1 = new ShelterCatalog();
        Set<Shelter> shelters2 = new HashSet<>();
        Tundra tundra = new Tundra("B.1", 680, true);
        shelters1.addShelter(tundra);
        shelters2.add(tundra);
        assertEquals(shelters1.getShelters().size(), shelters2.size());
    }

    @Test
    void readShelterCatalog() {
        Coastal coastal = new Coastal("A.1", 470, false, 40);
        Tundra tundra = new Tundra("B.1", 680, true);
        Reef reef = new Reef("C.1", 745, true, 38);

        try {
            ShelterCatalog shelters1 = ShelterCatalog.readShelterCatalog("sheltersTest.txt");
            ShelterCatalog shelters2 = new ShelterCatalog();
            shelters2.addShelter(coastal);
            shelters2.addShelter(tundra);
            shelters2.addShelter(reef);
            assertEquals(shelters1, shelters2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testToString() {
        Coastal coastal = new Coastal("A.1", 470, false, 40);
        Tundra tundra = new Tundra("B.1", 680, true);
        Reef reef = new Reef("C.1", 745, true, 38);
        ShelterCatalog shelters = new ShelterCatalog();
        shelters.addShelter(coastal);
        shelters.addShelter(reef);
        shelters.addShelter(tundra);
        String result = "Coastal Shelter\n" +
                "ID: A.1 - Volume: 470 m3 - Available: false - Land surface: 40 m2\n" +
                "Reef Shelter\n" +
                "ID: C.1 - Volume: 745 m3 - Available: true - Number of unique coral types: 38\n" +
                "Tundra Shelter\n" +
                "ID: B.1 - Volume: 680 m3 - Available: true\n";
        assertEquals(result, shelters.toString());
    }

    @Test
    void testEqualsSameObject() {
        Coastal coastal = new Coastal("A.1", 470, false, 40);
        Tundra tundra = new Tundra("B.1", 680, true);
        Reef reef = new Reef("C.1", 745, true, 38);
        ShelterCatalog shelters2 = new ShelterCatalog();
        shelters2.addShelter(tundra);
        shelters2.addShelter(coastal);
        shelters2.addShelter(reef);
        assertEquals(shelters2, shelters2);
    }

    @Test
    void testEqualsEqualObjects() {
        Coastal coastal = new Coastal("A.1", 470, false, 40);
        Tundra tundra = new Tundra("B.1", 680, true);
        Reef reef = new Reef("C.1", 745, true, 38);
        ShelterCatalog shelters2 = new ShelterCatalog();
        ShelterCatalog shelters1 = new ShelterCatalog();
        shelters2.addShelter(tundra);
        shelters2.addShelter(coastal);
        shelters2.addShelter(reef);
        shelters1.addShelter(coastal);
        shelters1.addShelter(tundra);
        shelters1.addShelter(reef);
        assertEquals(shelters2, shelters1);
    }

    @Test
    void testEqualsDifferentObjects() {
        Coastal coastal = new Coastal("A.1", 470, false, 40);
        Tundra tundra = new Tundra("B.1", 680, true);
        Reef reef = new Reef("C.1", 745, true, 38);
        ShelterCatalog shelters2 = new ShelterCatalog();
        ShelterCatalog shelters1 = new ShelterCatalog();
        shelters2.addShelter(tundra);
        shelters2.addShelter(coastal);
        shelters2.addShelter(reef);
        shelters1.addShelter(tundra);
        shelters1.addShelter(coastal);
        assertNotEquals(shelters2, shelters1);
    }

    @Test
    public void myExceptionTest1() {
        assertThrows(ArithmeticException.class, () -> {
            final int a = 0;
            final int b = 10;
            int c = b / a;
        });
    }

    @Test
    public void myExceptionTest2() {
        boolean exceptionThrown = false;
        try {
            final int a = 0;
            final int b = 10;
            int c = a / b;
        }
        catch(ArithmeticException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}