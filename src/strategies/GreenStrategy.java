package strategies;

import electrical.Producer;

import java.util.ArrayList;
import java.util.Comparator;

public class GreenStrategy implements Strategy {
    @Override
    public void specificStrategy(ArrayList<Producer> producers) {
        producers.sort(Comparator.comparing("WIND, SOLAR, HYDRO"::equals));
        producers.sort(Comparator.comparing(Producer::getPriceKW));
        producers.sort(Comparator.comparing(Producer::getEnergyPerDistributor).reversed());

    }
}
