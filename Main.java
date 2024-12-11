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
        List<String> actionsList = Arrays.asList("help", "look", "look around", "stop", "go", "open", "pick", "grab", "inventory", "location", "map"); // all the possible one word actions that a user can do

        // Initializing Classes:
        /* Rooms */
        Room mainBedroom = new Room("Main Bedroom", "Looking around you notice that the bedroom is very sparse. There's a metal framed bed, a desk with a single candle lighting up the room, and a wooden chair. A large window takes up most of the whole wall. There's two sturdy doors leading out; one that is white and the other is black.", false);
        Room mainBathroom = new Room("Main Bathroom", "Observing the bathroom you see a sleak bathtub, a modest sink and toilet. There's a mirror above the sink. You don't recognize the reflection staring back at you. You are confused. There lays a toothbrush innocently laying besides the sink. ", false);
        Room hallway = new Room("Hallway", "This long hallway has a white door on one end and a pink door on the other. On one side of the wall in order is a green door, an orange door, and a purple door. On the other side are blue, red, and yellow doors. You question why there are no normally painted doors in this tower.", false);
        Room secondBedRoom = new Room("Second Bedroom", "This is a simple bedroom", false);
        Room library = new Room("Library", "This is a simple library", false);

        /* Objects */
        Item deskPaper = new Item("Paper", "A piece of paper found on the desk of the Main Bedroom. 'ESCAPE!' is written on the paper in some special dark purple ink.", false);
        Item toothBrush = new Item("Toothbrush", "It's an orange toothbrush that appears to be unused.", false);

        /* Sub Rooms */ // areas found inside the Rooms
        SubRoom desk = new SubRoom("desk", mainBedroom, "The desk looks pretty standard with no extra compartments. There is a single sheet of blank paper atop the desk, but as you move closer you notice lettering in dark purplpe ink slowly appear: ESCAPE!", "The desk looks pretty standard with no extra compartments.", false, false, deskPaper);
        SubRoom window = new SubRoom("window", mainBedroom ,"You move closer to the window and the scenery becomes clearer before you. You realize that you are several thousands of feet above the ground with miles and miles of a snowy landscape as far as the eye can see. ", null, false, true, null);
        List<SubRoom> mBedroomSub = Arrays.asList(window, desk);

        /* Other */
        Person user = new Person(inventory, mainBedroom, null);
        
        // START OF THE GAME:
        /* Intro to Game */
        System.out.println("************************");
        System.out.println("------------------------");
        System.out.println("    ESCAPE THE TOWER    ");
        System.out.println("------------------------");
        System.out.println("************************");

        /* Initializing the game */
        System.out.println("You open your eyes to an unfamiliar bedroom. You are unsure on what to do. Maybe asking for help?");

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
                System.out.println(user.getRoom().getDescription());
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

            /* Help */
            if(userResponse.equals("help")){
                System.out.println("----Helpful Commands---- \n + stop: to stop the game \n + inventory \n + location: gives current room \n + look around \n + go: to move between rooms or approach certain areas \n + grab " );
            }


            /* Default response to giving wrong command */
            if(!actionsList.contains(userWords[0])){
                System.out.println("Sorry, there's no command for \"" + userResponse + "\". ");
            } 

            // Inside Main Bedroom:
            if(user.getRoom().getName().equals("Main Bedroom")){

                for(int i = 0; i < mBedroomSub.size(); i++){ // going through each of the main bedroom sub rooms
                    for(int j = 0; j < userWords.length; j++){  
                        
                        /* Checks to see if the user's response matches any of the subrooms */
                        if(mBedroomSub.get(i).getName().equalsIgnoreCase(userWords[j]) && actionsList.contains(userWords[0])){
                            
                            /* Assigns user's subroom as the one that matches their response */
                            user.setSubRoom(mBedroomSub.get(i));

                            /* If there is an object, set access to true */
                            if(user.getSubRoom().getEmpty() == false){
                                user.getSubRoom().getItem().setAccess(true); // if there is an item then allow access to it
                            }

                            /* The sub area doesn't have an item anymore, updates description */
                            if(user.getSubRoom().getEmpty() == true && user.getSubRoom().getItem() != null){
                                System.out.println(user.getSubRoom().getDescription2()); // gives description

                            } else{
                                /* Gives description */
                                System.out.println(user.getSubRoom().getDescription());
                            }
                        }
                    }
                }

                /* Pick up object */
                if(user.getSubRoom() != null){

                    /* There is an item to pick up */
                    if(user.getSubRoom().getItem() != null){

                        if(actionsList.contains(userWords[0]) && user.getSubRoom().getItem().getAccess() == true && userResponse.contains(user.getSubRoom().getItem().getName().toLowerCase()) && user.getSubRoom().getEmpty() != true){
                            System.out.println("yippee");
                            user.grabItem(user.getSubRoom().getItem()); // adds the item to inventory
                            user.getSubRoom().setEmpty(true); // sets the sub room to empty
                        }

                    }
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
                    System.out.println("You step into a long hallway with seven doors each painted in different colors. Across from you is a pink door. To the left of you in order is a green door, an orange door, and a purple door. To the right of you are blue, red, and yellow doors. You question why there are no normally painted doors in this tower.");
                    continue;
                }

            }

            // Inside Main Bathroom:
            if(user.getRoom().getName().equals("Main Bathroom")){
                /* Grants access to toothbrush */
                toothBrush.setAccess(true);

                /* Returning back to main bedroom */
                if(actionsList.contains(userWords[0]) && userResponse.contains("black") && userResponse.contains("door")){
                    System.out.println("Opening black door...");
                    user.setRoom(mainBedroom);
                    System.out.println("Current location: " +user.getRoom().getName());
                    System.out.println(mainBedroom.getDescription());
                    continue;
                }

                /* Grab item */
                if(actionsList.contains(userWords[0]) && userResponse.contains("tooth") && userResponse.contains("brush")&& toothBrush.getAccess()){
                    System.out.println(toothBrush.getDescription());
                    user.grabItem(toothBrush);
                    
                } else if(actionsList.contains(userWords[0]) && userResponse.contains(toothBrush.getName().toLowerCase()) && toothBrush.getAccess()){
                    System.out.println(toothBrush.getDescription());
                    user.grabItem(toothBrush);
                }
                
            }

            // Inside Hallway:
            if(user.getRoom().getName().equals("Hallway")){
                /* Go through green door */
                if(actionsList.contains(userWords[0]) && userResponse.contains("green") && userResponse.contains("door")){
                    System.out.println("As you open up the green door, you notice that you can't see into the room. It's just pitch blackness. As you step into the void, black surrounds you until you realize you stepped into a hallway. You look wildly around until you realize that you came out of the purple door. Weird.");
                    continue;
                }

                /* Go through orange door */
                if(actionsList.contains(userWords[0]) && userResponse.contains("orange") && userResponse.contains("door")){
                    System.out.println("As you open up the orange door, you notice that you can't see into the room. It's just pitch blackness. As you step into the void, black surrounds you until you realize you stepped into a different bedroom.");
                    user.setRoom(secondBedRoom);
                    System.out.println("Current location: " +user.getRoom().getName());
                    System.out.println(secondBedRoom.getDescription());
                    continue;
                }

                /* Go through purple door */
                if(actionsList.contains(userWords[0]) && userResponse.contains("purple") && userResponse.contains("door")){
                    System.out.println("As you open up the purple door, you notice that you can't see into the room. It's just pitch blackness. As you step into the void, black surrounds you until you realize you stepped into a hallway. You look wildly around until you realize that you came out of the pink door. Weird.");
                    continue;
                }

                /* Go through pink door */
                if(actionsList.contains(userWords[0]) && userResponse.contains("pink") && userResponse.contains("door")){
                    System.out.println("As you open up the pink door, you notice that you can't see into the room. It's just pitch blackness. As you step into the void, black surrounds you until you realize you stepped into a hallway. You look wildly around until you realize that you came out of the green door. Weird.");
                    continue;
                }

                /* Go through yellow door */
                if(actionsList.contains(userWords[0]) && userResponse.contains("yellow") && userResponse.contains("door")){
                    System.out.println("You try to turn the door knob but it won't budge. The yellow door is locked.");
                    continue;
                }

                /* Go through red door */
                if(actionsList.contains(userWords[0]) && userResponse.contains("red") && userResponse.contains("door")){
                    System.out.println("As you open up the red door, you notice that you can't see into the room. It's just pitch blackness. As you step into the void, black surrounds you until you realize you stepped into a hallway. You look wildly around until you realize that you came out of the blue door. Weird.");
                    continue;
                }
                
                /* Go through blue door */
                if(actionsList.contains(userWords[0]) && userResponse.contains("blue") && userResponse.contains("door")){
                    System.out.println("As you open up the blue door, you notice that you can't see into the room. It's just pitch blackness. As you step into the void, black surrounds you until you realize you stepped into a library.");
                    user.setRoom(library);
                    System.out.println("Current location: " +user.getRoom().getName());
                    System.out.println(library.getDescription());
                    continue;
                }

            }

            // Inside Second Bedroom:
            if(user.getRoom().getName().equals("Second Bedroom")){

                /* Go through orange door to go back to hallway */
                if(actionsList.contains(userWords[0]) && userResponse.contains("orange") && userResponse.contains("door")){
                    System.out.println("Opening orange door...");
                    user.setRoom(hallway);
                    System.out.println("Current location: " +user.getRoom().getName());
                    System.out.println(user.getRoom().getDescription());
                    continue;
                }
            }

            // Inside Library:
            if(user.getRoom().getName().equals("Library")){

                /* Go through blue door to go back to hallway */
                if(actionsList.contains(userWords[0]) && userResponse.contains("blue") && userResponse.contains("door")){
                    System.out.println("Opening blue door...");
                    user.setRoom(hallway);
                    System.out.println("Current location: " +user.getRoom().getName());
                    System.out.println(user.getRoom().getDescription());
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