package ru.nsu.kgurin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * ru.nsu.kgurin.Main class.
 */
public class Main {
    public static ExecutorService bakersPool;
    public static ExecutorService deliverersPool;
    public static List<Baker> bakers = new ArrayList<>();
    public static List<Deliverer> deliverers = new ArrayList<>();
    public static volatile BlockingDeque<Order> queue = new LinkedBlockingDeque<>();
    public static volatile BlockingDeque<Order> stock = new LinkedBlockingDeque<>();

    /**
     * Here we collect all data about personal, start and
     * close pizzeria.
     *
     * @param args args
     */
    public static void main(String[] args) {
        JsonData jsonData = new JsonData("data.json");

        queue.addAll(jsonData.getOrders());
        bakers = jsonData.getBakers();
        deliverers = jsonData.getDeliverers();

        bakersPool = newFixedThreadPool(bakers.size());
        deliverersPool = newFixedThreadPool(deliverers.size());

        openPizzeria();
        closePizzeria();
    }

    /**
     * Method to open pizzeria.
     */
    public static void openPizzeria() {
        bakers.forEach(bakersPool::execute);
        deliverers.forEach(deliverersPool::execute);
    }

    /**
     * Method to close pizzeria.
     */
    public static void closePizzeria() {
        while (true) {
            if (queue.isEmpty() && bakers.stream().noneMatch(Baker::isBusy)) {
                bakersPool.shutdownNow();
                break;
            }
        }
        while (true) {
            if (stock.isEmpty() && deliverers.stream().noneMatch(Deliverer::isBusy)) {
                deliverersPool.shutdownNow();
                break;
            }
        }
        System.out.println("Pizzeria is closed");
    }

    /**
     * Method for bakers to take order from queue.
     *
     * @return order
     * @throws InterruptedException if interrupted
     */
    public static Order takeFromQueue() throws InterruptedException {
        return queue.pollFirst(5, TimeUnit.SECONDS);
    }

    /**
     * Method for deliverers to take orders from stock.
     *
     * @param capacity bag capacity of current deliverer
     * @return list of orders to deliver
     * @throws InterruptedException if interrupted
     */
    public static List<Order> takeFromStock(int capacity) throws InterruptedException {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            Order order = stock.pollFirst(5, TimeUnit.SECONDS);
            if (order != null) {
                orders.add(order);
            }
        }
        return orders;
    }

    /**
     * Method for bakers to put cooked order in stock.
     *
     * @param order order to put in stock
     */
    public static void putInStock(Order order) {
        stock.add(order);
    }
}
