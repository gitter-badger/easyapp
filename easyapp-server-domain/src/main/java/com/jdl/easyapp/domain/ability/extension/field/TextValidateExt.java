package com.jdl.easyapp.domain.ability.extension.field;

import com.jdl.easyapp.domain.ext.IFieldValidateExt;
import com.jdl.easyapp.domain.model.Column;
import com.jdl.easyapp.domain.pattern.TextFieldPattern;
import io.github.dddplus.annotation.Extension;

@Extension(code = TextFieldPattern.CODE)
public class TextValidateExt implements IFieldValidateExt {

    @Override
    public void validate(Column column, String value) {

    }
}
