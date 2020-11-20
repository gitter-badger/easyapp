package io.github.dddplus.easyapp.domain.ext;

import io.github.dddplus.easyapp.domain.model.Column;
import io.github.dddplus.ext.IDomainExtension;

public interface IFieldValidateExt extends IDomainExtension {

    void validate(Column column, String value);

}
