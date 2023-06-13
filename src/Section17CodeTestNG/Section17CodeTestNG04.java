package Section17CodeTestNG;

public class Section17CodeTestNG04 {

	int count;

	public Section17CodeTestNG04(int count) {
		this.count = count;
	}

	public int Sect17_TestNG_04_multiplyByTwo() {
		count = count * 2;
		return count;
	}

	public int Sect17_TestNG_04_multiplyByThree() {
		count = count * 3;
		return count;
	}
}
