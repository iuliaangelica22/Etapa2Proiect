package electrical;

public final class SingletonFactory {
    private SingletonFactory() {
    }

    private static SingletonFactory instance  = null;

    /**
     * metoda pentru retunarea instantei  existente sau crearea uneia noi daca nu exista
     * @return instanta de tip SingletonFactory
     */

    public static SingletonFactory getInstance() {
        if (instance == null) {
            instance = new SingletonFactory();
        }
        return instance;
    }

    /**
     * metoda folosita pentru obtinerea instantei in clasa MOnthlyPayments si SimulateGame
     * @param consumer  obtinerea de instante de tip ElectricalConsumers
     * @return instantei propriu-zise
     */
    public ElectricalConsumers createConsumer(final Consumer consumer) {
        return new ElectricalConsumers(consumer.getId(),
                consumer.getInitialBudget(), consumer.getMonthlyIncome());

    }

}
