package com.huoli.enableload.annotation.filecontent;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.*;

@Data
//@Builder
@EqualsAndHashCode
public class FileContent {

    private Map<String, List<String>> urls;
    private final static String FACTORIES_RESOURCE_LOCATION = "META-INF/git.factories";

    public FileContent() {
        init(FACTORIES_RESOURCE_LOCATION);
    }

    private void init(String path) {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
        urls = getUrlsData(classLoader, FACTORIES_RESOURCE_LOCATION);
    }


    public MultiValueMap<String, String> getUrlsData(ClassLoader classLoader, String path) {
        MultiValueMap<String, String> urlResult = new LinkedMultiValueMap<>();
        try {
            Enumeration<URL> urls = classLoader.getResources(path);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                UrlResource resource = new UrlResource(url);
                // 加载每个URL中的配置
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                // 遍历每个配置
                for (Map.Entry<?, ?> entry : properties.entrySet()) {
                    String factoryClassName = ((String) entry.getKey()).trim();
                    // 将实现类的配置按照","符号分割开
                    for (String factoryName : StringUtils.commaDelimitedListToStringArray((String) entry.getValue())) {
                        // 逐个添加到接口对应的集合当中
                        urlResult.add(factoryClassName, factoryName.trim());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlResult;
    }

}
