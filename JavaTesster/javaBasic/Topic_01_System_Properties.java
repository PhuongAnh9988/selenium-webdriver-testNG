package javaBasic;

public class Topic_01_System_Properties {

	public static void main(String[] args) {
		String projectPath = System.getProperty("User.dir");
		System.out.println(projectPath);
		
	}

}
