package io.github.dddplus.easyapp.domain.ability.extension.column;

import io.github.dddplus.annotation.Extension;
import io.github.dddplus.easyapp.domain.ext.IFieldValidateExt;
import io.github.dddplus.easyapp.domain.model.Column;
import io.github.dddplus.easyapp.domain.pattern.MobileFieldPattern;

@Extension(code = MobileFieldPattern.CODE)
public class MobileValidateExt implements IFieldValidateExt {

    @Override
    public void validate(Column column, String value) {

    }
}
