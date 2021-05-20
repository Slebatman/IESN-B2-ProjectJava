package business;

import dataAcces.RentalDB;
import dataAcces.dao.IRentalDAO;

import java.sql.Connection;

public class DelayManager {
    // Variable
    private IRentalDAO dao;

    // Constructor
    public DelayManager() {
        setDao();
    }

    // Setter
    private void setDao() {
        this.dao = new RentalDB();
    }

    //
}
