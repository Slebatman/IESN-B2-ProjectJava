package model.research;

import exception.ModelException;

import java.util.GregorianCalendar;

public class FirstResearch {
    // Variables
    private GregorianCalendar startDate;
    private String objectName;
    private String collectiveName;

    // Constructors

    public FirstResearch(GregorianCalendar startDate, String objectName, String collectiveName) throws ModelException {
        setStartDate(startDate);
        setObjectName(objectName);
        setCollectiveName(collectiveName);
    }

    // Setters
    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public void setObjectName(String objectName) throws ModelException {
        if (objectName.equals("")) throw new ModelException("Le nom ne peut pas être une chaine vide");
        this.objectName = objectName;
    }

    public void setCollectiveName(String collectiveName) throws ModelException {
        if (collectiveName.equals("")) throw new ModelException("Le nom ne peut pas être une chaine vide");
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
