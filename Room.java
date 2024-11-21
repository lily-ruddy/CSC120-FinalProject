public class Room {

    // Atrributes:
    private String name; // name of the room 
    private String description; // description of the room
    private boolean locked; // whether the user can access the room

    // Constructor:
    public Room(String name, String description, boolean locked ){
        this.name = name;
        this.description = description;
        this.locked = locked;
        System.out.println("You created a room");
    }

    

    public static void main(String[] args) {
        
    }


}
