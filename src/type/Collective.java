package type;

public class Collective {
    // Link to DB
    private int idCollective;
    private String name;
    private String category;
    private String physicalAddress;
    private String emailAddress;

    public Collective(String name, String category, String physicalAddress, String emailAddress) {
        this.name = name;
        this.category = category;
        this.physicalAddress = physicalAddress;
        this.emailAddress = emailAddress;
    }

    public Collective(int idCollective, String name, String category, String physicalAddress, String emailAddress) {
        this(name, category, physicalAddress, emailAddress);
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

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Collective{" +
                "idCollective=" + idCollective +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
