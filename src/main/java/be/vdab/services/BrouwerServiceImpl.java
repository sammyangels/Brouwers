package be.vdab.services;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@ReadOnlyTransactionalService
class BrouwerServiceImpl implements BrouwerService {
    private final BrouwerDAO brouwerDAO;

    @Autowired
    BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
        this.brouwerDAO = brouwerDAO;
    }

    @Override
    @ModifyingTransactionalServiceMethod
    public void create(Brouwer brouwer) {
        brouwerDAO.save(brouwer);
    }

    @Override
    public List<Brouwer> findAll() {
        return brouwerDAO.findAll(new Sort("naam"));
    }

    @Override
    public List<Brouwer> findByNaam(String beginNaam) {
        return brouwerDAO.findByNaamStartsWithOrderByNaamAsc(beginNaam);
    }
}
