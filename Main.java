// Resources:
// https://www.geeksforgeeks.org/split-string-java-examples/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        /* Game Play */
        boolean stillPlaying = true; // let's us know when the loop should end
        ArrayList<String> inventory = new ArrayList<String>(); // inventory of the user

        // Parsing User's Input
        Scanner userInput = new Scanner(System.in); // user's input
        String userResponse = ""; // stores user's response
        List<String> actionsList = Arrays.asList("look", "look around", "stop", "go", "open", "pick", "grab"); // all the possible one word actions that a user can do
        //List<String> nounsList = Arrays.asList("window");
        //List<String> adjectiveList = Arrays.asList("brown", "black");
        

        /* Initializing Classes */
        Room mainBedroom = new Room("Main Bedroom", "Looking around you notice that the bedroom is very sparse. There's a metal framed bed, a desk with a single candle lighting up the room, and a wooden chair. A large window takes up most of the whole wall. There's two sturdy doors leading out; one that is white and the other is black.", false);
        Room mainBathroom = new Room("Main Bathroom", "This is a simple bathroom. ", false);
        Room hallway = new Room("Hallway", "You step into a long hallway with six doors.", false);
        Person user = new Person(inventory, mainBedroom);

        // START OF THE GAME:
        /* Intro to Game */
        System.out.println("************************");
        System.out.println("------------------------");
        System.out.println("    ESCAPE THE TOWER    ");
        System.out.println("------------------------");
        System.out.println("************************");

        /* Initializing the game */
        System.out.println("You open your eyes to an unfamiliar bedroom. You are unsure on what to do. ");

        /* Main Game Loop */
        do{
            /* Parsing user's response */
            userResponse = userInput.nextLine().toLowerCase(); // converts all the actions to lowervase
            String[] userWords = userResponse.split(" "); // spli
            
            // for(String i:userWords){
            //     if(actionsList.contains(i)){
            //         System.out.println(i);
            //     }
            // }

            // Basic Commands in Every Room:
            /* Gives user their room's description */
            if(userResponse.equals("look around") || userResponse.equals("look")){
                System.out.println(user.getRoom().getDescription()); // gives the current room's description
            }

            /* Gives user their location */
            if(userResponse.equals("location")){
                System.out.println("Current location: " +user.getRoom().getName()); // gives the current room's description
            }

            /* Prints out user's inventory */
            if(userResponse.equals("inventory")){
                if(inventory.size() == 0){
                    System.out.println("You reach inside your pockets to find them empty. :(");
                
                } else{
                    System.out.println("----Inventory---- \n");
                    for(String i:inventory){
                        System.out.println(i);
                    }
                }
            }

            // NEEDS WORK
            /* Default response to giving wrong command */
            // if(!actionsList.contains(userResponse)){ // first checks if valid action verb
                
            //     /* if only 1 word */
            //     if(userWords.length == 1){
            //         System.out.println("Sorry, there's no command for \"" + userResponse + "\". ");

            //     } else{ /* checks if last word is in the nouns list */

            //         /* The last word of the user is in the noun list */
            //         if(nounsList.contains(userWords[userWords.length-1])){
                        
            //             // PROBLEM NOT EVERYTHING IS GOING TO HAVE AN ADJECTIVE
            //             /* second to last word of the user is in the adj list */
            //             if(adjectiveList.contains(userWords[userWords.length-2])){
            //                 System.out.println(":)");
            //             } else{
            //                 System.out.println("Sorry, there's no command for \"" + userResponse + "\". ");
            //                 System.out.println("adj");
            //             }

            //         } else{ /* last word is in the noun list */
            //             System.out.println("Sorry, there's no command for \"" + userResponse + "\". ");
            //             System.out.println("noun");
            //         }
            //     }
            // }

            // Inside Main Bedroom:
            if(user.getRoom().getName().equals("Main Bedroom")){

                /* Go to window */
                if(actionsList.contains(userWords[0]) && userResponse.contains("window")){
                    System.out.println("You move closer to the window and the scenery becomes clearer before you. You realize that you are several thousands of feet above the ground with miles and miles of a snowy landscape as far as the eye can see. ");
                }

                /* Go to desk */
                if(actionsList.contains(userWords[0]) && userResponse.contains("desk")){
                    System.out.println("The desk looks pretty standard with no extra compartments. There is a single sheet of blank paper atop the desk, but as you move closer you notice lettering in dark purplpe ink slowly appear: ESCAPE!");
                }

                /* Add paper to inventory */
                if(actionsList.contains(userWords[0]) && userResponse.contains("paper")){
                    // System.out.println("please I'm so confused");
                    // user.getInventory().add("paper");
                    // System.out.println("papoef");
                    System.out.println("This is going to be a method from the person class where they check if its not already in their inventory and then add it to their inventory");
                }

                /* Go through black door to main bathroom */
                if(actionsList.contains(userWords[0]) && userResponse.contains("black") && userResponse.contains("door")){
                    System.out.println("Opening black door...");
                    user.setRoom(mainBathroom);
                    System.out.println("Current location: " +user.getRoom().getName());
                    System.out.println(mainBathroom.getDescription());
                    continue;
                }

                /* Go through white door to hallway */
                if(actionsList.contains(userWords[0]) && userResponse.contains("white") && userResponse.contains("door")){
                    System.out.println("Opening white door...");
                    user.setRoom(hallway);
                    System.out.println("Current location: " +user.getRoom().getName());
                    System.out.println(hallway.getDescription());
                    continue;
                }
            }

            // Inside Main Bathroom:
            if(user.getRoom().getName().equals("Main Bathroom")){
                System.out.println("In bathroom :)");

                /* Returning back to main bedroom */
                if(actionsList.contains(userWords[0]) && userResponse.contains("black") && userResponse.contains("door")){
                    System.out.println("Opening black door...");
                    user.setRoom(mainBedroom);
                    System.out.println("Current location: " +user.getRoom().getName());
                    System.out.println(mainBedroom.getDescription());
                    continue;
                }
            }
            




            /* Exiting the game */
            if(userResponse.equals("stop")){
                System.out.println("Leaving Game");
                stillPlaying = false;
            }
        } while (stillPlaying);

        userInput.close(); // closing scanner
        


    }

}