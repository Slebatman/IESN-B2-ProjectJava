package Model;

public class TypeOfProblemRental {
    // Link to DB
    private int idTypeOfProblemRental;
    private String name;
    private String description;

    // Constructor
    public TypeOfProblemRental(int idTypeOfProblemRental, String name, String description) {
        this.idTypeOfProblemRental = idTypeOfProblemRental;
        this.name = name;
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
}
