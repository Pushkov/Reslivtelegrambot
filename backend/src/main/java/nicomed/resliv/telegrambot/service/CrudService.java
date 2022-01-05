package nicomed.resliv.telegrambot.service;

import java.util.Collection;

public interface CrudService<C, D, ID> {

    D findById(ID id);

    void save(C creatDto);

    Collection<D> findAll();

    void delete(ID id);
}
