使用 nginx-1.12.0

http://nginx.org/en/download.html
下载后解压 
进入到nginx文件夹，直接start nginx就OK了。

直接访问http://localhost可以看到nginx

退出：nginx -s quit
nginx -s stop
查看帮助
nginx -h


配置文件conf/nginx.conf

	##配置虚拟机
	#### 输入8080.itmayiedu.com 跳转到 http://127.0.0.1:8080
	server {
		listen 80;
		server_name www.zm.com;
		#charset koi8-r;
		#access_log logs/host.access.log main;
		location / {
			proxy_pass http://127.0.0.1:8080/;
			index index.html index.htm;
		}
		location ~* \.(html|css|js)$ {
			proxy_pass http://127.0.0.1:8080;
		}
	}