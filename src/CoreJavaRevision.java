import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CoreJavaRevision {

	public static void main(String[] args) {
		//ArrayList practice
		ArrayList<String> arrayList = new ArrayList();
		arrayList.add("Record 1");
		arrayList.add("Record 2");
		arrayList.add("Record 3");
		arrayList.remove(1);
		
		System.out.println("ArrayList records: " + arrayList.toString());	
		
		System.out.println("ArrayList size: " + arrayList.size());
		
		//Modified for loop
		for(String item : arrayList) 
		{
			System.out.println("ArrayList record: " + item);
		}
		
		//Determine if an item is in an ArrayList
		System.out.println("ArrayList record 2 present: " + arrayList.contains("Record 2"));
	
		//Convert an Array to an ArrayList
		String[] names = {"Gerardo", "Juan", "Jose"};
		List<String> namesList = Arrays.asList(names);
		
		//String Literals - String is an Object that represents a sequence of characters
		String first = "First string";
		String second = "First string"; //This will create a reference to "first" rather than create new object in memory
		
		// Using "new" key word
		String third = new String("First string"); //This creates a new object in memory
		String fourth = new String("First string"); //This creates a new object in memory
	}
}
