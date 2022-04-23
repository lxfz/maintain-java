package com.xiaofei.spring;

import com.xiaofei.service.AppConfig;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

  private Class configClass;
  private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
  private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
  private ArrayList<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

  public ApplicationContext(Class configClass) {
    this.configClass = configClass;

    // 扫描
    if (configClass.isAnnotationPresent(ComponentScan.class)) {

      ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
      String path = componentScanAnnotation.value(); //  扫描路径 com.xiaofei
      // 扫描class文件
      path = path.replace(".", "/"); // com/xiaofei
      ClassLoader classLoader = ApplicationContext.class.getClassLoader();
      // /Users/xiaofei/Documents/A07_Dev/JavaProjects/maintain-java/out/production/MockSpring/com/xiaofei
      URL resource = classLoader.getResource(path);
      File file = new File(resource.getFile());
      System.out.println(file);
      if (file.isDirectory()) {
        File[] files = file.listFiles();
        for (File f : files) {
          String fileName = f.getAbsolutePath();
          System.out.println(fileName);
          if (fileName.endsWith(".class")) {
            String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
            className = className.replace("/", ".");
            System.out.println(className);
            Class<?> clazz = null;
            try {
              clazz = classLoader.loadClass(className);
              if (clazz.isAnnotationPresent(Component.class)) {

                // BeanPostProcessor
                // 判断clazz 是否实现该接口
                if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                  BeanPostProcessor instance = (BeanPostProcessor) clazz.newInstance();
                  beanPostProcessorList.add(instance);
                }


                // Bean
                // 单例Bean, 多例Bean
                // BeanDefinition
                Component component = clazz.getAnnotation(Component.class);
                String beanName = component.value();

                if (beanName.equals("")) {
                  beanName = Introspector.decapitalize(clazz.getSimpleName());
                }

                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setType(clazz);
                if (clazz.isAnnotationPresent(Scope.class)) {
                  Scope scopeAnnotation = clazz.getAnnotation(Scope.class);
                  String scope = scopeAnnotation.value();
                  beanDefinition.setScope(scope);
                } else {
                  beanDefinition.setScope("singleton");
                }
                beanDefinitionMap.put(beanName, beanDefinition);
              }
            } catch (ClassNotFoundException e) {
              e.printStackTrace();
            } catch (InstantiationException e) {
              e.printStackTrace();
            } catch (IllegalAccessException e) {
              e.printStackTrace();
            }

          }
        }
      }
    }

    // 实例华单例Bean对象
    for (String beanName : beanDefinitionMap.keySet()) {
      BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

      if (beanDefinition.getScope().equals("singleton")) {
        Object bean = this.creatBean(beanName, beanDefinition);
        singletonObjects.put(beanName, bean);
      }
    }
  }

  private Object creatBean(String beanName, BeanDefinition beanDefinition) {
    Class clazz = beanDefinition.getType();
    // 无参构造
    try {
      Object instance = clazz.getConstructor().newInstance();

      // 依赖注入
      for (Field field : clazz.getDeclaredFields()) {
        if (field.isAnnotationPresent(Autowired.class)) {

          field.setAccessible(true);
          // 通过属性名赋值
          field.set(instance, getBean(field.getName()));
          System.out.println("依赖注入");
        }
      }

      // Aware 回调
      if (instance instanceof BeanNameAware) {
        ((BeanNameAware) instance).setBeanName(beanName);
      }

      for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
        instance = beanPostProcessor.postProcessBeforeInitialization(beanName, instance);
      }

      // 初始化
      if (instance instanceof InitializingBean) {
        ((InitializingBean) instance).afterPropertiesSet();
      }
      for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
        instance = beanPostProcessor.postProcessAfterInitialization(beanName, instance);
      }

      // BeanPostProcessor 初始化后 AOP


      return instance;
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    return null;
  }

  public Object getBean(String beanName) {
    BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

    if (beanDefinition == null) {
      throw new NullPointerException();
    } else {
      String scope = beanDefinition.getScope();

      if (scope.equals("singleton")) {
        Object bean = singletonObjects.get(beanName);
        if (bean == null) {
          Object bean1 = this.creatBean(beanName, beanDefinition);
          singletonObjects.put(beanName, bean1);
        }
        return bean;
      } else {
        // 多例
        return creatBean(beanName, beanDefinition);
      }
    }
  }
}
