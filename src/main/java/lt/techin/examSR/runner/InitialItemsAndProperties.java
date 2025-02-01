package lt.techin.examSR.runner;

import lt.techin.examSR.model.Item;
import lt.techin.examSR.model.Property;
import lt.techin.examSR.repository.ItemRepository;
import lt.techin.examSR.repository.PropertyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Order(2)
public class InitialItemsAndProperties implements CommandLineRunner {

    private ItemRepository itemRepository;
    private PropertyRepository propertyRepository;

    public InitialItemsAndProperties(ItemRepository itemRepository, PropertyRepository propertyRepository) {
        this.itemRepository = itemRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Item item1 = new Item();
        item1.setTitle("Item 1");

        Item item2 = new Item();
        item2.setTitle("Item 2");

        Item item3 = new Item();
        item3.setTitle("Item 3");

        Item item4 = new Item();
        item4.setTitle("Item 4");

        itemRepository.saveAll(Arrays.asList(item1, item2, item3, item4));

        Property property1 = new Property();
        property1.setName("Property 1");

        Property property2 = new Property();
        property2.setName("Property 2");

        Property property3 = new Property();
        property3.setName("Property 3");

        property1.setItems(Arrays.asList(item1, item2));
        property2.setItems(Arrays.asList(item2, item3));
        property3.setItems(Arrays.asList(item3, item4));

        propertyRepository.saveAll(Arrays.asList(property1, property2, property3));

        item1.setProperties(Arrays.asList(property1));
        item2.setProperties(Arrays.asList(property1, property2));
        item3.setProperties(Arrays.asList(property2, property3));
        item4.setProperties(Arrays.asList(property3));

        itemRepository.saveAll(Arrays.asList(item1, item2, item3, item4));

    }
}

