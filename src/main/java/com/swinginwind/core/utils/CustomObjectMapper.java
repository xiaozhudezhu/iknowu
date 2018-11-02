package com.swinginwind.core.utils;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BasicSerializerFactory;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.SerializerFactory;

/**
 * <p>
 * 描 述：定制ObjectMapper，主要用于定义Date和Clob类型的序列化
 * </p>
 * <p>
 * 创 建 人：hadoop
 * </p>
 * <p>
 * 创建时间：2015年12月23日上午9:15:21
 * </p>
 */
public class CustomObjectMapper extends ObjectMapper
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomObjectMapper()
    {
        changeSerializer("yyyy-MM-dd HH:mm:ss");
    }

    public CustomObjectMapper(String dateTimePattern)
    {
        changeSerializer(dateTimePattern);
    }

    public void changeSerializer(final String dateTimePattern)
    {
    	SimpleDateFormat smt = new SimpleDateFormat(dateTimePattern);  
        this.setDateFormat(smt);  
        setSerializationInclusion(Include.NON_NULL);// null不参加序列化
    }

}
