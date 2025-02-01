package lt.techin.examSR.service;


import lt.techin.examSR.repository.PropertyRepository;
import org.springframework.stereotype.Service;


@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }


}
