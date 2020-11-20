package com.jdl.easyapp.domain.model.mock;

import com.jdl.easyapp.domain.facade.repository.IIdRepository;

public class IdRepository implements IIdRepository {
    private long id;

    @Override
    public Long newId() {
        return ++id;
    }

}
