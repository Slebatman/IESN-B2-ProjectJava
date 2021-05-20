package model;

import exception.ModelException;

public class TypeOfProblemRental {
    // Variables
    private Integer idTypeOfProblemRental;
    private String name;
    private String description;

    // Constructor
    public TypeOfProblemRental(int idTypeOfProblemRental, String name, String description) throws ModelException {
        setIdTypeOfProblemRental(idTypeOfProblemRental);
        setName(name);
        setDescription(description);
    }

    // Setters
    public void setIdTypeOfProblemRental(Integer idTypeOfProblemRental) {
        this.idTypeOfProblemRental = idTypeOfProblemRental;
    }

    public void setName(String name) throws ModelException {
        if (name.equals("")) throw new ModelException("Le nom ne peut pas être une chaine vide");
        this.name = name;
    }

    public void setDescription(String description) throws ModelException {
        if (description.equals("")) throw new ModelException("La description ne peut pas être une chaine vide");
        this.description = description;
    }

    // Getters
    public Integer getIdTypeOfProblemRental() {
        return idTypeOfProblemRental;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // ToString for debug
    @Override
    public String toString() {
        return "TypeOfProblemRental{" +
                "idTypeOfProblemRental=" + idTypeOfProblemRental +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
