import java.util.ArrayList;

public class Person {

    // Attributes:
    private ArrayList<String> inventory; // the user's inventory
    private Room room; // user's location
    private SubRoom subRoom; 

    // Constructor:
    /**
     * Creates a person who has their own inventory and location. Can navigate through the Tower and pick up and remove items from their inventory.
     * 
     * @param inventory Arraylist that stores all the items the user pick up on their journey
     * @param room Room that is used to determine the location of the user
     * @param subRoom SubRoom that is used to determine the location of the user
     */
    public Person(ArrayList<String> inventory, Room room, SubRoom subRoom){
        this.inventory = inventory;
        this.room = room;
        this.subRoom = subRoom;
    }

    // Accessors:
    /**
     * Getter for the inventory.
     * @return inventory ArrayList inventory of the user
     */
    public ArrayList<String> getInventory(){
        return this.inventory;
    }

    /**
     * Getter for the room the user is currently in
     * @return room Room the user is currently in
     */
    public Room getRoom(){
        return this.room;
    }

    /**
     * Getter for the sub room the user is currently in
     * @return subRoom SubRoom that the user is currently in, if null then the user isn't in a sub room
     */
    public SubRoom getSubRoom(){
        return this.subRoom;
    }

    /**
     * Setter for the room the user is currently in
     * @param room Room class, updates the room the user is in
     */
    public void setRoom(Room room){
        this.room = room;
    }

    /**
     * Setter for the sub room the user is currently in
     * @param subRoom SubRoom class, updates the sub room the user is in
     */
    public void setSubRoom(SubRoom subRoom){
        this.subRoom = subRoom;
    }

    // Methods:
    /**
     * Picks up the item and adds it to the user's inventory. If the item is already in the user's inventory it will indicate that.
     * @param item Item class added to user's inventory
     */
    public void grabItem(Item item){
        if(this.inventory.contains(item.getName())){ 
            System.out.println("The " + item.getName().toLowerCase() +" is already in your inventory."); // checks to see if it is already in inventory

        } else{
            System.out.println("Putting " + item.getName().toLowerCase() + " in pockets."); 
            this.getInventory().add(item.getName()); // if not adds to user's inventory
        }
    }

    /**
     * Checks to see if the item is already in user's inventory and removes it.
     * @param item Item class removed from user's inventory
     */
    public void removeItem(Item item){
        if(!this.inventory.contains(item.getName())){
            System.out.println("The " + item.getName().toLowerCase() +" isn't in your pockets."); // not in inventory

        } else{
            System.out.println("Dropping " + item.getName().toLowerCase() + "."); 
            this.getInventory().remove(item.getName()); // removes item from inventory
        } 
    }
}
