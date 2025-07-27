package ui;

import java.sql.Date;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import exception.QueryException;
import model.Intern;
import model.Promotion;
import model.Question;
import service.InternService;
import service.PromotionService;
import service.QuestionService;

public class InputUI {
	
	private static final InputUI INSTANCE = new InputUI();
	private PrintUI ui;
	private InternService internService;
	private PromotionService promotionService;
	private QuestionService questionService;
	private Scanner scanner;

    private InputUI() {
		internService = InternService.getInstance();
		promotionService = PromotionService.getInstance();
		questionService = QuestionService.getInstance();
		ui = PrintUI.getInstance();

    }

    public static InputUI getInstance() {
        return INSTANCE;
    }

    public void scanMainMenu() throws SQLException, QueryException {
    	scanner = new Scanner(System.in);
    	int id;
    	int initialPage;
    	int numbersItemsPage;
    	
    	while (true) {
    		ui.showMainMenu();
            try {
            	switch (scanner.nextInt()) {
        		case 1:
        			ui.showSentenceInitialPage();
        			initialPage = scanInt();
        			ui.showSentenceNumberItemsPages();
        			numbersItemsPage = scanInt();
        			List<Intern> interns = null;
        			
        			if (initialPage > 0) {
            			interns = new InternPage(initialPage, numbersItemsPage).getPageData();
        			} else {
        				ui.showSentenceErrorNumber();
        			}
        			
        			if (interns != null) {
        				System.out.println(interns);
        			} else {
        				ui.showSentenceErrorQuery();
        			}
        			break;
        		case 2:
        			List<Promotion> promotions = promotionService.selectPromotions();
        			
        			if (promotions != null) {
        				System.out.println(promotions);
        			} else {
        				ui.showSentenceErrorQuery();
        			}
        			break;
        		case 3:
        			ui.showSentenceId();
        			id = scanInt();
        			Optional<Intern> intern = internService.selectIntern(id);
        			
        			if (intern.isPresent()) {
        				System.out.println(intern);
        			} else {
        				ui.showSentenceErrorQuery();
        			}
        			break;
        		case 4:
        			ui.showSentenceId();
        			id = scanInt();
        			Optional<Question> question = questionService.selectQuestion(id);
        			
        			if (question != null) {
        				System.out.println(question);
        			} else {
        				ui.showSentenceErrorQuery();
        			}
        			break;
        		case 5:
        			if (internService.insertIntern(scanInternData())) {
        				ui.showSentenceSuccessfulQuery();
        			} else {
        				ui.showSentenceErrorQuery();
        			}
        			break;
        		case 6:
        			ui.showSentenceId();
        			id = scanInt();
        			
        			if (internService.updateIntern(id, scanInternData())) {
        				ui.showSentenceSuccessfulQuery();
        			} else {
        				ui.showSentenceErrorQuery();
        			}
        			break;
        		case 7:
        			ui.showSentenceId();
        			id = scanInt();

        			if (internService.deleteIntern(id)) {
        				ui.showSentenceSuccessfulQuery();
        			} else {
        				ui.showSentenceErrorQuery();
        			}
        			break;
        		default:
        			ui.showSentenceErrorNumber();
        			break;
            	}
            }
            catch (InputMismatchException e) {
            	ui.showSentenceErrorInput();
                scanner.nextLine();
            }
        }
    }

    public Intern scanInternData() throws SQLException {
		ui.showSentenceIntern();
		String firstName = scanString();
		String lastName = scanString();
		Date arrival = scanDate(true, null);
		Date formationOver = scanDate(false, arrival);

    	return new Intern.InternBuilder(firstName, lastName, arrival.toLocalDate(), 
    			new Promotion.PromotionBuilder(scanInt(), "lul").build()
    			).setFormationOver(formationOver.toLocalDate()).build();
    }

    public int scanInt() throws SQLException {
    	while (true) {
            try {
            	return scanner.nextInt();
            }
            catch (InputMismatchException e) {
            	ui.showSentenceErrorInput();
                scanner.nextLine();
            }
        }
    }

    public String scanString() throws SQLException {
    	while (true) {
            try {
                return scanner.nextLine();
            }
            catch (NoSuchElementException e) {
            	ui.showSentenceErrorInput();
            }
        }
    }

    public Date scanDate(boolean required, Date firstDate) throws SQLException {
    	String input;
    	Date lastDate;
    	
    	while (true) {
            try {
            	input = scanner.nextLine();
            	
            	if (required == false && input.isEmpty()) {
            		return null;
            	}
            	
            	lastDate = Date.valueOf(input);
            	
        		if (lastDate.toLocalDate().isAfter(firstDate.toLocalDate())) {
                	return Date.valueOf(input);
        		}
        		
        		ui.showSentenceErrorDateNotAfter();
            }
            catch (IllegalArgumentException e) {
            	ui.showSentenceErrorInput();
            }
        }
    }
}
