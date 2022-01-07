import java.util.ArrayList;
import java.util.Collections;

/**
 * Assignment ElevenPointOne on iLearn PROG1.
 * @author Lucas Ilstedt, luil7872
 */
public class DogsUI {
    //#region Test dogs and owners
    // Shamelesssly borrowed Dogs from AssignmentEightPointEightTest.java
    private static final Dog BELLA = new Dog("Bella", "Labrador", 3, 12);
	private static final Dog RATATA = new Dog("Ratata", "Tax", 15, 7);
	private static final Dog DORIS = new Dog("Doris", "Cocker spaniel", 5, 7);
	private static final Dog LASSIE = new Dog("Lassie", "Mops", 11, 11);
	private static final Dog CHARLIE = new Dog("Charlie", "Puli", 9, 12);
    private static final Dog[] PREPARED_DOGS = { BELLA, RATATA, DORIS, LASSIE, CHARLIE };
    private static final Owner ERIK = new Owner("Erik");
    private static final Owner RONJA = new Owner("Ronja");
    private static final Owner[] PREPARED_OWNERS = {ERIK, RONJA};
    //#endregion
    //#region Instance Variables
    private Reader reader = new Reader();
    // @UnderTest(id = "dogs")
    private ArrayList<Dog> dogs = new ArrayList<>();
    // @UnderTest(id = "owners")
    private ArrayList<Owner> owners = new ArrayList<>();
    private Dog nullDog;
    private String nameOfDog;
    private String nameOfOwner;
    private Owner owner;
    private Dog dog;
    private boolean runDog = true;
    private boolean runOwner = true;
    //#endregion
    
    public static void main(String[] args) {
        DogsUI dogsUI = new DogsUI();
        dogsUI.run();
    }

    /**
     * Runs the program, not in main so everything can be non-static.
     */
    private void run() {
        startUp();
        commandLoop();
        terminate();
    }

    /**
     * Prints welcome message and calls printAvailableCommands().
     */
    private void startUp() {
        System.out.println("Välkommen till DogRescue's användargränssnitt!");
        System.out.println("");
        printAvailableCommands();
    }

    /**
     * Prints the avaiable commands
     */
    private void printAvailableCommands() {
        System.out.println("Följande kommandon finns tillgängliga, ange ett kommando med dess hela namn eller förkortningen inom parentesen:");
        System.out.println("Lagg till tester (ltt)");
        System.out.println("Registrera ny hund (rnh)");
        System.out.println("Lista hundar (lh)");
        System.out.println("Oka alder (oa)");
        System.out.println("Ta bort hund (tbh)");
        System.out.println("Registrera ny agare (rna)");
        System.out.println("Ge bort hund (gbh)");
        System.out.println("Lista agare (la)");
        System.out.println("Ta bort hund fran agare (tbhfa)");
        System.out.println("Ta bort agare (tba)");
        System.out.println("Avsluta (a)");
    }

    /**
     * Loops the readCommand and handleComman sequence until user chooses to exit.
     */
    private void commandLoop() {
        String command;
        do {
            resetVariableValues();
            command = readCommand();
            handleCommand(command);
        } while (!command.equals("exit") && !command.equals("e") && !command.equals("avsluta") && !command.equals("a"));
    }

    /**
     * Resets instance variables so they do not have incorrect values when running multiple commands in one sitting.
     */
    private void resetVariableValues() {
        runDog = true;
        runOwner = true;
    }

    /**
     * Reads command to execute.
     * @return String command.
     */
    private String readCommand() {
        return reader.readString("Ange kommando", false).toLowerCase();
    }

