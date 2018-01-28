package com.ad;

import com.sdk.server.HttpServer;

import snowfox.lang.time.DateUtil;
import snowfox.lang.util.NetUtil;
import snowfox.lang.util.Strings;

public class startServer {

	public static void main(String[] args) throws Exception {

		// String filePath = System.getProperty("user.dir") +
		// "/log4j.properties";
		// PropertyConfigurator.configure(filePath);

		// 需要使用到HttpServer里面的initConfig方法执行netty的参数载入
		HttpServer server = new HttpServer();

		boolean isUsing = NetUtil.isLocalPortUsing(server.getConfig().port);
		if (isUsing) {
			System.out.println(Strings.format("{0}: Address [{1}:{2}] already in use.", DateUtil.now(),
					server.getConfig().host, server.getConfig().port));
			return;
		}



		System.out.println("server init start time: " + DateUtil.now());
		server.start();
		System.out.println("server init end time: " + DateUtil.now());

	}
}
