import java.util.ArrayList;

// Maybe I don't need this class bc there's only one person
public class Person {

    // Attributes:
    private ArrayList<String> inventory;
    private Room room;
    private SubRoom subRoom;

    // Constructor:
    public Person(ArrayList<String> inventory, Room room, SubRoom subRoom){
        this.inventory = inventory;
        this.room = room;
        this.subRoom = subRoom;
    }

    // Accessors:
    public ArrayList<String> getInventory(){
        return this.inventory;
    }

    public Room getRoom(){
        return this.room;
    }

    public SubRoom getSubRoom(){
        return this.subRoom;
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public void setSubRoom(SubRoom subRoom){
        this.subRoom = subRoom;
    }

    // Methods:
    /* Adds item to the user's inventory */
    public void grabItem(Item item){
        if(this.inventory.contains(item.getName())){
            System.out.println("The " + item.getName().toLowerCase() +" is already in your inventory.");

        } else{
            System.out.println("Putting " + item.getName().toLowerCase() + " in pockets.");
            this.getInventory().add(item.getName());
        }
    }

    /* Removes item from the user's inventory */
    public void dropItem(Item item){

    }

    /* Uses the item */
    public void userItem(Item item){

    }
    

}
