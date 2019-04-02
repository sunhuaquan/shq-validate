package com.shq.validate.aspect;

import com.shq.validate.annotation.ShqValidate;
import com.shq.validate.exception.ValidateException;
import com.shq.validate.helper.ValidateHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @author sunhuaquan
 * @Title: ShqValidateAspect
 * @ProjectName shq-validate
 * @Description: TODO
 * @date 2019/3/3110:22
 */

@Aspect
@Component
public class ShqValidateAspect {


    @Around("execution(* com.shq.validate.controller..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("-------------ShqValidateAspect start------------------");
        Object[] args = pjp.getArgs();
        if (args == null) {
            return pjp.proceed();
        }
        for (Object parma : args) {
            if (parma != null) {
                validate(parma);
            }
        }
        System.out.println("-------------ShqValidateAspect end------------------");
        return pjp.proceed();

    }

    private boolean validate(Object parma) throws IllegalAccessException {
        if (isBasicType(parma.getClass())) {
            return true;
        }
        Class clazz = parma.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields == null) {
            return true;
        }
        for (Field field : fields) {
            ShqValidate shqValidate = field.getAnnotation(ShqValidate.class);
            if (shqValidate != null) {
                field.setAccessible(true);
                Object value = field.get(parma);
                //验证是否必须
                if (shqValidate.require()) {
                    if (ValidateHelper.isEmpty(value)) {
                        throw new ValidateException("字段" + field.getName() + "必须输入值");
                    }
                }
                if (value.toString().length() < shqValidate.minLength()) {
                    throw new ValidateException("字段" + field.getName() + "长度必须大于等于" + shqValidate.minLength());
                }
                if (value.toString().length() > shqValidate.maxLength()) {
                    throw new ValidateException("字段" + field.getName() + "长度必须小于等于" + shqValidate.maxLength());
                }
                //验证正则表达式
                if (!StringUtils.isEmpty(shqValidate.regex())) {
                    if (!ValidateHelper.isMatchRegex(shqValidate.regex(), value.toString())) {
                        throw new ValidateException("字段" + field.getName() + "格式不正确");
                    }
                }
            }
        }
        return true;
    }

    public boolean isBasicType(Class clazz) {

        Class aClass = clazz.getClass();
        if (aClass == Integer.class) {
            return true;
        }
        if (aClass == Character.class) {
            return true;
        }
        if (aClass == Byte.class) {
            return true;
        }
        if (aClass == Short.class) {
            return true;
        }
        if (aClass == Boolean.class) {
            return true;
        }
        if (aClass == Double.class) {
            return true;
        }
        if (aClass == Float.class) {
            return true;
        }
        if (aClass == Long.class) {
            return true;
        }
        if (aClass == String.class) {
            return true;
        }
        return false;
    }
}
