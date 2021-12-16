package org.bsuir.ppvis.observer;

@FunctionalInterface
public interface MainFrameObserver {
    void parameterChanged(MainFrameEvent event) throws Exception;
}