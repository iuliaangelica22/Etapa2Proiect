package electrical;


public class Consumer {
    private int id;
    private Double initialBudget;
    private int monthlyIncome;

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final Double getInitialBudget() {
        return initialBudget;
    }

    public final void setInitialBudget(final Double initialBudget) {
        this.initialBudget = initialBudget;
    }

    public final int getMonthlyIncome() {
        return monthlyIncome;
    }

    public final void setMonthlyIncome(final int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }


}
