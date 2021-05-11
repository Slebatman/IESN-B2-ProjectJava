package type;

public class Collective {
    // Link to DB
    private int idCollective;
    private String name;
    private String category;
    private String physicalAdress;
    private String emailAdress;

    public Collective(String name, String category, String physicalAdress, String emailAdress) {
        this.name = name;
        this.category = category;
        this.physicalAdress = physicalAdress;
        this.emailAdress = emailAdress;
    }

    public Collective(int idCollective, String name, String category, String physicalAdress, String emailAdress) {
        this(name, category, physicalAdress, emailAdress);
        this.idCollective = idCollective;
    }

    public int getIdCollective() {
        return idCollective;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPhysicalAdress() {
        return physicalAdress;
    }

    public String getEmailAdress() {
        return emailAdress;
    }
}
