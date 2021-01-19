package observer;

import java.util.ArrayList;

public final class Subject {
    private final ArrayList<Observer> observerList = new ArrayList<>();
    private Integer newEnergy;

    /**
     *
     * @param observer
     */

    public void append(Observer observer) {
        observerList.add(observer);
    }

    /**
     *
     * @param newEnergy
     */
    public void setStatus(Integer newEnergy) {
        this.newEnergy = newEnergy;
        notifyAllObservers();
    }

    /**
     *
     */
    public void notifyAllObservers() {
        for (Observer observer : observerList) {
            observer.update(newEnergy);
        }
    }

    /**
     *
     * @return noului update de la subiect
     */
    public Integer getStatus() {
        return newEnergy;
    }


}
