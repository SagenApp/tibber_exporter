package app.sagen.api.model;

import java.util.Objects;

public final class Consumption {
    private final String from;
    private final String to;
    private final double unitPrice;
    private final double unitPriceVAT;
    private final double consumption;
    private final String consumptionUnit;
    private final double cost;
    private final double currency;

    public Consumption(
            String from,
            String to,
            double unitPrice,
            double unitPriceVAT,
            double consumption, // kwH consumed
            String consumptionUnit,
            double cost,
            double currency
    ) {
        this.from = from;
        this.to = to;
        this.unitPrice = unitPrice;
        this.unitPriceVAT = unitPriceVAT;
        this.consumption = consumption;
        this.consumptionUnit = consumptionUnit;
        this.cost = cost;
        this.currency = currency;
    }

    public String from() {
        return from;
    }

    public String to() {
        return to;
    }

    public double unitPrice() {
        return unitPrice;
    }

    public double unitPriceVAT() {
        return unitPriceVAT;
    }

    public double consumption() {
        return consumption;
    }

    public String consumptionUnit() {
        return consumptionUnit;
    }

    public double cost() {
        return cost;
    }

    public double currency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Consumption) obj;
        return Objects.equals(this.from, that.from) &&
                Objects.equals(this.to, that.to) &&
                Double.doubleToLongBits(this.unitPrice) == Double.doubleToLongBits(that.unitPrice) &&
                Double.doubleToLongBits(this.unitPriceVAT) == Double.doubleToLongBits(that.unitPriceVAT) &&
                Double.doubleToLongBits(this.consumption) == Double.doubleToLongBits(that.consumption) &&
                Objects.equals(this.consumptionUnit, that.consumptionUnit) &&
                Double.doubleToLongBits(this.cost) == Double.doubleToLongBits(that.cost) &&
                Double.doubleToLongBits(this.currency) == Double.doubleToLongBits(that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, unitPrice, unitPriceVAT, consumption, consumptionUnit, cost, currency);
    }

    @Override
    public String toString() {
        return "Consumption[" +
                "from=" + from + ", " +
                "to=" + to + ", " +
                "unitPrice=" + unitPrice + ", " +
                "unitPriceVAT=" + unitPriceVAT + ", " +
                "consumption=" + consumption + ", " +
                "consumptionUnit=" + consumptionUnit + ", " +
                "cost=" + cost + ", " +
                "currency=" + currency + ']';
    }
}
