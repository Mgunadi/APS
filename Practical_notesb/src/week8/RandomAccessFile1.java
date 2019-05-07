package week8;

import java.io.*;

public class RandomAccessFile1 {
	public static void main(String arg[]) {
		try {

	         RandomAccessFile randomfile = new RandomAccessFile("test.dat","rw");

	         // writing 3 int elements to array
	         for (int i=1; i<=3; i++)
	             randomfile.writeInt(i);// each int occupies 4 bytes in the file

	         //  rewind back one integer 4 bytes 
		   //  ...1...2...3|
	         randomfile.seek( randomfile.getFilePointer() - 4 * 1);
	         //  ...1...2|...3
	         int x=randomfile.readInt();

		   //  ...1...2...3|
	         x = x + 20;
	         
	         randomfile.seek( randomfile.getFilePointer() - 4 * 1);
	         //  ...1...2|...3
	         randomfile.writeInt(x);
		   //  ...1...2..23|

	         randomfile.seek(0);
	         //  |...1...2..23
	         for (int i=1; i<=3; i++)
	             System.out.println(" " + randomfile.readInt());
		   //  ...1...2..23|

 

		   randomfile.close();


		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
	}
}


