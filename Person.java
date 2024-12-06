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
    // public void grabItem(Item item){
    //     if(this.inventory.contains(item)){
    //         System.out.println();
    //     }
    // }

    

}
