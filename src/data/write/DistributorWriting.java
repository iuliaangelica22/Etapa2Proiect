package data.write;

import strategies.EnergyChoiceStrategyType;

import java.util.ArrayList;

public final class DistributorWriting {
    private final int id;
    private final Integer energyNeededKW;
    private final Integer contractCost;
    private final Integer budget;
    private final EnergyChoiceStrategyType producerStrategy;
    private final boolean isBankrupt;
    private final ArrayList<ContractWriting> contracts;

    public DistributorWriting(int id, Integer energyNeededKW, Integer contractCost,
                              Integer budget, EnergyChoiceStrategyType producerStrategy,
                              boolean isBankrupt,
                              ArrayList<ContractWriting> contracts) {
        this.id = id;
        this.energyNeededKW = energyNeededKW;
        this.contractCost = contractCost;
        this.budget = budget;
        this.producerStrategy = producerStrategy;
        this.isBankrupt = isBankrupt;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public Integer getBudget() {
        return budget;
    }

    /**
     * folosit pentru scrierea in fisier
     * @return campul necesar pentru scriere
     */

    public boolean getisBankrupt() {
        return isBankrupt;
    }

    public ArrayList<ContractWriting> getContracts() {
        return contracts;
    }

    public Integer getEnergyNeededKW() {
        return energyNeededKW;
    }

    public Integer getContractCost() {
        return contractCost;
    }

    public EnergyChoiceStrategyType getProducerStrategy() {
        return producerStrategy;
    }

}
