package thriftyrent;

import static thriftyrent.ThriftyRentSystem.DATE_PATTERN;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * A Van type of RentalVehicle.
 */
public class Van extends RentalVehicle {

	/** What type of rental vehicle this is. */
	public static final String VEHICLE_TYPE_VAN = "Van";

	/** Minimum number of days a Van can be rented for. */
	public static final int MIN_RENT_DAYS = 1;

	/** Daily rent cost. */
	public static final double VAN_RENT_RATE = 235.0;

	/** Daily late rent cost. */
	public static final double VAN_LATE_RATE = 299.0;

	/** Max days in between maintenance. */
	public static final int MAINT_INTERVAL = 12;

	/** Date this vehicle was last maintained. */
	private LocalDateTime lastMaintenanceDate;

	/**
	 * Create a Van.
	 *
	 * @param year  year of the vehicle
	 * @param make  make of the vehicle
	 * @param model model of the vehicle
	 */
	public Van(final int year, final String make, final String model) {
		super(year, make, model, 15);
		this.lastMaintenanceDate = LocalDateTime.now();
	}

	@Override
	public String getVehicleType() {
		return VEHICLE_TYPE_VAN;
	}

	/**
	 * @return date this vehicle was last maintained
	 */
	public LocalDateTime getLastMaintenanceDate() {
		return lastMaintenanceDate;
	}

	/**
	 * @param lastMaintenanceDate date this vehicle was last maintained
	 */
	public void setLastMaintenanceDate(final LocalDateTime lastMaintenanceDate) {
		this.lastMaintenanceDate = lastMaintenanceDate;
	}

	@Override
	public String toString() {
		return super.toString() + ":" + ThriftyRentSystem.DATE_PATTERN.format(getLastMaintenanceDate());
	}

	@Override
	public boolean validateRent(final LocalDateTime rentDate, final int numOfRentDay) {

		if (numOfRentDay <= 0) {
			return false;
		}

		if (numOfRentDay < 1) {
			System.out.println("You cannot rent this vehicle less than 1 day");
			return false;
		}

		if (rentDate.toLocalDate().isBefore(LocalDateTime.now().toLocalDate())) {
			return false;
		}

		if (rentDate.isAfter(lastMaintenanceDate.plusDays(MAINT_INTERVAL))) {
			System.out.printf("You cannot rent this vehicle on %s as it will be under maintenance.%n",
					DATE_PATTERN.format(rentDate));
			return false;
		}

		if (rentDate.plusDays(numOfRentDay).isAfter(lastMaintenanceDate.plusDays(MAINT_INTERVAL))) {
			System.out.printf(
					"You cannot rent this vehicle for %s days, as we need to perform maintenance every %d days.%n",
					numOfRentDay, MAINT_INTERVAL);
			return false;
		}

		return true;
	}

	@Override
	public String getPromptTextForHowManyDaysToRent(LocalDateTime rentDay) {
		return "Please enter a number of days greater or equal to " + MIN_RENT_DAYS + ": ";
	}

	@Override
	public double calculateRentalFee(final LocalDateTime estimatedReturnDate, final LocalDateTime rentDate,
			final LocalDateTime actualReturnDate) {

		final long actualRentedDays = Duration.between(rentDate, actualReturnDate).toDays();
		final long bookedDays = Duration.between(rentDate, estimatedReturnDate).toDays();

		// Did they rent for LONGER than they said they would?
		if (actualRentedDays > bookedDays) {
			return bookedDays * VAN_RENT_RATE;
		} else {
			// This means they rented less than they booked.
			return actualRentedDays * VAN_RENT_RATE;
		}
	}

	@Override
	public double calculateLateFee(final LocalDateTime estimatedReturnDate, final LocalDateTime actualReturnDate) {
		final Duration difference = Duration.between(estimatedReturnDate, actualReturnDate);
		final long daysRentedExtra = difference.toDays();

		if (daysRentedExtra > 0) {
			return daysRentedExtra * VAN_LATE_RATE;
		}
		return 0.00;
	}

	@Override
	public String getDetailsExtraDetail() {
		return "Last maintenance Date:  " + ThriftyRentSystem.DATE_PATTERN.format(lastMaintenanceDate) + "\n";
	}

	@Override
	public boolean completeMaintenance(final LocalDateTime completionDate) {
		System.out.println(
				getVehicleType() + " " + getVehicleId() + "  has all maintenance completed and ready for rent");
		setLastMaintenanceDate(completionDate);
		setVehicleStatus(AVAILABLE);

		return true;
	}

}
