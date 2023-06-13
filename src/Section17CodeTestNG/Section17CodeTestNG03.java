package Section17CodeTestNG;

public class Section17CodeTestNG03 extends Section17CodeTestNG04 {

	int count;

	public Section17CodeTestNG03(int count) {
		// Need to assign to parent super constructor must come first
		super(count);
		this.count = count;
	}

	public int Sect17_TestNG_03_increment() {
		count = count + 1;
		return count;
	}

	public int Sect17_TestNG_03_decrement() {
		count = count - 1;
		return count;
	}
}
