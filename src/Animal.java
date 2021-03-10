import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Animal {
    private String name;
    private int volume;
    private ArrayList<String> shelters;

    /**
     * This is the constructor method of the animals
     * @param name - a string with the name of the animals
     * @param volume - an integer with the minimum volume of the shelter in which this animal can be accommodated
     * @param shelters - a string with the list of shelters in which these animals can be accommodated in order
     */
    public Animal(String name, int volume, ArrayList<String> shelters) {
        this.name = name;
        this.volume = volume;
        this.shelters = shelters;
    }

    /**
     * This is the getter method for the name
     * @return - a string with the name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the getter method for the volume
     * @return - an int with the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * This is the getter method for the list of Strings with shelters
     * @return - a list of String with shelter types
     */
    public ArrayList<String> getShelters() {
        return shelters;
    }

    /**
     * This method returns the shelter type from the arraylist at place index
     * @param index - an integer value
     * @return - a String with the shelter type at place index
     */
    public String getParticularShelter(int index) {
        return shelters.get(index);
    }

    /**
     * This is the equals method for the animal. It compares an object with an animals and returns true if the are both animals and they...
     * ...have the same name, volume and shelter types and false otherwise
     * @param other - an Object with which we compare the animal
     * @return - a boolean value described as above
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Animal)) return false;
        Animal that = (Animal) other;
        return getVolume() == that.getVolume() &&
                Objects.equals(getName(), that.getName()) &&
                this.shelters.equals(that.getShelters());
    }

    /**
     * This method returns a String containing the animal written in a human-friendly way
     * @return - a String described as above
     */
    public String toString() {
        String result = name + " - Requires: " + volume + " m3 - Preferred shelter: ";
        for(int i = 0 ; i < shelters.size(); i++) {
            result = result + shelters.get(i);
            if(i < shelters.size() - 1) {
                result = result + ", ";
            }
        }
        return result;
    }

    /**
     * This method reads a String with an animal using a scanner and returns an Animal with the attributes from the string
     * @param line - a String containing an animal
     * @return - an Animal described as above
     */
    public static Animal readAnimal(String line) {
        Scanner words = new Scanner(line).useDelimiter("; ");
        String name = words.next();
        int volume = words.nextInt();
        ArrayList<String> shelters= new ArrayList<>();
        String preferredShelters = words.next();
        Scanner scannerShelters = new Scanner(preferredShelters).useDelimiter(", ");
        while(scannerShelters.hasNext()) {
            shelters.add(scannerShelters.next());
        }
        return new Animal(name, volume, shelters);
    }

    /**
     * This method receives a Shelter and returns a boolean which is true if the shelter is suitable for the animal or false otherwise
     * @param shelter - a Shelter
     * @return - a boolean described as above
     */
    public boolean suitable(Shelter shelter) {
        String type = "";
        if(shelter instanceof Tundra) {
            type = "Tundra";
        }
        if(shelter instanceof Coastal) {
            type = "Coastal";
        }
        if(shelter instanceof Reef) {
            type = "Reef";
        }
        if(shelters.contains(type)) {
            return volume <= shelter.getVolume();
        }
        return false;
    }

}
