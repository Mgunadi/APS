package week9;

public class Car {
	private int speed; // distance per time-unit
	private int x;
	private int y;

	public Car(int initialX, int initialY, int initialSpeed) {
		x = initialX;
		y = initialY;
		speed = initialSpeed;
	}

	public void move() {
		if (x + speed <= 120)
			x += speed;
	}

	public int accelerate() throws SpeedException {
		if (speed < 12)
			speed += 1;
		else
			throw new SpeedException();
		return speed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeed() {
		return speed;
	}
}