    /**
     * Calls command.
     * @param command String command to call.
     */
    private void handleCommand(String command) {
        switch (command) {
            //#region Optional case structure for older java versions (including VPL)
            // case "at": 
            // case "add tests": 
            // case "ltt": 
            // case "lagg till tester":
            //     addTestsCommand();
            //     break;
            
            // case "rnd": 
            // case "register new dog":
            // case "rnh": 
            // case "registrera ny hund":
            //     dogs.add(createDog());
            //     break;
        
            // case "ld": 
            // case "list dogs": 
            // case "lh":
            // case "lista hundar":
            //     listDogsCommand();
            //     break;

            // case "ia": 
            // case "increase age": 
            // case "oa":
            // case "oka alder":
            //     increaseAge();
            //     break;

            // case "rd": 
            // case "remove dog": 
            // case "tbh":
            // case "ta bort hund":
            //     removeDog();
            //     break;

            // case "rno": 
            // case "register new owner": 
            // case "rna": 
            // case "registrera ny agare":
            //     addOwner();
            //     break;

            // case "gd": 
            // case "give dog":
            // case "gbh":
            // case "ge bort hund": 
            //     addDogToOwner();
            //     break;

            // case "lo": 
            // case "list owners": 
            // case "la": 
            // case "lista agare":
            //     listOwnersAndDogs();
            //     break;

            // case "rod": 
            // case "remove owned dog": 
            // case "tbhfa": 
            // case "ta bort hund fran agare":
            //     removeDogFromOwner();
            //     break;

            // case "ro": 
            // case "remove owner": 
            // case "tba": 
            // case "ta bort agare":
            //     removeOwner();
            //     break;

            // case "e": 
            // case "exit": 
            // case "a": 
            // case "avsluta":
            //     break;
            //#endregion
            case "at", "add tests", "ltt", "lagg till tester":
                addTestsCommand();
                break;
            
            case "rnd", "register new dog", "rnh", "registrera ny hund":
                dogs.add(createDog());
                break;
        
            case "ld", "list dogs", "lh", "lista hundar":
                listDogsCommand();
                break;

            case "ia", "increase age", "oa", "oka alder":
                increaseAge();
                break;

            case "rd", "remove dog", "tbh", "ta bort hund":
                removeDog();
                break;

            case "rno", "register new owner", "rna", "registrera ny agare":
                addOwner();
                break;

            case "gd", "give dog", "gbh", "ge bort hund": 
                addDogToOwner();
                break;

            case "lo", "list owners", "la", "lista agare":
                listOwnersAndDogs();
                break;

            case "rod", "remove owned dog", "tbhfa", "ta bort hund fran agare":
                removeDogFromOwner();
                break;

            case "ro", "remove owner", "tba", "ta bort agare":
                removeOwner();
                break;

            case "e", "exit", "a", "avsluta":
                break;

            default:
                System.out.println("Error: Unknown command");
                printAvailableCommands();
                break;
        }    
    }

    /**
     * Add pre-prepared test dogs and owners to ArrayList<Dog> dogs and ArrayList<Owner> owners.
     */
    private void addTestsCommand() {
        for (Dog dog : PREPARED_DOGS) {
            dogs.add(dog);
        }
        for (Owner owner : PREPARED_OWNERS) {
            owners.add(owner);
        }

        ERIK.addDogToOwner(BELLA);
        ERIK.addDogToOwner(RATATA);
        RONJA.addDogToOwner(DORIS);

        System.out.println("Tests added.");
    }

    //#region Register new dog Command
    /**
     * Creates a dog.
     * 
     * @return instance of class Dog.
     */
    //@UnderTest(id = "U6.4")
    private Dog createDog() {
        String name = reader.readString("Vad heter hunden", true);
        String breed = reader.readString("Vilken ras är hunden", true);
        int age = enterAge();
        int weight = enterWeight();
        Dog dog = new Dog(name, breed, age, weight);
        System.out.println(name + " är nu tillagd i systemet!");
        return dog;
    }

    /**
     * Reads the age for the dog.
     */
    private int enterAge() {
        int age;

        do {
            age = reader.readInt("Hur gammal är hunden");
            if (!isIntegerPositive(age)) {
                printErrorNegativeInt();
            }
        } while (!isIntegerPositive(age));

        return age;
    }

    /**
     * Reads the weight for the dog.
     */
    private int enterWeight() {
        int weight;
        
        do {
            weight = reader.readInt("Hur mycket väger hunden");
            if (!isIntegerPositive(weight)) {
                printErrorNegativeInt();
            }
        } while (!isIntegerPositive(weight));

        return weight;
    }

    /**
     * Checks whether given Integer is negative.
     * 
     * @param i Integer to check.
     * @return boolean.
     */
    private boolean isIntegerPositive(int i) {
        if (i >= 0) {
            return true;
        }

        return false;
    }

    /**
     * Prints an error message saying that given Integer cannot be negative.
     */
    private void printErrorNegativeInt() {
        System.out.println("Error: This Integer cannot be negative");
    }
    //#endregion

    //#region List dogs command
    private void listDogsCommand() {
        selectionSort();
        listDogsByTailLength();
    }

    /**
     * Switches place of two dogs in local ArrayList<Dog> using
     * Collections.swap(List<>, int, int). Will not swap if index is the same.
     * 
     * @param indexFirstDog  Index of first dog.
     * @param indexSecondDog Index of second dog.
     * @return boolean true if swap happened. Else false if swap did not happen.
     */
    // @UnderTest(id = "U7.6.1.2")
    private boolean collectionsSwapTwoDogs(int indexFirstDog, int indexSecondDog) {
        if (indexFirstDog != indexSecondDog) {
            Collections.swap(dogs, indexFirstDog, indexSecondDog);

            // Indicates if swap happened.
            // This because swap should not happen and be counted by selectionSort() if it
            // just swaps a dog for itself.
            return true;
        }

        return false;
    }

