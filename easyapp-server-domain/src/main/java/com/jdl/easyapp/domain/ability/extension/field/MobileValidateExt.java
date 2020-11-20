package com.jdl.easyapp.domain.ability.extension.field;

import com.jdl.easyapp.domain.ext.IFieldValidateExt;
import com.jdl.easyapp.domain.model.Column;
import com.jdl.easyapp.domain.pattern.MobileFieldPattern;
import io.github.dddplus.annotation.Extension;

@Extension(code = MobileFieldPattern.CODE)
public class MobileValidateExt implements IFieldValidateExt {

    @Override
    public void validate(Column column, String value) {

    }
}
