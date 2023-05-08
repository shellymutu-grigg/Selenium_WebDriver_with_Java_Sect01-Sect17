
public class Section03Code_MethodsRevision01 {

	public static void main(String[] args) {

		Section03Code_MethodsRevision01 section03Code_MethodsRevision01 = new Section03Code_MethodsRevision01();
		section03Code_MethodsRevision01.getData();

		Section03Code_MethodsRevision02 section03Code_MethodsRevision02 = new Section03Code_MethodsRevision02();
		System.out.println("MethodsRevision02 getUserData() result: " + section03Code_MethodsRevision02.getUserData());

		System.out.println("MethodsRevision01 getDataStatic() result: " + getDataStatic());

	}

	public void getData() {

		System.out.println("MethodsRevision01 getData() method entered");
	}

	public static String getDataStatic() {

		System.out.println("MethodsRevision01 getDataStatic() method entered");
		return "User Data Static MethodsRevision01";
	}

}
