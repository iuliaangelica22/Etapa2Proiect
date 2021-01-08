package data.write;

import entities.EnergyType;

import java.util.ArrayList;

public class ProducerWriting {
    private final Integer id;
    private final  Integer maxDistributors;
    private final Double priceKW;
    private final EnergyType energyType;
    private final Integer energyPerDistributor;
    private  final ArrayList<MonthlyStats> monthlyStats;


    public ProducerWriting(Integer id, Integer maxDistributors, Double priceKW,
                           EnergyType energyType, Integer energyPerDistributor,
                           ArrayList<MonthlyStats> monthlyStats) {
        this.id = id;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyType = energyType;
        this.energyPerDistributor = energyPerDistributor;
        this.monthlyStats = monthlyStats;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMaxDistributors() {
        return maxDistributors;
    }

    public Double getPriceKW() {
        return priceKW;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public Integer getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    public ArrayList<MonthlyStats> getMonthlyStats() {
        return monthlyStats;
    }
}
