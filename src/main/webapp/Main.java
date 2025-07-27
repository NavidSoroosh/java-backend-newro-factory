package main.webapp;
import java.sql.SQLException;

import exception.QueryException;
import ui.InputUI;

public class Main {

	public static void main(String[] args) throws SQLException, QueryException {
		InputUI service = InputUI.getInstance();
		service.scanMainMenu();
	}
}
