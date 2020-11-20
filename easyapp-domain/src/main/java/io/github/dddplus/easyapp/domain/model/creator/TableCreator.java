package io.github.dddplus.easyapp.domain.model.creator;

import io.github.dddplus.easyapp.domain.model.base.Org;
import io.github.dddplus.model.IDomainModelCreator;
import lombok.Data;

@Data
public class TableCreator implements IDomainModelCreator {
    private Org org;
    private String name;
}
