package io.github.dddplus.easyapp.domain.pattern;

import io.github.dddplus.annotation.Pattern;
import io.github.dddplus.easyapp.domain.dict.ColumnType;
import io.github.dddplus.easyapp.domain.model.Column;
import io.github.dddplus.ext.IIdentityResolver;

@Pattern(code = TextFieldPattern.CODE, name = "text")
public class TextFieldPattern implements IIdentityResolver<Column> {
    public static final String CODE = "text";

    @Override
    public boolean match(Column model) {
        return ColumnType.Text.equals(model.getColumnType()) || ColumnType.TextArea.equals(model.getColumnType());
    }
}
