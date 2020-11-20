package io.github.dddplus.easyapp.domain.model.mock;

import io.github.dddplus.easyapp.domain.facade.repository.IIdRepository;

public class IdRepository implements IIdRepository {
    private long id;

    @Override
    public Long newId() {
        return ++id;
    }

}
