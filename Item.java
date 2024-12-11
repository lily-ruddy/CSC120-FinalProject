public class Item {

    // Attributes:
    private String name; // name of the item 
    private String description; // description of the item
    private boolean access = false; // whether the user can access the item, default to no

    // Constructor
    /**
     * Creates an item that can be found in the Tower where a user can interact with it.
     * @param name String name of the item
     * @param description String description of the item
     * @param access Boolean whether the item can be picked up or not, if false = can't be picked up, if true = can be picked up
     */
    public Item(String name, String description, boolean access){
        this.name = name; // name of the item
        this.description = description; // description of the item
        this.access = access; // access to the item
    }

    // Accessors:
    /**
     * Getter for the name of the item
     * @return item The string name of the item
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter for the description of the item
     * @return description The string description of the item
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Getter for whether the user has access to the item
     * @return access The boolean access, false = can't pick up, true = can pick up
     */
    public Boolean getAccess(){
        return this.access;
    }

    /**
     * Setter for the access of the item
     * @param a The boolean access, false = can't pick up, true = can pick up
     */
    public void setAccess(boolean a){
        access = a; // grants or denys access to item
    }
}
