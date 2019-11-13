/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.qunce.utils;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @ClassName ObjectUtils
 * @Description 对象工具类
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2019/11/13 9:14
 * @ModifyDate 2019/11/13 9:14
 * @Version 1.0
 */
public class ObjectUtils {

    public static final String STRING_CLASS_TYPE = "class java.lang.String";

    public static final String GET_METHOD_TYPE = "get";

    /**
     * @Description 如果对象String类型的值为空，则将它们初始化为 ""。
     * 主要用于向客户端传递数据时，保证字符类型不为null。
     * @Author soul goodman
     * @Date 2019/11/13 9:19
     * @ModifyDate 2019/11/13 9:19
     * @Params obj 可能包含空字符串属性的实体对象
     * @Return T 不包含空字符串属性的实体对象
     */
    public <T> T checkNullAndInit(@NotNull T obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<? extends Object> clazz = obj.getClass();

        // 获取实体的所有属性， 返回Filed数组
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            // 可访问私有变量
            field.setAccessible(true);
            // 获取属性类型
            String fieldType = field.getGenericType().toString();

            // 如果type是类类型，则在属性类型前追加"class "，后面跟类名
            if(STRING_CLASS_TYPE.equals(fieldType)) {
                String methodName = field.getName().replaceFirst(field.getName().substring(0, 1), field.getName().substring(0, 1).toUpperCase());
                Method methodGet = clazz.getMethod(GET_METHOD_TYPE + methodName);
                // 调用getter方法获取属性值
                String str = (String) methodGet.invoke(obj);
                if (str == null) {
                    // 如果为null的String类型的属性则重新复制为空字符串
                    field.set(obj, field.getType().getConstructor(field.getType()).newInstance(""));
                }
            }
        }
        
        return obj;
    }


}
