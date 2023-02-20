/**
 * 
 */
package br.com.nt.taskscheduler.util.converter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

/**
 * @author Neto
 *
 */
public class ObjectToMapConverter {

	public static MapSqlParameterSource convert(Object object) {
		Map<String, Object> map = new HashMap<>();
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				map.put(field.getName(), field.get(object));
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		return new MapSqlParameterSource(map);
	}
}
