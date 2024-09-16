/**
 * The ManualContentList class models a shipping container with manually entered contents.
 * This class extends the ShipContainer class and provides  methods for setting and returning the container's contents.
 *
 * @author Shifat Ghazi
 * @version August 14, 2024
 */

public class ManualContentList extends ShipContainer{
    /**
     * The contents of the Manual Content List shipping container.
     */
    private String contents;

    /**
     * Default constructor for ManualContentList.
     * Container is initialized with default values.
     */
    public ManualContentList(){
        super();
        contents = null;
    }


    /**
     * Constructor for ManualContentList that assigns to a specific container ID.
     *
     * @param newID the unique ID that assigns to this container of the associated type.
     */
    public ManualContentList(int newID){
        containerID = newID;
    }

    /**
     * Sets the contents of the container.
     *
     * @param contents the contents to be stored in the container of the associated class.
     */
    @Override
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * Returns the contents of the container.
     *
     * @return a string representing the contents of the container.
     */
    @Override
    public String containerContentList(){
        return contents;
    }
}
