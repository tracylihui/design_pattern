package com.lihui.factory_method;

public class Client {
	public static void main(String args[]) {
		LoggerFactory factory;
		Logger logger;
		factory = (LoggerFactory) XMLUtil.getBean(); // getBean()的返回类型为Object，需要进行强制类型转换
		logger = factory.createLogger();
		logger.writeLog();
	}
}

// 日志记录器接口：抽象产品
interface Logger {
	public void writeLog();
}

// 数据库日志记录器：具体产品
class DatabaseLogger implements Logger {
	public void writeLog() {
		System.out.println("数据库日志记录。");
	}
}

// 文件日志记录器：具体产品
class FileLogger implements Logger {
	public void writeLog() {
		System.out.println("文件日志记录。");
	}
}

// 日志记录器工厂接口：抽象工厂
interface LoggerFactory {
	public Logger createLogger();
}

// 数据库日志记录器工厂类：具体工厂
class DatabaseLoggerFactory implements LoggerFactory {
	public Logger createLogger() {
		// 连接数据库，代码省略
		// 创建数据库日志记录器对象
		Logger logger = new DatabaseLogger();
		// 初始化数据库日志记录器，代码省略
		return logger;
	}
}

// 文件日志记录器工厂类：具体工厂
class FileLoggerFactory implements LoggerFactory {
	public Logger createLogger() {
		// 创建文件日志记录器对象
		Logger logger = new FileLogger();
		// 创建文件，代码省略
		return logger;
	}
}