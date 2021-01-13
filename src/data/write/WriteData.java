package data.write;


import java.util.ArrayList;

public final class WriteData {
    private final ArrayList<ConsumerWriting> consumers;
    private final ArrayList<DistributorWriting> distributors;
    private final ArrayList<ProducerWriting> energyProducers;

    public WriteData(final ArrayList<ConsumerWriting> consumers,
                     final ArrayList<DistributorWriting> distributors,
                     final ArrayList<ProducerWriting> energyProducers) {
        this.consumers = consumers;
        this.distributors = distributors;
        this.energyProducers = energyProducers;
    }

    public ArrayList<ConsumerWriting> getConsumers() {
        return consumers;
    }

    public ArrayList<DistributorWriting> getDistributors() {
        return distributors;
    }

    public ArrayList<ProducerWriting> getEnergyProducers() {
        return energyProducers;
    }
}
