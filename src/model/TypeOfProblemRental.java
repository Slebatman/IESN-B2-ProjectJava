package model;

public class TypeOfProblemRental {
    // Variables
    private Integer idTypeOfProblemRental;
    private String name;
    private String description;

    // Constructor
    public TypeOfProblemRental(int idTypeOfProblemRental, String name, String description) {
        setIdTypeOfProblemRental(idTypeOfProblemRental);
        setName(name);
        setDescription(description);
    }

    // Setters
    public void setIdTypeOfProblemRental(Integer idTypeOfProblemRental) {
        this.idTypeOfProblemRental = idTypeOfProblemRental;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
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
