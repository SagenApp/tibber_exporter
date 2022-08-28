package app.sagen.api.model;

import java.util.Objects;

public final class ContactInfo {
    private final String email;
    private final String mobile;

    public ContactInfo(
            String email,
            String mobile
    ) {
        this.email = email;
        this.mobile = mobile;
    }

    public String email() {
        return email;
    }

    public String mobile() {
        return mobile;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ContactInfo) obj;
        return Objects.equals(this.email, that.email) &&
                Objects.equals(this.mobile, that.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, mobile);
    }

    @Override
    public String toString() {
        return "ContactInfo[" +
                "email=" + email + ", " +
                "mobile=" + mobile + ']';
    }
}
