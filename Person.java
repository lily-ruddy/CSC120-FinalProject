import java.util.ArrayList;

// Maybe I don't need this class bc there's only one person
public class Person {

    // Attributes:
    private ArrayList<String> inventory;
    private Room room;

    // Constructor:
    public Person(ArrayList<String> inventory, Room room){
        this.inventory = inventory;
        this.room = room;
    }

    // Accessors:
    public ArrayList<String> getInventory(){
        return this.inventory;
    }

    public Room getRoom(){
        return this.room;
    }

    public void setRoom(Room room){
        this.room = room;
    }

    // Methods:
    /* Adds item to the user's inventory */
    public void grabItem(Item item){
        if(this.inventory.contains(item.getName())){
            System.out.println("This is already ");
        }
    }

    /* Removes item from the user's inventory */
    public void dropItem(Item item){

    }

    /* Uses the item */
    public void userItem(Item item){

    }
    

}
