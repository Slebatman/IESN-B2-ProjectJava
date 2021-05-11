package controler;
import business.*;
import type.*;
import type.Object;

public class AddObjectControler {
    private AddObjectBusiness business;
    public AddObjectControler(){
        business = new AddObjectBusiness();
    }
    public void addObject(Object object){
        business.addObject(object);
    }
}
