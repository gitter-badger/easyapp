package io.github.dddplus.easyapp.domain.ability.extension.column;

import io.github.dddplus.annotation.Extension;
import io.github.dddplus.easyapp.domain.ext.IFieldValidateExt;
import io.github.dddplus.easyapp.domain.model.Column;
import io.github.dddplus.easyapp.domain.pattern.TextFieldPattern;

@Extension(code = TextFieldPattern.CODE)
public class TextValidateExt implements IFieldValidateExt {

    @Override
    public void validate(Column column, String value) {

    }
}
