package com.mul.util;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UserMethodArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public Object resolveArgument(MethodParameter parameter, 
								  ModelAndViewContainer mavContainer, 
								  NativeWebRequest webRequest,
								  WebDataBinderFactory binderFactory) throws Exception 
	{
		Authentication auth = AuthorityUtils.getAuthentication();
		
		return null;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) 
	{
		Class<?> parameterType = parameter.getParameterType();
		return UserEntity.class.equals(parameterType);
	}

}
