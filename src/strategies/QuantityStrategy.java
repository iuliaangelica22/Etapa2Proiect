package strategies;

import electrical.Producer;

import java.util.ArrayList;
import java.util.Comparator;

public class QuantityStrategy  implements Strategy {
    @Override
    public void specificStrategy(ArrayList<Producer> producers) {
        producers.sort(Comparator.comparing(Producer::getEnergyPerDistributor).reversed());

    }
}
