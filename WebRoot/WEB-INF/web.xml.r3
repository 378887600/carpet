<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">

	<display-name>carpet</display-name>
	<description>中国最大的地毯销售平台</description>

	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>
			classpath*:/applicationContext.xml,
			classpath*:/applicationContext-shiro.xml
		</param-value>
	</context-param>

	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>

	<filter>
		<filter-name>encodingConvertFilter</filter-name>
		<filter-class>com.shop.filter.EncodingConvertFilter</filter-class>
		<init-param>
			<param-name>fromEncoding</param-name>
			<param-value>ISO-8859-1</param-value>
		</init-param>
		<init-param>
			<param-name>toEncoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
	</filter>

	<filter>
		<filter-name>siteStatusFilter</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
	</filter>

	<filter>
		<filter-name>accessDeniedFilter</filter-name>
		<filter-class>com.shop.filter.AccessDeniedFilter</filter-class>
	</filter>

	<filter>
		<filter-name>shiroFilter</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
	</filter>

	<filter>
		<filter-name>areaCacheFilter</filter-name>
		<filter-class>net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter</filter-class>
		<init-param>
			<param-name>cacheName</param-name>
			<param-value>area</param-value>
		</init-param>
	</filter>

	<filter>
		<filter-name>articleCacheFilter</filter-name>
		<filter-class>net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter</filter-class>
		<init-param>
			<param-name>cacheName</param-name>
			<param-value>article</param-value>
		</init-param>
	</filter>

	<filter>
		<filter-name>productCacheFilter</filter-name>
		<filter-class>net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter</filter-class>
		<init-param>
			<param-name>cacheName</param-name>
			<param-value>product</param-value>
		</init-param>
	</filter>

	<filter>
		<filter-name>brandCacheFilter</filter-name>
		<filter-class>net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter</filter-class>
		<init-param>
			<param-name>cacheName</param-name>
			<param-value>brand</param-value>
		</init-param>
	</filter>

	<filter>
		<filter-name>promotionCacheFilter</filter-name>
		<filter-class>net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter</filter-class>
		<init-param>
			<param-name>cacheName</param-name>
			<param-value>promotion</param-value>
		</init-param>
	</filter>

	<filter>
		<filter-name>reviewCacheFilter</filter-name>
		<filter-class>net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter</filter-class>
		<init-param>
			<param-name>cacheName</param-name>
			<param-value>review</param-value>
		</init-param>
	</filter>

	<filter>
		<filter-name>consultationCacheFilter</filter-name>
		<filter-class>net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter</filter-class>
		<init-param>
			<param-name>cacheName</param-name>
			<param-value>consultation</param-value>
		</init-param>
	</filter>

	<filter>
		<filter-name>friendLinkCacheFilter</filter-name>
		<filter-class>net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter</filter-class>
		<init-param>
			<param-name>cacheName</param-name>
			<param-value>friendLink</param-value>
		</init-param>
	</filter>

	<filter>
		<filter-name>productCategoryCacheFilter</filter-name>
		<filter-class>net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter</filter-class>
		<init-param>
			<param-name>cacheName</param-name>
			<param-value>productCategory</param-value>
		</init-param>
	</filter>

	<filter>
		<filter-name>compressingFilter</filter-name>
		<filter-class>com.planetj.servlet.filter.compression.CompressingFilter</filter-class>
	</filter>

	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>*.jsp</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>*.jhtml</url-pattern>
	</filter-mapping>

	<!--
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>*.jsp</url-pattern>
	</filter-mapping>
	<filter-mapping>
		<filter-name>encodingConvertFilter</filter-name>
		<url-pattern>*.jhtml</url-pattern>
	</filter-mapping>
	-->

	<filter-mapping>
		<filter-name>siteStatusFilter</filter-name>
		<url-pattern>*.html</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>siteStatusFilter</filter-name>
		<url-pattern>*.jsp</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>siteStatusFilter</filter-name>
		<url-pattern>*.jhtml</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>accessDeniedFilter</filter-name>
		<url-pattern>*.properties</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>accessDeniedFilter</filter-name>
		<url-pattern>*.conf</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>shiroFilter</filter-name>
		<url-pattern>/admin/*</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>areaCacheFilter</filter-name>
		<url-pattern>/common/area.jhtml</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>areaCacheFilter</filter-name>
		<url-pattern>/admin/common/area.jhtml</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>articleCacheFilter</filter-name>
		<url-pattern>/article/list/*</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>productCacheFilter</filter-name>
		<url-pattern>/product/list/*</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>productCacheFilter</filter-name>
		<url-pattern>/product/list.jhtml</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>brandCacheFilter</filter-name>
		<url-pattern>/brand/list/*</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>brandCacheFilter</filter-name>
		<url-pattern>/brand/content/*</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>promotionCacheFilter</filter-name>
		<url-pattern>/promotion/content/*</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>reviewCacheFilter</filter-name>
		<url-pattern>/review/content/*</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>consultationCacheFilter</filter-name>
		<url-pattern>/consultation/content/*</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>friendLinkCacheFilter</filter-name>
		<url-pattern>/friend_link.jhtml</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>productCategoryCacheFilter</filter-name>
		<url-pattern>/product_category.jhtml</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>compressingFilter</filter-name>
		<url-pattern>*.css</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>compressingFilter</filter-name>
		<url-pattern>*.js</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>compressingFilter</filter-name>
		<url-pattern>*.html</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>compressingFilter</filter-name>
		<url-pattern>*.jsp</url-pattern>
	</filter-mapping>

	<filter-mapping>
		<filter-name>compressingFilter</filter-name>
		<url-pattern>*.jhtml</url-pattern>
	</filter-mapping>

	<servlet>
		<servlet-name>springmvc</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath*:/applicationContext-mvc.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>springmvc</servlet-name>
		<url-pattern>*.jhtml</url-pattern>
	</servlet-mapping>

	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>

	<listener>
		<listener-class>org.springframework.web.util.IntrospectorCleanupListener</listener-class>
	</listener>

	<session-config>
		<session-timeout>30</session-timeout>
	</session-config>

	<welcome-file-list>
		<welcome-file>index.html</welcome-file>
		<welcome-file>index.jsp</welcome-file>
	</welcome-file-list>

	<error-page>
		<error-code>404</error-code>
		<location>/common/resource_not_found.jhtml</location>
	</error-page>

</web-app>