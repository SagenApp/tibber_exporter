package app.sagen.api.model;

import java.util.Objects;

public final class MeteringPointData {
    private final String consumptionEan;
    private final String gridCompany;
    private final String gridAreaCode;
    private final String priceAreaCode;
    private final String productionEan;
    private final String energyTaxType;
    private final String vatType;
    private final int estimatedAnnualConsumption;

    public MeteringPointData(
            String consumptionEan,
            String gridCompany,
            String gridAreaCode,
            String priceAreaCode,
            String productionEan,
            String energyTaxType,
            String vatType,
            int estimatedAnnualConsumption
    ) {
        this.consumptionEan = consumptionEan;
        this.gridCompany = gridCompany;
        this.gridAreaCode = gridAreaCode;
        this.priceAreaCode = priceAreaCode;
        this.productionEan = productionEan;
        this.energyTaxType = energyTaxType;
        this.vatType = vatType;
        this.estimatedAnnualConsumption = estimatedAnnualConsumption;
    }

    public String consumptionEan() {
        return consumptionEan;
    }

    public String gridCompany() {
        return gridCompany;
    }

    public String gridAreaCode() {
        return gridAreaCode;
    }

    public String priceAreaCode() {
        return priceAreaCode;
    }

    public String productionEan() {
        return productionEan;
    }

    public String energyTaxType() {
        return energyTaxType;
    }

    public String vatType() {
        return vatType;
    }

    public int estimatedAnnualConsumption() {
        return estimatedAnnualConsumption;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (MeteringPointData) obj;
        return Objects.equals(this.consumptionEan, that.consumptionEan) &&
                Objects.equals(this.gridCompany, that.gridCompany) &&
                Objects.equals(this.gridAreaCode, that.gridAreaCode) &&
                Objects.equals(this.priceAreaCode, that.priceAreaCode) &&
                Objects.equals(this.productionEan, that.productionEan) &&
                Objects.equals(this.energyTaxType, that.energyTaxType) &&
                Objects.equals(this.vatType, that.vatType) &&
                this.estimatedAnnualConsumption == that.estimatedAnnualConsumption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumptionEan, gridCompany, gridAreaCode, priceAreaCode, productionEan, energyTaxType, vatType, estimatedAnnualConsumption);
    }

    @Override
    public String toString() {
        return "MeteringPointData[" +
                "consumptionEan=" + consumptionEan + ", " +
                "gridCompany=" + gridCompany + ", " +
                "gridAreaCode=" + gridAreaCode + ", " +
                "priceAreaCode=" + priceAreaCode + ", " +
                "productionEan=" + productionEan + ", " +
                "energyTaxType=" + energyTaxType + ", " +
                "vatType=" + vatType + ", " +
                "estimatedAnnualConsumption=" + estimatedAnnualConsumption + ']';
    }
}
