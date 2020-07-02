package com.namibank.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(PreFilter.class);
    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 1000;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("this is a pre filter: send {} request to {}",request.getMethod(),
                request.getRequestURL().toString());
        return null;
    }
}
