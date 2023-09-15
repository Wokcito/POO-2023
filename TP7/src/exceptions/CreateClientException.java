package exceptions;

import java.util.List;

public class CreateClientException extends ErrorMessages {
	public CreateClientException(List<String> messages) {
		super(messages);
	}
}
