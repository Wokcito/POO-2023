package exceptions;

import java.util.List;

public class CreatePurchaseException extends ErrorMessages {
	public CreatePurchaseException(List<String> messages) {
		super(messages);
	}
}
