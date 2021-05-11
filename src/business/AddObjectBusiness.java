package business;
import type.*;
import type.Object;

public class AddObjectBusiness {

    public AddObjectBusiness(){

    }
    public void addObject(Object object){
        System.out.println(object.getName());
        System.out.println(object.getPurchaseDate());
        System.out.println(object.getMaxRentalPeriod());
    }
}
