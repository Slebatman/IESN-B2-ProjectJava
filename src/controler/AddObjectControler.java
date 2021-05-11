package controler;
import type.*;

public class AddObjectControler {
    private AddObjectBusiness business;
    public AddObjectControler(){
        business = new AddObjectBusiness();
    }
    public void addObject(Object object){
        business.addObject(object);
    }
}
