package thriftyrent;

import static thriftyrent.RentalVehicle.AVAILABLE;
import static thriftyrent.RentalVehicle.MAINTENANCE;
import static thriftyrent.RentalVehicle.RENTED;
import static thriftyrent.Van.VEHICLE_TYPE_VAN;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.Scanner;

/**
 * The controlling class for the command line driven Thrifty Rent System. This
 * is the only class responsible for obtaining input from the user, and the main
 * component responsible for outputting message to the user.
 *
 * @author Suheyla Sayram - s3716766 Master of Data Science - Advanced
 *         Programming Assignment 1
 *
 */

public class ThriftyRentSystem {

	/** Date format we use in this system for obtaining dates from the user. */
	public static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd/MM/uuuu")
			.withResolverStyle(ResolverStyle.STRICT);

	/**
	 * Regex that we use to pre-validate dates from user input.
	 */
	private static final String REGEX_DATE_PATTERN = "\\d{2}/\\d{2}/\\d{4}";

	/**
	 * Array of vehicles to be managed by this system. Note that a more advanced
	 * system should be using a {@link List} instead of an array.
	 */
	private final RentalVehicle[] vehicles = new RentalVehicle[50];

	/**
	 * An index to the earliest vehicle added to the array; acts as a barrier
	 * against referencing empty slots in the array.
	 */
	private int arrayCounter = 0;

	/**
	 * Object we use to obtain user input from the console.
	 */
	private final Scanner input = new Scanner(System.in);

	/** Default constructor. */
	public ThriftyRentSystem() {

	}

	/** Display the menu, providing the user with a list of choices. */
	public void displayMenu() {
		int userChoice;
		final String outOfRange = ("It is out of range. ");
		final String messageRange = "Please enter a number between 1 and 7: ";
		do {
			System.out.println("\n**** THRIFTYRENT SYSTEM MENU ****");
			System.out.printf("%-25s %d %n", "Add Vehicle:", 1);
			System.out.printf("%-25s %d %n", "Rent Vehicle:", 2);
			System.out.printf("%-25s %d %n", "Return Vehicle:", 3);
			System.out.printf("%-25s %d %n", "Vehicle Maintenance:", 4);
			System.out.printf("%-25s %d %n", "Complete Maintenance:", 5);
			System.out.printf("%-25s %d %n", "Display All Vehicles:", 6);
			System.out.printf("%-25s %d %n", "Exit Program:", 7);
			System.out.print("\nPlease Enter your choice: ");
			do {
				userChoice = getInteger(messageRange);
				if (userChoice <= 0 || userChoice > 7) {
					System.out.printf("%nThe number you entered is: %d %s %s%n", userChoice, outOfRange, messageRange);
				}
			} while (userChoice <= 0 || userChoice > 7);

			doChoice(userChoice);
		} while (userChoice != 7);

	}

	/**
	 * Get integer from the user via console.
	 *
	 * @param messageRange message to display the user explaining what range of
	 *                     integers are expected
	 * @return integer entered by the user.
	 */
	private int getInteger(final String messageRange) {
		int number;

		while (!input.hasNextInt()) {
			final String choice = input.nextLine();
			System.out.printf("%n\"%s\" is not a valid number. %s%n", choice, messageRange);
		}
		number = input.nextInt();
		input.nextLine();
		return number;
	}

	/**
	 * Call methods on {@link ThriftyRentSystem} to effect whatever menu choice the
	 * user made.
	 *
	 * @param userChoice the integer choice entered by the user.
	 */
	private void doChoice(final int userChoice) {

		if (userChoice == 1) {
			System.out.println("Adding a new vehicle to the system.");
			promptAddVehicle();
		} else if (userChoice == 2) {
			System.out.println("Renting a vehicle.");
			promptRentVehicle();
		} else if (userChoice == 3) {
			System.out.println("Returning a vehicle.");
			promptReturnVehicle();
		} else if (userChoice == 4) {
			System.out.println("Performing a maintenance.");
			promptMaintainVehicle();
		} else if (userChoice == 5) {
			System.out.println("Completing maintenance for a vehicle.");
			promptCompleteMaintenance();
		} else if (userChoice == 6) {
			System.out.println("Displaying details of all vehicles in the system.");
			displayAllVehicles();
		} else {
			System.out.println("Ok, Exiting");
		}
	}

