package org.bsuir.ppvis.observer;

public interface MainFrameObservable {
    void attach(MainFrameObserver observer);

    void detach(MainFrameObserver observer);

    void notifyObservers(String property) throws Exception;
}
