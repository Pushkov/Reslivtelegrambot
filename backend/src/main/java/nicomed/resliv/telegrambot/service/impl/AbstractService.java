package nicomed.resliv.telegrambot.service.impl;

import nicomed.resliv.telegrambot.service.BaseService;
import nicomed.resliv.telegrambot.service.CrudService;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class AbstractService<D, T, ID> implements BaseService<T, ID>, CrudService<D, ID> {

    @Override
    public D findById(ID id) {
        return getRepository().findById(id).map(this::mapToDto)
                .orElseGet(null);
    }

    @Override
    public void save(D dto) {
        getRepository().save(mapToEntity(dto));
    }

    @Override
    public Collection<D> findAll() {
        return getRepository().findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    public abstract D mapToDto(T entity);

    public abstract T mapToEntity(D dto);

    public abstract void mapToEntity(T entity, D dto);
}
