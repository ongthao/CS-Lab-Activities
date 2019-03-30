/*Name: Ong Thao
 * Program description: Purpose of this program is to use double link lists to store long numbers with a few features.
 * Date Created: 2/15/19
 */

import java.util.*;
import java.io.*;

public class LongNumDouble {
	public static void main(String[] args) throws IOException {
		create();
	}

	public static void create() throws IOException {
		File f = new File("Long Numbers.txt");
		Scanner input = new Scanner(f);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			Scanner token = new Scanner(line);
			String fi = token.next();
			String s = token.next();
			Node first = new Node(Character.getNumericValue(fi.charAt(0)));
			DoubleLink list1 = new DoubleLink(first);
			Node second = new Node(Character.getNumericValue(s.charAt(0)));
			DoubleLink list2 = new DoubleLink(second);
			for (int i = 1; i < fi.length(); i++) {
				list1.addLeastSignificant(Character.getNumericValue(fi.charAt(i)));
			}
			for (int i = 1; i < s.length(); i++) {
				list2.addLeastSignificant(Character.getNumericValue(s.charAt(i)));
			}
			System.out.println(list1.toString() + " + " + list2.toString() + " = " + list1.add(list2));
			System.out.println("inserting the digit 9 at position 3 to num1");
			list1.insert(3, 9);
			System.out.println("inserting the digit 7 at position 4 to num2");
			list2.insert(4, 7);
			System.out.println(list1.toString() + " + " + list2.toString() + " = " + list1.add(list2));
			System.out.println(
					"Adding a \'9\' and \'3\' to the least significant position to num1 and num2, respectively");
			list1.addLeastSignificant(9);
			list2.addLeastSignificant(3);
			System.out.println(list1.toString() + " + " + list2.toString() + " = " + list1.add(list2));
		}
	}
}