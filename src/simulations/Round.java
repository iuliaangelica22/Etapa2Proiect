package simulations;


import electrical.Consumer;
import electrical.Distributor;
import electrical.ElectricalConsumers;
import electrical.Producer;
import electrical.SingletonFactory;
import strategies.StrategyFactory;
import strategies.EnergyChoiceStrategyType;
import update.DistributorChanges;

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
                       final ArrayList<DistributorChanges> distributorChanges,
                       final ArrayList<ElectricalConsumers> consumers,
                       final ArrayList<Producer> producers) {
        for (Consumer newConsumer : newConsumers) {
            SingletonFactory consumer = SingletonFactory.getInstance();
            consumers.add(consumer.createConsumer(newConsumer));
        }

        distributors.sort(Comparator.comparing(Distributor::getId));

        for (DistributorChanges distributorChanges1 : distributorChanges) {
            distributors.get(distributorChanges1.getId()).setInitialInfrastructureCost(
                    distributorChanges1.getInfrastructureCost());
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
        distributors.sort(Comparator.comparing(Distributor::getContractCost));
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
                            consumer.setPriceContract(distributor.getContractCost());
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

    /**
     * @param producers
     * @param distributors
     * @param month
     */

    public void chooseProducer(ArrayList<Producer> producers, ArrayList<Distributor> distributors,
                               Integer month) {
        final int PERCENTAGE = 10;
        int sum;
        double auxiliar;
        ArrayList<Producer> newList = new ArrayList<>();

        for (Distributor distributor : distributors) {
            sum = 0;
            auxiliar = 0.0;
            if (distributor.getStatusUpdate()) {
                distributor.setStatusUpdate(false);
                for (Producer producer : distributor.getCurrentProducers()) {
                    producer.getCurrentDistributors().remove(distributor);
                }
                distributor.getCurrentProducers().clear();

                EnergyChoiceStrategyType strategyType = distributor.getProducerStrategy();
                StrategyFactory.createStrategy(strategyType, producers).specificStrategy();

                for (Producer producer : producers) {
                    if (producer.getNumberOfCurrentDistributors() <
                            producer.getMaxDistributors()) {
                        sum += producer.getEnergyPerDistributor();
                        newList.add(producer);
                    }
                    if (sum >= distributor.getEnergyNeededKW()) {
                        for (Producer producer1 : newList) {
                            distributor.getCurrentProducers().add(producer1);
                            producer1.getCurrentDistributors().add(distributor);
                            auxiliar += producer1.getEnergyPerDistributor()
                                    * producer1.getPriceKW();
                            producer1.setNumberOfCurrentDistributors(
                                    producer1.getNumberOfCurrentDistributors() + 1);

                        }
                        distributor.setInitialProductionCost(
                                (double) Math.round(Math.floor(auxiliar / PERCENTAGE)));
                        newList.clear();
                        break;
                    }
                }
            }
        }

        for (Producer producer : producers) {
            for (int j = 0; j < producer.getCurrentDistributors().size(); j++) {
                producer.getMonthlyStats().get(month).getDistributorsIds()
                        .add(producer.getCurrentDistributors().get(j).getId());
            }
            producer.getMonthlyStats().get(month).getDistributorsIds()
                    .sort(Comparator.comparing(Integer::intValue));
        }

    }
}



