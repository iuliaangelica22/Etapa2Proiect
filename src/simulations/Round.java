package simulations;


import electrical.Consumer;
import electrical.Distributor;
import electrical.ElectricalConsumers;
import electrical.Producer;
import electrical.SingletonFactory;
import strategies.StrategyFactory;
import strategies.EnergyChoiceStrategyType;
import strategies.Strategy;

import java.util.ArrayList;
import java.util.Comparator;

public final class Round {
    /**
     * actualizare consumatori si setarea noilor costuri pentru distributori
     *
     * @param newConsumers actualizare lista consumatori
     * @param distributors contine informatiile despre distribuitori
     */

    public void update(final ArrayList<Consumer> newConsumers,
                       final ArrayList<Distributor> distributors,
                       final ArrayList<ElectricalConsumers> consumers,
                       final ArrayList<Producer> producers) {
        for (Consumer newConsumer : newConsumers) {
            SingletonFactory consumer = SingletonFactory.getInstance();
            consumers.add(consumer.createConsumer(newConsumer));
        }
        distributors.sort(Comparator.comparing(Distributor::getId));
        for (Distributor distributor : distributors) {
            distributor.setInitialInfrastructureCost(distributor.getInitialInfrastructureCost());
        }
        for (Producer producer : producers) {
            producer.setEnergyPerDistributor(producer.getEnergyPerDistributor());
        }
        producers.sort(Comparator.comparing(Producer::getId));
    }

    /**
     * alegerea contractelor consumatorilor si realizarea taskurilor lunare
     *
     * @param consumers    isi aleg contract
     * @param distributors actualizarea preturilor contractelor, verificari si plata
     */
    public void chooseContract(final ArrayList<ElectricalConsumers> consumers,
                               final ArrayList<Distributor> distributors) {
        for (Distributor distributor : distributors) {
            distributor.calculatePriceContract();
        }
        distributors.sort(Comparator.comparing(Distributor::getPriceContract));
        for (ElectricalConsumers consumers1 : consumers) {
            if (!consumers1.isBankrupt()) {
                consumers1.setInitialBudget(
                        consumers1.getInitialBudget() + consumers1.getMonthlyIncome());
            }
        }
        for (ElectricalConsumers consumer : consumers) {
            if (!consumer.isBankrupt()) {
                if ((consumer.getChosenContract() == null
                        || consumer.getChosenContract().isBankrupt())) {
                    if (consumer.getChosenContract() != null
                            && consumer.getChosenContract().isBankrupt()) {
                        consumer.setNumberOfMonth(0);
                    }

                    for (Distributor distributor : distributors) {
                        if (!distributor.isBankrupt()) {
                            consumer.setChosenContract(distributor);
                            consumer.setPriceContract(distributor.getPriceContract());
                            distributor.getListOfConsumers().add(consumer);
                            consumer.pay();
                            consumer.setContractLength(1);
                            break;
                        }

                    }

                } else {
                    consumer.pay();
                    consumer.setContractLength(consumer.getContractLength() + 1);
                }
            }

        }
        for (Distributor distributor : distributors) {
            if (!distributor.isBankrupt()) {
                distributor.pay();
            }
        }

    }

    public void chooseStrategy(ArrayList<Producer> producers, ArrayList<Distributor> distributors) {
        for (Distributor distributor : distributors) {
            EnergyChoiceStrategyType strategyType = distributor.getProducerStrategy();
            Strategy strategy = StrategyFactory.createStrategy(strategyType, producers);
        }

    }


}



