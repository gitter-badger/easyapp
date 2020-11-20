package io.github.dddplus.easyapp.domain.ability;

import io.github.dddplus.annotation.DomainAbility;
import io.github.dddplus.easyapp.domain.CoreDomain;
import io.github.dddplus.easyapp.domain.ext.IFieldValidateExt;
import io.github.dddplus.easyapp.domain.model.Column;
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
