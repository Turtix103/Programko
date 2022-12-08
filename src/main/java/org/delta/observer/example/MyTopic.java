package org.delta.observer.example;

import org.delta.observer.Observer;
import org.delta.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {

    private final Object MUTEX = new Object();
    private String message;
    private boolean changed;

    public MyTopic() {
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observers.contains(obj)) {
                observers.add(obj);
                obj.setSubject(this);
            }
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;

        synchronized (MUTEX) {
            if (!changed) {
                return;
            }

            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }

        for (Observer obj : observersLocal) {
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("Message Posted to Topic:" + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}
