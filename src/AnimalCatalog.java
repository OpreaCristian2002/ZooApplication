import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AnimalCatalog {

    private ArrayList<Animal> allAnimals;

    /**
     * This is the constructor method for the Animal Catalog
     */
    public AnimalCatalog() {
        this.allAnimals = new ArrayList<>();
    }

    /**
     * This is the getter method for the arraylist of animals
     * @return - an ArrayList with the animals
     */
    public ArrayList<Animal> getAllAnimals() {
        return allAnimals;
    }

    /**
     * This method receives an Animal and adds it to the ArrayList of Animals
     * @param animal - an Animals
     */
    public void addAnimal(Animal animal) {
        allAnimals.add(animal);
    }

    /**
     * This method returns a String containing the catalog of animals written in a human-friendly way
     * @return - a String described as above
     */
    public String toString() {
        String result = "";
        for(Animal animal : allAnimals) {
            result = result + animal.toString() + "\n";
        }
        return result;
    }

    /**
     * This method receives a String with a file name, reads the animals from that file and...
     * ...returns an Animal Catalog containing the read animals
     * @param fileName - a String with the name of a file
     * @return - an Animal Catalog
     * @throws IOException - thrown if the file doesn't exist
     */
    public static AnimalCatalog readAllAnimals(String fileName) throws IOException {
        AnimalCatalog allAnimals = new AnimalCatalog();
        Scanner sc = new Scanner(new File(fileName));
        String line;
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            allAnimals.addAnimal(Animal.readAnimal(line));
        }
        sc.close();
        return allAnimals;
    }

    /**
     * This method receives an Object and returns true if the Object is also an Animal Catalog and...
     * ...if the ArrayLists of Animals are equal or false otherwise
     * @param other - an Object
     * @return - a boolean described as above
     */
    @Override
    public boolean equals(Object other) {
        if(other == this) return true;
        if(other instanceof AnimalCatalog) {
            AnimalCatalog that = (AnimalCatalog) other;
            return this.allAnimals.equals(that.getAllAnimals());
        }
        return false;
    }

    /**
     * This method receives a String with a type of animal and returns true if the AnimalCatalog has that kind of animal
     * @param type - a String with the name of an animal
     * @return - a boolean described as above
     */
    public boolean containsAnimal(String type) {
        for(Animal animal : allAnimals) {
            if(animal.getName().equals(type)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method receives a Shelter and a String with the name of an animal and returns true if...
     * ...the animal exists in the AnimalCatalog and if the shelter is suitable for that animal
     * @param shelter - a Shelter
     * @param type -  a String with the name of an animal
     * @return - a boolean described as above
     */
    public boolean suitable(Shelter shelter, String type) {
        for(Animal animal : allAnimals) {
            if(animal.getName().equals(type)) {
                return animal.suitable(shelter);
            }
        }
        return false;
    }

    /**
     * This method receives a String with a type of animal and returns the Animal for which its name matches the type or null otherwise
     * @param type - a String with the name of an animal
     * @return - an Animal
     */
    public Animal getAnimal(String type) {
        for(Animal animal : allAnimals) {
            if(type.equals(animal.getName()))
                return animal;
        }
        return null;
    }
}
