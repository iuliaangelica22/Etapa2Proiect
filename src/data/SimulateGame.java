package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.read.ReadData;
import data.write.ConsumerWriting;
import data.write.ContractWriting;
import data.write.DistributorWriting;
import data.write.WriteData;
import electrical.Distributor;
import electrical.ElectricalConsumers;
import electrical.Month;
import electrical.SingletonFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public final class SimulateGame {
    /**
     * citire date si apelarea metodei din clasa Month pentru realizarea tututor actiunilor lunare
     * scrierea cu PrettyPrinter la final
     *
     * @param in  citire date
     * @param out scriere date
     * @throws IOException verificare date input
     */
    public void simulate(final File in, final File out) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ReadData read = objectMapper.readValue(in, ReadData.class);
        ArrayList<ElectricalConsumers> electricalConsumers = new ArrayList<>();

        for (int i = 0; i < read.getInitialData().getConsumers().size(); i++) {
            SingletonFactory consumer = SingletonFactory.getInstance();
            electricalConsumers
                    .add(consumer.createConsumer(read.getInitialData().getConsumers().get(i)));
        }

        Month m = new Month();
        m.callMethod(read, electricalConsumers);
        read.getInitialData().getDistributors().sort(Comparator.comparing(Distributor::getId));

        ArrayList<ConsumerWriting> consumers = new ArrayList<>();

        for (ElectricalConsumers electricalConsumer : electricalConsumers) {
            ConsumerWriting c2 = new ConsumerWriting(electricalConsumer.getId(),
                    electricalConsumer.isBankrupt(),
                    electricalConsumer.getInitialBudget().intValue());
            consumers.add(c2);
        }

        ArrayList<DistributorWriting> distributors = new ArrayList<>();

        for (int i = 0; i < read.getInitialData().getDistributors().size(); i++) {
            ArrayList<ElectricalConsumers> electricalConsumers1 =
                    read.getInitialData().getDistributors().get(i).getListOfConsumers();
            ArrayList<ContractWriting> contracts = new ArrayList<>();

            for (ElectricalConsumers consumers1 : electricalConsumers1) {
                ContractWriting contract = new ContractWriting(consumers1.getId(),
                        consumers1.getPriceContract().intValue(),
                        read.getInitialData().getDistributors().get(i).getContractLength()
                                - consumers1.getContractLength());
                contracts.add(contract);
            }

            DistributorWriting distributorWriting = new DistributorWriting(
                    read.getInitialData().getDistributors().get(i).getId(),
                    read.getInitialData().getDistributors().get(i).getInitialBudget().intValue(),
                    read.getInitialData().getDistributors().get(i).isBankrupt(), contracts);
            distributors.add(distributorWriting);
        }


        WriteData write = new WriteData(consumers, distributors);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(out, write);

    }

}
