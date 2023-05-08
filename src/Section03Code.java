public class Section03Code {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myNum = 5;
		String website = "Rahul Shetty Academy";
		char letter = 'r';
		double dec = 5.99;
		boolean myCard = true;

		System.out.println(myNum + "is the value stored in the myNum variable");
		System.out.println(website);

		// Arrays -
		int[] arr = new int[5];// 5, 10
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 5;
		arr[4] = 6;

		int[] arr2 = { 1, 2, 4, 5, 6 };

		System.out.println(arr2[0]);

		// for loop arr.length - 5
		for (int i = 0; i < arr.length; i++) // 4
		{
			System.out.println(arr[i]);
		}

		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		String[] name = { "rahul", "shetty", "selenium" };

		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}

		for (String s : name) {
			System.out.println(s);
		}

		// A string is an object //String literal
		// String s1 = "Rahul Shetty Academy";

		String s5 = "hello";

		// new
		String s2 = new String("Welcome");
		String s3 = new String("Welcome");
		String s = "Rahul Shetty Academy";

		String[] splitString = s.split("Shetty");

		System.out.println(splitString[0]);
		System.out.println(splitString[1]);
		System.out.println(splitString[1].trim());

		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.println(s.charAt(i));
		}
	}
}
