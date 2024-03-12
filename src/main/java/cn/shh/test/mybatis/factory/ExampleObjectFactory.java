package cn.shh.test.mybatis.factory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * 对象工厂
 *
 * 简介：每次 MyBatis 创建结果对象的新实例时，它都会使用一个对象工厂（ObjectFactory）实例来完成
 *   实例化工作。 默认的对象工厂需要做的仅仅是实例化目标类，要么通过默认无参构造方法，要么通过存在的
 *   参数映射来调用带有参数的构造方法。如果想覆盖对象工厂的默认行为，可以通过创建自己的对象工厂来实现。
 *
 *   ObjectFactory 接口很简单，它包含两个创建实例用的方法，一个是处理默认无参构造方法的，另外一个
 *   是处理带参数的构造方法的。 另外，setProperties 方法可以被用来配置 ObjectFactory，在初始化
 *   你的 ObjectFactory 实例后，objectFactory 元素体中定义的属性会被传递给setProperties方法。
 *
 */
public class ExampleObjectFactory extends DefaultObjectFactory {
    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }
}
