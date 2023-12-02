package com.kdt.please.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME) //라이프 사이클, 애노테이션이 언제까지 살아 남아 있을지를 정하는 것
public @interface LoginUser {

}
