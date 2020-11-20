package com.jdl.easyapp.domain.pattern;

import com.jdl.easyapp.domain.dict.ColumnType;
import com.jdl.easyapp.domain.model.Column;
import io.github.dddplus.annotation.Pattern;
import io.github.dddplus.ext.IIdentityResolver;

@Pattern(code = MobileFieldPattern.CODE, name = "mobile")
public class MobileFieldPattern implements IIdentityResolver<Column> {
    public static final String CODE = "mobile";

    @Override
    public boolean match(Column model) {
        return ColumnType.Mobile.equals(model.getColumnType());
    }
}
