# job4j_grabber
[![Build Status](https://app.travis-ci.com/chulkovdmitry/job4j_grabber.svg?branch=master)](https://app.travis-ci.com/chulkovdmitry/job4j_grabber)
[![codecov](https://codecov.io/gh/chulkovdmitry/job4j_grabber/branch/master/graph/badge.svg?token=4221A4UQSL)](https://codecov.io/gh/chulkovdmitry/job4j_grabber)

## Проект - Агрегатор вакансий<br>
Система запускается по расписанию. Период запуска указывается в настройках - app.properties.
Первый сайт будет sql.ru. В нем есть раздел job. Программа должна считывать все вакансии относящиеся к Java и записывать их в базу.
Доступ к интерфейсу будет через REST API.

## Сборка и запуск<br>
для сборки `mvn install`<br>
для запуска`java -jar target/job4j_grabber-1.0.jar`

## Использование<br>
Для поиска вакансий на сайте sql.ru

## Контакты<br> 
tg: @LentulBat
