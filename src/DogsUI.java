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
        System.out.println("Välkommen till DogDaycare's användargränssnitt!");
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
                
                break;
            
            case "rnd", "register new dog", "rnh", "registrera ny hund":
                // Call method(s).
                break;
        
            case "ld", "list dogs", "lh", "lista hundar":

                break;

            case "ia", "increase age", "oa", "oka alder":

                break;

            case "rd", "remove dog", "tbh", "ta bort hund":

                break;

            case "rno", "register new owner", "rna", "registrera ny agare":

                break;

            case "gd", "give dog", "gbh", "ge bort hund": 

                break;

            case "lo", "list owners", "la", "lista agare":

                break;

            case "rod", "remove owned dog", "tbhfa", "ta bort hund fran agare":

                break;

            case "ro", "remove owner", "tba", "ta bort agare":

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
