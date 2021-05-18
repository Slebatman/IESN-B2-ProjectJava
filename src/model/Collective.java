package model;

public class Collective {
    // Variables
    private Integer idCollective;
    private String name;
    private String category;
    private String physicalAddress;
    private String emailAddress;

    // Constructors
    public Collective(String name, String category, String physicalAddress, String emailAddress) {
        setName(name);
        setCategory(category);
        setPhysicalAddress(physicalAddress);
        setEmailAddress(emailAddress);
    }

    public Collective(int idCollective, String name, String category, String physicalAddress, String emailAddress) {
        this(name, category, physicalAddress, emailAddress);
        setIdCollective(idCollective);
    }

    // Setters
    public void setIdCollective(Integer idCollective) {
        this.idCollective = idCollective;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    // Getters
    public Integer getIdCollective() {
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

    // ToString for debug
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
