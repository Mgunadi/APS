package revision;

class Hotel {
	public int bookings ;
	public void book() {
		bookings ++;
	}
}

class SuperHotel extends Hotel {
	public void book() {
		bookings --;
	}

	public void book( int size ) {
		book();
		super .book();
		bookings += size ;
	}
	
	public static void main(String args []) {
		Hotel hotel = new SuperHotel();
		((SuperHotel)hotel).book (2);
		System. out .print( hotel . bookings );
	}
}
