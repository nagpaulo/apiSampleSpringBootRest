package br.com.projeto.apisamplerest.security.exception;

public class RegraNegocioException extends RuntimeException {

	private static final long serialVersionUID = -2827422931736521235L;

	public RegraNegocioException(String message) {
		super(message);
	}
}
