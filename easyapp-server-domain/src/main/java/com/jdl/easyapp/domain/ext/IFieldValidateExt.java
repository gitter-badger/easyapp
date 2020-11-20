package com.jdl.easyapp.domain.ext;

import com.jdl.easyapp.domain.model.Column;
import io.github.dddplus.ext.IDomainExtension;

public interface IFieldValidateExt extends IDomainExtension {

    void validate(Column column, String value);

}