    /**
     * Compare two dogs according to tail length and returns index of dog with
     * smallest tail length in local ArrayList<Dog>.
     * If dogs have same tail length will instead compare names and return the
     * earliest alphabetically.
     * Uses local compareBySize(firstDog, secondDog) and compareByName(firstDog,
     * secondDog)
     * 
     * @param firstDog  First Dog to compare.
     * @param secondDog Second Dog to compare.
     * @return int index of "smallest" dog.
     */
    // @UnderTest(id = "U7.6.2")
    private int compareTwoDogs(Dog firstDog, Dog secondDog) {
        int indexOfEarlierDog = compareBySize(firstDog, secondDog);
        if (indexOfEarlierDog == -1) {
            indexOfEarlierDog = compareByName(firstDog, secondDog);
        }

        return indexOfEarlierDog;
    }

    /**
     * Compares two dogs according to tail length.
     * 
     * @param firstDog  First Dog to compare.
     * @param secondDog Second Dog to compare.
     * @return int index of dog with smaller tail in local ArrayList<Dog> or -1 if
     *         same tail length.
     */
    private int compareBySize(Dog firstDog, Dog secondDog) {
        if (firstDog.getTailLength() < secondDog.getTailLength()) {
            return dogs.indexOf(firstDog);
        } else if (secondDog.getTailLength() < firstDog.getTailLength()) {
            return dogs.indexOf(secondDog);
        } else {
            return -1;
        }
    }

    /**
     * Compares two dogs according to name.
     * 
     * @param firstDog  First Dog to compare.
     * @param secondDog Second Dog to compare.
     * @return int index of dog with earlier name alphabetically. Will return index
     *         of firstDog if dogs have same name.
     */
    private int compareByName(Dog firstDog, Dog secondDog) {
        String shorterName;
        if (firstDog.getName().length() > secondDog.getName().length()) {
            shorterName = secondDog.getName();
        } else {
            shorterName = firstDog.getName();
        }
        
        for (int i = 0; i < shorterName.length(); i++) {
            if (firstDog.getName().charAt(i) < secondDog.getName().charAt(i)) {
                return dogs.indexOf(firstDog);
            } else if (firstDog.getName().charAt(i) > secondDog.getName().charAt(i)) {
                return dogs.indexOf(secondDog);
            }
        }

        if (shorterName.equalsIgnoreCase(firstDog.getName())) {
            return dogs.indexOf(firstDog);
        } else {
            return dogs.indexOf(secondDog);
        }
    }

    /**
     * Finds the remaining smallest Dog in local ArrayList<Dog>.
     * 
     * @param indexToStartAt Index to start searching in ArrayList<Dog> from, 0 to
     *                       search entire ArrayList<Dog>.
     * @return int index of "smallest" Dog.
     */
    // @UnderTest(id = "U7.6.3")
    private int findRemainingSmallestDog(int indexToStartAt) {
        int indexOfSmallestDog = -1;
        Dog smallestDog = dogs.get(indexToStartAt);

        for (int i = indexToStartAt + 1; i < dogs.size(); i++) {
            indexOfSmallestDog = compareTwoDogs(smallestDog, dogs.get(i));
            smallestDog = dogs.get(indexOfSmallestDog);
        }

        return indexOfSmallestDog;
    }

    /**
     * Runs a selection sort algorithm on local ArrayList<Dog>.
     * 
     * @return int Number of swaps.
     */
    // @UnderTest(id = "U7.6.4")
    private int selectionSort() {
        int counter = 0;
        for (int i = 0; i < dogs.size() - 1; i++) {
            if (collectionsSwapTwoDogs(i, findRemainingSmallestDog(i))) {
                counter++;
            }
        }

        return counter;
    }
    //#endregion

    //#region Increase age command
    /**
     * Increases the age of Dog with name asked for.
     * Prints error if no Dog with name is found.
     * Uses findDog(dogName) from AssignmentSevenPointThree.
     */
    // @UnderTest(id = "U7.4")
    private void increaseAge() {
        String dogName = reader.readString("Vad heter hunden", false);
        Dog dog = findDog(dogName);

        if (dog == null) {
            System.out.println("Error: No such dog in register");
        } else {
            dog.increaseAge(1);
            System.out.println(dog.getName() + " är nu ett år äldre.");
        }
    }
    //#endregion

