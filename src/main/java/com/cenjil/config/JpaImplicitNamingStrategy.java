package com.cenjil.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitEntityNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;


/**
 * @author CenJIl
 * @date 2019/9/3 15:19
 * JPA隐式映射实体类字段的策略
 */
public class JpaImplicitNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

    private final String EnCharRegex = "[a-zA-z]+";

    @Override
    public Identifier determinePrimaryTableName(ImplicitEntityNameSource source) {
        String entityName = source.getEntityNaming().getJpaEntityName();
        if (!entityName.matches(EnCharRegex)) {
            throw new RuntimeException(String.format("表名只支持英文字符,不支持%s", entityName));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("T_");
        for (int i = 0; i < entityName.toCharArray().length; i++) {
            char c = entityName.toCharArray()[i];
            if (i > 0 && Character.isUpperCase(c)) {
                stringBuilder.append("_");
                c = Character.toLowerCase(c);
            }
            stringBuilder.append(c);
        }
        return new Identifier(stringBuilder.toString(), false);
    }

    @Override
    public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource source) {
        String fieldName = source.getAttributePath().getProperty();
        if (!fieldName.matches(EnCharRegex)) {
            throw new RuntimeException(String.format("列名只支持英文字符,不支持%s", fieldName));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("F");
        for (int i = 0; i < fieldName.toCharArray().length; i++) {
            char c = fieldName.toCharArray()[i];
            if (i == 0 && Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }
            stringBuilder.append(c);
        }
        return new Identifier(stringBuilder.toString(), false);
    }
}
