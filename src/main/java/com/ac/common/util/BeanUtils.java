package com.ac.common.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * spring cglib
 * BeanUtils
 *
 * @author anchao
 */
public class BeanUtils {

    public static <T> T copy(Object source, Class<T> targetClass) {
        if (source == null || targetClass == null) {
            return null;
        }
        try {
            BeanCopier beanCopier = BeanCopier.create(source.getClass(), targetClass, false);
            T target = targetClass.newInstance();
            beanCopier.copy(source, target, null);
            return target;
        } catch (Exception e) {
            return null;
        }
    }

    public static <T, K> List<K> copyList(Collection<T> sources, Class<K> targetClass) {
        if (CollectionUtils.isEmpty(sources) || targetClass == null) {
            return Lists.newArrayList();
        }
        try {
            Iterator<T> iterator = sources.iterator();
            BeanCopier beanCopier = BeanCopier.create(iterator.next().getClass(), targetClass, false);
            List<K> result = Lists.newArrayList();
            for (Object source : sources) {
                K target = targetClass.newInstance();
                beanCopier.copy(source, target, null);
                result.add(target);
            }
            return result;
        } catch (Exception e) {
            return Lists.newArrayList();
        }
    }

    /**
     * 将bean转为map
     *
     * @param object
     * @return
     */
    public static Map<String, Object> bean2map(Object object) {
        Map<String, Object> result = Maps.newHashMap();
        if (object != null) {
            BeanMap beanMap = BeanMap.create(object);
            for (Object key : beanMap.keySet()) {
                result.put(key + "", beanMap.get(key));
            }
        }
        return result;
    }

    /**
     * 将bean转为map
     *
     * @param object
     * @return
     */
    public static Map<String, String> bean2mapStr(Object object) {
        Map<String, String> result = Maps.newHashMap();
        if (object != null) {
            BeanMap beanMap = BeanMap.create(object);
            for (Object key : beanMap.keySet()) {
                Object value = beanMap.get(key);
                if (value != null) {
                    result.put(key + "", String.valueOf(value));
                }
            }
        }
        return result;
    }



}