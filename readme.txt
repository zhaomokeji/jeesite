---------------jeesite-----------------

支持手机版方法
内容管理-->站点设置-->默认主题(base winxin)

\zhaomokeji\WEB-INF\views\modules\cms\front\themes


切换站点 后 分别维护各切点下的栏目


http://localhost:8081/zhaomokeji/f
http://localhost:8081/zhaomokeji/a

---------------db-----------------

mysql pwd: 123456  root

---------------maven-----------------
注意：maven的使用及相关依赖库路径的设置

Bundled (Maven 3)

C:\Users\xxxx\.m2\settings.xml
C:\Users\xxxx\.m2\repository

如果本地有安装的maven，注意使用哪一个!
D:\maven\maven3\bin

E:\zhaomokeje\jeesite\jeesite\doc\maven\maven3\bin



------------------tomcat------------
如果两个工程用同个tomcat且 D:\tomcat7\webapps含有两个项目，如果不想运行某个项目则修改
D:\tomcat7\conf\server.xml
<Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">

        <!-- SingleSignOn valve, share authentication between web applications
             Documentation at: /docs/config/valve.html -->
        <!--
        <Valve className="org.apache.catalina.authenticator.SingleSignOn" />
        -->

        <!-- Access log processes all example.
             Documentation at: /docs/config/valve.html
             Note: The pattern used is equivalent to using pattern="common" -->
        <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               prefix="localhost_access_log." suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />
			<Context path="/zhaomokeji" reloadable="true"
                    docBase="/zhaomokeji" />
			<Context path="/bmcloud" reloadable="true"
                    docBase="/bmcloud" />
      </Host>
	  
	  把<Context path="/bmcloud"给删除
	  
	  