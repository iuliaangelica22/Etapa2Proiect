package strategies;

import electrical.Producer;

import java.util.ArrayList;
import java.util.Comparator;

public final class GreenStrategy implements Strategy {
    private final ArrayList<Producer> producers;

    public GreenStrategy(ArrayList<Producer> producers) {
        this.producers = producers;
    }

    @Override
    public void specificStrategy() {
        producers.sort(Comparator.comparing(Producer::getId));
        producers.sort((o1, o2) -> {
            int result = Boolean.compare(o2.getEnergyType().isRenewable(),
                    o1.getEnergyType().isRenewable());
            if (result == 0) {
                result = o1.getPriceKW().compareTo(o2.getPriceKW());
            }
            if (result == 0) {
                result = o2.getEnergyPerDistributor().compareTo(o1.getEnergyPerDistributor());
            }
            if (result == 0) {
                result = o1.getId().compareTo(o2.getId());
            }
            return result;
        });


    }
}
