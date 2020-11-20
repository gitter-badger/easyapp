package com.jdl.easyapp.domain.pattern;

import com.jdl.easyapp.domain.dict.ColumnType;
import com.jdl.easyapp.domain.model.Column;
import io.github.dddplus.annotation.Pattern;
import io.github.dddplus.ext.IIdentityResolver;

@Pattern(code = TextFieldPattern.CODE, name = "text")
public class TextFieldPattern implements IIdentityResolver<Column> {
    public static final String CODE = "text";

    @Override
    public boolean match(Column model) {
        return ColumnType.Text.equals(model.getColumnType()) || ColumnType.TextArea.equals(model.getColumnType());
    }
}
