import java.util.Scanner;

public class Reef extends Shelter{

    protected int nCorals;
    private static final String waterType = "Warm Trophic";
    private static final String climate = "Tropical";

    /**
     * This is the constructor of Reef
     * @param id - a String with the id of the Reef Shelter
     * @param volume - an int with the volume of the Reef Shelter
     * @param availability - a boolean with the availability of the Reef Shelter
     * @param nCorals - an int with the number of corals in the Reef Shelter
     */
    public Reef(String id, int volume, boolean availability, int nCorals) {
        super(id, volume, availability);
        this.nCorals = nCorals;
    }

    /**
     * This is the getter method for the number of corals of the Reef Shelter
     * @return - an integer with the number of corals
     */
    public int getNCorals() {
        return nCorals;
    }

    /**
     * This is the setter method for the number of corals of the Reef Shelterw
     * @param nCorals - an int with the number of corals
     */
    public void setNCorals(int nCorals) {
        this.nCorals = nCorals;
    }

    /**
     * This method compares a Reef Shelter with an Object and returns true if the Object is also a Reef Shelter and...
     * ...if they have the same id, volume, availability and number of corals and false otherwise
     * @param other - an Object
     * @return - a boolean described as above
     */
    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(other == null) {
            return false;
        }
        if(other instanceof Reef) {
            Reef that = (Reef) other;
            return super.equals(that) && this.nCorals == that.nCorals;
        }
        return false;
    }

    /**
     * This method receives a scanner and returns a Reef Shelter
     * @param sc - a scanner containing a Reef Shelter
     * @return - a Reef Shelter
     */
    public static Reef readReef(Scanner sc) {
        Reef reef = (Reef) Shelter.readShelter(sc, "Reef");
        reef.setNCorals(sc.nextInt());
        return reef;
    }

    /**
     * This method returns a string containing a Reef Shelter written in a human-friendly way
     * @return - a String described as above
     */
    public String toString() {
        String result = "Reef Shelter\n";
        result = result + super.toString() +
                " - Number of unique coral types: " + nCorals;
        return result;
    }

    /**
     * This method returns a string containing the constant values of the Reef Shelter
     * @return - a String described as above
     */
    public static String toStringConstant() {
        String result = "Reef Shelter\n";
        result = result + waterType + " Water - " + climate + " Climate\n";
        return result;
    }
}
