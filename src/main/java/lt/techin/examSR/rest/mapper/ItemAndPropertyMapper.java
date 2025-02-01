package lt.techin.examSR.rest.mapper;

import lt.techin.examSR.model.Item;
import lt.techin.examSR.rest.dto.ItemDto;
import lt.techin.examSR.model.Property;
import lt.techin.examSR.rest.dto.PropertyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemAndPropertyMapper {

    @Mapping(target = "properties", source = "properties")
    ItemDto toDto(Item item);

    @Mapping(target = "properties", source = "properties")
    Item toEntity(ItemDto itemDto);

    PropertyDto toDto(Property property);
    Property toEntity(PropertyDto propertyDto);

    List<PropertyDto> propertiesToPropertyDtos(List<Property> properties);
    List<Property> propertyDtosToProperties(List<PropertyDto> propertyDtos);
}
