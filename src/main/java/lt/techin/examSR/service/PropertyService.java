package lt.techin.examSR.service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.techin.examSR.repository.PropertyRepository;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class PropertyService {

    private PropertyRepository propertyRepository;



}
