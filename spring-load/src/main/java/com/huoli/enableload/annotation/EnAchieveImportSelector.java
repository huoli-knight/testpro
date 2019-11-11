package com.huoli.enableload.annotation;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@Import(AchieveImportSelector.class)
public @interface EnAchieveImportSelector {
}
