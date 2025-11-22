package com.example.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.rabbitmq.Constants.*;

// @Configuration 是 Spring 核心配置注解，作用是 标记当前类为 “配置类”，
// 用于集中管理 Spring 容器的 Bean 定义（配合 @Bean 注解）、替代传统 XML 配置文件，
// 是 Spring 基于 Java 代码进行配置的核心入口。
@Configuration
public class RabbitMQConfig {

    // @Bean 是 Spring 框架的核心注解，
    // 作用是 手动向 Spring 容器中注册一个 “Bean 实例”（即由 Spring 管理的对象）
    // Spring 启动时，会执行被 @Bean 标注的方法，将方法的 返回值 作为 Bean 实例存入容器，
    // 后续可通过 @Autowired 等方式注入使用。
    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(topicExchange()).with(BINDING_KEY);
    }

    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
