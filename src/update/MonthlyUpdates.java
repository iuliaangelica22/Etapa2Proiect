package update;

import electrical.Consumer;

import java.util.ArrayList;

public final class MonthlyUpdates {
    private ArrayList<Consumer> newConsumers;
    private ArrayList<DistributorChanges> distributorChanges;
    private ArrayList<ProducerChanges> producerChanges;

    public ArrayList<ProducerChanges> getProducerChanges() {
        return producerChanges;
    }

    public void setProducerChanges(ArrayList<ProducerChanges> producerChanges) {
        this.producerChanges = producerChanges;
    }

    public ArrayList<DistributorChanges> getDistributorChanges() {
        return distributorChanges;
    }

    public void setDistributorChanges(ArrayList<DistributorChanges> distributorChanges) {
        this.distributorChanges = distributorChanges;
    }

    public ArrayList<Consumer> getNewConsumers() {
        return newConsumers;
    }


    public void setNewConsumers(final ArrayList<Consumer> newConsumers) {
        this.newConsumers = newConsumers;
    }


    @Override
    public String toString() {
        return "MonthlyUpdates{" +
                "newConsumers=" + newConsumers +
                ", distributorChanges=" + distributorChanges +
                ", producerChanges=" + producerChanges +
                '}';
    }
}
