public class Item {

    // Attributes:
    private String name; // name of the item 
    private String description; // description of the item
    private boolean access = false; // whether the user can access the item, default to no

    // Constructor
    public Item(String name, String description, boolean access){
        this.name = name;
        this.description = description;
        this.access = access;
        System.out.println("You created an item!");
    }

    // Accessors:
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Boolean getAccess(){
        return this.access;
    }

    public void setAccess(boolean a){
        access = a; // grants / denys access to item
    }
}
