public class SubRoom extends Room{

    // Attributes:
    private String description2; // secondary description of the area after the item has been taken
    private Room room; // Room the subroom is in
    private Boolean empty = false; // false means that there are items in the subroom
    private Item item;

    /**
     * Creates a sub room. This is an area within the room that a user can access. 
     * @param name String name of the subroom
     * @param room Room where the sub room is located within
     * @param description String description of the subroom
     * @param description2 Updated String description of the subroom, typically after an item is picked up the item is removed from the description
     * @param locked Boolean true = user has access to subroom, false = user doesn't have access to subroom
     * @param empty Boolean true = there are no item in the subroom, false = there are items in the subroom
     * @param item Item in the subroom that the user can pick up, null if there are no items
     */
    // Constructor
    public SubRoom(String name, Room room, String description, String description2, boolean locked, boolean empty, Item item){
        super(name, description, false); // extends the Room class
        this.room = room; // name of the room
        this.description2 = description2; // description of the room now that the item is gone
        this.empty = empty; // tells us if the subroom has an item or not
        this.item = item; // item

    }

    // Accessors:
    /**
     * Getter to the second description of the subroom now that the item is removed
     * @return description2 String description of the subroom now that the item is removed
     */
    public String getDescription2(){
        return this.description2;
    }

    /**
     * Getter to whether there is an item in the subroom
     * @return empty Boolean, true = there are no item in the subroom, false = there are items in the subroom
     */
    public Boolean getEmpty(){
        return this.empty;
    }

    /**
     * Getter to the room that the subroom is located within
     * @return room Room class that the subroom is located within
     */
    public Room getRoom(){
        return this.room;
    }

    /**
     * Getter to the item that is located within the subroom
     * @return item Item that is located withint the subroom, null if there are no items
     */
    public Item getItem(){
        return this.item;
    }

    /**
     * Setter to change whether the subroom is empty or not. Typically this function is used once the item is picked up by the user and put in their inventory.
     * @param e Boolean, true = no item in subroom, false = item in subroom
     */
    public void setEmpty(boolean e){
        this.empty = e;
    }    
}
