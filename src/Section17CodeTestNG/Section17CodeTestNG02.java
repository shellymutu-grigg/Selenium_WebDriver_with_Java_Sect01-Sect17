package Section17CodeTestNG;

import java.text.MessageFormat;

import org.testng.annotations.Test;

public class Section17CodeTestNG02 extends Section17CodeTestNG01 {

	@Test
	public void Sect17_TestNG_02() {
		// If extends is not present you need to create an object
		Section17CodeTestNG03 obj03 = new Section17CodeTestNG03(3);

		int count = 3;

		Sect17_TestNG_01();

		System.out.println(MessageFormat.format("Call incement: {0}", obj03.Sect17_TestNG_03_increment()));
		System.out.println(MessageFormat.format("Call decement: {0}", obj03.Sect17_TestNG_03_decrement()));

		// Section17CodeTestNG04 obj04 = new Section17CodeTestNG04(count);
		// System.out.println(MessageFormat.format("Call multiply by two: {0}",
		// obj04.Sect17_TestNG_04_multiplyByTwo()));
		// System.out
		// .println(MessageFormat.format("Call multiply by three: {0}",
		// obj04.Sect17_TestNG_04_multiplyByThree()));
		System.out.println(MessageFormat.format("Call multiply by two: {0}", obj03.Sect17_TestNG_04_multiplyByTwo()));
	}
}