    //#region Remove dog command
    /**
     * Removes dog with name given when prompted.
     * Prints error if no dog with name is found.
     * Uses findDog(dogName) from AssignmentSevenPointThree.
     * Updated version of U7.5
     * Also now uses owner.removeDogFromOwner(Dog) and
     * findOwner() from U8.3.
     */
    // @UnderTest(id = "U8.8")
    private void removeDog() {
        String dogName = reader.readString("Vad heter hunden", false);
        Dog dog = findDog(dogName);

        if (dog == null) {
            System.out.println("Error: No such dog in register");
        } else {
            if (dog.isOwned()) {
                nameOfOwner = dog.getOwner().getName();
                findOwner();
                owner.removeDogFromOwner(dog);
            }
            dogs.remove(dog);
            System.out.println(dog.getName() + " är nu borttagen från registret.");
        }
    }
    //#endregion

    //#region Register new owner command
    /**
     * Creates and adds instance of Class Owner to local ArrayList<Owner>.
     */
    // @UnderTest(id = "U8.1")
    private void addOwner() {
        String name = reader.readString("Namn", true);

        owners.add(new Owner(name));

        System.out.println(name + " är nu tillagd i registret.");
    }
    //#endregion

    //#region Give dog command
    // See addDogToOwner() in Used by several commands region
    //#endregion

    //#region List owners command
    /**
     * Returns all owners and the name of their dogs.
     */
    // @UnderTest(id = "U8.4")
    private void listOwnersAndDogs() {
        if (owners.size() == 0) {
            System.out.println("Error: No owners registered.");
        }
        for (Owner owner : owners) {
            System.out.println(owner.toString());
            owner.listOwnedDogs();
        }
    }
    //#endregion

    //#region Remove owned dog command
    /**
     * Removes a Dog from their Owner.
     */
    // @UnderTest(id = "U8.6")
    private void removeDogFromOwner() {
        String dogName = reader.readString("Namn på hund att ta bort", false);
        if (dogName == null || dogName.equals("")) {
            System.out.println("Error: This String cannot be empty");
        } else {
            for (Dog dog : dogs) {
                if (dogName.equalsIgnoreCase(dog.getName())) {
                    if (!dog.removeOwner()) {
                        System.out.printf("Error: %s is not owned by anyone.", dog.getName());
                    }
                    return;
                }
            }
            System.out.println("Error: no such dog.");
        }
    }
    //#endregion

    //#region Remove owner command
     /**
     * Removes an owner from the system (actually local ArrayList<Owner>).
     */
    // @UnderTest(id = "U8.7")
    private void removeOwner() {
        String ownerName = reader.readString("Namn på ägare att ta bort", false);
        if (ownerName == null || ownerName.equals("")) {
            System.out.println("Error: This String cannot be empty");
        } else {
            for (int i = 0; i < owners.size(); i++) {
                if (ownerName.equalsIgnoreCase(owners.get(i).getName())) {
                    removeOwnedDogs(i);
                    System.out.printf("%s är nu borttagen från systemet.%n", owners.get(i).getName());
                    owners.remove(i);
                    return;
                }
            }

            System.out.println("Error: No such owner registered.");
        }
    }

    /**
     * Removes all Dogs in local ArrayList<Dog> owned by Owner with index i in local
     * ArrayList<Owner>.
     * 
     * @param i index for owner.
     */
    private void removeOwnedDogs(int i) {
        ArrayList<Dog> dogsToRemove = new ArrayList<>();
        for (int j = 0; j < dogs.size(); j++) {
            if (dogs.get(j).getOwner() == owners.get(i)) {
                dogsToRemove.add(dogs.get(j));
            }
        }
        
        for (int j = 0; j < dogsToRemove.size(); j++) {
            for (int k = 0; k < dogs.size(); k++) {
                if (dogs.get(k) == dogsToRemove.get(j)) {
                    dogs.remove(k);
                }
            }
        }
    }
    //#endregion

    //#region Used by several commands
    /**
     * Tries to find a dog with given name in local ArrayList.
     * 
     * @param dogName String with dogs name.
     * @return Dog with given name or if none exists Dog with value null.
     */
    // @UnderTest(id = "U7.3")
    private Dog findDog(String dogName) {
        nullDog = null;

        for (Dog dog : dogs) {
            if (dog.getName().equalsIgnoreCase(dogName.trim())) {
                return dog;
            }
        }

        return nullDog;
    }
    
