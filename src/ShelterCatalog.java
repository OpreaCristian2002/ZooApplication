import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShelterCatalog {
    private Set<Shelter> shelters;

    /**
     * This is the constructor method for the ShelterCatalog
     */
    public ShelterCatalog() {
        shelters = new HashSet<Shelter>();
    }

    /**
     * This method receives a Shelter and adds that shelter to the ShelterCatalog
     * @param shelter - a Shelter
     */
    public void addShelter(Shelter shelter) {
        shelters.add(shelter);
    }

    /**
     * This is the getter method for for the Set of Shelters
     * @return - a Set with Shelters
     */
    public Set<Shelter> getShelters() {
        return shelters;
    }

    /**
     * This method receives a string with a file name, reads the shelters from that file and...
     * ...returns a Shelter Catalog containing the read shelters
     * @param fileName - a String with the name of a file
     * @return - a ShelterCatalog
     * @throws IOException - thrown if the file doesn't exist
     */
    public static ShelterCatalog readShelterCatalog(String fileName) throws IOException {
        ShelterCatalog shelters = new ShelterCatalog();
        Scanner sc = new Scanner(new File(fileName));
        String type;
        while(sc.hasNextLine()) {
            type = sc.next();
            if(type.equals("Coastal")) {
                shelters.addShelter(Coastal.readCoastal(sc));
            }
            else if(type.equals("Tundra")) {
                shelters.addShelter(Tundra.readTundra(sc));
            }
            else {
                shelters.addShelter(Reef.readReef(sc));
            }
        }
        sc.close();
        return shelters;
    }

    /**
     * This method returns a String containing the catalog of shelters written in a human-friendly way
     * @return - a String described as above
     */
    public String toString() {
        String result = "";
        for(Shelter shelter: shelters) {
            result = result + shelter.toString() + "\n";
        }
        return result;
    }

    /**
     * This method receives an Object and returns true if the Object is also a Shelter Catalog and...
     * ...if the Sets of Shelters are equal or false otherwise
     * @param other - an Object
     * @return - a boolean described as above
     */
    public boolean equals(Object other) {
        if(other instanceof ShelterCatalog) {
            ShelterCatalog that = (ShelterCatalog) other;
            return this.shelters.equals(that.shelters);
        }
        return false;
    }

}
