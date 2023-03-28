package ru.nsu.kgurin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Class for start pizzeria.
 */
public class Pizzeria {
    /**
     * Method to upload data and start pizzeria.
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();

        List<Baker> bakers = objectMapper.readValue(
                new File("src/main/resources/Bakers.json"),
                typeFactory.constructCollectionType(List.class, Baker.class));
        bakers.sort((o1, o2) -> o2.getSkill() - o1.getSkill());

        List<Deliverer> deliverers = objectMapper.readValue(
                new File("src/main/resources/Deliverers.json"),
                typeFactory.constructCollectionType(List.class, Deliverer.class));
        deliverers.sort((o1, o2) -> o2.getSkill() - o1.getSkill());


        List<Stock> stocks = objectMapper.readValue(
                new File("src/main/resources/Stocks.json"),
                typeFactory.constructCollectionType(List.class, Stock.class));
        stocks.sort((o1, o2) -> o2.getCapacity() - o1.getCapacity());

        List<Order> queue = objectMapper.readValue(
                new File("src/main/resources/Orders.json"),
                typeFactory.constructCollectionType(List.class, Order.class));

        Staff staff = new Staff(bakers, deliverers, stocks);

        System.out.println("Пиццерия открыта и готова к принятию заказов.");
        for (var i : queue) {
            CreateOrder.createAndStart(i, staff);
            Thread.sleep(2000);
        }
        Thread.currentThread().join();
        System.out.println("Пиццерия закрыта.");
    }
}
