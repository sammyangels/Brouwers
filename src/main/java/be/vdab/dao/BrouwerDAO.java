package be.vdab.dao;

import be.vdab.entities.Brouwer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrouwerDAO extends JpaRepository<Brouwer, Long> {
    List<Brouwer> findByNaamStartsWithOrderByNaamAsc(String beginNaam);
}
