import java.util.Scanner;

public class Tundra extends Shelter {

    private static final String waterType = "Cool Eutrophic";
    private static final String climate = "Polar";

    /**
     * This is the constructor of Tundra
     * @param id - a String with the id of the Tundra Shelter
     * @param volume - an int with the volume of the Tundra Shelter
     * @param availability - a boolean with the availability of the Tundra Shelter
     */
    public Tundra(String id, int volume, boolean availability) {
        super(id, volume, availability);
    }

    /**
     * This method compares a Tundra Shelter with an Object and returns true if the Object is also a Tundra Shelter and...
     * ...if they have the same id, volume and availability and false otherwise
     * @param other - an Object
     * @return - a boolean described as above
     */
    @Override
    public boolean equals(Object other) {
       return super.equals(other);
    }

    public static Tundra readTundra(Scanner sc) {
        Tundra tundra = (Tundra) readShelter(sc, "Tundra");
        return tundra;
    }

    /**
     * This method returns a string containing a Tundra Shelter written in a human-friendly way
     * @return - a String described as above
     */
    public String toString() {
        String result = "Tundra Shelter\n";
        result = result + super.toString();
        return result;
    }

    /**
     * This method returns a string containing the constant values of the Tundra Shelter
     * @return - a String described as above
     */
    public static String toStringConstant() {
        String result = "Tundra Shelter\n";
        result = result + waterType + " Water - " + climate + " Climate\n";
        return result;
    }
}
