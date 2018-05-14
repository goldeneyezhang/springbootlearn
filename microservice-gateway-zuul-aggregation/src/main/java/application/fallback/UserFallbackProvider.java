package application.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackProvider implements ZuulFallbackProvider{
		public String getRoute() {
			//表明是为哪个微服务提供
			return "microservice-provider-user";
		}
		public ClientHttpResponse fallbackResponse() {
			return new ClientHttpResponse() {
				public HttpStatus getStatusCode() throws IOException{
					//fallback时的状态码
					return HttpStatus.OK;
				}

				public InputStream getBody() throws IOException {
					//响应体
					return new ByteArrayInputStream("用户微服务不可用，请稍候再试。".getBytes());
				}

				public HttpHeaders getHeaders() {
					//headers设定
					HttpHeaders headers=new HttpHeaders();
					MediaType mt=new MediaType("application","json",Charset.forName("UTF-8"));
					headers.setContentType(mt);
					return headers;
				}

				public int getRawStatusCode() throws IOException {
					// TODO Auto-generated method stub
					// 数字类型的状态码，本例返回的其实是200
					return this.getStatusCode().value();
				}

				public String getStatusText() throws IOException {
					// TODO Auto-generated method stub
					//状态文本，本例返回的其实就是OK
					return this.getStatusCode().getReasonPhrase();
				}

				public void close() {
					// TODO Auto-generated method stub
					
				}
			};
		}
}
