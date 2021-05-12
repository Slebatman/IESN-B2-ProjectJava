package controler.exception;

public class ObjectCommandableException extends Exception{
    private Boolean commandable;

    public ObjectCommandableException(Boolean commandable){
        this.commandable = commandable;
    }

    @Override
    public String getMessage(){
        return commandable + " n'est pas une valeur correcte pour la valeur commandable de l'objet";
    }
}
