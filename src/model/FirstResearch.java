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
    public FirstResearch() {
    }

    public FirstResearch(GregorianCalendar startDate, String objectName, String collectiveName) throws DAOException {
        setStartDate(startDate);
        setObjectName(objectName);
        setCollectiveName(collectiveName);
    }

    // Setters
    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setCollectiveName(String collectiveName)  {
        this.collectiveName = collectiveName;
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
