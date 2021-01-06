package strategies;

import electrical.Producer;

import java.util.ArrayList;
import java.util.Comparator;

public class PriceStrategy  implements  Strategy{
    @Override
    public void specificStrategy(ArrayList<Producer> producers) {
        producers.sort(Comparator.comparing(Producer::getPriceKW));
        producers.sort(Comparator.comparing(Producer::getEnergyPerDistributor).reversed());

    }
}
