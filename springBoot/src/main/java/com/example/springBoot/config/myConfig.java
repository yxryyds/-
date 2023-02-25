package com.example.springBoot.config;

import com.example.springBoot.model.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1.此为配置类（可以用于替代spring的配置文件），用于将类引入IOC容器
 * 2.proxyBeanMethods ：为true： 则通过代理类中的方法产生的bean对象只会是同一个（不论调用多少次，指向的都是同一个对象）
 * 在组件中存在依赖注入则使用true；不存在就用false
 *
 * 3.使用@Import()来导入组件
 *      给容器中自动创建出对应的组件
 * 4. @ConditionalOnBean(name="")条件装配
 *      写在类上，如果组件中有name为指定name的组件，则类中所有的方法会生效
 *      写在方法上，如果组件中没有name为指定name的组件，则此方法无法生效
 *      除了此组件外还有其他组件，使用@Conditional来通过联想得到
 * 5.@ImportResource("classpath:...xml")
 *      如果使用的是xml的方式配置的bean，通过这个可以使用到xml文件下的bean
 */

@Configuration(proxyBeanMethods = true)
public class myConfig {
//    @Bean
//    public Test getTest(){
//        return new Test("test1", "eat");
//    }

}
