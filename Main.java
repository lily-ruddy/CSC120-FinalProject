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
        List<String> actionsList = Arrays.asList("look", "look around", "stop", "go", "open", "pick", "grab", "inventory", "location", "map"); // all the possible one word actions that a user can do

        // Initializing Classes:
        /* Rooms */
        Room mainBedroom = new Room("Main Bedroom", "Looking around you notice that the bedroom is very sparse. There's a metal framed bed, a desk with a single candle lighting up the room, and a wooden chair. A large window takes up most of the whole wall. There's two sturdy doors leading out; one that is white and the other is black.", false);
        Room mainBathroom = new Room("Main Bathroom", "Observing the bathroom you see a sleak bathtub, a modest sink and toilet. There's a mirror above the sink. You don't recognize the reflection staring back at you. You are confused. There lays a single tube of toothpaste and a toothbrush innocently laying besides the sink. ", false);
        Room hallway = new Room("Hallway", "You step into a long hallway with six doors.", false);
        
        /* Sub Rooms */ // areas found inside the Rooms
        SubRoom desk = new SubRoom("desk", mainBedroom, "The desk looks pretty standard with no extra compartments. There is a single sheet of blank paper atop the desk, but as you move closer you notice lettering in dark purplpe ink slowly appear: ESCAPE!", "The desk looks pretty standard with no extra compartments.", false, false);
        SubRoom window = new SubRoom("window", mainBedroom ,"You move closer to the window and the scenery becomes clearer before you. You realize that you are several thousands of feet above the ground with miles and miles of a snowy landscape as far as the eye can see. ", null, false, true);

        /* Objects */
        Item deskPaper = new Item("Paper", "A piece of paper found on the desk of the Main Bedroom. 'ESCAPE!' is written on the paper in some special dark purple ink.", false);
        Item toothBrush = new Item("Toothbrush", "It's an orange toothbrush that appears to be unused.", false);
        Item toothPaste = new Item("Toothpaste", "A drugstore brand toothpaste: 6/10 DENTISTS AGREE THAT THIS IS IN FACT TOOTHPASTE", false);
        
        /* Other */
        Person user = new Person(inventory, mainBedroom);
        List<SubRoom> subRoomsList = Arrays.asList(window, desk);

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
                    System.out.println("----Inventory----");
                    for(String i:inventory){
                        System.out.print("+ ");
                        System.out.println(i);
                    }
                }
            }

            /* Map */
            if(userResponse.equals("map")){
                System.out.println("**Confused Noises** \n What is a map?");
            }

            /* Default response to giving wrong command */
            if(!actionsList.contains(userWords[0])){
                System.out.println("Sorry, there's no command for \"" + userResponse + "\". ");
            } 

            // Inside Main Bedroom:
            if(user.getRoom().getName().equals("Main Bedroom")){

                /* Go to window or desk if it's unlocked */
                for(SubRoom i:subRoomsList){
                    if(actionsList.contains(userWords[0]) && userResponse.contains(i.getName()) && i.getLocked() == false){
                        System.out.println(i.getDescription());

                        /* If the subroom has an object, allow access to it */
                        if(i.getEmpty() == false){

                        }

                    
                        
                    }
                }

                /* Pick up object */
                for(SubRoom i:subRoomsList){
                    if(actionsList.contains(userWords[0]) && userResponse.contains(i.getName())){
                        System.out.println(i.getDescription());
                        
                    }
                }


                /* Go to desk */
                // if(actionsList.contains(userWords[0]) && userResponse.contains(desk.getName())){
                //     System.out.println(desk.getDescription());
                //     deskPaper.setAccess(true); // allows user to pick up the paper

                //     // if(user)
                // }

                /* Add paper to inventory */
                if(actionsList.contains(userWords[0]) && userResponse.contains("paper") && deskPaper.getAccess()){
                    System.out.println("This is going to be a method from the person class where they check if its not already in their inventory and then add it to their inventory");
                    user.getInventory().add("Paper");
                    System.out.println("Putting the piece of paper in pockets...");
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
                /* Grants access to toothbrush and toothpaste */
                toothBrush.setAccess(true);
                toothPaste.setAccess(true);

                /* Returning back to main bedroom */
                if(actionsList.contains(userWords[0]) && userResponse.contains("black") && userResponse.contains("door")){
                    System.out.println("Opening black door...");
                    user.setRoom(mainBedroom);
                    System.out.println("Current location: " +user.getRoom().getName());
                    System.out.println(mainBedroom.getDescription());
                    continue;
                }

                // I NEED TO HAVE A METHOD THAT CHECKS TO SEE IF I CAN ADD THE ITEM SO I DON"T NEED TO WRITE REPEATING CODE
                // FUTURE TASK
                /* Grab items */
                if(actionsList.contains(userWords[0]) && userResponse.contains("toothbrush") && toothBrush.getAccess()){
                    user.getInventory().add("Toothbrush");
                    System.out.println("Putting the toothbrush in pockets...");
                }

                if(actionsList.contains(userWords[0]) && userResponse.contains("toothpaste") && toothPaste.getAccess()){
                    user.getInventory().add("Toothpaste");
                    System.out.println("Putting the toothpaste in pockets...");
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