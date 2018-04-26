package application.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component 
public class PreRequestLogFilter extends ZuulFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);
	@Override
	public String filterType() {
		return "pre";
	}
	@Override
	public int filterOrder() {
		return 1;
	}
	
	public boolean shouldFilter() {
		return true;
	}
	
	public Object run() {
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		PreRequestLogFilter.LOGGER.info(String.format("send %s request to %s", request.getMethod(),request.getRequestURL().toString()));
		return null;
	}
}
