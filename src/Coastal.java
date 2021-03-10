import java.util.Scanner;

public class Coastal extends Shelter {

    protected int landSurface;
    private static final String waterType = "Cool Eutrophic";
    private static final String climate = "Temperate";

    /**
     * This is the constructor of Coastal
     * @param id - a String with the id of the Coastal Shelter
     * @param volume - an int with the volume of the Coastal Shelter
     * @param availability - a boolean with the availability of the Coastal Shelter
     * @param landSurface - an int with the land surface of the Coastal Shelter
     */
    public Coastal(String id, int volume, boolean availability, int landSurface) {
        super(id, volume, availability);
        this.landSurface = landSurface;

    }

    /**
     * This method is the setter for the land surface of the Coastal Shelter
     * @param landSurface - an int with the land surface
     */
    public void setLandSurface(int landSurface) {
        this.landSurface = landSurface;
    }

    /**
     * This is the getter method for the land surface
     * @return - an integer with the land surface
     */
    public int getLandSurface() {
        return landSurface;
    }

    /**
     * This method compares a Coastal Shelter with an Object and returns true if the Object is also a Coastal Shelter and...
     * ...if they have the same id, volume, availability and land surface and false otherwise
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
        if(other instanceof Coastal) {
           Coastal that = (Coastal) other;
           return super.equals(that) && this.landSurface == that.landSurface;
        }
        return false;
    }

    /**
     * This method receives a scanner and returns a Coastal Shelter
     * @param sc - a scanner containing a Coastal Shelter
     * @return - a Coastal Shelter
     */
    public static Coastal readCoastal(Scanner sc) {
        Coastal coastal = (Coastal) Shelter.readShelter(sc, "Coastal");
        coastal.setLandSurface(sc.nextInt());
        return coastal;
    }

    /**
     * This method returns a string containing a Coastal Shelter written in a human-friendly way
     * @return - a String described as above
     */
    public String toString() {
        String result = "Coastal Shelter\n";
        result = result + super.toString();
        result = result + " - Land surface: " + landSurface + " m2";
        return result;
    }

    /**
     * This method returns a string containing the constant values of the Coastal Shelter
     * @return - a String described as above
     */
    public static String toStringConstant() {
        String result = "Coastal Shelter\n";
        result = result + waterType + " Water - " + climate + " Climate\n";
        return result;
    }
}
