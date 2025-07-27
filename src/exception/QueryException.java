package exception;

public class QueryException extends Exception {
	
	private String message = "Erreur lors de l'accès à la base de données.";
	
	public void printExceptionMessage() {
		System.out.println(message);
	}

}
