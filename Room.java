public class Room {

    // Atrributes:
    private String name; // name of the room 
    private String description; // description of the room
    private boolean locked = false; // whether the user can access the room

    // Constructor:
    public Room(String name, String description, boolean locked){
        this.name = name;
        this.description = description;
        this.locked = locked;
        System.out.println("You created a room");
    }

    // Accessors:
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Boolean getLocked(){
        return this.locked;
    }

    public void setLocked(){
        locked = true; // unlocks the room
    }
    
}
