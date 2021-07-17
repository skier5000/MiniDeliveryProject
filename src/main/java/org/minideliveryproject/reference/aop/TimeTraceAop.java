package org.minideliveryproject.reference.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * <pre>
 * AOP 예제 작성
 * <pre>
 *
 * @author LJB
 * @since 2021.06.20
 * @version 1.0
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.06.20.		LJB			최초작성
 */

// SpringConfig 에서 Bean 으로 등록해도되고 @Component 스캔으로 등록해도 되고
//@Component
//@Aspect
public class TimeTraceAop {

    // @Around 는 AOP 를 어디에다가 적용할건지 Targeting
    @Around("execution(* com.minidelivery.minidelivery..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString()); // 어떤 메소드를 Call 하는지

        try {
            return joinPoint.proceed(); // 다음 메소드로 진행
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs +
                    "ms");
        }
    }
}