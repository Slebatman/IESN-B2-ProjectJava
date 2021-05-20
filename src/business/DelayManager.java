package business;

import dataAcces.RentalDB;
import dataAcces.dao.IRentalDAO;
import exception.DAOException;
import exception.ModelException;
import model.Delay;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    //Tache Métier
    public ArrayList<Delay> getTacheMetier() throws DAOException, ModelException {
        ArrayList<Delay> rentals = this.dao.getTacheMetier();
        ArrayList<Delay> delays = new ArrayList<>();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar today = new GregorianCalendar();
        Date todayDate = today.getTime();
        GregorianCalendar startDate = new GregorianCalendar();

        for(Delay delay : rentals){
            startDate = delay.getStartDate();
            //formatDate.format(startDate.getTime());
            double diff =  ((double)(today.getTime().getTime() - startDate.getTime().getTime())) / (1000 * 60 * 60 *24);
            int days = (int)diff;
            if(diff > delay.getMaxRentalPeriod()){
                delay.setNbDaysDelay(days);
                delays.add(delay);
            }
        }

        return delays;
    }
}
