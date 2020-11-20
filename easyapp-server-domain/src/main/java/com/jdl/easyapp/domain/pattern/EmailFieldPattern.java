package com.jdl.easyapp.domain.pattern;

import com.jdl.easyapp.domain.dict.ColumnType;
import com.jdl.easyapp.domain.model.Column;
import io.github.dddplus.annotation.Pattern;
import io.github.dddplus.ext.IIdentityResolver;

@Pattern(code = EmailFieldPattern.CODE, name = "email")
public class EmailFieldPattern implements IIdentityResolver<Column> {
    public static final String CODE = "email";

    @Override
    public boolean match(Column model) {
        return ColumnType.Email.equals(model.getColumnType());
    }
}
