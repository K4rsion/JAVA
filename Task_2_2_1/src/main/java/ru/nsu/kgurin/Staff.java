package ru.nsu.kgurin;

import java.util.List;

/**
 * Wrapper class for all staff of pizzeria.
 */
public class Staff {
    List<Baker> bakers;
    List<Deliverer> deliverers;
    List<Stock> stocks;

    /**
     * Constructor.
     * @param allBakers list of bakers
     * @param allDeliverers list of deliverers
     * @param allStocks list of stocks
     */
    public Staff(List<Baker> allBakers, List<Deliverer> allDeliverers, List<Stock> allStocks) {
        bakers = allBakers;
        deliverers = allDeliverers;
        stocks = allStocks;
    }

    /**
     * Get list of bakers.
     * @return list of bakers
     */
    public List<Baker> getBakers() {
        return bakers;
    }

    /**
     * Get list of deliverers.
     * @return list of deliverers
     */
    public List<Deliverer> getDeliverers() {
        return deliverers;
    }

    /**
     * Get list of stocks.
     * @return list of stocks
     */
    public List<Stock> getStocks() {
        return stocks;
    }
}
