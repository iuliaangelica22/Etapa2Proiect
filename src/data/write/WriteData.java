package data.write;


import java.util.ArrayList;

public final class WriteData {
    private final ArrayList<ConsumerWriting> consumers;
    private final ArrayList<DistributorWriting> distributors;

    public WriteData(final ArrayList<ConsumerWriting> consumers,
                     final ArrayList<DistributorWriting> distributors) {
        this.consumers = consumers;
        this.distributors = distributors;
    }

    public ArrayList<ConsumerWriting> getConsumers() {
        return consumers;
    }

    public ArrayList<DistributorWriting> getDistributors() {
        return distributors;
    }
}
