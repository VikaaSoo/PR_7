/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practika7;

/**
 *
 * @author sogri
 */
public class ThreadNamePrinter implements Runnable {
    private final String name;
    private final Object lock;

    public ThreadNamePrinter(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                try {
                    System.out.println(name);
                    lock.notifyAll();
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted.");
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
