package models;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 实体字段，展示描述的注解 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface FieldView {
    public String title(); // 标题
    public int width() default 80; // 宽度
    public String align() default "middle"; // 长度
    public boolean isOrder() default false; // 是否排序
    public String ico() default ""; // 图标
}
