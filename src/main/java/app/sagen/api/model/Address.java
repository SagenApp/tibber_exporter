package app.sagen.api.model;

import java.util.Objects;

public final class Address {
    private final String address1;
    private final String address2;
    private final String address3;
    private final String city;
    private final String postalCode;
    private final String country;
    private final String latitude;
    private final String longitude;

    public Address(
            String address1,
            String address2,
            String address3,
            String city,
            String postalCode,
            String country,
            String latitude,
            String longitude
    ) {
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String address1() {
        return address1;
    }

    public String address2() {
        return address2;
    }

    public String address3() {
        return address3;
    }

    public String city() {
        return city;
    }

    public String postalCode() {
        return postalCode;
    }

    public String country() {
        return country;
    }

    public String latitude() {
        return latitude;
    }

    public String longitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Address) obj;
        return Objects.equals(this.address1, that.address1) &&
                Objects.equals(this.address2, that.address2) &&
                Objects.equals(this.address3, that.address3) &&
                Objects.equals(this.city, that.city) &&
                Objects.equals(this.postalCode, that.postalCode) &&
                Objects.equals(this.country, that.country) &&
                Objects.equals(this.latitude, that.latitude) &&
                Objects.equals(this.longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address1, address2, address3, city, postalCode, country, latitude, longitude);
    }

    @Override
    public String toString() {
        return "Address[" +
                "address1=" + address1 + ", " +
                "address2=" + address2 + ", " +
                "address3=" + address3 + ", " +
                "city=" + city + ", " +
                "postalCode=" + postalCode + ", " +
                "country=" + country + ", " +
                "latitude=" + latitude + ", " +
                "longitude=" + longitude + ']';
    }
}
