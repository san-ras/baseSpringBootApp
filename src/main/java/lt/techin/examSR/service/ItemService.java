package lt.techin.examSR.service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lt.techin.examSR.exception.ItemNotFoundException;
import lt.techin.examSR.model.Item;
import lt.techin.examSR.model.Property;
import lt.techin.examSR.repository.ItemRepository;
import lt.techin.examSR.repository.PropertyRepository;
import lt.techin.examSR.rest.dto.ItemDto;
import lt.techin.examSR.rest.dto.PropertyDto;
import lt.techin.examSR.rest.mapper.ItemAndPropertyMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@Service
public class ItemService {

    private ItemAndPropertyMapper mapper;
    private ItemRepository itemRepository;
    private PropertyRepository propertyRepository;

    private static final String ITEM_NOT_FOUND_WITH_ID = "Item not found with id: ";


    public List<ItemDto> findAllItems() {
        return itemRepository.findAll().stream().map(itemDto -> mapper.toDto(itemDto)).toList();
    }

    public ItemDto findItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(ITEM_NOT_FOUND_WITH_ID + id));
        return mapper.toDto(item);
    }

    public ItemDto createItem(ItemDto itemDto) {
        Item item = mapper.toEntity(itemDto);
        item.setId(null);
        List<Property> properties = propertyRepository.findAllById(
                itemDto.getProperties().stream().map(PropertyDto::getId).collect(Collectors.toList())
        );
        item.setProperties(properties);
        itemRepository.save(item);
        return mapper.toDto(item);
    }

    public void deleteItem(Long id) {
        itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(ITEM_NOT_FOUND_WITH_ID + id));
        itemRepository.deleteById(id);
    }

    public List<ItemDto> findByTitleContainingIgnoreCase(String title) {
        List<Item> listOfItems = itemRepository.findByTitleContainingIgnoreCase(title);
        return listOfItems.stream().map(item -> mapper.toDto(item)).toList();
    }

    public ItemDto updateItem(ItemDto itemDto) {
        Item item = itemRepository.findById(itemDto.getId())
                .orElseThrow(() -> new ItemNotFoundException(ITEM_NOT_FOUND_WITH_ID + itemDto.getId()));
        item.setTitle(itemDto.getTitle());
        item.setProperties(mapper.propertyDtosToProperties(itemDto.getProperties()));
        itemRepository.save(item);
        return mapper.toDto(item);
    }

    public List<ItemDto> findAllItemsByPropertyId(Long id) {
        List<Item> listOfItems = itemRepository.findByPropertiesId(id);
        return listOfItems.stream().map(item -> mapper.toDto(item)).toList();
    }

    public List<ItemDto> findAllItemsByPropertyName(String name) {
        List<Item> listOfItems = itemRepository.findByPropertiesName(name);
        return listOfItems.stream().map(item -> mapper.toDto(item)).toList();
    }

}
