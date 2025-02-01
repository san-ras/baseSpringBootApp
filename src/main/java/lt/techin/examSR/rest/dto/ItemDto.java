package lt.techin.examSR.rest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private Long id;

    @NotNull(message = "Title must be provided")
    @Size(min = 1, max = 50, message = "Title's length must be 1 to 50 characters")
    private String title;

    private List<PropertyDto> properties = new ArrayList<>();

}
