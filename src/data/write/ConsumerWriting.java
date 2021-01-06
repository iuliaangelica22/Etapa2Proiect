package data.write;

public final class ConsumerWriting {
    private final int id;
    private final boolean isBankrupt;
    private final Integer budget;

    public ConsumerWriting(final int id, final boolean isBankrupt, final Integer budget) {
        this.id = id;
        this.isBankrupt = isBankrupt;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    /**
     * scrierea in fisier
     * @return campul de care am nevoie pentru scrierea in fisier
     */

    public boolean getisBankrupt() {
        return isBankrupt;
    }

    public Integer getBudget() {
        return budget;
    }
}
