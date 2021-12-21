package program;

import java.util.ArrayList;


public class ErrorsManager {

	//Singleton
	private static ErrorsManager errorsManager = new ErrorsManager();
	private ErrorsManager() {
		super();
	}
	public static ErrorsManager getErrorsManager() {
		return errorsManager;
	}
	
	//Class
	//TODO Come in future!
	private ArrayList<String> errorMessages = new ArrayList<>();
	
	public void addErrorMessage(String error) {
		errorMessages.add(error);
	}
	public ArrayList<String> getErrorMessages() {
		return errorMessages;
	}
	public void printErrors() {
		if (!errorMessages.isEmpty()) {
			for (int i = 0; i < errorMessages.size(); i++) {
				System.err.println(errorMessages.get(i));
			}
		}
	}
}
