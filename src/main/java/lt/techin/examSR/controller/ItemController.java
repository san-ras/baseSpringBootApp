package lt.techin.examSR.controller;

import jakarta.validation.Valid;
import lt.techin.examSR.rest.dto.ItemDto;
import lt.techin.examSR.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping
    public ResponseEntity<List<ItemDto>> findAllItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> findItemById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findItemById(id));
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.createItem(itemDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ItemDto>> findByTitleContainingIgnoreCase(@Valid @RequestParam String title) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findByTitleContainingIgnoreCase(title));
    }

    @PutMapping
    public ResponseEntity<ItemDto> updateItem(@Valid @RequestBody ItemDto itemDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.updateItem(itemDto));
    }

    @GetMapping("/propertyId")
    public ResponseEntity<List<ItemDto>> findAllItemsByPropertyId(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findAllItemsByPropertyId(id));
    }

    @GetMapping("/property/{name}")
    public ResponseEntity<List<ItemDto>> findAllItemsByPropertyName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findAllItemsByPropertyName(name));
    }

}
