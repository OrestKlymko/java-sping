package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(3)
public class ExepctionHandlingAspect {

    @Before("aop.aspects.MyPointcuts.allAddMethod()")
    public void beforeExepctionHandlingAspect(){
        System.out.println("ExepctionHandlingAspect: catch exeptions");
    }
}
