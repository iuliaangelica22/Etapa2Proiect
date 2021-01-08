package observer;


public abstract class Observer {
    // agregare
    protected Subject subject;

    /**
     * notificarea oricarei actualizari
     */
    public abstract void update(Integer energyPerDistributor);


}
