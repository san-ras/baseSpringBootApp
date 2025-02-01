package lt.techin.examSR.repository;

import lt.techin.examSR.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByTitleContainingIgnoreCase(String title);
}
