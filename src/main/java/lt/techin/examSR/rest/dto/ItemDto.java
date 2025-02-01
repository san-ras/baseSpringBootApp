package lt.techin.examSR.rest.dto;

import lt.techin.examSR.model.Item;
import lt.techin.examSR.model.Property;

import java.util.List;

public class ItemDto {

    private Long id;
    private String title;
    private List<Property> properties;


    public ItemDto() {
    }

    public ItemDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.properties = item.getProperties();
    }

    public ItemDto(Long id, String title, List<Property> properties) {
        this.id = id;
        this.title = title;
        this.properties = properties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
