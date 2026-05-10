package com.nt.interceptos;

import java.time.LocalTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TimeCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		System.out.println("TimeCheckInterceptor.preHandle()");
		if (!req.getServletPath().equalsIgnoreCase("/")) {
			// get system date and time
			LocalTime time = LocalTime.now();
			// get current hour of the day
			int hour = time.getHour();
			// pre request processing logics
			if (hour <10 || hour > 17) {
				RequestDispatcher rd = req.getRequestDispatcher("/timeout.jsp");
				rd.forward(req, res);
				return false;
			} // method
		} // method
		return true;
	}

}
