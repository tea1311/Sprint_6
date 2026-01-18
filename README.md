# Sprint_6
QA Java Project
В проекте: 
* Unit-тестирование
* Изоляция зависимостей 
* Параметризация
* Использование Mockito
* Отчет с помощью Jacoco

# Структура проекта

```Sprint_6/
├── pom.xml
├── README.md
├── .gitignore
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/example/
│   │           ├── Animal.java
│   │           ├── Cat.java
│   │           ├── Feline.java
│   │           ├── Lion.java
│   │           └── Predator.java
│   └── test/
│       └── java/
│           └── com/example/
│               ├── CatTest.java
│               ├── FelineParameterizedTest.java
│               ├── FelineTest.java
│               ├── LionParameterizedTest.java
│               └── LionTest.java
├── target/
│   └── site/
│       └── jacoco/
│           └── index.html
```
# Технологии
* Java 11
* Maven
* JUnit 4
* Mockito
* Jacoco 

# Настройка среды
Клонировать репозиторий: https://github.com/tea1311/Sprint_6 Импортировать проект в IntelliJ IDEA. Убедиться, что установлен JDK 11 Maven подтянет зависимости автоматически при открытии проекта.

# Запуск тестов
```bash
  mvn clean test
```
# Отчет Jacoco
Для оценки покрытия тестами используется инструмент Jacoco
``` bash 
  mvn verify
```
Отчет доступен по пути target/site/jacoco/index.html