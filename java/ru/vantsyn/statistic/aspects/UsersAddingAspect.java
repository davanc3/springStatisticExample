package ru.vantsyn.statistic.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.vantsyn.statistic.model.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class UsersAddingAspect {
    private final UserService userService;

    public UsersAddingAspect(UserService userService) {
        this.userService = userService;
    }

    @Before("execution(* ru.vantsyn.statistic.controllers.*.* (..))")
    public void checkUsersExist(JoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        for (Object arg: arguments) {
            if (arg instanceof HttpServletRequest) {
                if (((HttpServletRequest) arg).getSession().getAttribute("userId") == null) {
                    ((HttpServletRequest) arg).getSession().setAttribute("userId", userService.addNewUser());
                    System.out.println("-----------");
                    System.out.println("User adding");
                    System.out.println("-----------");
                }
                break;
            }
        }
    }
}
