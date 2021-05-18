package model;

import business.CollectiveManager;
import business.OneObjectManager;
import exception.DAOException;

import java.util.GregorianCalendar;

public class FirstResearch {
    // Variables
    private GregorianCalendar startDate;
    private String objectName;
    private String collectiveName;

    // Constructors
    public FirstResearch(Rental rental) throws DAOException {
        setStartDate(rental.getStartDate());
        setObjectName(rental.getIdObject());
        setCollectiveName(rental.getIdTenant());
    }

    // Setters
    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public void setObjectName(int idObject) throws DAOException {
        OneObjectManager oneObjectManager = new OneObjectManager();
        this.objectName = oneObjectManager.getObjectByID(idObject).getName();
    }

    public void setCollectiveName(int idCollective) throws DAOException {
        CollectiveManager collectiveManager = new CollectiveManager();
        this.collectiveName = collectiveManager.getACollectiveBasedId(idCollective).getName();
    }

    // Getters
    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public String getCollectiveName() {
        return collectiveName;
    }

    public String getObjectName() {
        return objectName;
    }

    // ToString for debug
    @Override
    public String toString() {
        return "FirstResearch{" +
                "startDate=" + startDate +
                ", objectName='" + objectName + '\'' +
                ", collectiveName='" + collectiveName + '\'' +
                '}';
    }
}
