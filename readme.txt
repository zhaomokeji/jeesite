---------------jeesite-----------------

֧���ֻ��淽��
���ݹ���-->վ������-->Ĭ������(base winxin)

\zhaomokeji\WEB-INF\views\modules\cms\front\themes


�л�վ�� �� �ֱ�ά�����е��µ���Ŀ


http://localhost:8081/zhaomokeji/f
http://localhost:8081/zhaomokeji/a

---------------db-----------------

mysql pwd: 123456  root

---------------maven-----------------
ע�⣺maven��ʹ�ü����������·��������

Bundled (Maven 3)

C:\Users\xxxx\.m2\settings.xml
C:\Users\xxxx\.m2\repository

��������а�װ��maven��ע��ʹ����һ��!
D:\maven\maven3\bin

E:\zhaomokeje\jeesite\jeesite\doc\maven\maven3\bin



------------------tomcat------------
�������������ͬ��tomcat�� D:\tomcat7\webapps����������Ŀ�������������ĳ����Ŀ���޸�
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
	  
	  ��<Context path="/bmcloud"��ɾ��
	  
	  