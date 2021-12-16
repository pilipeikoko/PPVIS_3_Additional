package org.bsuir.ppvis.observer;

import java.util.EventObject;

public class MainFrameEvent extends EventObject {
    private final String property;

    public MainFrameEvent(Object source, String property) {
        super(source);
        this.property =property;
    }

    @Override
    public MainFrameEvent getSource(){
        return (MainFrameEvent) super.getSource();
    }

    public String getProperty() {
        return property;
    }
}