package app.sagen.api.model;

import app.sagen.api.model.enumvalues.HeatingSource;
import app.sagen.api.model.enumvalues.HomeAvatar;
import app.sagen.api.model.enumvalues.HomeType;

import java.util.Objects;

public final class Home {
    private final String id;
    private final String timeZone;
    private final String appNickname;
    private final HomeAvatar appAvatar;
    private final int size;
    private final HomeType type;
    private final int numberOfResidents;
    private final HeatingSource primaryHeatingSource;
    private final boolean hasVentilationSystem;
    private final int mainFuseSize;
    private final Address address;
    private final LegalEntity owner;
    private final MeteringPointData meteringPointData;
    private final Subscription currentSubscription;

    public Home(
            String id,
            String timeZone,
            String appNickname,
            HomeAvatar appAvatar,
            int size,
            HomeType type,
            int numberOfResidents,
            HeatingSource primaryHeatingSource,
            boolean hasVentilationSystem,
            int mainFuseSize,
            Address address,
            LegalEntity owner,
            MeteringPointData meteringPointData,
            Subscription currentSubscription
    ) {
        this.id = id;
        this.timeZone = timeZone;
        this.appNickname = appNickname;
        this.appAvatar = appAvatar;
        this.size = size;
        this.type = type;
        this.numberOfResidents = numberOfResidents;
        this.primaryHeatingSource = primaryHeatingSource;
        this.hasVentilationSystem = hasVentilationSystem;
        this.mainFuseSize = mainFuseSize;
        this.address = address;
        this.owner = owner;
        this.meteringPointData = meteringPointData;
        this.currentSubscription = currentSubscription;
    }

    public String id() {
        return id;
    }

    public String timeZone() {
        return timeZone;
    }

    public String appNickname() {
        return appNickname;
    }

    public HomeAvatar appAvatar() {
        return appAvatar;
    }

    public int size() {
        return size;
    }

    public HomeType type() {
        return type;
    }

    public int numberOfResidents() {
        return numberOfResidents;
    }

    public HeatingSource primaryHeatingSource() {
        return primaryHeatingSource;
    }

    public boolean hasVentilationSystem() {
        return hasVentilationSystem;
    }

    public int mainFuseSize() {
        return mainFuseSize;
    }

    public Address address() {
        return address;
    }

    public LegalEntity owner() {
        return owner;
    }

    public MeteringPointData meteringPointData() {
        return meteringPointData;
    }

    public Subscription currentSubscription() {
        return currentSubscription;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Home) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.timeZone, that.timeZone) &&
                Objects.equals(this.appNickname, that.appNickname) &&
                Objects.equals(this.appAvatar, that.appAvatar) &&
                this.size == that.size &&
                Objects.equals(this.type, that.type) &&
                this.numberOfResidents == that.numberOfResidents &&
                Objects.equals(this.primaryHeatingSource, that.primaryHeatingSource) &&
                this.hasVentilationSystem == that.hasVentilationSystem &&
                this.mainFuseSize == that.mainFuseSize &&
                Objects.equals(this.address, that.address) &&
                Objects.equals(this.owner, that.owner) &&
                Objects.equals(this.meteringPointData, that.meteringPointData) &&
                Objects.equals(this.currentSubscription, that.currentSubscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeZone, appNickname, appAvatar, size, type, numberOfResidents, primaryHeatingSource, hasVentilationSystem, mainFuseSize, address, owner, meteringPointData, currentSubscription);
    }

    @Override
    public String toString() {
        return "Home[" +
                "id=" + id + ", " +
                "timeZone=" + timeZone + ", " +
                "appNickname=" + appNickname + ", " +
                "appAvatar=" + appAvatar + ", " +
                "size=" + size + ", " +
                "type=" + type + ", " +
                "numberOfResidents=" + numberOfResidents + ", " +
                "primaryHeatingSource=" + primaryHeatingSource + ", " +
                "hasVentilationSystem=" + hasVentilationSystem + ", " +
                "mainFuseSize=" + mainFuseSize + ", " +
                "address=" + address + ", " +
                "owner=" + owner + ", " +
                "meteringPointData=" + meteringPointData + ", " +
                "currentSubscription=" + currentSubscription + ']';
    }
}
