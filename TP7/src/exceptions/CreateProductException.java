package exceptions;

import java.util.List;

public class CreateProductException extends ErrorMessages {
	public CreateProductException(List<String> messages) {
		super(messages);
	}
}
