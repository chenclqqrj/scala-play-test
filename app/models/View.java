package models;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface View {
    public boolean editable() default false; // 可编辑
    public boolean hasAddOperate() default true; // 有新增操作
    public boolean hasRemoveOperate() default true; // 有删除操作
    public boolean hasUpdateOperate() default true; // 有更新操作
}
