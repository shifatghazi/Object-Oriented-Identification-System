/**
 * The ShipContainer class serves as a abstract class for creating various types of shipping containers, each with a unique ID.
 * It defines a framework for managing container contents, including methods to assign and retrieve the container ID,
 * as well as to display the container's contents.
 *
 * @author Shifat Ghazi
 * @version August 14, 2024
 */
public abstract class ShipContainer {
    /**
     * The identifier to acknowledge a shipping container.
     */
    protected int containerID;

    /**
     * Default constructor for ShipContainer.
     * ContainerID is initilzed to 0.
     */
    public ShipContainer() {
        containerID = 0;
    }

    /**
     * Returns the unique identifier associated with the container.
     *
     * @return the container ID.
     */
    public int getContainerID() {
        return containerID;
    }

    /**
     * The contents of the shipping container are set.
     * This method must be used by the subclasses.
     *
     * @param contents the contents to be stored in the designated subclass container.
     */
    public abstract void setContents(String contents);


    /**
     * The container's unique identifier is set.
     *
     * @param containerID the unique ID that is being assigned to the container.
     */
    public void setContainerID(int containerID) {
        this.containerID = containerID;
    }


    /**
     * Returns all the contents in the container.
     * Subclasses may lead to overriding this method for specific details.
     *
     * @return a string that represents the container's contents.
     */
    public String containerContentList() {
        return "";
    }

    /**
     * Prints the current container's ID and its contents associated with it
     */
    public void printContent() {
        System.out.println("Container " + containerID + " contains " + containerContentList());
    }
}
