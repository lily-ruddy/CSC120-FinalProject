import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        /* Game Play */
        boolean stillPlaying = true; // let's us know when the loop should end
        Scanner userInput = new Scanner(System.in); // user's input
        String userResponse = ""; // stores user's response

        /* Initializing Classes */
        Room mainBedroom = new Room("Main Bedroom", "There's a desk with a single candle lighting up the room.", false);
        Room mainBathroom = new Room("Main Bathroom", "", false);



        // START OF THE GAME:
        /* Intro to Game */
        System.out.println("************************");
        System.out.println("------------------------");
        System.out.println("    ESCAPE THE TOWER    ");
        System.out.println("------------------------");
        System.out.println("************************");

        /* Main Game Loop */
        do{
            System.out.println("You open your eyes to an unfamiliar bedroom. You are unsure on what to do.");
            userResponse = userInput.nextLine().toLowerCase(); // converts all the actions to lowervase
            // ***********************************************************************

            





            /* Exiting the game */
            if(userResponse.equals("stop")){
                System.out.println("Leaving Game");
                stillPlaying = false;
            }
        } while (stillPlaying);

        userInput.close(); // closing scanner
        


    }

}