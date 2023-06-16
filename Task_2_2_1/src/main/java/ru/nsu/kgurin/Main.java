package ru.nsu.kgurin;

import static java.util.concurrent.Executors.newFixedThreadPool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Main pizzeria class.
 */
public class Main {
    public static ExecutorService bakersPool;
    public static ExecutorService deliverersPool;
    public static List<Baker> bakers = new ArrayList<>();
    public static List<Deliverer> deliverers = new ArrayList<>();
    private static final Deque<Order> queue = new ArrayDeque<>();
    private static final Deque<Order> stock = new ArrayDeque<>();

    /**
     * Upload all data about employee, start and end pizzeria.
     *
     * @param args args
     */
    public static void main(String[] args) {
        JsonData jsonData = new JsonData("data.json");

        bakers = jsonData.getBakers();
        deliverers = jsonData.getDeliverers();

        bakersPool = newFixedThreadPool(bakers.size());
        deliverersPool = newFixedThreadPool(deliverers.size());

        openPizzeria();
        for (int i = 0; i < jsonData.getOrders().size(); i++) {
            synchronized (queue) {
                queue.addLast(jsonData.getOrder(i));
                queue.notifyAll();
            }
        }
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                System.out.println("Closing pizzeria...");
                closePizzeria();
                System.out.println("Pizzeria is closed");
                timer.cancel();
            }
        }, 20000);
    }

    /**
     * To open pizzeria we need submit all employee.
     */
    public static void openPizzeria() {
        bakers.forEach(bakersPool::submit);
        deliverers.forEach(deliverersPool::submit);
    }

    /**
     * To close pizzeria we need shut down all thread pools.
     */
    public static void closePizzeria() {
        bakersPool.shutdownNow();
        deliverersPool.shutdownNow();
    }

    /**
     * Take order from queue(for bakers).
     *
     * @return order
     * @throws InterruptedException if interrupted
     */
    public static Order takeFromQueue() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            return queue.pollFirst();
        }
    }

    /**
     * Take order from stock(for deliverers).
     *
     * @return order
     * @throws InterruptedException if interrupted
     */
    public static List<Order> takeFromStock(int capacity) throws InterruptedException {
        synchronized (stock) {
            List<Order> orders = new ArrayList<>();
            while (stock.isEmpty()) {
                stock.wait();
            }
            while (!stock.isEmpty() && orders.size() < capacity) {
                orders.add(stock.pollFirst());
            }
            return orders;
        }
    }

    /**
     * Put ready order in stock(for bakers).
     *
     * @param order order to put
     */
    public static void putInStock(Order order) {
        synchronized (stock) {
            stock.addLast(order);
            stock.notifyAll();
        }
    }
}