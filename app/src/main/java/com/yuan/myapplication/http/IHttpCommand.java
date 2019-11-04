package com.yuan.myapplication.http;

/**
 * 执行网络请求命令接口
 * @param <T>
 */
public interface IHttpCommand<T> {
	//post
	public String execute(String url, IRequestParam<T> requestParam);

	//get
	public String executeGet(String url);
}
