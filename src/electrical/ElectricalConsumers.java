package electrical;

import com.fasterxml.jackson.annotation.JsonIgnore;


public final class ElectricalConsumers extends Consumer {
    private boolean isBankrupt = false;
    @JsonIgnore
    private Distributor chosenContract = null;
    private Double priceContract = 0.0;
    private int contractLength = 0;
    private int numberOfMonth = 0;
    private double debt = 0;


    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(final int contractLength) {
        this.contractLength = contractLength;
    }


    public ElectricalConsumers(final int id, final Double initialBudget, final int monthlyIncome) {
        this.setId(id);
        this.setInitialBudget(initialBudget);
        this.setMonthlyIncome(monthlyIncome);
    }

    public void setNumberOfMonth(final int numberOfMonth) {
        this.numberOfMonth = numberOfMonth;
    }

    /**
     * metoda pentru plata consumatorilor, inclusiv cand acestia acumuleaza datorii
     */

    public void pay() {
       final Double commission = 1.2;
        if ((getInitialBudget() - priceContract < 0) && numberOfMonth == 0) {
            debt = Math.round(Math.floor(commission * priceContract));
            numberOfMonth++;
            return;
        }
        if (numberOfMonth == 1) {
            if (getInitialBudget() - priceContract - debt > 0) {
                chosenContract.setInitialBudget(chosenContract.getInitialBudget()
                        + priceContract + debt);
                setInitialBudget(getInitialBudget() - priceContract - debt);
                numberOfMonth = 0;
            } else {
                isBankrupt = true;
                chosenContract.setInitialBudget(chosenContract.getInitialBudget()
                        - chosenContract.getInitialProductionCost());
                chosenContract.getListOfConsumers().remove(this);
                chosenContract = null;
            }
            return;
        }
        setInitialBudget(getInitialBudget() - priceContract);
        chosenContract.setInitialBudget(chosenContract.getInitialBudget() + priceContract);
    }

    public void setPriceContract(final Double priceContract) {
        this.priceContract = priceContract;
    }

    public Distributor getChosenContract() {
        return chosenContract;
    }

    public void setChosenContract(final Distributor chosenContract) {
        this.chosenContract = chosenContract;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public Double getPriceContract() {
        return priceContract;
    }


}
