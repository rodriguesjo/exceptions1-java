package model.exceptions;

/**
 * Classe personalizada para tratar exceções relacionadas ao domínio da aplicação.
 * Estende RuntimeException para ser uma exceção não verificada (unchecked exception).
 * Essa classe é usada para capturar e tratar erros relacionados às regras de negócio 
 * ou domínio da aplicação.
 */
public class DomainException extends RuntimeException {
    
    /* Serial version UID (identificador único para a serialização da classe)
     * Esse atributo é usado para identificar a versão da classe durante a 
     * serialização (processo de transformar um objeto em bytes para armazenar ou transmitir)
     * É uma boa prática incluir esse campo em classes que estendem Serializable 
     * (como as subclasses de RuntimeException)
	*/
    private static final long serialVersionUID = 1L;

    /**
     * Construtor da classe DomainException.
     * 
     * @param msg Mensagem de erro que será associada à exceção.
     *            Essa mensagem será passada para a classe RuntimeException.
     */
    public DomainException(String msg) {
    	/*
    	 * O construtor aceita uma mensagem (msg) que descreve o erro. 
    	 * Essa mensagem é passada para o construtor da superclasse 
    	 * RuntimeException para que possa ser recuperada com o método getMessage()
    	 */
        super(msg); // Chama o construtor da superclasse (RuntimeException) com a mensagem fornecida
    }
}
