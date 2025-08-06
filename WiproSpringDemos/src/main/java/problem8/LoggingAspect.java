package problem8;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

    public void logBefore() {
        System.out.println("Before method execution");
    }

    public void logAfterReturning() {
        System.out.println("After method returned successfully");
    }

    public void logAfterThrowing(Exception ex) {
        System.out.println("After method threw exception: " + ex);
    }

    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around advice: before proceeding");
        Object result = pjp.proceed();
        System.out.println("Around advice: after proceeding");
        return result;
    }
}
