import java.util.ArrayList;

/**
 * Assignment ElevenPointOne on iLearn PROG1.
 * @author Lucas Ilstedt, luil7872
 */
public class DogsUI {
    private static DogsUI dogsUI = new DogsUI();
    private Reader reader = new Reader();
    private ArrayList<Dog> dogs = new ArrayList<>();
    private ArrayList<Owner> owners = new ArrayList<>();
    
    public static void main(String[] args) {
        dogsUI.startUp();
        dogsUI.commandLoop();
        dogsUI.terminate();
    }

    private void startUp() {
        // intro text
    }

    private void commandLoop() {
        String command;
        do {
            command = reader.readString("Ange kommando", false).toLowerCase();
        
            switch (command) {
                case "at", "add tests":

                    break;
                
                case "rnd", "register new dog":
                    // Call method(s).
                    break;
            
                case "ld", "list dogs":

                    break;

                case "ia", "increase age":

                    break;

                case "rd", "remove dog":

                    break;

                case "rno", "register new owner":

                    break;

                case "gd", "give dog": 

                    break;

                case "lo", "list owners":

                    break;

                case "rod", "remove owned dog":

                    break;

                case "ro", "remove owner":

                    break;

                case "e", "exit":
                    break;

                default:
                    System.out.println("Error: Unknown command");
                    break;
            }
        } while (!command.equals("exit") && !command.equals("e"));
    }

    private void terminate() {
        // outro text
    }
}
