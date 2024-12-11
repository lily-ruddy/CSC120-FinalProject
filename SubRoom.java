public class SubRoom extends Room{

    // Attributes:
    /**
     * 
     */
    private String description2; // secondary description of the area after the item has been taken
    private Room room; // Room the sub room is in
    private Boolean empty = false; // false means that there are items in the subroom
    private Item item;

    // Constructor
    public SubRoom(String name, Room room, String description, String description2, boolean locked, boolean empty, Item item){
        super(name, description, false);
        this.room = room;
        this.description2 = description2;
        this.empty = empty;
        this.item = item;

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

    public Item getItem(){
        return this.item;
    }

    public void setEmpty(boolean e){
        this.empty = e;
    }    
}
