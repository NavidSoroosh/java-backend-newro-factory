package ui;

public class PrintUI {
	
	private static final PrintUI INSTANCE = new PrintUI();

    private PrintUI() {
    }

    public static PrintUI getInstance() {
        return INSTANCE;
    }

    public void showMainMenu () {
      	System.out.println("Entrez un chiffre pour effectuer une des actions suivantes :");
        System.out.println("1 - Lister les stagiaires");
        System.out.println("2 - Lister les promotions ");
        System.out.println("3 - Afficher le détail d'un stagiaire");
        System.out.println("4 - Afficher le détail d'une question");
        System.out.println("5 - Créer un stagiaire");
        System.out.println("6 - Editer un stagiaire");
        System.out.println("7 - Supprimer un stagiaire");
    }

    public void showSentenceIntern() {
        System.out.println("Entrez les données du stagiaire dans l'ordre (prénom, nom, dates d'arrivée et de fin de promotion, id de promotion) :");
    }

    public void showSentenceId() {
        System.out.println("Entrez un id valide :");
    }

    public void showSentenceInitialPage() {
        System.out.println("Entrez le numéro de page initial :");
    }

    public void showSentenceNumberItemsPages() {
        System.out.println("Entrez le nombre d'éléments par page :");
    }

    public void showSentenceString(String nameParam) {
        System.out.println("Entrez un + " + nameParam + " valide :");
    }

    public void showSentenceDate() {
        System.out.println("Entrez une date au format yyyy-mm-dd :");
    }

    public void showSentenceErrorDateNotAfter() {
        System.out.println("La date de fin de formation doit être après celle d'arrivée.");
    }

    public void showSentenceErrorInput() {
        System.out.println("Format incorrect, réessayez.");
    }

    public void showSentenceSuccessfulQuery() {
        System.out.println("La requête a bien été réalisée.");
    }
    
    public void showSentenceErrorQuery() {
        System.out.println("La requête n'a pas pu être réalisée.");
    }

    public void showSentenceErrorNumber() {
        System.out.println("Nombre incorrect.");
    }
    
    public void showSentenceErrorId() {
        System.out.println("L'id n'existe pas.");
    }
}
