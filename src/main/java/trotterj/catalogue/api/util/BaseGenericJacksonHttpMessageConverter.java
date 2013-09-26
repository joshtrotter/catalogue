/**
 * 
 */
package trotterj.catalogue.api.util;

import java.io.IOException;
import java.lang.reflect.Type;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;
import trotterj.catalogue.api.domain.Catalogue;

/**
 * @author jtrotter
 *
 */
public abstract class BaseGenericJacksonHttpMessageConverter<E> extends MappingJacksonHttpMessageConverter {
		
	@Override
	public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException,	HttpMessageNotReadableException {		
		JsonNode root = getObjectMapper().readTree(inputMessage.getBody());
		String typeArg = root.path("parametricType").getTextValue();
		
		Class<?> payloadType = null;
		try {
			payloadType = Class.forName(typeArg);
			JavaType javaType = TypeFactory.defaultInstance().constructParametricType(getGenericType(), payloadType);					
			try {
				return getObjectMapper().readValue(root, javaType);
			}
			catch (IOException ex) {
				throw new HttpMessageNotReadableException("Could not read JSON: " + ex.getMessage(), ex);
			}
		} catch (ClassNotFoundException e) {
			throw new HttpMessageNotReadableException("Could not load the payload class: " + payloadType, e);
		}									
	}
	
	@Override
	public boolean canRead(Type type, Class<?> contextClass, MediaType mediaType) {
		if (type instanceof ParameterizedTypeImpl && getGenericType().isAssignableFrom(((ParameterizedTypeImpl)type).getRawType())) {
			return canRead(mediaType);
		}
		//let another message converter handle all other message types
		return false;
	}
	
	public abstract Class<E> getGenericType();	

}
