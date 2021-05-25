package controller;

import business.DelayManager;
import exception.DAOException;
import exception.ModelException;
import model.Delay;

import java.util.ArrayList;

public class DelayController {
    // Variable
    private DelayManager manager;

    // Constructor
    public DelayController(){
        setManager(new DelayManager());
    }

    // Setter
    private void setManager(DelayManager manager) {
        this.manager = manager;
    }

    // (Job task) Late rentals and number of days in delay.
    public ArrayList<Delay> getJobTask() throws DAOException, ModelException{
        return manager.getJobTask();
    }
}
