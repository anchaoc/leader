
package com.ac.common.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * 使用Gson转换对象
 *
 * @author anchao
 **/
public class GsonUtil {

    /**
     * 标准
     */
    private static final Gson GSON = new GsonBuilder()
            .enableComplexMapKeySerialization()
            .create();

    /**
     * unicode
     */
    private static final Gson GSON_WITH_UNDERSCORES = new GsonBuilder()
            .enableComplexMapKeySerialization()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    /**
     * 针对单引号 双引号 修改
     */
    private static final Gson GSON_DISABLE = new GsonBuilder().disableHtmlEscaping().create();

    private GsonUtil() {
    }

    public static <T> T convert(String jsonStr, Class<T> classOfT) {
        return GSON.fromJson(jsonStr, classOfT);
    }

    public static <T> T convert(String jsonStr, Type type) {
        return GSON.fromJson(jsonStr, type);
    }


    public static String toJson(Object target) {
        return GSON.toJson(target);
    }

    public static String toUnderScoresJson(Object object) {
        return GSON_WITH_UNDERSCORES.toJson(object);
    }

    public static <T> T convertWithUnderScores(String jsonStr, Class<T> tClass) {
        return GSON_WITH_UNDERSCORES.fromJson(jsonStr, tClass);
    }

    public static <T> T convertWithUnderScores(String jsonStr, Type type) {
        return GSON_WITH_UNDERSCORES.fromJson(jsonStr, type);
    }

    public static String toJsonGSON_DISABLE(Object target) {
        return GSON_DISABLE.toJson(target);
    }
}