	/**
	 * Prompt a user for all details required to add a vehicle and then add a
	 * vehicle to the system.
	 */
	private void promptAddVehicle() {

		String vehicleType = getVehicleType();

		String make = "make";
		String model = "model";

		final String sMake = "Please enter the make of the vehicle: ";
		final String sModel = "Please enter the model of the vehicle: ";

		int year = getYear();

		make = getAlphaNumericValue(sMake);
		model = getAlphaNumericValue(sModel);

		int noOfSeats = 0;
		final String seatMessage = "Please enter the number of seats (4 or 7): ";

		if (vehicleType.compareToIgnoreCase("C") == 0) {
			do {
				System.out.print(seatMessage);
				noOfSeats = getInteger(seatMessage);
			} while (noOfSeats != 4 && noOfSeats != 7);
		}

		RentalVehicle vehicle = null;
		/*
		 * The only way a constructor can validate a parameter is if it throws an
		 * exception. We are not permitted to use exception handling in this assignment,
		 * therefore we must assume that the constructors can only receive valid inputs.
		 * Therefore, validation of parameters to the Car/Van constructor is purely done
		 * at the input gathering stage.
		 */
		if (vehicleType.compareToIgnoreCase("C") == 0) {
			vehicle = new Car(year, make, model, noOfSeats);
		} else {
			vehicle = new Van(year, make, model);
		}

		if (isVehicleUnique(vehicle)) {
			addVehicle(vehicle);
		}
	}

	/**
	 * @return vehicle type from user input
	 */
	private String getVehicleType() {
		String vehicleType = null;

		final String vehicleMessage = "Please enter the vehicle type. (Car: C or Van: V) C / V: ";
		do {
			System.out.print(vehicleMessage);
			vehicleType = input.nextLine();

			if (!(vehicleType.compareToIgnoreCase("C") == 0 || vehicleType.compareToIgnoreCase("V") == 0)) {
				System.out.printf("You entered \"%s\". It is not a Vehicle Type. ", vehicleType);
			}
		} while (!(vehicleType.compareToIgnoreCase("C") == 0 || vehicleType.compareToIgnoreCase("V") == 0));
		return vehicleType;
	}

	/**
	 * @return year from user input
	 */
	private int getYear() {
		int year = 0;
		final String sYear = "Please enter the year of the vehicle (4 digits - Between 2000 and 2019): ";
		do {
			System.out.print(sYear);

			year = getInteger(sYear);
			if (!(year >= 2000 && year <= 2019)) {
				System.out.println("Please enter the year within the range of 2000 and 2019");
			}

		} while (!(year >= 2000 && year <= 2019));
		return year;
	}

	/**
	 * This method asks for the make and model of the vehicle, later trims the
	 * string if there is some extra spaces and converts it to upper case and
	 * finally returns it to the caller.
	 *
	 * @param detailMessage String to ask the make and model of the vehicle
	 * @return returns the make or model of the vehicle
	 */
	public String getAlphaNumericValue(String detailMessage) {
		String detail;
		System.out.print(detailMessage);
		detail = input.nextLine();
		detail = detail.trim();
		detail = detail.toUpperCase();

		return detail;
	}

	/**
	 * Check if a vehicle is unique. To make the vehicle ID unique I add to the
	 * vehicle ID a counter. To comply with the requirements I am still checking if
	 * the vehicleId is unique in the last if statement.
	 *
	 * @param vehicle vehicle which should be unique to the ThriftyRent System.
	 * @return true if the new vehicle and vehicleId is unique - which means this
	 *         vehicle has not been entered into the system before and it's
	 *         vehicleId is unique.
	 */
	private boolean isVehicleUnique(final RentalVehicle vehicle) {
		final String vehicleString = vehicle.getVehicleType() + vehicle.getYear() + vehicle.getMake()
				+ vehicle.getModel() + vehicle.getNoOfSeats();

		// Check if the RentalVehicle array is empty if it is the vehicleId is unique
		for (final RentalVehicle eachVehicle : vehicles) {
			if (eachVehicle == null) {
				return true;
			}

			// Check if this very same vehicle entered into system before, if it is
			// vehicleId is unique but vehicle is not unique
			final String eachVehicleString = eachVehicle.getVehicleType() + eachVehicle.getYear()
					+ eachVehicle.getMake() + eachVehicle.getModel() + eachVehicle.getNoOfSeats();
			if (vehicleString.compareToIgnoreCase(eachVehicleString) == 0) {
				System.out.println("This vehicle already exists in the system.");
				return false;
			}

			// Finally just in case checking if the vehicleId is unique
			if (vehicle.getVehicleId().compareToIgnoreCase(eachVehicle.getVehicleId()) == 0) {
				System.out.println("This vehicleId already exists in the system.");
				return false;
			}
		}
		return true;
	}

