# first-homework-aop

## Описание

Сервис для работы со справочниками и реализация аспектов.

## Сборка backend части

```cmd
cd first-homework-aop && mvn clean package
```
Linux (bash):
```bash
(cd first-homework-aop && mvn clean package)
```

## Запуск

### Простой запуск:
```bash
java -jar target/first-homework-aop-0.0.1-SNAPSHOT.jar
```

## Использование

URL с swagger документацией: http://localhost:8080/swagger-ui/index.html

## Запуск браузера с отключённым CORS

chrome.exe --user-data-dir="C://chrome-dev-disabled-security" --disable-web-security --disable-site-isolation-trials

## Скрпиты для создания таблиц в БД

```
CREATE TABLE if not exists employees
(
id         bigint NOT NULL AUTO_INCREMENT,
name       varchar(100),
surname    varchar(100),
department varchar(20),
salary     int,
PRIMARY KEY (id)
);
```

```
CREATE TABLE if not exists loginfo
(
id          bigint NOT NULL AUTO_INCREMENT,
name_method varchar(100),
duration    bigint,
PRIMARY KEY (id)
);
```
