package business;

import dataAcces.RentalDB;
import dataAcces.dao.IRentalDAO;
import exception.DAOException;
import exception.ModelException;
import model.Delay;

import java.util.ArrayList;
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

        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar startDate = new GregorianCalendar();

        for(Delay delay : rentals){
            startDate = delay.getStartDate();
            int days = diffDays(today, startDate);
            if(days > delay.getMaxRentalPeriod()){
                delay.setNbDaysDelay(days);
                int nbRecalls = nbRecalls(days);
                delay.setNbRecalls(nbRecalls + 1); // A recall is also send at day 0
                delays.add(delay);
            }
        }
        return delays;
    }

    public int diffDays(GregorianCalendar today, GregorianCalendar startDate){
        return (int) ((double)(today.getTime().getTime() - startDate.getTime().getTime())) / (1000 * 60 * 60 *24);
    }

    public int nbRecalls(int days){
        return days/7;
    }
}