	/**
	 * Add vehicle to ThriftyRent's array of vehicles.
	 *
	 * @param vehicle vehicle to be added.
	 */
	private void addVehicle(final RentalVehicle vehicle) {
		if (arrayCounter >= 50) {
			System.out.println("\nSorry, cannot enter anymore vehicle, system is full");
		} else {
			vehicles[arrayCounter] = vehicle;
			System.out.println("\nNew vehicle " + vehicle.getVehicleId() + " added to the system");

			arrayCounter++;
		}
	}

	/**
	 * Prompt user to enter a date that we verify as a valid date and appears after
	 * the <code>compareDate</code>. Loop until getting the entered date in correct
	 * format and valid, then compare it if the entered date is before today's date
	 * or the rentDay Get the date as a string and convert the valid date to
	 * LocalDate and format it to dd/MM/yyyy then convert to DateTime before
	 * returning it to the calling method.
	 *
	 * @param inputMessage  input to prompt the user with
	 * @param compareDate   date that the user's date must be before
	 * @param beforeMessage message to display to the user if their date is not
	 *                      after the <code>compareDate</code>
	 * @return date object
	 */
	private LocalDateTime promptForDateAfter(final String inputMessage, final LocalDateTime compareDate,
			final String beforeMessage) {
		LocalDateTime dateFromUser = null;
		boolean isDateValid = false;

		do {
			System.out.print(inputMessage);
			dateFromUser = parseDateFromString(input.nextLine());
			if (dateFromUser == null) {
				System.out.print("Date is not entered correctly please enter again ");
			} else if (isDateWithinRange(dateFromUser, compareDate, 0)) {
				isDateValid = true;
			} else {
				System.out.println(beforeMessage);
			}
		} while (!isDateValid);

		return dateFromUser;
	}

	/**
	 * Prompt user for details required to rent a vehicle and then rent a vehicle.
	 */
	private void promptRentVehicle() {
		// Find the vehicle, which may be null.
		final RentalVehicle vehicle = promptUserForVehicleIdAndFind();
		if (vehicle == null) {
			return;
		}

		// Check if it is available for renting (not rented already or not under
		// maintenance)
		if (!vehicle.checkAvailability()) {
			System.out.printf("Vehicle %s is not available for renting. Please try again.%n", vehicle.getVehicleId());
			return;
		}
		// Vehicle is available.

		// Get customer ID
		final String custId = promptForCustomerId();

		// Get rental day.
		final String inputMessage = "Rent date (dd/mm/yyyy): ";
		final String beforeMessage = "You cannot rent a vehicle before today's date. ";

		LocalDateTime rentDay = promptForDateAfter(inputMessage, LocalDate.now().atStartOfDay(), beforeMessage);

		// Get how many days they want to rent.
		int rentingDays = promptForDaysToRent(vehicle, rentDay);

		/*
		 * Prompt for days and validate if an integer entered. After the intended
		 * renting days gathered we have all information to rent the vehicle. Here we
		 * are checking if the renting days are complying with the renting rules
		 */
		while (!vehicle.rent(custId, rentDay, rentingDays)) {
			int decision = 0;
			final String outOfRangeMessage = "Please enter 1, 2 or 3";

			do {
				System.out.println("Enter 1 to change renting days\n" + "Enter 2 to change rent date\n"
						+ "Enter 3 to go back to menu ");
				decision = getInteger(outOfRangeMessage);
			} while (decision <= 0 || decision > 3);

			if (decision == 1) {
				rentingDays = promptForDaysToRent(vehicle, rentDay);
			} else if (decision == 2) {
				rentDay = promptForDateAfter(inputMessage, LocalDate.now().atStartOfDay(), beforeMessage);
			} else {
				return;
			}

		}

		final RentalRecord rentalRecord = vehicle.getRentalRecords()[0];
		System.out.printf("%nRental record: %s%n%s%n", rentalRecord, rentalRecord.getDetails());
		System.out.printf("%s %s is now rented by customer %s%n", vehicle.getVehicleType(), vehicle.getVehicleId(),
				custId);
	}

