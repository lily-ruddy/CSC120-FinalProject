public class Room {

    // Atrributes:
    private String name; // name of the room 
    private String description; // description of the room
    private boolean locked = false; // whether the user can access the room

    // Constructor:
    /**
     * Creates a room in the Tower that a user can navigate to.  
     * @param name String name of the room
     * @param description String description of the room
     * @param locked Boolean, true = locked, false = unlocked
     */
    public Room(String name, String description, boolean locked){
        this.name = name;
        this.description = description;
        this.locked = locked;
    }

    // Accessors:
    /**
     * Getter for the name of the room
     * @return room The string name of the room
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Getter for the description of the room
     * @return description The string description of the room
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Getter for whether the room is locked or not
     * @return locked The boolean if true = locked and if false = unlocked
     */
    public Boolean getLocked(){
        return this.locked;
    }

    /**
     * Setter for unlocking the rooom
     */
    public void setLocked(){
        locked = true; // unlocks the room
    }
    
}
