package thriftyrent;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A Car type of RentalVehicle.
 */
public class Car extends RentalVehicle {

	/** What type of rental vehicle this is. */
	public static final String VEHICLE_TYPE_CAR = "Car";

	/** Date formatter to get day of week. */
	private static final DateTimeFormatter DAY_OF_WEEK_FORMATTER = DateTimeFormatter.ofPattern("EEEE");

	/**
	 * Minimum number of days a Car can be rented for when renting from a Friday or
	 * Saturday.
	 */
	private static final int WEEK_MIN_RENT_DAYS = 2;

	/** Minimum number of days a Car can be rented for. */
	private static final int WEEKEND_MIN_RENT_DAYS = 3;

	/** Maximum number of days a Car can be rented for. */
	private static final int MAX_RENT_DAYS = 14;

	/** Four seats daily rate. */
	private static final double FOUR_SEAT_RATE = 78.00;

	/** seven seats daily rate. */
	private static final double SEVEN_SEAT_RATE = 113.00;

	/** Late daily rate. */
	private static final double LATE_RATE = 1.25;

	/**
	 * Create a Car with required parameters.
	 *
	 * @param year      year of the vehicle
	 * @param make      make of the vehicle
	 * @param model     model of the vehicle
	 * @param noOfSeats number of seats in the vehicle
	 */
	public Car(final int year, final String make, final String model, final int noOfSeats) {
		super(year, make, model, noOfSeats);
	}

	@Override
	public String getVehicleType() {
		return VEHICLE_TYPE_CAR;
	}

	@Override
	public boolean validateRent(final LocalDateTime rentDate, final int numOfRentDay) {

		if (numOfRentDay <= 0) {
			return false;
		}

		if (rentDate.toLocalDate().isBefore(LocalDateTime.now().toLocalDate())) {
			return false;
		}

		final String weekDay = DAY_OF_WEEK_FORMATTER.format(rentDate);

		if (numOfRentDay > MAX_RENT_DAYS) {
			System.out.println("You cannot rent this vehicle more than " + MAX_RENT_DAYS + " days ");
			return false;
		}

		if (numOfRentDay < WEEK_MIN_RENT_DAYS && !((weekDay.equals("Friday") || weekDay.equals("Saturday")))) {
			System.out.println("You cannot rent this vehicle less than " + WEEK_MIN_RENT_DAYS + " days ");
			return false;
		}

		if (numOfRentDay < WEEKEND_MIN_RENT_DAYS && (weekDay.equals("Friday") || weekDay.equals("Saturday"))) {
			System.out.println(
					"You cannot rent this vehicle less than " + WEEKEND_MIN_RENT_DAYS + " days on Friday or Saturday");
			return false;
		}

		return true;
	}

	@Override
	public String getPromptTextForHowManyDaysToRent(LocalDateTime rentDay) {

		DayOfWeek dayOfWeek = rentDay.getDayOfWeek();
		if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
			return "\nPlease enter between " + WEEKEND_MIN_RENT_DAYS + " - " + MAX_RENT_DAYS + " days: ";
		}
		return "\nPlease enter between " + WEEK_MIN_RENT_DAYS + " - " + MAX_RENT_DAYS + " days: ";

	}

	/**
	 * Return normal cost for renting a certain number of <code>days</code>
	 * depending on number of seats.
	 *
	 * @param days how many days is the Car to be rented for
	 * @return cost for renting a Car for a certain number of <code>days</code>
	 *         depending on {@link #getNoOfSeats()}.
	 */
	private double calculateCarFees(final long days) {
		if (getNoOfSeats() == 4) {
			return FOUR_SEAT_RATE * days;
		}

		if (getNoOfSeats() == 7) {
			return SEVEN_SEAT_RATE * days;
		}
		return 0.00;
	}

	@Override
	public double calculateRentalFee(final LocalDateTime estimatedReturnDate, final LocalDateTime rentDate,
			final LocalDateTime actualReturnDate) {

		final long actualRentedDays = Duration.between(rentDate, actualReturnDate).toDays();
		final long bookedDays = Duration.between(rentDate, estimatedReturnDate).toDays();

		// Did they rent for LONGER than they said they would?
		if (actualRentedDays > bookedDays) {
			return calculateCarFees(bookedDays);
		} else {
			// This means they rented less than they booked.
			return calculateCarFees(actualRentedDays);
		}
	}

	@Override
	public double calculateLateFee(final LocalDateTime estimatedReturnDate, final LocalDateTime actualReturnDate) {
		final Duration difference = Duration.between(estimatedReturnDate, actualReturnDate);
		final long daysRentedExtra = difference.toDays();
		if (daysRentedExtra > 0) {
			return calculateCarFees(daysRentedExtra) * LATE_RATE;
		}
		return 0.00;
	}

	@Override
	public String getDetailsExtraDetail() {
		return "";
	}

	@Override
	public boolean completeMaintenance(final LocalDateTime completionDate) {
		System.out.println(
				getVehicleType() + " " + getVehicleId() + "  has all maintenance completed and ready for rent");
		setVehicleStatus(AVAILABLE);
		return true;
	}
}
