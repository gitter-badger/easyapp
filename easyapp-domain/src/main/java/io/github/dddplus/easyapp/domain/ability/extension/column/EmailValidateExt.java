package io.github.dddplus.easyapp.domain.ability.extension.column;

import io.github.dddplus.annotation.Extension;
import io.github.dddplus.easyapp.domain.ext.IFieldValidateExt;
import io.github.dddplus.easyapp.domain.model.Column;
import io.github.dddplus.easyapp.domain.pattern.EmailFieldPattern;

@Extension(code = EmailFieldPattern.CODE)
public class EmailValidateExt implements IFieldValidateExt {

    @Override
    public void validate(Column column, String value) {

    }
}
