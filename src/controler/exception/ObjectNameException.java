package controler.exception;

public class ObjectNameException extends Exception{
    private String name;
    public ObjectNameException(String name){
        this.name = name;
    }

    @Override
    public String getMessage(){
        return this.name + " n'est pas une valeur correcte pour le nom de l'objet";
    }
}
