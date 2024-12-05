public class Room {

    // Atrributes:
    private String name; // name of the room 
    private String description; // description of the room
    private boolean locked = false; // whether the user can access the room
    //private String location; // where the room is located on the map

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
    
    public static void main(String[] args) {
        Room mainBathroom = new Room("Main Bathroom", "This is a simple bathroom. ", false);
        Room mainBathroom2 = new Room("Main Bathroom", "This is a simple bathroom. ", false);
        mainBathroom.setLocked();
        System.out.println(mainBathroom.locked);
        System.out.println(mainBathroom2.locked);
    }


}
