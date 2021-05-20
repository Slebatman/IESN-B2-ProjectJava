package controller;

import business.DelayManager;
import exception.DAOException;
import exception.ModelException;
import model.Delay;

import java.util.ArrayList;

public class DelayControler {
    private DelayManager manager;

    public DelayControler(){
        setManager(new DelayManager());
    }

    private void setManager(DelayManager manager) {
        this.manager = manager;
    }

    public ArrayList<Delay> getTacheMetier() throws DAOException, ModelException{
        return manager.getTacheMetier();
    }
}
