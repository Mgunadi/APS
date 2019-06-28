package thriftyrent;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

/**
 * Record for a vehicle being rented.
 */
public class RentalRecord {

	/**
	 * Decimal formatter.
	 */
	private static DecimalFormat DF2 = new DecimalFormat("$#,##0.00");

	/**
	 * Date that the vehicle was actually returned on.
	 */
	private LocalDateTime actualReturnDate;

	/**
	 * ID of the customer who rented the vehicle.
	 */
	private String customerId;

	/**
	 * Date the customer estimated they will return the vehicle.
	 */
	private LocalDateTime estimatedReturnDate;

	/**
	 * Late fee to charge the customer if they return the vehicle late.
	 */
	private double lateFee;

	/**
	 * ID of this record.
	 */
	private final String recordId;

	/**
	 * Fee for renting this vehicle, excluding late fees, if any.
	 */
	private double rentalFee;

	/**
	 * When the customer began renting this vehicle from.
	 */
	private final LocalDateTime rentDate;

	/**
	 * Create a rental record.
	 *
	 * @param vehicle             vehicle being rented.
	 * @param customerId          ID of the customer renting the vehicle.
	 * @param rentDate            date the customer is renting the vehicle from
	 * @param estimatedReturnDate when the customer estimates they will return the
	 *                            vehicle.
	 */
	public RentalRecord(final RentalVehicle vehicle, final String customerId, final LocalDateTime rentDate,
			final LocalDateTime estimatedReturnDate) {
		this.recordId = vehicle.getVehicleId() + "_" + customerId + "_" + formatMyDate(rentDate);
		this.customerId = customerId;
		this.rentDate = rentDate;
		this.estimatedReturnDate = estimatedReturnDate;
	}

	/**
	 * @param myDate date to be formatted
	 * @return formatted string or "none"
	 */
	public String formatMyDate(final LocalDateTime myDate) {
		if (myDate == null) {
			return "none";
		} else {
			return ThriftyRentSystem.DATE_PATTERN.format(myDate);
		}
	}

	/**
	 * @return date vehicle was actually returned
	 */
	public LocalDateTime getActualReturnDate() {
		return actualReturnDate;
	}

	/**
	 * @return ID of customer renting the vehicle
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @return date customer estimates they will return the vehicle
	 */
	public LocalDateTime getEstimatedReturnDate() {
		return estimatedReturnDate;
	}

	/**
	 * @return late fee, if any
	 */
	public double getLateFee() {
		return lateFee;
	}

	/**
	 * @return rental fee, excluding late fee
	 */
	public double getRentalFee() {
		return rentalFee;
	}

	/**
	 * @return date the vehicle was rented from
	 */
	public LocalDateTime getRentDate() {
		return rentDate;
	}

	/**
	 * @param returnDate date the vehicle was actually returned
	 */
	public void setActualReturnDate(final LocalDateTime returnDate) {
		this.actualReturnDate = returnDate;
	}

	/**
	 * @param customerId ID of the customer renting the vehicle
	 */
	public void setCustomerId(final String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @param estimatedReturnDate date the customer estimated they will return the
	 *                            vehicle.
	 */
	public void setEstimatedReturnDate(final LocalDateTime estimatedReturnDate) {
		this.estimatedReturnDate = estimatedReturnDate;
	}

	/**
	 * @param lateFee late fee, if any
	 */
	public void setLateFee(final double lateFee) {
		this.lateFee = lateFee;
	}

	/**
	 * @param rentalFee rental fee, excluding late fee
	 */
	public void setRentalFee(final double rentalFee) {
		this.rentalFee = rentalFee;
	}

	@Override
	public String toString() {
		return recordId + ":" + formatMyDate(rentDate) + ":" + formatMyDate(estimatedReturnDate) + ":"
				+ formatMyDate(actualReturnDate) + ":" + (rentalFee == 0.0 ? "none" : DF2.format(rentalFee)) + ":"
				+ (lateFee == 0.0 ? "none" : DF2.format(lateFee));
	}

	/**
	 * @return detailed string describing this rental record.
	 */
	public String getDetails() {
		/*-
		 * Record ID:                xxxx
		 * Rent Date:                xxxx
		 * Estimated Return Date:    xxxx
		 */

		String output = //
				"\nRecord ID:              " + recordId + "\n" //
						+ "RentDate:               " + formatMyDate(rentDate) + "\n" //
						+ "Estimated Return Date:  " + formatMyDate(estimatedReturnDate) + "\n";

		if (actualReturnDate != null) {
			/*-
			 * *** ONLY IF VEHICLE HAS BEEN RETURNED ***
			 * Actual Return Date:       xxxx
			 * Rental Fee:               xxxx
			 * Late Fee:                 xxxx
			 */
			output += //
					"Actual Return Date:     " + formatMyDate(actualReturnDate) + "\n" + //
							"Rental Fee:             " + DF2.format(rentalFee) + "\n" + //
							"Late Fee:               " + DF2.format(lateFee) + "\n" + //
							"--------------------------------------";
		}

		if (actualReturnDate == null) {

		}

		return output;
	}
}
