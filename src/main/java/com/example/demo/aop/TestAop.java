package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAop {

    @Pointcut("execution(* com.example.demo.controller.TestController.test(..))")
    public void execution(){}

    @Pointcut("within(com.example.demo.controller..*)")
    public void within(){}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void annotation(){}

    //Advice路徑呼叫Pointcut
    @Before("com.example.demo.aop.TestAop.execution()")
    public void testAop(){
        System.out.println("testAop=>AOP開始");
    }

    //可以把Advice和Pointcut合在一起，直接在Advice上面定義切入點
    @Before("com.example.demo.aop.TestAop.within()")
    public void testAop2(JoinPoint jp){
        System.out.println("testAop2=>AOP2開始");
        System.out.println(jp.getArgs());
    }

    //設定返回值(如果不設定返回值，用法跟上面的一樣呼叫Pointcut即可)
    @AfterReturning(pointcut = "com.example.demo.aop.TestAop.execution()",
                    returning = "message")
    public void testAop3(Object message){
        message = "testAop3=>OK";
        System.out.println(message);
    }

    //能做@Before的事情，也可以做@AfterReturning的事情
    @Around("com.example.demo.aop.TestAop.execution()")
    public void testAop4(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("testAop4=>開始");
        Object message = pjp.proceed();
        System.out.println(message);
        System.out.println("testAop4=>結束");
    }


}
