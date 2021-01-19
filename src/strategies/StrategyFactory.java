package strategies;

import electrical.Producer;

import java.util.ArrayList;


public class StrategyFactory {
    public static Strategy createStrategy(EnergyChoiceStrategyType strategyType,
                                          ArrayList<Producer> producers) {
        return switch (strategyType) {
            case GREEN -> new GreenStrategy(producers);
            case PRICE -> new PriceStrategy(producers);
            case QUANTITY -> new QuantityStrategy(producers);
        };
    }
}
