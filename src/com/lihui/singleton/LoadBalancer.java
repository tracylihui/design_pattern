package com.lihui.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalancer {
	// 私有静态成员变量，存储唯一实例
	private volatile static LoadBalancer instance = null;
	// 服务器集合
	private List<String> serverList = null;

	// 私有构造函数
	private LoadBalancer() {
		serverList = new ArrayList<String>();
	}

	// 公有静态成员方法，返回唯一实例
	public static LoadBalancer getLoadBalancer() {
		if (instance == null) {
			synchronized (LoadBalancer.class) {
				if (instance == null)
					instance = new LoadBalancer();
			}
		}
		return instance;
	}

	// 增加服务器
	public void addServer(String server) {
		serverList.add(server);
	}

	// 删除服务器
	public void removeServer(String server) {
		serverList.remove(server);
	}

	// 使用Random类随机获取服务器
	public String getServer() {
		Random random = new Random();
		int i = random.nextInt(serverList.size());
		return (String) serverList.get(i);
	}
}