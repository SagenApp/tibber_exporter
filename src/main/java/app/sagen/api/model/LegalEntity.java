package app.sagen.api.model;

import java.util.Objects;

public final class LegalEntity {
    private final String id;
    private final String firstName;
    private final boolean isCompany;
    private final String name;
    private final String middleName;
    private final String lastName;
    private final String organizationNo;
    private final String language;
    private final ContactInfo contactInfo;
    private final Address address;

    public LegalEntity(
            String id,
            String firstName,
            boolean isCompany,
            String name,
            String middleName,
            String lastName,
            String organizationNo,
            String language,
            ContactInfo contactInfo,
            Address address
    ) {
        this.id = id;
        this.firstName = firstName;
        this.isCompany = isCompany;
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.organizationNo = organizationNo;
        this.language = language;
        this.contactInfo = contactInfo;
        this.address = address;
    }

    public String id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public boolean isCompany() {
        return isCompany;
    }

    public String name() {
        return name;
    }

    public String middleName() {
        return middleName;
    }

    public String lastName() {
        return lastName;
    }

    public String organizationNo() {
        return organizationNo;
    }

    public String language() {
        return language;
    }

    public ContactInfo contactInfo() {
        return contactInfo;
    }

    public Address address() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (LegalEntity) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.firstName, that.firstName) &&
                this.isCompany == that.isCompany &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.middleName, that.middleName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.organizationNo, that.organizationNo) &&
                Objects.equals(this.language, that.language) &&
                Objects.equals(this.contactInfo, that.contactInfo) &&
                Objects.equals(this.address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, isCompany, name, middleName, lastName, organizationNo, language, contactInfo, address);
    }

    @Override
    public String toString() {
        return "LegalEntity[" +
                "id=" + id + ", " +
                "firstName=" + firstName + ", " +
                "isCompany=" + isCompany + ", " +
                "name=" + name + ", " +
                "middleName=" + middleName + ", " +
                "lastName=" + lastName + ", " +
                "organizationNo=" + organizationNo + ", " +
                "language=" + language + ", " +
                "contactInfo=" + contactInfo + ", " +
                "address=" + address + ']';
    }
}
