package com.huoli.enableload.annotation;

import com.huoli.enableload.annotation.filecontent.FileContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/*
*所有实现ImportSelector的类，
* 都会在启动时被ConfigurationClassParser中的processImports进行实例化，
* 并执行selectImports方法
 */
@Slf4j
public class AchieveImportSelector implements ImportSelector, BeanFactoryAware {

    private BeanFactory beanFactory;



    //不能起名spring.factories，不然会加载默认的，可怕//
    //public static final String FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories";
    //无法更改读取
    public static final String FACTORIES_RESOURCE_LOCATION = "META-INF/git.factories";
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //getResources调用getBootstrapResources
        //Enumeration淘汰了，但是ClassLoader返回的
        log.info(new HelloWorldConfiguration().getTest());
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
        MultiValueMap<String, String> urlResult = new FileContent().getUrlsData(classLoader, FACTORIES_RESOURCE_LOCATION);
        List<String> listResult = new ArrayList<>();
        Set<String> keySet = urlResult.keySet();
        for (String key : keySet) {
            List<String> values = urlResult.get(key);
            listResult.addAll(values);
            //实例化
//            try {
//                Class<?> instanceClass = ClassUtils.forName(key, classLoader);
//                ReflectionUtils.accessibleConstructor(instanceClass).newInstance();
//            }
//            catch (Throwable e) {
//                e.printStackTrace();
//            }
        }
        //接口名，自动实例化spring.factories下的类
//        SpringFactoriesLoader.loadFactoryNames(Class<T>,null);
        String[] result = listResult.toArray(new String[listResult.size()]);
        log.info("成功");
        return result;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
