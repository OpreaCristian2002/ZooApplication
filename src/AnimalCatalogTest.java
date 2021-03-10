import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnimalCatalogTest {

    @Test
    void testConstructor() {
        AnimalCatalog catalog = new AnimalCatalog();
        assertNotNull(catalog);
    }

    @Test
    void testGetAllAnimals() {
        AnimalCatalog catalog = new AnimalCatalog();
        assertEquals(0, catalog.getAllAnimals().size());
    }

    @Test
    void testAddAnimal() {
        AnimalCatalog catalog = new AnimalCatalog();
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin" , 300, shelters1 );
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        shelters2.add("Tundra");
        shelters2.add("Reef");
        Animal animal2 = new Animal("Rock Crab", 80, shelters2);
        catalog.addAnimal(animal1);
        catalog.addAnimal(animal2);
        catalog.addAnimal(animal1);
        assertEquals(3, catalog.getAllAnimals().size());
    }

    @Test
    void testToString() {
        AnimalCatalog catalog = new AnimalCatalog();
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin" , 300, shelters1 );
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        shelters2.add("Tundra");
        shelters2.add("Reef");
        Animal animal2 = new Animal("Rock Crab", 80, shelters2);
        catalog.addAnimal(animal1);
        catalog.addAnimal(animal2);
        catalog.addAnimal(animal1);
        String result = "Penguin - Requires: 300 m3 - Preferred shelter: Tundra, Coastal\n" +
                "Rock Crab - Requires: 80 m3 - Preferred shelter: Coastal, Tundra, Reef\n" +
                "Penguin - Requires: 300 m3 - Preferred shelter: Tundra, Coastal\n";
        assertEquals(result, catalog.toString());
    }

    @Test
    void readAllAnimals() throws IOException {
        AnimalCatalog catalog = new AnimalCatalog();
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin" , 300, shelters1 );
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        shelters2.add("Tundra");
        shelters2.add("Reef");
        Animal animal2 = new Animal("Rock Crab", 80, shelters2);
        ArrayList<String> shelters3 = new ArrayList<>();
        shelters3.add("Coastal");
        Animal animal3 = new Animal("Duck", 50, shelters3);
        catalog.addAnimal(animal1);
        catalog.addAnimal(animal3);
        catalog.addAnimal(animal2);
        assertEquals(catalog, AnimalCatalog.readAllAnimals("animalsTest.txt"));
    }

    @Test
    void testEqualsSameObject() {
        AnimalCatalog catalog = new AnimalCatalog();
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin" , 300, shelters1 );
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        shelters2.add("Tundra");
        shelters2.add("Reef");
        Animal animal2 = new Animal("Rock Crab", 80, shelters2);
        catalog.addAnimal(animal1);
        catalog.addAnimal(animal2);
        catalog.addAnimal(animal1);
        assertEquals(catalog, catalog);
    }

    @Test
    void testEqualsEqualObjects() {
        AnimalCatalog catalog1 = new AnimalCatalog();
        AnimalCatalog catalog2 = new AnimalCatalog();
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin" , 300, shelters1 );
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        shelters2.add("Tundra");
        shelters2.add("Reef");
        Animal animal2 = new Animal("Rock Crab", 80, shelters2);
        catalog1.addAnimal(animal1);
        catalog1.addAnimal(animal2);
        catalog1.addAnimal(animal1);
        catalog2.addAnimal(animal1);
        catalog2.addAnimal(animal2);
        catalog2.addAnimal(animal1);
        assertEquals(catalog1,catalog2);
    }

    @Test
    void testEqualsDifferentObjects() {
        AnimalCatalog catalog1 = new AnimalCatalog();
        AnimalCatalog catalog2 = new AnimalCatalog();
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin" , 300, shelters1 );
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        shelters2.add("Tundra");
        shelters2.add("Reef");
        Animal animal2 = new Animal("Rock Crab", 80, shelters2);
        catalog1.addAnimal(animal1);
        catalog1.addAnimal(animal2);
        catalog1.addAnimal(animal1);
        catalog2.addAnimal(animal1);
        catalog2.addAnimal(animal2);
        assertNotEquals(catalog1, catalog2);
    }

    @Test
    void testContainsAnimalTrue() {
        AnimalCatalog catalog = new AnimalCatalog();
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin" , 300, shelters1 );
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        shelters2.add("Tundra");
        shelters2.add("Reef");
        Animal animal2 = new Animal("Rock Crab", 80, shelters2);
        ArrayList<String> shelters3 = new ArrayList<>();
        shelters3.add("Coastal");
        Animal animal3 = new Animal("Duck", 50, shelters3);
        catalog.addAnimal(animal1);
        catalog.addAnimal(animal3);
        catalog.addAnimal(animal2);
        assertTrue(catalog.containsAnimal("Penguin"));
    }

    @Test
    void testContainsAnimalFalse() {
        AnimalCatalog catalog = new AnimalCatalog();
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin" , 300, shelters1 );
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        shelters2.add("Tundra");
        shelters2.add("Reef");
        Animal animal2 = new Animal("Rock Crab", 80, shelters2);
        ArrayList<String> shelters3 = new ArrayList<>();
        shelters3.add("Coastal");
        Animal animal3 = new Animal("Duck", 50, shelters3);
        catalog.addAnimal(animal1);
        catalog.addAnimal(animal3);
        catalog.addAnimal(animal2);
        assertFalse(catalog.containsAnimal("Orca"));
    }

    @Test
    void testSuitable() {
        AnimalCatalog catalog = new AnimalCatalog();
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin" , 300, shelters1 );
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        shelters2.add("Tundra");
        shelters2.add("Reef");
        Animal animal2 = new Animal("Rock Crab", 80, shelters2);
        ArrayList<String> shelters3 = new ArrayList<>();
        shelters3.add("Coastal");
        Animal animal3 = new Animal("Duck", 50, shelters3);
        catalog.addAnimal(animal1);
        catalog.addAnimal(animal3);
        catalog.addAnimal(animal2);
        Shelter shelter = new Coastal("A.1", 470, false, 40);
        assertTrue(catalog.suitable(shelter, "Penguin"));
    }

    @Test
    void testGetAnimalExists() {
        AnimalCatalog catalog = new AnimalCatalog();
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin" , 300, shelters1 );
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        shelters2.add("Tundra");
        shelters2.add("Reef");
        Animal animal2 = new Animal("Rock Crab", 80, shelters2);
        ArrayList<String> shelters3 = new ArrayList<>();
        shelters3.add("Coastal");
        Animal animal3 = new Animal("Duck", 50, shelters3);
        catalog.addAnimal(animal1);
        catalog.addAnimal(animal3);
        catalog.addAnimal(animal2);
        assertEquals(animal1, catalog.getAnimal("Penguin"));
    }

    @Test
    void testGetAnimalNotExists() {
        AnimalCatalog catalog = new AnimalCatalog();
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin" , 300, shelters1 );
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        shelters2.add("Tundra");
        shelters2.add("Reef");
        Animal animal2 = new Animal("Rock Crab", 80, shelters2);
        ArrayList<String> shelters3 = new ArrayList<>();
        shelters3.add("Coastal");
        Animal animal3 = new Animal("Duck", 50, shelters3);
        catalog.addAnimal(animal1);
        catalog.addAnimal(animal3);
        catalog.addAnimal(animal2);
        assertNull(catalog.getAnimal("Orca"));
    }
}