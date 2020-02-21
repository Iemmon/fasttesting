# QuizSystem
Система Быстрого Тестирования Студентов. Студент регистрируется э-мейлом, к нему привязуеться его Успешность и на него будут приходить сообщения о результате тестов. В системе существует каталог Тестов по темам, авторизованный Студент может проходить тесты. В конце теста должна на странице отобразится форма где показано ошибки студента. Все данные об успеваемости и пройденных курсах отображаются на странице Администратора как сводная таблица по всем Студентам.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

To run this project you need:

```
Java 1.8 or newer
MySql 5.7 or newer
Tomcat 9.0.30 or newer
Maven 3.6.0 or newer
```

### Installing

Steps to run this project

- clone the project
- import data.sql to your mysql database to insert data
- build project
- deploy to Tomcat

## Running the tests

Running the tests is easy
```
mvn test
```

## Authors

**Kateryna Babenko** - [Iemmon](https://github.com/Iemmon)