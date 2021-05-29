# mysql

## mysql docker
```
docker pull igeting/mysql:8.0.0
docker run --name mysql -d -e MYSQL_ROOT_PASSWORD=123456 -p 3306:3306 igeting/mysql:8.0.0
```