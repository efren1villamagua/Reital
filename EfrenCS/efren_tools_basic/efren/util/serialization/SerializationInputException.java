package efren.util.serialization;

public class SerializationInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7791586277659848084L;

	/**
	 * 
	 */
	public SerializationInputException() {
		super();
	}
	/**
	 * 
	 */
	public SerializationInputException(String message) {
		super(message);
	}
	
	/**
	 * 
	 */
    public SerializationInputException(String message, Throwable cause) {
        super(message, cause);
    }

}
