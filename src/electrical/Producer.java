package electrical;

import entities.EnergyType;

import java.util.ArrayList;

public class Producer {
    private int id;
    private EnergyType energyType;
    private Integer maxDistributors;
    private Double infrastructureCost;
    private Double priceKW;
    private Integer energyPerDistributor;
    private ArrayList<Distributor> currentDistributors = new ArrayList<>();

    public ArrayList<Distributor> getCurrentDistributors() {
        return currentDistributors;
    }

    public void setCurrentDistributors(ArrayList<Distributor> currentDistributors) {
        this.currentDistributors = currentDistributors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }

    public Integer getMaxDistributors() {
        return maxDistributors;
    }

    public void setMaxDistributors(Integer maxDistributors) {
        this.maxDistributors = maxDistributors;
    }

    public Double getPriceKW() {
        return priceKW;
    }

    public void setPriceKW(Double priceKW) {
        this.priceKW = priceKW;
    }

    public Integer getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    public void setEnergyPerDistributor(Integer energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    public Double getInfrastructureCost() {
        return infrastructureCost;
    }

    public void setInfrastructureCost(Double infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }
}
