package data.write;

import java.util.ArrayList;

public final class DistributorWriting {
    private final int id;
    private final Integer budget;
    private final boolean isBankrupt;
    private final ArrayList<ContractWriting> contracts;

    public DistributorWriting(final int id, final Integer budget, final boolean isBankrupt,
                              final ArrayList<ContractWriting> contracts) {
        this.id = id;
        this.budget = budget;
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
}
