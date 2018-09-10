package com.enjoyor.soa.traffic.server.smsPlatform.commmon;

import com.enjoyor.soa.traffic.util.helper.LoggerHelper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderSupport;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author 周宏伟
 * @date 2017年3月24日
 * @email zhouhongwei@enjoyor.net
 * @description Spring读取
 */
@Component
public class SpringReader extends LoggerHelper implements ApplicationContextAware {
	// Spring上下文
	public static ApplicationContext context;

	// 配置参数
	private static Properties properties = new Properties();

	/**
	 * 加载Spring容器
	 * @param arg0
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringReader.context = applicationContext;
		try {
			getProperties();
		} catch (Exception e) {
			LOG.error("获取Spring配置参数错误", e);
		}
	}

	/**
	 * 获取配置参数
	 * @throws Exception
	 */
	private void getProperties() throws Exception {
		String[] names = context.getBeanNamesForType(BeanFactoryPostProcessor.class, true, true);
		for (String name : names) {
			BeanFactoryPostProcessor processor = context.getBean(name, BeanFactoryPostProcessor.class);
			if (processor instanceof PropertyResourceConfigurer) {
				PropertyResourceConfigurer configurer = (PropertyResourceConfigurer) processor;
				Method method = PropertiesLoaderSupport.class.getDeclaredMethod("mergeProperties");
				method.setAccessible(true);
				Properties p = (Properties) method.invoke(configurer);
				Method convert = PropertyResourceConfigurer.class.getDeclaredMethod("convertProperties", Properties.class);
				convert.setAccessible(true);
				convert.invoke(configurer, p);
				properties.putAll(p);
			}
		}
	}

	/**
	 * 获取配置参数
	 * @return
	 */
	public static Map<String, String> getProperty() {
		Map<String, String> map = new LinkedHashMap<>();
		Enumeration<?> enumeration = properties.propertyNames();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement().toString();
			map.put(key, properties.getProperty(key));
		}
		return map;
	}

	/**
	 * 获取配置参数
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	/**
     * 获取properties键值
     *
     * @param name properties名称
     * @return properties键值
     */
    public static Map<String, String> getProperties(String name)
    {
        Map<String, String> map = new HashMap<String, String>();
        InputStream is = null;
        try
        {
            is = new ClassPathResource(name + ".properties").getInputStream();
            Properties p = new Properties();
            p.load(is);
            Enumeration<?> e = p.propertyNames();
            while (e.hasMoreElements())
            {
                String key = e.nextElement().toString();
                map.put(key, p.getProperty(key));
            }
        }
        catch (IOException e)
        {
            LoggerHelper.LOG.error(e.getMessage());
        }
        finally
        {
            try
            {
                is.close();
            }
            catch (IOException e)
            {
            	LoggerHelper.LOG.error(e.getMessage());
            }
        }
        return map;
    }


	/**
     * 获取resource.properties
     *
     * @param key resource.properties键
     * @return resource.properties值
     */
    public static String getResourceProperties(String name,String key)
    {
        Map<String, String> map = getProperties(name);
        if (map != null && !map.isEmpty() && map.containsKey(key))
        {
            return map.get(key);
        }
        return null;
    }
}
