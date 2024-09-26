package com.rms.api.config.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.rms.api.config.ApiRequestHolder;
import com.rms.api.config.HTTPHelper;
import com.rms.api.config.MCbsApiChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.rms.api.repository.CommonRepository;

@Component
public class RequestFilter implements Filter {

	private MCbsApiChannel localReq = null;
	
	@Autowired
	private CommonRepository commonRepository;
	
	@Value("${api_channel}")
	private String channel;
	
	@Value("${api_channel_user}")
	private String user;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			String requstFromIp = HTTPHelper.getRealClientIpAddr(req);
			if (localReq == null) {
				localReq = commonRepository.getCBSLocalUser(channel, user);
			}
			if (localReq != null && localReq.getIpAddress().contains(requstFromIp)) {
				ApiRequestHolder.setToken(true);
			} else {
				ApiRequestHolder.setToken(false);
			}
			chain.doFilter(request, response);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ApiRequestHolder.removeToken();
		}

	}

}
