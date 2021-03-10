import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.Stream;
import java.util.stream.*;


public class ZooApplication {

    static Scanner input = new Scanner(System.in);
    static String fileShelters;
    static String fileAnimals;
    static ShelterCatalog allShelters;
    static AnimalCatalog allAnimals;

    public static void main(String[] args) {
        prepareDataStructure();
        int option;
        do {
            printMenu();

            option = input.nextInt();

            executeOption(option);
        }while(option != 6);

    }

    /**
     * This method reads the animals and the shelters from the files
     */
    public static void prepareDataStructure() {
        boolean check;
        do {
            try {
                check = false;
                System.out.println("Please enter the name of the file containing the shelters:");
                fileShelters = input.next();
                System.out.println("Please enter the name of the file containing the animals");
                fileAnimals = input.next();
                allAnimals = AnimalCatalog.readAllAnimals(fileAnimals);
                allShelters = ShelterCatalog.readShelterCatalog(fileShelters);
            }
            catch(IOException e) {
                System.out.println("Something wrong happened while reading the files. Try again.");
                check = true;
            }
        }while(check);
    }

    /**
     * This method prints the menu
     */
    public static void printMenu() {
        System.out.println("Please make your choice:");
        System.out.println("   1 – Show all shelters");
        System.out.println("   2 – Show all animals");
        System.out.println("   3 – Show all shelters suitable for a specific animal");
        System.out.println("   4 – Show the optimal shelters for a specific animal");
        System.out.println("   5 – Show the constant properties per shelter type");
        System.out.println("   6 – Stop the program");
    }

    /**
     * This method executes the option which the user selects
     * @param option - the option which the users selects
     */
    public static void executeOption(int option) {
        switch(option) {
            case 1:
                showAllShelters();
                break;
            case 2:
                showAllAnimals();
                break;
            case 3:
                showSuitableShelters();
                break;
            case 4:
                showOptimalShelters();
                break;
            case 5:
                showConstantProperties();
                break;
            case 6:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Please enter a valid option");
        }
    }

    /**
     * This method prints all shelters from the provided file
     */
    public static void showAllShelters() {
        System.out.println(allShelters.toString());
    }

    /**
     * This method prints all animals from the provided file
     */
    public static void showAllAnimals() {
        System.out.println(allAnimals.toString());
    }

    /**
     * This method asks the user for a shelter type and prints the constant values of that shelter type
     */
    public static void showConstantProperties() {
        System.out.println("Please enter a shelter type:");
        input.nextLine();
        String type = input.nextLine();
        if(type.equals("Coastal") || type.equals("coastal")) {
            System.out.println(Coastal.toStringConstant());
        }
        else if(type.equals("Tundra") || type.equals("tundra")) {
            System.out.println(Tundra.toStringConstant());
        }
        else if(type.equals("Reef") || type.equals("reef")) {
            System.out.println(Reef.toStringConstant());
        }
        else {
            System.out.println("We are sorry, but this shelter type is unknown.");
        }
    }

    /**
     * This method asks the user for an animal and prints all the suitable shelter for that animal type
     */
    public static void showSuitableShelters() {
        System.out.println("Please enter the name of the animal(starting with an uppercase letter): ");
        input.nextLine();
        String type = input.nextLine();
        if(!allAnimals.containsAnimal(type)) {
            System.out.println("We are sorry, but we don't have this animal");
            return;
        }

        ShelterCatalog result = new ShelterCatalog();

        for(Shelter shelter : allShelters.getShelters()) {
            if(allAnimals.suitable(shelter, type)) {
                result.addShelter(shelter);
            }
        }
        if(result.getShelters().size() == 0) {
            System.out.println("We are sorry, but we could not find any suitable shelter for that animal.");
            return;
        }
        System.out.println(result.toString());
    }

    /**
     * This method asks the user for an animal and prints all the available shelters suitable for that animal, starting with the smallest and most optimal shelter...
     */
    public static void showOptimalShelters() {
        System.out.println("Please enter the name of the animal(starting with an uppercase letter): ");
        input.nextLine();
        String type = input.nextLine();
        if(!allAnimals.containsAnimal(type)) {
            System.out.println("We are sorry, but we don't have this animal");
            return;
        }

        ShelterCatalog list = new ShelterCatalog();

        for(Shelter shelter : allShelters.getShelters()) {
            if(allAnimals.suitable(shelter, type)) {
                list.addShelter(shelter);
            }
        }
        if(list.getShelters().size() == 0) {
            System.out.println("We are sorry, but we could not find any suitable shelter for that animal.");
            return;
        }
        List<Shelter> sortedList = new ArrayList<>();
        Animal animal = allAnimals.getAnimal(type);
        for(String shelterType : animal.getShelters()) {
            sortedList.addAll(list.getShelters().stream()
                    .filter(shelter -> shelter.toString().startsWith(shelterType)).
                            filter(shelter -> shelter.availability == true).
                            sorted(Comparator.comparingInt(Shelter::getVolume)).
                            collect(Collectors.toList()));
        }
        System.out.println(toStringOptimal(sortedList));
    }

    /**
     * This method receives a list containing Shelters and returns a string with all the Shelters written in a human-friendly way
     * @param shelters - a list of Shelters
     * @return - a list containg all the Shelters written in a human-friendly way
     */
    public static String toStringOptimal(List<Shelter> shelters) {
        String result = "";
        for(Shelter shelter : shelters) {
            result = result + shelter.toString() + "\n";
        }
        return result;
    }

}
