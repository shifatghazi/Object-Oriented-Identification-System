import java.util.LinkedList;

/**
 * The ShippingContainerRFID class models a shipping container that uses RFID technology to manage and track its contents.
 * It extends the ShipContainer class, using linked lists to store items and their corresponding quantities.
 *
 * @author Shifat Ghazi
 * @version August 14, 2024
 */
public class ShippingContainerRFID extends ShipContainer{

    /**
     * A list that keeps track of the quantity of each item in the container for the associated class type.
     */
    private LinkedList<Integer> count = new LinkedList<Integer>();

    /**
     * A list that stores the names of the contents contained in the container for the associated class type.
     */
    private LinkedList<String> contents = new LinkedList<String>();


    /**
     * Overloaded Constructor for ShippingContainerRFID that assigns a specific container ID.
     *
     * @param newID the unique ID that is assigned to this container of the associated type.
     */
    public ShippingContainerRFID(int newID){
        containerID = newID;
    }

    /**
     * Searches for the index of a specific item within the contents list.
     *
     * @param s the name of the item that will be searched for.
     * @return the index of the item if found
     */
    private int searchItems(String s){
        return contents.indexOf(s);
    }

    /**
     * Adds an item to the shipping container or updates the quantity if the item already exists there.
     *
     * @param s the name of the item that will be added or updated.
     */
    @Override
    public void setContents(String s) {
        if (contents.contains(s)){
            count.set(searchItems(s), count.get(searchItems(s)) + 1);
        }else{
            contents.add(s);
            count.add(1);
        }
    }

    /**
     * Returns a well-formatted string representing the contents of the container and their designated quantities.
     *
     * @return a string that lists the quantity and name of each item in the container of the associated class.
     */
    public String containerContentList(){
        String contentOfWords = "";
        for (String item : contents){

            int indexOfCurrentItem = contents.indexOf(item);
            contentOfWords += count.get(indexOfCurrentItem) + " " + item + ". ";
        }
        return contentOfWords;
    }
}