	/**
	 * Prompt user for number of days to rent the vehicle for.
	 *
	 * @param vehicle vehicle that we are trying to rent: has a type specific
	 *                message relating to how many days it can be rented for.
	 * @param rentDay because days for rent can change depending on rent day
	 * @return integer for how many days to rent the vehicle for.
	 */
	private int promptForDaysToRent(final RentalVehicle vehicle, LocalDateTime rentDay) {
		int rentingDays = 0;

		do {
			System.out.print(vehicle.getPromptTextForHowManyDaysToRent(rentDay));

			rentingDays = getInteger("Invalid number of days!");

		} while (rentingDays <= 0);

		return rentingDays;
	}

	/**
	 * Prompt user for a customer ID.
	 *
	 * @return customer ID entered by the user.
	 */
	private String promptForCustomerId() {
		int custNo = 0;
		final String custMessage = "Customer id (1 to 999): ";
		do {
			System.out.print(custMessage);
			custNo = getInteger(custMessage);
		} while (!(custNo > 0 && custNo < 999));

		return "CUS" + String.format("%02d", custNo);
	}

	/**
	 * Prompt user for all details required in order to return a vehicle.
	 */
	private void promptReturnVehicle() {

		// Find the vehicle, which may be null.
		final RentalVehicle vehicle = promptUserForVehicleIdAndFind();
		if (vehicle == null) {
			return;
		}

		if (!vehicle.getVehicleStatus().equals(RENTED)) {
			System.out.println("This vehicle cannot be returned because it is not rented.");
			return;
		}

		// Prompt user for return date.
		final String inputMessage = "Return date (dd/mm/yyyy): ";
		final String beforeMessage = "You cannot return a vehicle before it's rent date. ";
		// We don't need to check vehicle.getRentalRecord()[0] for null, because we
		// know vehicle is RENTED and therefore has a rental record.
		final RentalRecord rentalRecord = vehicle.getRentalRecords()[0];
		final LocalDateTime rentDate = rentalRecord.getRentDate();
		final LocalDateTime returnDate = promptForDateAfter(inputMessage, rentDate, beforeMessage);

		// Call returning method on vehicle.
		if (vehicle.returnVehicle(returnDate)) {

			System.out.printf("%s %s is now returned by customer %s%n", vehicle.getVehicleType(),
					vehicle.getVehicleId(), rentalRecord.getCustomerId());
			System.out.printf("%nRental record: %s%n", rentalRecord);
			System.out.println(vehicle.getDetails());

		} else {
			System.out.printf("%s %s is NOT returned by customer %s%n", vehicle.getVehicleType(),
					vehicle.getVehicleId(), rentalRecord.getCustomerId());
		}
	}

	/**
	 * Prompt user for details required to maintain a vehicle and then call
	 * operations to maintain the vehicle.
	 */
	private void promptMaintainVehicle() {

		// Find the vehicle, which may be null.
		final RentalVehicle vehicle = promptUserForVehicleIdAndFind();
		if (vehicle == null) {
			return;
		}

		if (vehicle.getVehicleStatus().equals(MAINTENANCE)) {
			System.out.println("This vehicle is already under maintenance, maintainance cannot be performed.");
			return;
		}

		if (vehicle.getVehicleStatus().equals(RENTED)) {
			System.out.println("This vehicle is rented, maintainance cannot be performed.");
			return;
		}

		if (vehicle.performMaintenance()) {
			System.out.println(vehicle.getVehicleType() + " " + vehicle.getVehicleId() + " is now under maintenance.");
		} else {
			System.out.println(
					"Could not perform maintenance on: " + vehicle.getVehicleType() + " " + vehicle.getVehicleId());
		}
	}

	/**
	 * Prompt user for details required to complete maintenance on a vehicle and
	 * then complete the operation.
	 */
	private void promptCompleteMaintenance() {
		// Find the vehicle, which may be null.
		final RentalVehicle vehicle = promptUserForVehicleIdAndFind();
		if (vehicle == null) {
			return;
		}

		if (vehicle.getVehicleStatus().compareToIgnoreCase(RENTED) == 0) {
			System.out.println("This vehicle is rented, maintenance cannot be completed! ");
		} else if (vehicle.getVehicleStatus().equals(AVAILABLE)) {
			System.out.println("This vehicle is not under maintenance, maintainance cannot be completed.");
		} else if (vehicle.getVehicleType().equals(VEHICLE_TYPE_VAN)) {
			final LocalDateTime dateFromUser = promptForDateAfter("Completion date (dd/mm/yyyy): ",
					LocalDate.now().atStartOfDay(), "Cannot be before today");
			vehicle.completeMaintenance(dateFromUser);
		} else {
			vehicle.completeMaintenance(LocalDate.now().atStartOfDay());
		}
	}

