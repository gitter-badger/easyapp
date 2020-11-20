package com.jdl.easyapp.domain.ability;

import com.jdl.easyapp.domain.CoreDomain;
import com.jdl.easyapp.domain.ext.IFieldValidateExt;
import com.jdl.easyapp.domain.model.Column;
import io.github.dddplus.annotation.DomainAbility;
import io.github.dddplus.runtime.BaseDomainAbility;

@DomainAbility(domain = CoreDomain.CODE)
public class FieldValidateAbility extends BaseDomainAbility<Column, IFieldValidateExt> {

    public void validate(Column column, String value) {
        firstExtension(column).validate(column, value);
    }

    @Override
    public IFieldValidateExt defaultExtension(Column model) {
        return null;
    }
}
