package revision;

public class Test {
	 //Q7
	/*
	 * public static void main(String[] args ) { String entries [] = { "entry1" ,
	 * "entry2" }; int count = 0; while ( entries [ count ++] != null ) { System.
	 * out .println( count ); } System. out .println( count ); }
	 */
	 

	/* Test while loop with increments
	 * public static void main(String[] args ) { int num = 0; while (num < 13) {
	 * System.out.println(num + " "); num ++; } }
	 */

	/* Q8 - array of array
	 * public static void main(String[] args ) {
	 * 
	 * int[] entry = {2,3,4}; int[] entry2 = {5,6,7}; int[] hi [] = new int[][]
	 * {entry, entry2}; hi[0] = entry; hi[1] = entry2; System.out.println(hi[0][0]);
	 * System.out.println(hi[1]);
	 * 
	 * 
	 * int[] Ar[] = new int[5][2]; int[][] A2 = new int[4][]; }
	 */
	
	/*
	 * Q9 final static int x [] = new int [5]; public static void main(String[] args
	 * ) { final int x = new Test(). x [4]; System.out.println(x); if ( x <= 10)
	 * System. out .println( "javachamp" ); }
	 */

	public static void main(String[] args ) {
	for (int i=1; i <=5; i++) { if(i<=3) continue; System.out.print(i + "*");} System.out.println("end");
	}
	
}