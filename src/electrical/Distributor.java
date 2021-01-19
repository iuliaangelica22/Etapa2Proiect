package electrical;

import com.fasterxml.jackson.annotation.JsonIgnore;
import strategies.EnergyChoiceStrategyType;

import java.util.ArrayList;

public final class Distributor {

    private Integer id;
    private int contractLength;
    private Double initialBudget;
    private Double initialInfrastructureCost;
    private Double initialProductionCost = 0.0;
    private boolean isBankrupt = false;
    private Double contractCost;
    private Integer energyNeededKW;
    private ArrayList<Producer> currentProducers = new ArrayList<>();
    private EnergyChoiceStrategyType producerStrategy;
    private boolean statusUpdate = true;
    private boolean producerChange = false;

    @JsonIgnore
    private final ArrayList<ElectricalConsumers>
            listOfConsumers = new ArrayList<>();

    public ArrayList<ElectricalConsumers> getListOfConsumers() {
        return listOfConsumers;
    }


    /**
     * calcularea pretului fiecarui contract pe baza numarului consumatorilor curenti
     * stergerea din lista a celor care au terminat contractul
     */

    public void calculatePriceContract() {
        final double profitPercentage = 0.2;
        if (listOfConsumers.size() == 0) {
            contractCost = initialInfrastructureCost + initialProductionCost
                    + Math.round(Math.floor(profitPercentage * initialProductionCost));
        } else {

            contractCost = (double) Math
                    .round(Math.floor(initialInfrastructureCost / listOfConsumers.size())
                            + initialProductionCost
                            + Math.round(Math.floor(profitPercentage * initialProductionCost)));
            for (ElectricalConsumers consumers : listOfConsumers) {
                if (consumers.getContractLength() == contractLength) {
                    consumers.setChosenContract(null);
                }
            }
            listOfConsumers.removeIf(consumers -> consumers.getContractLength() == contractLength);
        }
    }

    /**
     * metoda de plata a distributor si marcarea cu true daca este falimentat
     */
    public void pay() {
        initialBudget = initialBudget - initialInfrastructureCost - (
                initialProductionCost * listOfConsumers.size());
        if (initialBudget < 0) {
            isBankrupt = true;
        }

    }


    public boolean isBankrupt() {
        return isBankrupt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(final int contractLength) {
        this.contractLength = contractLength;
    }

    public Double getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(final Double initialBudget) {
        this.initialBudget = initialBudget;
    }

    public Double getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    public void setInitialInfrastructureCost(final Double initialInfrastructureCost) {
        this.initialInfrastructureCost = initialInfrastructureCost;
    }

    public Double getInitialProductionCost() {
        return initialProductionCost;
    }

    public void setInitialProductionCost(final Double initialProductionCost) {
        this.initialProductionCost = initialProductionCost;
    }

    public Double getContractCost() {
        return contractCost;
    }

    public EnergyChoiceStrategyType getProducerStrategy() {
        return producerStrategy;
    }

    public void setProducerStrategy(EnergyChoiceStrategyType producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    public Integer getEnergyNeededKW() {
        return energyNeededKW;
    }

    public void setEnergyNeededKW(Integer energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }


    public ArrayList<Producer> getCurrentProducers() {
        return currentProducers;
    }


    public void setCurrentProducers(ArrayList<Producer> currentProducers) {
        this.currentProducers = currentProducers;
    }

    public boolean getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(boolean statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public boolean isProducerChange() {
        return producerChange;
    }

    public void setProducerChange(boolean producerChange) {
        this.producerChange = producerChange;
    }
}
