# mysql

## mysql docker
```
docker pull igeting/mysql:5.7.9
docker run --name mysql -d -e MYSQL_ROOT_PASSWORD=123456 -p 3306:3306 igeting/mysql:5.7.9
```