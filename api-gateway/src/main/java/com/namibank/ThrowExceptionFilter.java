package com.namibank;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ThrowExceptionFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(ThrowExceptionFilter.class);
    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {
        logger.info("this is a pre filter, it will throw a RuntimeException");
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            doSomething();
        }catch (Exception e){
            ctx.set("sendErrorFilter.ran");
//            throw new RuntimeException(e);
        }

        return null;
    }
    private void doSomething(){
        throw new RuntimeException("Exist some errors...");
    }
}
