package electrical;

import data.write.MonthlyStats;
import entities.EnergyType;
import observer.Observer;
import java.util.ArrayList;

public class Producer extends Observer {
    private Integer id;
    private EnergyType energyType;
    private Integer maxDistributors;
    private Double priceKW;
    private Integer energyPerDistributor;
    private Integer numberOfCurrentDistributors = 0;
    private ArrayList<Distributor> currentDistributors = new ArrayList<>();
    private ArrayList<MonthlyStats> monthlyStats = new ArrayList<>();

    @Override
    public void update(Integer energyPerDistributor) {
        for(Distributor distributor : currentDistributors){
            distributor.setStatusUpdate(true);
            distributor.setEnergyNeededKW(energyPerDistributor);
        }
    }


    public ArrayList<Distributor> getCurrentDistributors() {
        return currentDistributors;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getNumberOfCurrentDistributors() {
        return numberOfCurrentDistributors;
    }

    public void setNumberOfCurrentDistributors(Integer numberOfCurrentDistributors) {
        this.numberOfCurrentDistributors = numberOfCurrentDistributors;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public ArrayList<MonthlyStats> getMonthlyStats() {
        return monthlyStats;
    }

    public void setMonthlyStats(ArrayList<MonthlyStats> monthlyStats) {
        this.monthlyStats = monthlyStats;
    }

}
