package observer;

import java.util.ArrayList;

public abstract class Subject {
    private final ArrayList<Observer> observerList = new ArrayList<>();
    private Integer newEnergy;

    public void append(Observer observer) {
        observerList.add(observer);
    }
    public void setStatus(Integer newEnergy) {
        this.newEnergy = newEnergy;
        notifyAllObservers();
    }

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
