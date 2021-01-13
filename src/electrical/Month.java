package electrical;

import data.read.ReadData;
import data.write.MonthlyStats;
import simulations.Round;


import java.util.ArrayList;
import java.util.Comparator;

public final class Month {
    /**
     * apelarea tututor metodelor din clasa MonthlyPayments
     * au fost rulate numberOfTurns +1 runde
     *
     * @param data      acces date citite
     * @param consumers realizarea actiunilor lunare
     */
    public void callMethod(final ReadData data, final ArrayList<ElectricalConsumers> consumers) {
        Round round = new Round();


        for (Producer producer : data.getInitialData().getProducers()) {
            for (int i = 0; i <= data.getNumberOfTurns(); i++) {
                ArrayList<Integer> distributorsId = new ArrayList<>();
                producer.getMonthlyStats().add(new MonthlyStats(i, distributorsId));
            }
        }
        round.chooseProducer(data.getInitialData().getProducers(),
                data.getInitialData().getDistributors(), 0);
        round.chooseContract(consumers, data.getInitialData().getDistributors());

        for (int i = 1; i <= data.getNumberOfTurns(); i++) {
            round.update(data.getMonthlyUpdates().get(i - 1).getNewConsumers(),
                    data.getInitialData().getDistributors(), consumers,
                    data.getInitialData().getProducers());
            round.chooseContract(consumers, data.getInitialData().getDistributors());
            round.chooseProducer(data.getInitialData().getProducers(),
                    data.getInitialData().getDistributors(), i);
            data.getInitialData().getDistributors().sort(Comparator.comparing(Distributor::getId));
            for (int k = 0; k < data.getInitialData().getDistributors().size(); k++) {
                if (data.getInitialData().getDistributors().get(k).getStatusUpdate()) {
                    for (int j = 0;
                         j < data.getInitialData().getDistributors().get(k).getCurrentProducers()
                                 .size(); j++) {
                        data.getInitialData().getDistributors().get(k).getCurrentProducers().remove(
                                data.getInitialData().getDistributors().get(k).getCurrentProducers().get(j));
                    }
                }
            }
        }
    }
}

