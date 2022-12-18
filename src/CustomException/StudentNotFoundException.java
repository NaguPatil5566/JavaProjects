package CustomException;

/**
 * 
 * @author HP
 * @since 2021
 *
 *we are adding implementation for 8 abstract methods StudentManagementSystem
 *
 */
public class StudentNotFoundException extends RuntimeException {
	
	private String message;

	public StudentNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
