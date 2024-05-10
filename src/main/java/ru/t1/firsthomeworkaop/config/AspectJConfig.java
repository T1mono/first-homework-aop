package ru.t1.firsthomeworkaop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.t1.firsthomeworkaop")
@EnableAspectJAutoProxy
public class AspectJConfig {

}