	/**
	 * Display details of all vehicles.
	 */
	private void displayAllVehicles() {

		System.out.println("\n                Thrifty Rent System Vehicle Report");
		System.out.println("===================================================================");

		for (final RentalVehicle vehicle : vehicles) {
			if (vehicles[0] == null) {
				System.out.println("There is no vehicle in the system yet to display. ");
			}

			if (vehicle == null) {
				break;
			} else {
				System.out.println(vehicle.getDetails());
			}

		}
	}

	/**
	 * Ask user for a vehicle ID and return vehicle matching that ID.
	 *
	 *
	 * @return a vehicle that matched an ID input from the user or null if there are
	 *         no vehicles in the system yet or if the user chose to cancel this
	 *         operation.
	 */
	private RentalVehicle promptUserForVehicleIdAndFind() {
		// Is it the case that we have NO vehicles at all?
		if (vehicles[0] == null) {
			System.out.println("There are currently no vehicles in the system.");
			// Caller must deal with the fact that this method can return null.
			return null;
		}
		RentalVehicle vehicle = null;
		while (vehicle == null) {
			final String id = promptUserForVehicleId();
			if (id == null) {
				return null;
			}
			// Look at each vehicle element until we find a match or null.
			for (final RentalVehicle vhcl : vehicles) {

				// Stop at the first null... it means that every element from this one on is
				// empty... and that we haven't found a match in any non-null element.
				if (vhcl == null) {
					break;
				}
				// Not null.. Check if the vehicle at this index has the ID we are looking for.
				if (vhcl.getVehicleId().equals(id)) {
					vehicle = vhcl;
				}
			}
			/*
			 * If we got through the for loop and are still here, it means that we have
			 * checked all non-null positions in the vehicle array and none of them had the
			 * ID we were looking for.
			 */
			if (vehicle == null) {
				System.out.printf("There is no vehicle found with this id: %s. Please enter another id. %n", id);
			}
		}
		return vehicle;
	}

	/**
	 * Ask user for the vehicle ID and let them cancel.
	 *
	 * @return String vehicleId or null if user chooses cancel.
	 */
	private String promptUserForVehicleId() {
		// Prompt the user and get input.
		System.out.print("Vehicle ID (or just press enter to cancel): ");
		final String id = input.nextLine();
		// Ensure we have some form of input before continuing.
		if (id == null || id.trim().isEmpty()) {
			System.out.print("Ok, cancelling.\n");
			return null;
		}
		return id;
	}

	/**
	 * @param date string that might be a date
	 * @return date object if string date could be parsed as a date; null otherwise.
	 *         We can use regex in a limited way to check if a string is a valid
	 *         date format, but ultimately we have to call parse on a date format
	 *         which can throw an exception. Rather than crash the program, I chose
	 *         to catch the exception (only at this single point in the app) so I
	 *         don't waste user's time.
	 */
	public static LocalDateTime parseDateFromString(final String date) {

		if (!date.matches(REGEX_DATE_PATTERN)) {
			return null;
		}
		try {
			return LocalDate.parse(date, DATE_PATTERN).atStartOfDay();
		} catch (final DateTimeParseException dtpe) {
			dtpe.printStackTrace();
			return null;
		}
	}

	/**
	 * @param dateToCheck       date that we need validate against a date range
	 * @param start             date that forms start of range; dateToCheck cannot
	 *                          be before this.
	 * @param numberOfDaysToEnd number of days to add to start in order to get end
	 *                          of range. Can be 0 or negative in which case we
	 *                          ignore it
	 * @return true if dateToCheck is not before dateToCheck and not after
	 *         dateToCheck + numberOfDaysToEnd (if numberOfDaysToEnd > 0)
	 */
	public static boolean isDateWithinRange(final LocalDateTime dateToCheck, final LocalDateTime start,
			final int numberOfDaysToEnd) {
		if (dateToCheck.toLocalDate().isBefore(start.toLocalDate())) {
			return false;
		}
		// Should we check end of date range?
		if (numberOfDaysToEnd <= 0) {
			return true;
		}
		// Yes, we should check end of date range.
		return dateToCheck.toLocalDate().isBefore(start.toLocalDate().plusDays(numberOfDaysToEnd + 1));
	}

}
