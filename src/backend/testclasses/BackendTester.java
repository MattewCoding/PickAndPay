package backend.testclasses;

import backend.postgresql.PostgreSqlRequestSender;

public class BackendTester {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Works");
		if(PostgreSqlRequestSender.addUser("Smith", "John", 'M', '3', "jsmith@gmail.com", "horogame", "airprt#$lol")) {
			System.out.println("User added.");
		}
		
	}

}
