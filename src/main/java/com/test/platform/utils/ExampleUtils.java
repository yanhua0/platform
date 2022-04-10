package com.test.platform.utils;
import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;
import java.lang.reflect.Field;
@Slf4j
public class ExampleUtils {
    public static Example getExample(Object object) {
        Example example = new Example(object.getClass());
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            Example.Criteria criteria = example.createCriteria();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(object);
                if (value != null) {
                    criteria=criteria.andEqualTo(field.getName(),value);
                }
            }
            example.orderBy("id").desc();
            return example;
        } catch (IllegalAccessException e) {
            log.error("reflect error",e);
        }
        return example;
    }
}
