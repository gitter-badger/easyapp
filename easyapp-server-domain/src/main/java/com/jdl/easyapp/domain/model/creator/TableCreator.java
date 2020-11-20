package com.jdl.easyapp.domain.model.creator;

import com.jdl.easyapp.domain.model.base.Org;
import io.github.dddplus.model.IDomainModelCreator;
import lombok.Data;

@Data
public class TableCreator implements IDomainModelCreator {
    private Org org;
    private String name;
}
