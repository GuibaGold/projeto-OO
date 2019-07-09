package excecoes;

public class ValorInvalidoException extends Exception {

	public ValorInvalidoException() {
		
	}

	public ValorInvalidoException(String message, Exception cause) {
		super(message, cause);
	}
}
