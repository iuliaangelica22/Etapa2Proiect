package strategies;

import electrical.Producer;

import java.util.ArrayList;
import java.util.Comparator;

public class QuantityStrategy implements Strategy {
    private ArrayList<Producer> producers = new ArrayList<>();

    public QuantityStrategy(ArrayList<Producer> producers) {
        this.producers = producers;
    }

    @Override
    public void specificStrategy() {
        producers.sort(Comparator.comparing(Producer::getId));
        producers.sort((o1, o2) -> {
            int result = o2.getEnergyPerDistributor().compareTo(o1.getEnergyPerDistributor());
            if (result == 0) {
                result = o1.getId().compareTo(o2.getId());
            }
            return result;
        });


    }
}
