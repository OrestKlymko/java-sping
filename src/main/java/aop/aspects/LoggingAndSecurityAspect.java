package aop.aspects;


import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) //порядковий номер виконання
public class LoggingAndSecurityAspect {

    @Before("aop.aspects.MyPointcuts.allAddMethod()")
    public void beforeAddSecurityAdvice(JoinPoint joinPoint){

       MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature: "+methodSignature);
        System.out.println("methodSignature.getMethod(): "+methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): "+methodSignature.getReturnType());
        System.out.println("methodSignature.getName(): "+methodSignature.getName());


    if (methodSignature.getName().equals("addBook")){
        Object[] arg = joinPoint.getArgs();
        for (Object obj: arg) {
            if(obj instanceof Book){
                Book myBook = (Book) obj;
                System.out.println("INFO: "+myBook.getName()+ " " + myBook.getAuthor()+" "+myBook.getYearPub());
            }
            else {
                System.out.println("OBJ  "+obj);
            }
        }



    }


        System.out.println("beforeGetSecurityAdvice: checing rules on get magazine or book");
    }
}









//    @Pointcut("execution(* aop.UniLibrary.*(..))")
//    public void AllMethodsFromUnilab(){}
//
//    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
//    public void returnMagazineFromUniLibrary(){}
//
//    @Pointcut("AllMethodsFromUnilab()&&!returnMagazineFromUniLibrary()")
//    public void AllMethodsExceptReturnMagazine(){}
//
//    @Before("AllMethodsExceptReturnMagazine()")
//    public void beforeAllMethodsExceptReturnMagazine(){
//        System.out.println("AllMethodsExceptReturnMagazine");
//    }


//    @Pointcut("execution (* aop.UniLibrary.get*())")
//    private void AllGetMethodsFromUniLibrary(){}
//
//
//    @Pointcut("execution (* aop.UniLibrary.return*())")
//    private void AllReturnMethodsFromUniLibrary(){}
//
//
//    @Pointcut("AllGetMethodsFromUniLibrary()||AllReturnMethodsFromUniLibrary()")
//    private void AllGetAndReturnMethods(){}
//
//    @Before("AllGetMethodsFromUniLibrary()")
//    public void beforeGetLoginAdvice(){
//        System.out.println("beforeGetLoginAdvice: writing log#1 ");
//    }
//
//    @Before("AllReturnMethodsFromUniLibrary()")
//    public void beforeReturnMethodsFromUniLibrary(){
//        System.out.println("beforeReturnMethodsFromUniLibrary");
//    }
//
//    @Before("AllGetAndReturnMethods()")
//    public void beforeAllGetAndReturnMethods(){
//        System.out.println("beforeAllGetAndReturnMethods");
//    }




//
