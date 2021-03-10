import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    void testConstructor() {
        ArrayList<String> shelters = new ArrayList<>();
        shelters.add("Tundra");
        shelters.add("Coastal");
        Animal animal = new Animal("Penguin", 300, shelters);
        assertNotNull(animal);
    }
    @Test
    void testGetName() {
        ArrayList<String> shelters = new ArrayList<>();
        shelters.add("Tundra");
        shelters.add("Coastal");
        Animal animal = new Animal("Penguin", 300, shelters);
        assertEquals("Penguin", animal.getName());
    }

    @Test
    void getVolume() {
        ArrayList<String> shelters = new ArrayList<>();
        shelters.add("Tundra");
        shelters.add("Coastal");
        Animal animal = new Animal("Penguin", 300, shelters);
        assertEquals(300, animal.getVolume());
    }

    @Test
    void getShelters() {
        ArrayList<String> shelters = new ArrayList<>();
        shelters.add("Tundra");
        shelters.add("Coastal");
        Animal animal = new Animal("Penguin", 300, shelters);
        assertEquals(shelters, animal.getShelters());
    }

    @Test
    void testGetParticularShelter() {
        ArrayList<String> shelters = new ArrayList<>();
        shelters.add("Tundra");
        shelters.add("Coastal");
        Animal animal = new Animal("Penguin", 300, shelters);
        assertEquals("Coastal", animal.getParticularShelter(1));
    }

    @Test
    void testEqualsSameObject() {
        ArrayList<String> shelters = new ArrayList<>();
        shelters.add("Tundra");
        shelters.add("Coastal");
        Animal animal = new Animal("Penguin", 300, shelters);
        assertEquals(animal, animal);
    }

    @Test
    void testEqualsEqualObjects() {
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Tundra");
        shelters2.add("Coastal");
        Animal animal1 = new Animal("Penguin", 300, shelters1);
        Animal animal2 = new Animal("Penguin", 300, shelters2);
        assertEquals(animal1, animal2);
    }

    @Test
    void testEqualsDifferentObjects() {
        ArrayList<String> shelters1 = new ArrayList<>();
        shelters1.add("Tundra");
        shelters1.add("Coastal");
        Animal animal1 = new Animal("Penguin", 300, shelters1);
        ArrayList<String> shelters2 = new ArrayList<>();
        shelters2.add("Coastal");
        Animal animal2 = new Animal("Duck", 50, shelters2);
        assertNotEquals(animal1, animal2);
    }

    @Test
    void testToString() {
        ArrayList<String> shelters = new ArrayList<>();
        shelters.add("Tundra");
        shelters.add("Coastal");
        Animal animal = new Animal("Penguin", 300, shelters);
        String result = "Penguin - Requires: 300 m3 - Preferred shelter: Tundra, Coastal";
        assertEquals(result, animal.toString());
    }

    @Test
    void testReadAnimal() {
        ArrayList<String> shelters = new ArrayList<>();
        shelters.add("Coastal");
        shelters.add("Tundra");
        shelters.add("Reef");
        Animal animal = new Animal("Rock Crab", 80, shelters);
        String line = "Rock Crab; 80; Coastal, Tundra, Reef";
        assertEquals(animal, Animal.readAnimal(line));
    }

    @Test
    void testSuitable() {
        ArrayList<String> shelters = new ArrayList<>();
        shelters.add("Tundra");
        shelters.add("Coastal");
        Animal animal = new Animal("Penguin", 300, shelters);
        Shelter shelter = new Coastal("A.1", 470, false, 40);
        assertTrue(animal.suitable(shelter));
    }

    @Test
    void testNotSuitable1() {
        ArrayList<String> shelters = new ArrayList<>();
        shelters.add("Tundra");
        shelters.add("Coastal");
        Animal animal = new Animal("Penguin", 300, shelters);
        Shelter shelter = new Coastal("A.1", 250, false, 40);
        assertFalse(animal.suitable(shelter));
    }

    @Test
    void testNotSuitable2() {
        ArrayList<String> shelters = new ArrayList<>();
        shelters.add("Tundra");
        shelters.add("Coastal");
        Animal animal = new Animal("Penguin", 300, shelters);
        Shelter shelter = new Reef("C.1", 470, true, 38);
        assertFalse(animal.suitable(shelter));
    }
}