import java.text.MessageFormat;

public class Section34Code {

	public static void main(String[] args) {
		int i = 10;

		while (i < 10) {
			System.out.println(MessageFormat.format("i is {0}", i));

			// Ensure to decrement rather than increment
			i--;
		}

	}

}
