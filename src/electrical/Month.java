package electrical;

import data.read.ReadData;
import simulations.Round;


import java.util.ArrayList;
import java.util.Comparator;

public final class Month {
    /**
     *aplearea tututor metodelor din clasa MonthlyPayments
     * au fost rulate numberOfTurns +1 runde
     * @param data acces date citite
     * @param consumers  realizarea actiunilor lunare
     */
    public void callMethod(final ReadData data, final ArrayList<ElectricalConsumers> consumers) {
        Round consumer = new Round();
        consumer.chooseContract(consumers, data.getInitialData().getDistributors());
        consumer.chooseProducer(data.getInitialData().getProducers(),
                data.getInitialData().getDistributors());

        for (int i = 0; i < data.getNumberOfTurns(); i++) {
            consumer.update(data.getMonthlyUpdates().get(i).getNewConsumers(),
                    data.getInitialData().getDistributors(), consumers,data.getInitialData().getProducers());
            consumer.chooseContract(consumers, data.getInitialData().getDistributors());
            data.getInitialData().getDistributors().sort(Comparator.comparing(Distributor::getId));
            consumer.chooseProducer(data.getInitialData().getProducers(),
                    data.getInitialData().getDistributors());





        }

    }
}
