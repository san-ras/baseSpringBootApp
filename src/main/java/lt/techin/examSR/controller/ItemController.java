package lt.techin.examSR.controller;

import lt.techin.examSR.rest.dto.ItemDto;
import lt.techin.examSR.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/items")
    public ResponseEntity<List<ItemDto>> findAllItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findAllItems());
    }

}
