package lt.techin.examSR.rest.dto;

import lt.techin.examSR.model.Property;

public class PropertyDto {

    private Long id;
    private String name;

    public PropertyDto() {
    }

    public PropertyDto(Property property) {
        this.id = property.getId();
        this.name = property.getName();
    }
}
