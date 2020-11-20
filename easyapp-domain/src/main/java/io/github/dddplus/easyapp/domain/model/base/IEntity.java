package io.github.dddplus.easyapp.domain.model.base;

import io.github.dddplus.model.IDomainModel;

public interface IEntity extends IDomainModel {

    Long Id();

    Org org();
}
