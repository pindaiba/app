package infra.exception;

/**
 * Created by theo on 15/09/15.
 */
public class BusinessException extends PindaibaException{

    public BusinessException(String mensagem){
        super(mensagem);
    }
}
