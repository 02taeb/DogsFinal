import java.util.ArrayList;

/**
 * Assignment ElevenPointOne on iLearn PROG1.
 * @author Lucas Ilstedt, luil7872
 */
public class DogsUI {
    private Reader reader = new Reader();
    private ArrayList<Dog> dogs = new ArrayList<>();
    private ArrayList<Owner> owners = new ArrayList<>();
    
    public static void main(String[] args) {
        DogsUI dogsUI = new DogsUI();
        dogsUI.run();
    }

    private void run() {
        startUp();
        commandLoop();
        terminate();
    }

    private void startUp() {
        System.out.println("Välkommen till DogRescue's användargränssnitt!");
        System.out.println("");
        printAvailableCommands();
    }

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

    private void commandLoop() {
        String command;
        do {
            command = readCommand();
            handleCommand(command);
        } while (!command.equals("exit") && !command.equals("e") && !command.equals("avsluta") && !command.equals("a"));
    }

    private String readCommand() {
        return reader.readString("Ange kommando", false).toLowerCase();
    }

    private void handleCommand(String command) {
        switch (command) {
            case "at", "add tests", "ltt", "lagg till tester":
                // Call method which creates and adds dogs and owners for testing.
                // Maybe borrow from jUnit test cases.
                break;
            
            case "rnd", "register new dog", "rnh", "registrera ny hund":
                // Call method(s).
                // From AssignmentSevenPointOne. (uses 6.4)
                break;
        
            case "ld", "list dogs", "lh", "lista hundar":
                // From AssignmentSevenPointSix & AssignmentEightPointFour. (uses 7.2 & 8.3)
                break;

            case "ia", "increase age", "oa", "oka alder":
                // From AssignmentSevenPointFour. (uses 7.3)
                break;

            case "rd", "remove dog", "tbh", "ta bort hund":
                // From AssignmentEightPointEight. (uses 7.3 & 8.3)
                break;

            case "rno", "register new owner", "rna", "registrera ny agare":
                // From AssignmentEightPointOne.
                break;

            case "gd", "give dog", "gbh", "ge bort hund": 
                // From AssignmentEightPointThree.
                break;

            case "lo", "list owners", "la", "lista agare":
                // From AssignmentEightPointFour. (uses 7.2 & 8.3)
                break;

            case "rod", "remove owned dog", "tbhfa", "ta bort hund fran agare":
                // From AssignmentEightPointSix. (uses 7.2, 8.3 & 8.4)
                break;

            case "ro", "remove owner", "tba", "ta bort agare":
                // From AssignmentEightPointSeven. (uses 8.3)
                break;

            case "e", "exit", "a", "avsluta":
                break;

            default:
                System.out.println("Error: Unknown command");
                printAvailableCommands();
                break;
        }    
    }

    private void terminate() {
        // outro text
    }
}
