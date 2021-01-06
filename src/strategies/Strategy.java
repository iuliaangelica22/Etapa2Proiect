package strategies;

import electrical.Producer;

import java.util.ArrayList;

public interface Strategy {
    void specificStrategy(final ArrayList<Producer> producers);
}
