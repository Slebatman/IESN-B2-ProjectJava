package model;

public class TypeOfProblemRental {
    // Variables
    private int idTypeOfProblemRental;
    private String name;
    private String description;

    // Constructor
    public TypeOfProblemRental(int idTypeOfProblemRental, String name, String description) {
        setIdTypeOfProblemRental(idTypeOfProblemRental);
        setName(name);
        setDescription(description);
    }

    // Setters
    public void setIdTypeOfProblemRental(int idTypeOfProblemRental) {
        this.idTypeOfProblemRental = idTypeOfProblemRental;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getters
    public int getIdTypeOfProblemRental() {
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
