package com.jdl.easyapp.domain.ability.extension.field;

import com.jdl.easyapp.domain.ext.IFieldValidateExt;
import com.jdl.easyapp.domain.model.Column;
import com.jdl.easyapp.domain.pattern.EmailFieldPattern;
import io.github.dddplus.annotation.Extension;

@Extension(code = EmailFieldPattern.CODE)
public class EmailValidateExt implements IFieldValidateExt {

    @Override
    public void validate(Column column, String value) {

    }
}
