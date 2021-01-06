package update;

public  final class CostChanges {
    private int id;
    private Double infrastructureCost;
    private Double productionCost;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Double getInfrastructureCost() {
        return infrastructureCost;
    }

    public void setInfrastructureCost(final Double infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    public Double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(final Double productionCost) {
        this.productionCost = productionCost;
    }

    @Override
    public String toString() {
        return "CostChanges{"
                + "id=" + id
                + ", infrastructureCost=" + infrastructureCost
                + ", productionCost=" + productionCost
                + '}';
    }
}
