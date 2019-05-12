/*
 * package week9;
 * 
 * import static org.junit.Assert.*; import org.junit.After; import
 * org.junit.Before; import org.junit.Test;
 * 
 * public class CarTest { Car car;
 * 
 * @Before public void setUp() throws Exception { car = new Car(100, 100, 10); }
 * 
 * @After public void tearDown() throws Exception { }
 * 
 * @Test public void testMove1() { car.move(); assertEquals(110, car.getX()); }
 * 
 * @Test public void testMove2() { car.move(); car.move(); assertEquals(120,
 * car.getX()); }
 * 
 * @Test public void testMove3() { car.move(); car.move(); car.move();
 * assertEquals(120, car.getX()); }
 * 
 * @Test public void testAccelerate1() throws SpeedException { car.accelerate();
 * car.accelerate(); assertEquals(12, car.getSpeed()); }
 * 
 * @Test(expected = SpeedException.class) public void testAccelerate() throws
 * SpeedException { car.accelerate(); car.accelerate(); car.accelerate(); } }
 */