import java.util.Objects;
import java.util.Scanner;

public abstract class Shelter {
    protected String id;
    protected int volume;
    protected boolean availability;

    /**
     * This is the constructor for the Shelter
     * @param id - a String with the id of the Shelter
     * @param volume - an int with the volume of the Shelter
     * @param availability - a boolean with the availability of the Shelter
     */
    public Shelter(String id, int volume, boolean availability) {
        this.id = id;
        this.volume = volume;
        this.availability = availability;
    }

    /**
     * This is the getter method for the id
     * @return - a String with the id
     */
    public String getId() {
        return id;
    }

    /**
     * This is the getter method for the volume
     * @return - an int with the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * This is the getter method for the availability
     * @return - a boolean with the availability
     */
    public boolean getAvailability() {
        return availability;
    }

    /**
     * This method compares a Shelter with an Object and returns true if the Object is also a Shelter and...
     * ...if they have the same id, volume and availability and false otherwise
     * @param other - an Object
     * @return - a boolean described as above
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Shelter that = (Shelter) other;
        return this.volume == that.getVolume() &&
                this.availability == that.getAvailability() &&
                this.id.equals(that.getId());
    }

    /**
     * This method receives a scanner and a String with a Shelter type and returns a Shelter of that type
     * @param sc - a scanner containing a Shelter
     * @param type - the type of the Shelter it contains
     * @return - a Shelter described as above
     */
    public static Shelter readShelter(Scanner sc, String type) {
        String id = sc.next();
        int volume = sc.nextInt();
        boolean availability = sc.nextBoolean();
        if(type.equals("Coastal")) {
            return new Coastal(id, volume, availability, 0);
        }
        else if(type.equals("Tundra")) {
            return new Tundra(id, volume, availability);
        }
        else {
            return new Reef(id, volume, availability, 0);
        }

    }

    /**
     * This method returns a string containing a Shelter written in a human-friendly way
     * @return - a String described as above
     */
    public String toString() {
        String result;
        result = "ID: " + id + " - Volume: " +
                volume + " m3 - Available: " + availability;
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVolume(), getAvailability());
    }

}
