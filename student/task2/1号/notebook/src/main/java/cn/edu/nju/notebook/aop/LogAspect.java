package cn.edu.nju.notebook.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("within(cn.edu.nju.notebook.controller.*)")
//    @Pointcut("execution(public * cn.edu.nju.notebook.controller.*.*(..))")等价于上面一句
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("前置通知（记录请求内容）：");

        //记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        if(request==null){
            logger.info("请求为空");
        }else{
            logger.info("URL:"+request.getRequestURL());
            logger.info("HTTP_METHOD:"+request.getMethod());
            logger.info("IP:"+request.getRemoteAddr());
            logger.info("CLASS_AND_METHOD:"+joinPoint.getSignature().getDeclaringTypeName()
                    +"."+joinPoint.getSignature().getName());
            logger.info("ARGS:"+ Arrays.toString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret){
        logger.info("后置通知（记录响应内容）：");
        logger.info("RESPONSE:"+ret);
        logger.info("---------------------------");
    }

    @AfterThrowing(pointcut = "webLog()")
    public void doAfterThrowing(JoinPoint joinPoint){
        logger.info("异常通知：");
        logger.info(joinPoint.getSignature().getDeclaringTypeName()+
                "."+joinPoint.getSignature().getName()+"抛出异常");

        logger.info("---------------------------");
    }

    @Before("within(cn.edu.nju.notebook.service..*)&&@annotation(loggerManage)")
    public void doBefore2(JoinPoint joinPoint,LoggerManage loggerManage){
        //使用日志注解
        logger.info(loggerManage.description());
    }


}
