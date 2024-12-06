/* Items are only found in sub rooms */
public class SubRoom extends Room{

    // Attributes:
    String description2; // secondary description of the area after the item has been taken
    Room room; // Room the sub room is in
    Boolean empty = false; // false means that there are items in the subroom

    // Constructor
    public SubRoom(String name, Room room, String description, String description2, boolean locked, boolean empty){
        super(name, description, false);
        this.room = room;
        this.description2 = description2;
        this.empty = empty;

    }

    // Accessors:
    public String getDescription2(){
        return this.description2;
    }

    public Boolean getEmpty(){
        return this.empty;
    }

    public Room getRoom(){
        return this.room;
    }

    public void setEmpty(boolean e){
        this.empty = e;
    }

    
    
    
}
