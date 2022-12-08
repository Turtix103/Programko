package org.delta.observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {

    List<Observer> observers = new ArrayList<>();

    public void register(Observer obj);

    public void unregister(Observer obj);

    public void notifyObservers();

    public Object getUpdate(Observer obj);

}
