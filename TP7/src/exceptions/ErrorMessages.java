package exceptions;

import java.util.List;

public class ErrorMessages extends Exception {
	private List<String> messages;
	
	public ErrorMessages(List<String> messages) {
		this.messages = messages;
	}
	
	public String toString() {
		String errorMessage = "ERROR: ";
		
		int count = 0;
		while (count < this.messages.size()) {
			errorMessage += "\n  " + this.messages.get(count);
			count++;
		}
		
		return errorMessage;
	}
}
