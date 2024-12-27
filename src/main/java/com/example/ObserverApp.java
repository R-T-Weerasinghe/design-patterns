package com.example;

import java.util.List;
import java.util.ArrayList;

interface Observer {
    void update(String message);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

class ConcreteObserver1 implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Observer1 received: " + message);
    }
}

class ConcreteObserver2 implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Observer2 received: " + message);
    }
}


public class ObserverApp {
    public static void main(String[] args) { 
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();
    
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.notifyObservers("hello world");
    }
}
