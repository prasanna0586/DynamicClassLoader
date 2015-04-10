package com.classloader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClassLoader {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//Local Jar File
		//URL url = new URL("file:///C:/Users/prasannakumarr/Desktop/reference.jar");
		//Remote Jar File
		URL url = new URL("http", "192.168.7.63",8080, "/reference.jar");
		System.out.println("URL is " + url.toString());
		String[] arguments = new String[1];
		URL[] urls = new URL[1];
		urls[0] = url;
		URLClassLoader classLoader = new URLClassLoader(urls);
		Class<?> referenceClass = classLoader.loadClass("com.reference.Reference");
		Method mainMethod =	referenceClass.getMethod("main", String[].class);
		System.out.println(mainMethod);
		System.out.println(referenceClass);
		mainMethod.invoke(referenceClass.newInstance(), arguments);
		classLoader.close();
	}

}
