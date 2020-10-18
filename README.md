# TodoIstBack

Дла запуска приложения необходимы выполнить пару простых действий

## Настройка окружения

###Установить Java8

Для MacOS
```
    $ brew cask install java8
```

Для Linux

```
    $ sudo apt update
    $ sudo apt install openjdk-8-jdk
```

###Для сборки и запуска приложение необходимо установить Maven

```
    $ sudo apt update
    $ sudo apt install maven
```


##Запуск приложение

Клонируем git репозиторий в папку

```
    $ git clone https://github.com/StepanLyahov/TodoIstBack.git -b dev_with_h2
```
Заходим в папку проекта

```
    $ cd TodoIstBack
```

Собираем проект через Maven

```
    $ mvn install
```
Запускаем проект

```
    $ mvn spring-boot:run
```




