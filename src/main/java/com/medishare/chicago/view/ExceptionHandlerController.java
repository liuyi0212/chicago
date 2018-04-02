package com.medishare.chicago.view;

import javax.servlet.http.HttpServletRequest;

import com.medishare.chicago.utils.JSONRet;
import com.medishare.chicago.utils.JSonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandlerController {

	Logger error = LoggerFactory.getLogger("error");

	@ExceptionHandler(value = { Exception.class, RuntimeException.class })
	@ResponseBody
	public String defaultErrorHandler(HttpServletRequest request, Exception e) {
//		error.error(request.getRequestURL().toString(), e);
		JSONRet ret = new JSONRet();
		ret.setCode(1);
		ret.setErrorMsg(e.getMessage() == null ? e.toString() : e.getMessage());
		return JSonUtils.toJsonString(ret);
	}
}