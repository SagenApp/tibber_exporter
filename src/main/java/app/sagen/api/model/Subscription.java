package app.sagen.api.model;

import app.sagen.api.model.LegalEntity;

import java.util.Objects;

public final class Subscription {
    private final String id;
    private final LegalEntity subscriber;
    private final String validFrom;
    private final String validTo;
    private final String status;
    private final String statusReason;

    public Subscription(
            String id,
            LegalEntity subscriber,
            String validFrom,
            String validTo,
            String status,
            String statusReason
//        PriceInfo priceInfo,
//        PriceRating priceRating
    ) {
        this.id = id;
        this.subscriber = subscriber;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.status = status;
        this.statusReason = statusReason;
    }

    public String id() {
        return id;
    }

    public LegalEntity subscriber() {
        return subscriber;
    }

    public String validFrom() {
        return validFrom;
    }

    public String validTo() {
        return validTo;
    }

    public String status() {
        return status;
    }

    public String statusReason() {
        return statusReason;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Subscription) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.subscriber, that.subscriber) &&
                Objects.equals(this.validFrom, that.validFrom) &&
                Objects.equals(this.validTo, that.validTo) &&
                Objects.equals(this.status, that.status) &&
                Objects.equals(this.statusReason, that.statusReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subscriber, validFrom, validTo, status, statusReason);
    }

    @Override
    public String toString() {
        return "Subscription[" +
                "id=" + id + ", " +
                "subscriber=" + subscriber + ", " +
                "validFrom=" + validFrom + ", " +
                "validTo=" + validTo + ", " +
                "status=" + status + ", " +
                "statusReason=" + statusReason + ']';
    }
}
