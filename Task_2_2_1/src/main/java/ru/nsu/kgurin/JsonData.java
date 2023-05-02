package ru.nsu.kgurin;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;

/**
 * Class for reading Json data.
 */
public class JsonData {
    private final List<Baker> bakers;
    private final List<Deliverer> deliverers;
    private final List<Order> orders;

    /**
     * Constructor.
     *
     * @param file file with data to read
     */
    public JsonData(String file) {
        Gson gson = new Gson();
        JsonData jsonData;
        try (Reader reader = new InputStreamReader(Objects.requireNonNull(
                Main.class.getClassLoader().getResourceAsStream(file)))) {
            jsonData = gson.fromJson(reader, JsonData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.bakers = jsonData.bakers;
        this.deliverers = jsonData.deliverers;
        this.orders = jsonData.orders;

    }

    /**
     * Get list of bakers.
     *
     * @return list of bakers
     */
    public List<Baker> getBakers() {
        return bakers;
    }

    /**
     * Get list of deliverers.
     *
     * @return list of deliverers
     */
    public List<Deliverer> getDeliverers() {
        return deliverers;
    }

    /**
     * Get list of orders.
     *
     * @return list of orders
     */
    public List<Order> getOrders() {
        return orders;
    }
}
