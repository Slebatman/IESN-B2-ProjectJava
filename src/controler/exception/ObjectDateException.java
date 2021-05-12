package controler.exception;

import java.util.GregorianCalendar;

public class ObjectDateException extends Exception{
    private GregorianCalendar date;

    public ObjectDateException(GregorianCalendar date){
        this.date = date;
    }

    @Override
    public String getMessage(){
        return this.date + " n'est pas une valeur correcte pour la date";
    }
}
