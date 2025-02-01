package lt.techin.examSR.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lt.techin.examSR.rest.dto.ItemDto;

import java.util.List;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinTable(
            name = "item_property",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "property_id"))
    private List<Property> properties;

    //todo add getter setter constructor


    public Item(Long id, String title, List<Property> properties) {
        this.id = id;
        this.title = title;
        this.properties = properties;
    }

    public Item() {}


    public ItemDto toDto() {
        return new ItemDto(this.id, this.title, this.properties);
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
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

}
