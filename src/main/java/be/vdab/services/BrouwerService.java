package be.vdab.services;

import be.vdab.entities.Brouwer;

import java.util.List;

public interface BrouwerService {
    void create(Brouwer brouwer);

    List<Brouwer> findAll();

    List<Brouwer> findByNaam(String beginNaam);
}
