package com.congfu.util;

import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 反序列化工具
 *  
 * @author congfu
 * @Date 2016年9月5日
 */
public class SerializableTool {
    private SerializableTool(){
    }
    /**
     * 序列化
     * 
     * @param object 待序列化的实例对象
     * @return 序列化的JSON字符串
     * @throws Exception
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月5日
     * </PRE>
     */
    public static <T> String serialize(T object) throws Exception{
        if(object == null) 
            return null;
        try {
            return JSON.toJSONString(object);
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("serialize failed. \n" + object.toString());
            throw e;
        }
    }
    /**
     * 序列化
     * 
     * @param object 待序列化的实例对象
     * @return 序列化的JSON字符串
     * @throws Exception
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月5日
     * </PRE>
     */
    public static<T> String serializeFormat(T object) throws Exception{
        return serialize(object, SerializerFeature.PrettyFormat);
    }
    
    /**
     * 序列化
     * 
     * @param object 待序列化的实例对象
     * @return 序列化的JSON字符串
     * @throws Exception
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月5日
     * </PRE>
     */
    public static <T> String serializeDataFormat(T object) throws Exception{
        return serialize(object,SerializerFeature.WriteDateUseDateFormat);
    }
    
    /**
     * 序列化
     * 
     * 
     * @param object 待序列化的实例对象
     * @return 序列化的JSON对象
     * @throws Exception
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月5日
     * </PRE>
     */
    public static <T> String serializeDataAndPrettyFormat(T object) throws Exception{
        return serialize(object,SerializerFeature.PrettyFormat,SerializerFeature.WriteDateUseDateFormat);
    }
    
    /**
     * 序列化
     * 
     * @param object 待序列化的实例对象
     * @param features
     * @return 序列化的JSON字符串
     * @throws Exception
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月5日
     * </PRE>
     */
    private static <T> String serialize(T object, SerializerFeature... features) throws Exception{
        if (object == null) 
            return null;
        try {
            return JSON.toJSONString(object, features);
        } catch (Exception e) {
            // TODO: handle exception
           System.err.println("serialize failed. \n" + object.toString());
           throw e;
        }
    }
    
    /**
     * 反序列化
     * 
     * @param jsonString 待反序列化的json字符串
     * @param clazz 反序列化的目标对象class
     * @return 目标实例对象
     * @throws Exception
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月5日
     * </PRE>
     */
    public static <T> T parseObject(String jsonString, Class<T> clazz) throws Exception{
        if(StringUtils.isBlank(jsonString))
            return null;
        try {
            return JSON.parseObject(jsonString,clazz);
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("serialize failed. \n" + jsonString);
            throw e;
        }   
    }
    
    /**
     * 方法parse的功能描述：反序列化
     * 
     * 
     * @param jsonString 待反序列化的json字符串
     * @throws Exception
     * @return Object 目标实例对象
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月5日
     * </PRE>
     */
    public static Object parse(String jsonString) throws Exception{
        if (StringUtils.isBlank(jsonString))
            return null;
        try {
            return JSON.parse(jsonString);
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("serialize failed. \n" + jsonString);
            throw e;
        }
    }
    
    /**
     * 反序列化
     * 
     * @param jsonString 待反序列化的json字符串
     * @param clazz 反序列化的目标对象class
     * @return object 目标实例对象
     * @throws Exception
     * @since v0.0.1
     * <PRE>
     * author congfu
     * Date 2016年9月5日
     * </PRE>
     */
    public static Object deserialize(String jsonString, Class<?> clazz) throws Exception{
        if(StringUtils.isBlank(jsonString))
            return null;
        try {
            if(StringUtils.startsWith(jsonString, "[")){
                return JSON.parseArray(jsonString, clazz);
            }else {
                return JSON.parseObject(jsonString, clazz);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("serialize failed. \n" + jsonString);
            throw e;
        }
    }
}