    /**
     * Asks for a tail length and outputs dogs with given tail length in local
     * ArrayList<Dog>.
     */
    // @UnderTest(id = "U7.2")
    private void listDogsByTailLength() {
        double tailLengthMin;
        
        if (!dogs.isEmpty()) {
            tailLengthMin = reader.readDouble("Kortast svanslängd att visa");
            ArrayList<Dog> dogsWithTailLength = searchForDogsByTailSize(tailLengthMin);

            if (dogsWithTailLength.isEmpty()) {
                System.out.println("Error: No dogs with given tail length in register");
            }

            for (Dog dog : dogsWithTailLength) {
                System.out.println(dog.toString());
            }
        } else {
            System.out.println("Error: No dogs in register");
        }
    }

    /**
     * Gets all the dogs with given tail length in local ArrayList<Dog> and returns
     * them in new ArrayList<Dog>.
     * 
     * @param tailLengthCheck double, Tail length to check.
     * @return ArrayList<Dog> of Dogs with tail length.
     */
    // @UnderTest(id = "U7.2-extra")
    private ArrayList<Dog> searchForDogsByTailSize(double tailLengthCheck) {
        ArrayList<Dog> dogsWithTailLength = new ArrayList<>();

        for (int i = 0; i < dogs.size(); i++) {
            if (dogs.get(i).getTailLength() >= tailLengthCheck) {
                dogsWithTailLength.add(dogs.get(i));
            }
        }

        return new ArrayList<Dog>(dogsWithTailLength);
    }

    /**
     * Adds a dog to an owner. Both should exist in local ArrayList<>'s.
     */
    // @UnderTest(id = "U8.3")
    private void addDogToOwner() {
        setDogName();
        initialiseDog();
        // Should only ask for owner if dog is processed correctly.
        if (runDog) {
            setOwnerName();
            initialiseOwner();
        }

        if (!runDog || !runOwner) {
            System.out.println("Error: Operation Failed. Please see earlier error messages.");
        } else if (!owner.hasDog(dog) && !dog.isOwned()) {
            owner.addDogToOwner(dog);
            System.out.println(owner + " äger nu " + dog);
        } else {
            System.out.println("Error: This dog is already owned by this owner.");
        }
    }

    /**
     * Sets nameOfDog.
     * Will also set runDog = false if no name is entered.
     */
    private void setDogName() {
        nameOfDog = reader.readString("Namn på hunden", false);
        if (nameOfDog == null || nameOfDog.equalsIgnoreCase("")) {
            runDog = false;
        }
    }

    /**
     * Will run findDogWithoutOwner() if runDog is true.
     * Else will print error.
     */
    private void initialiseDog() {
        if (runDog) {
            runDog = findDogWithoutOwner();
        } else {
            System.out.println("Error: No dog entered.");
        }
    }

    /**
     * Finds a dog in local ArrayList<Dog>.
     * 
     * @return boolean true if dog with no owner found, false if dog already has
     *         owner or no dog found.
     */
    private boolean findDogWithoutOwner() {
        for (int i = 0; i < dogs.size(); i++) {
            if (dogs.get(i).getName().equalsIgnoreCase(nameOfDog)) {
                dog = dogs.get(i);
                if (!dog.isOwned()) {
                    return true;
                } else {
                    System.out.println("Error: Dog already owned");
                    return false;
                }
            }
        }

        System.out.println("Error: No such dog in registry.");
        return false;
    }

    /**
     * Sets nameOfOwner.
     * Will also set runOwner = false if no name is entered.
     */
    private void setOwnerName() {
        nameOfOwner = reader.readString("Namn på ägaren", false);
        if (nameOfOwner == null || nameOfDog.equalsIgnoreCase("")) {
            runOwner = false;
        }
    }

    /**
     * Will run findOwner() if runOwner is true.
     * Else will print error.
     */
    private void initialiseOwner() {
        if (runOwner) {
            runOwner = findOwner();
        } else {
            System.out.println("Error: No owner entered.");
        }
    }

    /**
     * Finds an owner in local ArrayList<Owner>.
     * 
     * @return boolean true if owner found, false if no owner found.
     */
    private boolean findOwner() {
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).getName().equalsIgnoreCase(nameOfOwner)) {
                owner = owners.get(i);
                return true;
            }
        }

        System.out.println("Error: No such owner in registry.");
        return false;
    }
    //#endregion

    /**
     * Prints parting messages.
     */
    private void terminate() {
        System.out.println("Tack för att du använde DogRescue's användargränssnitt!");
        System.out.println("Hoppas vi ses igen!");
    }
}
