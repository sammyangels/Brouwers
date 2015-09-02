package be.vdab.dao;

import be.vdab.entities.Brouwer;

import java.util.List;

public interface BrouwerDAO {
    void create(Brouwer brouwer);

    List<Brouwer> findAll();

    List<Brouwer> findByNaam(String beginNaam);
}
