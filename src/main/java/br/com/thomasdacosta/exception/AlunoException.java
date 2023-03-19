package br.com.thomasdacosta.exception;

public class AlunoException extends RuntimeException {

	private static final long serialVersionUID = -7737840351898585883L;

	public AlunoException() {
    }

    public AlunoException(String message) {
        super(message);
    }

    public AlunoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlunoException(Throwable cause) {
        super(cause);
    }

    public AlunoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
