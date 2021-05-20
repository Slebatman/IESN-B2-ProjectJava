package model;

import exception.ModelException;

public class Collective {
    // Variables
    private Integer idCollective;
    private String name;
    private String category;
    private String physicalAddress;
    private String emailAddress;

    // Constructors
    public Collective(String name, String category, String physicalAddress, String emailAddress) throws ModelException {
        setName(name);
        setCategory(category);
        setPhysicalAddress(physicalAddress);
        setEmailAddress(emailAddress);
    }

    public Collective(int idCollective, String name, String category, String physicalAddress, String emailAddress) throws ModelException {
        this(name, category, physicalAddress, emailAddress);
        setIdCollective(idCollective);
    }

    // Setters
    public void setIdCollective(Integer idCollective) throws ModelException {
        if (idCollective < 1) throw new ModelException("L'identifiant doit être suppérieur à 0");
        this.idCollective = idCollective;
    }

    public void setName(String name) throws ModelException {
        if (name.equals("")) throw new ModelException("Le nom ne peut pas être une chaine vide");
        this.name = name;
    }

    public void setCategory(String category) throws ModelException {
        if (category.equals("")) throw new ModelException("La categorie ne peut pas être une chaine vide");
        this.category = category;
    }

    public void setPhysicalAddress(String physicalAddress) throws ModelException {
        if (physicalAddress.equals("")) throw new ModelException("L'adresse ne peut pas être une chaine vide");
        this.physicalAddress = physicalAddress;
    }

    public void setEmailAddress(String emailAddress) throws ModelException {
        if (emailAddress.equals("")) throw new ModelException("L'email ne peut pas être une chaine vide");
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
