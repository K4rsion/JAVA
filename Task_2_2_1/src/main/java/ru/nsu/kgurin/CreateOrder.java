package ru.nsu.kgurin;

import java.util.List;

/**
 * Class for creating a current order. Here we find a baker,
 * stock and deliverer for complete order.
 */
public class CreateOrder implements Runnable {
    Thread order;
    Staff staff;
    Order orderDetails;

    /**
     * Constructor.
     *
     * @param ord list of all orders
     * @param stf staff of pizzeria(bakers, stocks, deliverers)
     */
    public CreateOrder(Order ord, Staff stf) {
        order = new Thread(this, ord.getId());
        orderDetails = ord;
        staff = stf;
    }

    /**
     * Method to create thread and start it.
     *
     * @param order list of all orders
     * @param staff staff of pizzeria(bakers, stocks, deliverers)
     */
    public static void createAndStart(Order order, Staff staff) {
        CreateOrder currentOrder = new CreateOrder(order, staff);
        currentOrder.order.start();
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        //find baker
        System.out.println(orderDetails.getId() + ": Поиск пекаря");
        Baker baker = findBaker(staff.getBakers());
        while (baker == null) {
            System.out.println(orderDetails.getId()
                    + ": Все пекари в данный момент заняты");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            baker = findBaker(staff.getBakers());
        }
        System.out.println(orderDetails.getId() + ": Пекарь найден: "
                + baker.getName());
        try {
            System.out.println(orderDetails.getId() + ": Пекарь готовит заказ");
            Thread.sleep(orderDetails.getComplexity()
                    / baker.getSkill() * 100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(orderDetails.getId()
                + ": Пекарь приготовил заказ и передает на склад");


        //find stock
        System.out.println(orderDetails.getId() + ": Поиск склада");
        Stock stock = findStock(staff.getStocks());
        while (stock == null) {
            System.out.println(orderDetails.getId()
                    + ": Все склады в данный момент заняты");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stock = findStock(staff.getStocks());
        }
        System.out.println(orderDetails.getId() + ": Склад найден: "
                + stock.getName()
                + ". Передаем и освобождаем повара");
        baker.changeIsCooking();
        stock.addItem();


        //find deliverer
        System.out.println(orderDetails.getId() + ": Поиск курьера");
        Deliverer deliverer = findDeliverer(staff.getDeliverers());
        while (deliverer == null) {
            System.out.println(orderDetails.getId()
                    + ": Все курьеры в данный момент заняты");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            deliverer = findDeliverer(staff.getDeliverers());
        }
        System.out.println(orderDetails.getId() + ": Курьер найден: "
                + deliverer.getName() + ". Загружаем");
        for (var currentStock : staff.getStocks()) {
            if (currentStock.getOccupied() > 0) {
                while (!deliverer.isFull() && currentStock.getOccupied() > 0) {
                    deliverer.addItemToBag();
                    stock.removeItem();
                }
            }
            if (deliverer.isFull()) {
                break;
            }
        }
        System.out.println(orderDetails.getId() + ": Курьер доставляет заказ");
        try {
            Thread.sleep(orderDetails.getComplexity()
                    / deliverer.getSkill() * 100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(orderDetails.getId()
                + ": Курьер выполнил заказ и освободился");
        deliverer.clearBag();
        deliverer.changeIsDelivering();
    }


    /**
     * Method to choose baker from list. We just find the first free baker.
     *
     * @param bakers list of bakers
     * @return null if no free baker found, object baker otherwise
     */
    public Baker findBaker(List<Baker> bakers) {
        for (var baker : bakers) {
            if (!baker.getIsCooking()) {
                baker.changeIsCooking();
                return baker;
            }
        }
        return null;
    }

    /**
     * Method to choose stock from list. We find the first not full
     * stock in which we can put an order.
     *
     * @param stocks list of stocks
     * @return null if no empty stock found, object stock otherwise
     */
    public Stock findStock(List<Stock> stocks) {
        for (var stock : stocks) {
            if (!stock.isFull()) {
                return stock;
            }
        }
        return null;
    }


    /**
     * Method to find a deliverer. We choose the first one who
     * has empty bag and not in tje process of delivering.
     *
     * @param deliverers list of deliverers
     * @return null if no free deliverer found, object deliverer otherwise
     */
    public Deliverer findDeliverer(List<Deliverer> deliverers) {
        for (var deliverer : deliverers) {
            if (!deliverer.getIsDelivering() && !deliverer.isFull()) {
                deliverer.changeIsDelivering();
                return deliverer;
            }
        }
        return null;
    }
}
