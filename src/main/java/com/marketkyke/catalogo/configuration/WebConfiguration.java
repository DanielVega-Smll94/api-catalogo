package com.marketkyke.catalogo.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        for(HttpMessageConverter<?> converter:converters){
            //RECIBO ALGO LO CONVIERTO EN OTRA COSA
            if(converter instanceof MappingJackson2HttpMessageConverter){
                ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) converter).getObjectMapper();
                //CONFIG NOMBRES DE ATRIBUTOS EN MAY O MIN
                objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CASE);
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                //INCLUIR ATRIBUTOS A LA PARTE DE LA RESPUESTA, SI ES NON_NULL SACALO DE LA RESPUESTA POR EL VOLUMEN DE DATO
                //TARDA LA RESPUESTA
                objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            }
        }
    }
}
