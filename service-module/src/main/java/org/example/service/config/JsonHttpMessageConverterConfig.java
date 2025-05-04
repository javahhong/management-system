package org.example.service.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.Collections;

/**
 * @program: my-multi-module-project
 * @author: hhong
 * @create: 2025-04-21 15:29
 **/
@Configuration
public class JsonHttpMessageConverterConfig {
    @Bean
    @Primary             //优先使用这个bean
    public HttpMessageConverters fastJsonHttpMessageConverters(){
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,                    //输出格式化（带缩进）
                SerializerFeature.WriteNullStringAsEmpty,          //字符串为null时输出“ ”
                SerializerFeature.WriteNullListAsEmpty,            //列表为null时输出“ ”
                SerializerFeature.WriteMapNullValue,               //映射中的null值保留
                SerializerFeature.MapSortField,                    //按字段名排序输出
                SerializerFeature.DisableCircularReferenceDetect   //禁用循环应用检测(正常生产环境建议不要禁用)
        );
        //将配置消息应用到转换器
        fastConverter.setFastJsonConfig(fastJsonConfig);
        fastConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new HttpMessageConverters(fastConverter);
    }
}
