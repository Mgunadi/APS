package thriftyrent;

import static thriftyrent.ThriftyRentSystem.isDateWithinRange;

import java.time.LocalDateTime;

/**
 * Abstract definition of a rental vehicle.
 */
public abstract class RentalVehicle {

	/** String used to represent "available" status. */
	public static final String AVAILABLE = "Available";

	/** String used to represent "rented" status. */
	public static final String RENTED = "Rented";

	/** String used to represent "under maintenance" status. */
	public static final String MAINTENANCE = "Maintenance";

	/** Array of ten most recent rental records. */
	private final RentalRecord[] rentalRecord = new RentalRecord[10];

	/** ID of the vehicle. */
	private final String vehicleId;

	/** Year of the vehicle. */
	private final int year;

	/** Make of the vehicle. */
	private final String make;

	/** Model of the vehicle. */
	private final String model;

	/** Number of seats in the vehicle. */
	private final int noOfSeats;

	/** Status of the vehicle. */
	private String vehicleStatus;

	/** Status of the vehicle. */
	private int recordCounter;

	/** Static integer that we use to get a unique counter for each new vehicle. */
	private static int vehicleCounter = 0;

	/**
	 * Create new rental vehicle.
	 *
	 * @param year      year of the vehicle
	 * @param make      make of the vehicle
	 * @param model     model of the vehicle
	 * @param noOfSeats number of seats in the vehicle
	 */
	protected RentalVehicle(final int year, final String make, final String model, final int noOfSeats) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.noOfSeats = noOfSeats;
		this.vehicleStatus = AVAILABLE;
		this.vehicleId = concatVehicleId();
	}

	/**
	 * Create and return ID value rules: First Letter of the Vehicle Type +
	 * underscore + counter for created vehicles with two zeros + dash + year +
	 * capital initials of make name + capital initials of model or if it is one
	 * word then the whole word.
	 *
	 * @return vehicle ID constructed from attributes of the vehicle itself.
	 */
	public String concatVehicleId() {
		vehicleCounter++;
		char vehicleType = getVehicleType().charAt(0);
		String number = String.format("%03d", vehicleCounter);
		int intYear = year;
		String makeInitials = getInitials(make);
		String modelInitials = getInitials(model);
		return vehicleType + "_" + number + "-" + intYear + makeInitials + modelInitials;
	}

	/**
	 * @return vehicle type
	 */
	public abstract String getVehicleType();

	/**
	 * @return vehicle ID
	 */
	public String getVehicleId() {
		return vehicleId;
	}

	/**
	 * @return vehicle status
	 */
	public String getVehicleStatus() {
		return vehicleStatus;
	}

	/**
	 * @param vehicleStatus vehicle status
	 */
	public void setVehicleStatus(final String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	/**
	 * @param fullString multi-word string
	 * @return initials of each word.
	 */
	public String getInitials(String fullString) {

		String initials = "";
		String initialsUpper = "";
		String trimmedString = "";
		StringBuilder sb = new StringBuilder();
		for (String s : fullString.split(" ")) {

			if (!s.equals("")) {
				sb.append(s + " "); // add word with 1 space
			}
		}
		trimmedString = new String(sb.toString());

		for (String bol : trimmedString.split(" +")) {
			initials += bol.charAt(0);

			initialsUpper = initials.toUpperCase();
		}
		return initialsUpper;
	}

	/**
	 * Validate that this vehicle can be rented from the given <code>rentDate</code>
	 * for the given number of days (<code>numOfRentDay</code>).
	 *
	 * @param rentDate     date this vehicle will be rented from
	 * @param numOfRentDay how many days the user wants to rent this vehicle for,
	 *                     from <code>rentDate</code>
	 * @return true if user will be allowed to rent this vehicle for the given
	 *         input; false otherwise.
	 */
	public abstract boolean validateRent(LocalDateTime rentDate, int numOfRentDay);

	/**
	 * Calculate rental fee, excluding late fees (which is calculated separately).
	 *
	 * @param estimatedReturnDate when the vehicle should be returned
	 * @param rentDate            when the vehicle is rented from
	 * @param actualReturnDate    when the vehicle was actually returned
	 * @return rental fee (fee, excluding late fees).
	 */
	public abstract double calculateRentalFee(LocalDateTime estimatedReturnDate, LocalDateTime rentDate,
			LocalDateTime actualReturnDate);

	/**
	 * Calculate late fee, if any.
	 *
	 * @param estimatedReturnDate when the vehicle should be returned
	 * @param actualReturnDate    when the vehicle was actually returned
	 * @return late fee, if any
	 */
	public abstract double calculateLateFee(LocalDateTime estimatedReturnDate, LocalDateTime actualReturnDate);

	/**
	 * Complete maintenance. Allows sub-types to implement their own rules about
	 * when maintenance on vehicles can be completed
	 *
	 * @param completionDate date when maintenance should be completed
	 * @return true if maintenance can be completed; false otherwise
	 */
	public abstract boolean completeMaintenance(LocalDateTime completionDate);

	/**
	 * @return message that we will prompt the user with when we are asking them how
	 *         many days to rent this vehicle.
	 * @param rentDay because days for rent can change depending on rent day
	 */
	public abstract String getPromptTextForHowManyDaysToRent(LocalDateTime rentDay);

	/**
	 * @return true if the vehicle is available for renting, false otherwise
	 */
	public boolean checkAvailability() {
		// If status is "Available" return true.
		// If status is *anything else*, return false.
		return (vehicleStatus.equals(AVAILABLE));
	}

	/**
	 * Checks if the vehicle is rented in those intended date range.
	 *
	 * Added this method after the submission
	 *
	 * @param rentDate
	 * @param returnDate
	 * @return true if rented, false if it is available
	 */
	public boolean isVehicleRentedThoseDates(LocalDateTime rentDate, LocalDateTime intendedReturnDate) {
		LocalDateTime oldRentDate = null;
		LocalDateTime oldReturnDate = null;

		boolean isBetweenNew = false;
		boolean isBetweenOld = false;
		boolean result = false;

		for (RentalRecord element : rentalRecord) {

			if (element != null) {

				oldRentDate = element.getRentDate();
				oldReturnDate = element.getActualReturnDate();

				isBetweenNew = (oldRentDate.compareTo(rentDate) * rentDate.compareTo(oldReturnDate) > 0)
						|| (oldRentDate.compareTo(intendedReturnDate)
								* intendedReturnDate.compareTo(oldReturnDate) > 0);
				// System.out.println("isBetweenNew: " + isBetweenNew + "\n");

				isBetweenOld = (rentDate.compareTo(oldRentDate) * oldRentDate.compareTo(intendedReturnDate) > 0)
						|| (rentDate.compareTo(oldReturnDate) * oldReturnDate.compareTo(intendedReturnDate) > 0);
				// System.out.println("isBetweenOld: " + isBetweenOld + "\n");

				result = isBetweenNew || isBetweenOld;
				if (result) {
					System.out.println("This vehicle is rented between these days: " + formatMyDate(oldRentDate) + " - "
							+ formatMyDate(oldReturnDate));
					return true;
				}
			}
		}
		return result;
	}

	/**
	 * Check if the vehicle can be rented with the given parameters.
	 *
	 * @param customerId   customer ID
	 * @param rentDate     when the vehicle should be rented from
	 * @param numOfRentDay number of days the vehicle will be rented for
	 * @return true if the vehicle is rented with all the given parameters, false if
	 *         any of the rules for renting were broken and we refused to rent this
	 *         vehicle.
	 */
	public boolean rent(final String customerId, final LocalDateTime rentDate, final int numOfRentDay) {
		// Vehicle non-specific test: Check if the vehicle is available for those
		// dates

		if (isVehicleRentedThoseDates(rentDate, rentDate.plusDays(numOfRentDay))) {
			return false;
		}

		// Vehicle Type Specific tests
		if (validateRent(rentDate, numOfRentDay)) {

			final LocalDateTime estimatedReturnDate = rentDate.plusDays(numOfRentDay);

			final RentalRecord record = new RentalRecord(this, customerId, rentDate, estimatedReturnDate);
			if (recordCounter > 0) {
				for (int i = recordCounter; i > 0; i--) {
					rentalRecord[i] = rentalRecord[i - 1];
				}
			}

			rentalRecord[0] = record;

			setVehicleStatus(RENTED);

			recordCounter++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Return a rented vehicle and make it available again.
	 *
	 * @param returnDate date when the customer returns keys/checks out etc.
	 * @return true if we successfully returned the vehicle; false otherwise (i.e.
	 *         some rule was broken and the vehicle cannot be returned on this date)
	 */
	public boolean returnVehicle(final LocalDateTime returnDate) {
		// Check rental status.
		if (!getVehicleStatus().equals(RENTED)) {
			return false;
		}

		// Check that rental date is before actualReturnDate.
		final LocalDateTime rentDate = getRentalRecords()[0].getRentDate();
		if (!isDateWithinRange(returnDate, rentDate, 0)) {
			return false;
		}

		final RentalRecord lastRentalRecord = rentalRecord[0];

		// All is good
		setVehicleStatus(AVAILABLE);
		lastRentalRecord.setActualReturnDate(returnDate);
		lastRentalRecord.setRentalFee(calculateRentalFee(lastRentalRecord.getEstimatedReturnDate(),
				lastRentalRecord.getRentDate(), returnDate));
		lastRentalRecord.setLateFee(calculateLateFee(lastRentalRecord.getEstimatedReturnDate(), returnDate));
		return true;
	}

	/**
	 * @return true if we successfully performed maintenance.
	 */
	public boolean performMaintenance() {
		if (!getVehicleStatus().equals(AVAILABLE)) {
			return false;
		}

		setVehicleStatus(MAINTENANCE);
		return true;
	}

	/**
	 * Display details of all vehicles.
	 */
	public void displayAllVehicles() {
		System.out.println(rentalRecord[0].getDetails());
	}

	/**
	 * Format a date according to {@link ThriftyRentSystem#DATE_PATTERN}.
	 *
	 * @param myDate date to be formatted
	 * @return string representation of the date
	 */
	public String formatMyDate(final LocalDateTime myDate) {
		if (myDate == null) {
			return null;
		} else {
			return ThriftyRentSystem.DATE_PATTERN.format(myDate);
		}
	}

	/**
	 * @return array of the last 10 rental records for this vehicle
	 */
	public RentalRecord[] getRentalRecords() {
		return rentalRecord;
	}

	/**
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return make name
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @return model name
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return number of seats
	 */
	public int getNoOfSeats() {
		return noOfSeats;
	}

	@Override
	public String toString() {
		return vehicleId + ":" + year + ":" + make + ":" + model + ":" + noOfSeats + ":" + vehicleStatus;
	}

	/**
	 * @return string to be added to {@link #getDetails()} if the sub-class needs to
	 *         add anything extra.
	 */
	public abstract String getDetailsExtraDetail();

	/**
	 * @return more detailed version of {@link #toString()}
	 */
	public String getDetails() {
		String output = //
				String.format("%-23s %-23s %n", "Vehicle ID:", vehicleId)//
						+ String.format("%-23s %-23s %n", "Year:", year)//
						+ String.format("%-23s %-23s %n", "Make:", make)//
						+ String.format("%-23s %-23s %n", "Model:", getModel())//
						+ String.format("%-23s %-23s %n", "Number of seats:", noOfSeats) //
						+ String.format("%-23s %-23s %n", "Status:", vehicleStatus) //
						+ String.format("%n%-23s", getDetailsExtraDetail())//
						+ String.format("%n%-23s", "RENTAL RECORD:");

		if (rentalRecord[0] == null) {
			output += String.format("%s  %n", " Empty")//
					+ "\n-------------------------------------------------------------------------";
		} else {
			for (final RentalRecord element : rentalRecord) {
				if (element == null) {
					break;
				}
				output += element.getDetails() + //
						"\n-------------------------------------------------------------------------";
			}

		}

		return output;
	}
}
