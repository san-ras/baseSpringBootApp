package lt.techin.examSR.service;


import lt.techin.examSR.model.Item;
import lt.techin.examSR.repository.ItemRepository;
import lt.techin.examSR.rest.dto.ItemDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDto> findAllItems() {
            return itemRepository.findAll().stream().map(Item::toDto).toList();
        }


    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
