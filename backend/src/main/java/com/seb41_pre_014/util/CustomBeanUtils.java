package com.seb41_pre_014.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Collection;

// Custom BeanUtils 클래스
@Component
public class CustomBeanUtils<T> {   // 제네릭이 적용되어 있어서 아무 클래스에서나 사용 가능

    public T copyNonNullProperties(T source, T destination) {
        if (source == null || destination == null || source.getClass() != destination.getClass()) {
            return null;
        }

        final BeanWrapper src = new BeanWrapperImpl(source);    // 가져온 모든 필드를 저장할 변수
        final BeanWrapper dest = new BeanWrapperImpl(destination);  // 모든 필드들 중 변경한 값만 저장할 변수

        for (final Field property : source.getClass().getDeclaredFields()) {    // 모든 필드를 가져와서
            Object sourceProperty = src.getPropertyValue(property.getName());   // 해당 필드 안에 들어가 있는 값을 가져옴

            if (sourceProperty != null && !(sourceProperty instanceof Collection<?>)) { // null이 아닌 값만
                dest.setPropertyValue(property.getName(), sourceProperty);  // dest에 저장 ---> 수정하고자하는 정보들만 업데이트 됨
            }
        }

        return destination; // 얘가 위의 모두를 포함하는 것이라 destionation를 리턴
    }
}
