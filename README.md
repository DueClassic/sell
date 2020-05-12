## 项目部署

<hr>

项目打包:     
```
mvn clean package -Dmaven.test.skip=true
```

启动jar包:
```
nohup java -jar -Dserver.port=8080 -Dspring.profiles.active=prod sell.jar > /dev/null 2>&1 &
```
    
   