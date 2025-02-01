package lt.techin.examSR.repository;

import lt.techin.examSR.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByTitleContainingIgnoreCase(String title);

    List<Item> findByPropertiesId(Long id);

    List<Item> findByPropertiesName(String name);
}
