import java.util.Scanner;
import java.util.ArrayList;

/**
 * This is the Main class that provides command lines with a user interface which that will manage shipping containers of certain types.
 * Users will be able to manually enter container contents, use RFID scanning, print container details, and quit the application through a provided menu.
 *
 * @author Shifat Ghazi
 * @version August 14, 2024
 */

public class Main {

    /**
     * Default constructor for the Main class
     */
    public Main() {
    }

    /**
     * The main method is the start of the application.
     * It presents a menu to the user for different operations related to shipping containers,
     * including manual entry, RFID entry, printing details, or quitting the application.
     *
     * @param args arguments that are command lines however this is not used
     */
    public static void main(String[] args) {

        Scanner scanUserInput = new Scanner(System.in);
        ArrayList<ShipContainer> currentShipContainer = new ArrayList<ShipContainer>();
        int containerIDNum = 100;

        String menuChoice = "";

        while (!menuChoice.equalsIgnoreCase("Q")) {
            //Menu is outputted to the user
            System.out.println("\nChoose type of details entering method:");
            System.out.println("\tM)anual container entry.");
            System.out.println("\tR)FID container entry.");
            System.out.println("\tP)rint Shipping Container details.");
            System.out.println("\tQ)uit");
            System.out.print("Choice: ");
            menuChoice = scanUserInput.nextLine();

            switch (menuChoice.toUpperCase()) {
                case "M":
                    //User will perform entries for a Manual Content List container
                    ManualContentList manualContainerList = new ManualContentList(containerIDNum);
                    System.out.print("Enter the container contents: ");

                    String manualAddContents = scanUserInput.nextLine();
                    manualContainerList.setContents(manualAddContents);
                    currentShipContainer.add(manualContainerList);
                    containerIDNum++;
                    break;

                case "R":
                    //User will perform entries for a RFID container
                    ShippingContainerRFID rfidContainerList = new ShippingContainerRFID(containerIDNum);
                    String addAgainChoice = "";

                    while (!addAgainChoice.equals("N")) {

                        System.out.print("Scan an RFID (Enter the container contents): ");
                        String rfidAddContents = scanUserInput.nextLine();
                        rfidContainerList.setContents(rfidAddContents);

                        System.out.print("Would you like to scan another RFID? (Y/N): ");
                        addAgainChoice = scanUserInput.nextLine();
                        addAgainChoice = addAgainChoice.toUpperCase();

                        while (!addAgainChoice.equals("Y") && !addAgainChoice.equals("N")) {
                            System.out.print("\nPlease enter a valid entry, (Y/N)!");
                            addAgainChoice = scanUserInput.nextLine();
                            addAgainChoice = addAgainChoice.toUpperCase();
                        }
                    }
                    currentShipContainer.add(rfidContainerList);
                    containerIDNum++;
                    break;

                case "P":
                    //All current shipping container details will be outputted
                    System.out.println("\n******* Shipping container details *******\n");
                    for (ShipContainer container : currentShipContainer) {
                        container.printContent();
                    }
                    break;

                case "Q":
                    //The application will end
                    System.out.println("No longer typing details!");
                    break;

                default:
                    //User will be provided with an output acknowledging an invalid input has been inputted and to enter a valid input
                    System.out.println("Invalid option. Please enter M, R, P or Q.");
                    break;
            }
        }
    }
}