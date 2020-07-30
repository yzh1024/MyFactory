package com.yzh1024.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建Bean对象的工厂
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties pros;
    //定义一个Map，用于存放我们创建的对象。我们把它称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            pros = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            pros.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的Key
            Enumeration keys = pros.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                //取出每个Key
                String key = keys.nextElement().toString();
                //根据Key获取value
                String beanPath = pros.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /**
     * 根据Bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

/*
    *//**
     * 根据Bean的名称获取bean对象
     *
     * @param beanName
     * @return
     *//*
    public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String beanPath = pros.getProperty(beanName);
            System.out.println(beanPath);
            bean = Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}

