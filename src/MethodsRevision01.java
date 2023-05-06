
public class MethodsRevision01 {

	public static void main(String[] args) {

		MethodsRevision01 methodsRevision01 = new MethodsRevision01();
		methodsRevision01.getData();

		MethodsRevision02 methodsRevision02 = new MethodsRevision02();
		System.out.println("MethodsRevision02 getUserData() result: " + methodsRevision02.getUserData());

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
