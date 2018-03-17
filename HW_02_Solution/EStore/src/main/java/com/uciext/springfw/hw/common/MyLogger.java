package com.uciext.springfw.hw.common;

import org.aspectj.lang.JoinPoint;
import com.uciext.springfw.hw.catalog.service.impl.*;
import com.uciext.springfw.hw.catalog.model.*;

public class MyLogger {
	
	public void logBeforeGetProd(JoinPoint joinPoint, String sku) {
		System.out.println("before product details "+ sku );
	}

	public void logAfterGetProd(JoinPoint joinPoint,String sku) {
		System.out.println("get product from catalog");
	}

	public void logExceptionProdAdd(JoinPoint joinPoint, Exception ex) {
		System.out.println("exception for add product "+ ex.getMessage() );
	}
}
