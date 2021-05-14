package dataAcces;

import type.Rental;

import java.util.GregorianCalendar;

public class FirstResearchManager {
    // Variables
    private GregorianCalendar startDate;
    private String objectName;
    private String collectiveName;

    // Constructors
    public FirstResearchManager(Rental rental) {
        setStartDate(rental.getStartDate());
        setObjectName(rental.getIdObject());
        setCollectiveName(rental.getIdTenant());
    }

    // Setters
    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public void setObjectName(int idObject) {
        OneObjectManager oneObjectManager = new OneObjectManager();
        this.objectName = oneObjectManager.getObjectByID(idObject).getName();
    }

    public void setCollectiveName(int idCollective) {
        CollectiveManager collectiveManager = new CollectiveManager();
        this.collectiveName = collectiveManager.searchACollectiveBasedId(idCollective).getName();
    }

    // ToString
    @Override
    public String toString() {
        return "FirstResearchManager{" +
                "startDate=" + startDate +
                ", objectName='" + objectName + '\'' +
                ", collectiveName='" + collectiveName + '\'' +
                '}';
    }
}
