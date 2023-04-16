/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practika7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author sogri
 */
public class Practika7 {
public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Согрина Виктория, РИБО-03-21, вариант 1 ");
        Object lock = new Object();
        Thread t1 = new Thread(new ThreadNamePrinter("Thread 1", lock));
        Thread t2 = new Thread(new ThreadNamePrinter("Thread 2", lock));
        Thread t3 = new Thread(new ThreadNamePrinter("Thread 3", lock));
        t1.start();
        t2.start();
        t3.start();

        boolean running = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (running) {
            Thread.sleep(1000);
            synchronized (lock) {
                lock.notifyAll();
            }
            if (reader.ready()) {
                running = false;
            }
        }

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
    }
}
