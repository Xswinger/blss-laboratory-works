# Лабораторная работа №1

## Текст задания

Описать бизнес-процесс в соответствии с нотацией BPMN 2.0, после чего реализовать его в виде приложения на базе Spring Boot.

Порядок выполнения работы:

* Выбрать один из бизнес-процессов, реализуемых сайтом из варианта задания.
* Утвердить выбранный бизнес-процесс у преподавателя.
  Специфицировать модель реализуемого бизнес-процесса в соответствии с требованиями BPMN 2.0.
* Разработать приложение на базе Spring Boot, реализующее описанный на предыдущем шаге бизнес-процесс. Приложение должно использовать СУБД PostgreSQL для хранения данных, для всех публичных интерфейсов должны быть разработаны REST API.
* Разработать набор curl-скриптов, либо набор запросов для REST клиента Insomnia для тестирования публичных интерфейсов разработанного программного модуля. Запросы Insomnia оформить в виде файла экспорта.
* Развернуть разработанное приложение на сервере helios.
  Содержание отчёта:

Текст задания.
* Модель потока управления для автоматизируемого бизнес-процесса.
* UML-диаграммы классов и пакетов разработанного приложения.
* Спецификация REST API для всех публичных интерфейсов разработанного приложения.
* Исходный код системы или ссылка на репозиторий с исходным кодом.
* Выводы по работе.

## Вариант №1201

https://wroom.ru

## Модель потока управления

![Общий бизнес процесс](./img/БЛПС%20лаб1.png "Бизнес процесс выбора модели машины")

![Редатирование](./img/user's%20roles%20-1%20script.png "Бизнес процесс редактирования модели машины")

![Добавление](./img/user's%20roles%20-2%20script.png "Бизнес процесс добавления модели машины")

## Спецификация REST API
{
"_type": "export",
"__export_format": 4,
"__export_date": "2024-02-28T15:36:00.634Z",
"__export_source": "insomnia.desktop.app:v8.6.1",
"resources": [
{
"_id": "req_4882332837c9441ba0b31451a25d39ec",
"parentId": "wrk_scratchpad",
"modified": 1709134499333,
"created": 1709134216788,
"url": "localhost:8080/cars/filter",
"name": "getByFilter",
"description": "",
"method": "POST",
"body": {},
"parameters": [
{
"id": "pair_0654fbd3d74144229806f4d04fc3abaf",
"name": "country",
"value": "1",
"description": ""
},
{
"id": "pair_17877b02a590441a896d9321c983a321",
"name": "lineup",
"value": "1",
"description": ""
}
],
"headers": [
{
"name": "User-Agent",
"value": "insomnia/8.6.1"
}
],
"authentication": {},
"metaSortKey": -1709134216788,
"isPrivate": false,
"pathParameters": [],
"settingStoreCookies": true,
"settingSendCookies": true,
"settingDisableRenderRequestBody": false,
"settingEncodeUrl": true,
"settingRebuildPath": true,
"settingFollowRedirects": "global",
"_type": "request"
},
{
"_id": "wrk_scratchpad",
"parentId": null,
"modified": 1707323109418,
"created": 1707323109418,
"name": "Scratch Pad",
"description": "",
"scope": "collection",
"_type": "workspace"
},
{
"_id": "req_7624ec1ba31c46b6885961c27f85239b",
"parentId": "wrk_scratchpad",
"modified": 1709133622603,
"created": 1709133587259,
"url": "localhost:8080/cars/models",
"name": "getModels",
"description": "",
"method": "GET",
"body": {},
"parameters": [],
"headers": [
{
"name": "User-Agent",
"value": "insomnia/8.6.1"
}
],

            "authentication": {},
            "metaSortKey": -1709133587259,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_a306dc9ade684671b847716f36c4919e",
            "parentId": "wrk_scratchpad",
            "modified": 1709133565130,
            "created": 1709133434158,
            "url": "localhost:8080/cars/country",
            "name": "getCountries",
            "description": "",
            "method": "GET",
            "body": {},
            "parameters": [],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {},
            "metaSortKey": -1709133434158,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_49fa83e0e81b4ddabf1517ead5e03c7a",
            "parentId": "wrk_scratchpad",
            "modified": 1709133425415,
            "created": 1709133357582,
            "url": "localhost:8080/cars/country/1",
            "name": "getBrandsByCountry",
            "description": "",
            "method": "POST",
            "body": {},
            "parameters": [],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {},
            "metaSortKey": -1709133357582,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_6accc56858da4df2be1aa90924d7ab83",
            "parentId": "wrk_scratchpad",
            "modified": 1709133308612,
            "created": 1709133244078,
            "url": "localhost:8080/cars/class",
            "name": "getClasses",
            "description": "",
            "method": "GET",
            "body": {},
            "parameters": [],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {},
            "metaSortKey": -1709133244078,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_5a0cbc6c8a6148fea734a760817604ad",
            "parentId": "wrk_scratchpad",
            "modified": 1709133605711,
            "created": 1709123418438,
            "url": "localhost:8080/cars/",
            "name": "getBrands",
            "description": "",
            "method": "GET",
            "body": {},
            "parameters": [],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {},
            "metaSortKey": -1709123418438,
            "isPrivate": false,

            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "env_99d30891da4bdcebc63947a8fc17f076de878684",
            "parentId": "wrk_scratchpad",
            "modified": 1709123405118,
            "created": 1709123405118,
            "name": "Base Environment",
            "data": {},
            "dataPropertyOrder": null,
            "color": null,
            "isPrivate": false,
            "metaSortKey": 1709123405118,
            "_type": "environment"
        },
        {
            "_id": "jar_99d30891da4bdcebc63947a8fc17f076de878684",
            "parentId": "wrk_scratchpad",
            "modified": 1709123405134,
            "created": 1709123405134,
            "name": "Default Jar",
            "cookies": [],
            "_type": "cookie_jar"
        }
    ]
}

## Выводы по работе

BPMN предоставляет удобный и понятный набор элементов для описания бизнес-процесса

# Лабораторная работа №2

## Текст задания

Доработать приложение из лабораторной работы #1, реализовав в нём управление транзакциями и разграничение доступа к операциям бизнес-логики в соответствии с заданной политикой доступа.

Управление транзакциями необходимо реализовать следующим образом:

Переработать согласованные с преподавателем прецеденты (или по согласованию с ним разработать новые), объединив взаимозависимые операции в рамках транзакций.
Управление транзакциями необходимо реализовать с помощью Spring JTA.
В реализованных (или модифицированных) прецедентах необходимо использовать программное управление транзакциями.
В качестве менеджера транзакций необходимо использовать Atomikos.
Разграничение доступа к операциям необходимо реализовать следующим образом:

Разработать, специфицировать и согласовать с преподавателем набор привилегий, в соответствии с которыми будет разграничиваться доступ к операциям.
Специфицировать и согласовать с преподавателем набор ролей, осуществляющих доступ к операциям бизнес-логики приложения.
Реализовать разработанную модель разграничений доступа к операциям бизнес-логики на базе Spring Security. Информацию об учётных записях пользователей необходимо сохранять в реляционую базу данных, для аутентификации использовать JWT.
Правила выполнения работы:

Все изменения, внесённые в реализуемый бизнес-процесс, должны быть учтены в описывающей его модели, REST API и наборе скриптов для тестирования публичных интерфейсов модуля.
Доработанное приложение необходимо развернуть на сервере helios.

## Модель потока управления

![Общий бизнес процесс](./img/БЛПС%20лаб1.png "Бизнес процесс выбора модели машины")

![Удаления](./img/BLPS-admin.png "Бизнес процесс удаления модели машины")

![Добавления](./img/BLPS-admin1.png "Бизнес процесс добавления модели машины")

## Спецификация пользовательских ролей

### Роль USER

Привилегии:

1. Получение списка моделей машин по фильтрам

Требования для доступа: нет

### Роль ADMIN

Привилегии:
1. Добавление новой модели машины/страны/марки
2. Удаление определенной модели машины/страны/марки

Требования для доступа: авторизация через логин, пароль

## UML-диаграмма классов

![uml](./img/UML-класс-блпс2.png "UML-диаграмма")

## Спецификация REST API

{
{"_type":"export","__export_format":4,"__export_date":"2024-04-10T14:50:27.532Z","__export_source":"insomnia.desktop.app:v8.6.1","resources":[{"_id":"req_8da7124835014dbd949f8a5016d9b02c","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1712752267271,"created":1712749022253,"url":"localhost:8080/auth/sign-up","name":"signUp","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"adminName\": \"user1\",\n\t\"password\": \"password\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1712749022253,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","parentId":null,"modified":1711436895608,"created":1711436895608,"name":"BLLS","description":"","scope":"collection","_type":"workspace"},{"_id":"req_eb337053e3dd4e75ba9ce2f2560fbed1","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1712749066650,"created":1712749010834,"url":"localhost:8080/auth/sign-in","name":"signIn","description":"","method":"POST","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1712749010834,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_db52329fa45646f4b0b8557917df1ab4","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1711553945312,"created":1711490730423,"url":"localhost:8080/admin/add/country","name":"saveCountry","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"name\": \"Italia\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711490730423,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_2c464139e4054546b18efc4efb9831f7","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1711492608420,"created":1711491705250,"url":"localhost:8080/admin/add/class","name":"saveClass","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"name\": \"Минивен\",\n\t\"description\": \"Семейные автомобили повышенной вместимости\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711142246591.5,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_f5733e7c71714aada4d2754187fa63d5","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1711554592175,"created":1711491696543,"url":"localhost:8080/admin/add/brand","name":"saveBrand","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"name\": \"MAN\",\n\t\"country\": {\n\t\t\"id\": 52\n\t},\n\t\"lineups\": []\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1710793762760,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_8ddcdf4c4c7c49d4a3ca13f3bb60dca6","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1711487733003,"created":1709134216788,"url":"localhost:8080/cars/filter","name":"getByFilter","description":"","method":"POST","body":{},"parameters":[{"id":"pair_0654fbd3d74144229806f4d04fc3abaf","name":"country","value":"1","description":""},{"id":"pair_17877b02a590441a896d9321c983a321","name":"lineup","value":"1","description":""}],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1709134216788,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_88b59915d10b46d6af164e03ea8c97db","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1712659783121,"created":1709133587259,"url":"localhost:8080/cars/models","name":"getModels","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1709133587259,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_3e285d98ff9e4dedb348611e246c3b3a","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1711489047239,"created":1709133434158,"url":"localhost:8080/cars/country","name":"getCountries","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1709133434158,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_7da8d67e84654e4fa75e09debf25a06a","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1711459686892,"created":1709133357582,"url":"localhost:5432/cars/country/1","name":"getBrandsByCountry","description":"","method":"POST","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1709133357582,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_6280e52212f046f5be302aec93430294","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1711487250558,"created":1709133244078,"url":"localhost:8080/cars/class","name":"getClasses","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1709133244078,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_57897fe12a9246589851a8b293b28992","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1711489934470,"created":1709123418438,"url":"localhost:8080/cars/","name":"getBrands","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1","id":"pair_34bbe5e4bd594b3fa2b355ef6f8b8f27"}],"authentication":{},"metaSortKey":-1709123418438,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"env_94842ae06f69b45e338d9ed5dc6c194be90c14c9","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1711436895616,"created":1711436895616,"name":"Base Environment","data":{},"dataPropertyOrder":null,"color":null,"isPrivate":false,"metaSortKey":1711436895616,"_type":"environment"},{"_id":"jar_94842ae06f69b45e338d9ed5dc6c194be90c14c9","parentId":"wrk_ca1cdf940fc44a2f9aa43bd552a2a79c","modified":1712751472435,"created":1711436895621,"name":"Default Jar","cookies":[{"key":"JSESSIONID","value":"10EA69393A8588E77CDD1294F7B947EC","domain":"localhost","path":"/","httpOnly":true,"hostOnly":true,"creation":"2024-03-26T21:48:22.269Z","lastAccessed":"2024-04-10T12:17:52.435Z","id":"ab36561d-ae5d-4006-b40b-c3426b52e019"}],"_type":"cookie_jar"}]}
}

## Вариант №1201

https://wroom.ru

# Лабораторная работа №3

## Текст задания

Доработать приложение из лабораторной работы #2, реализовав в нём асинхронное выполнение задач с распределением бизнес-логики между несколькими вычислительными узлами и выполнением периодических операций с использованием планировщика задач.

Требования к реализации асинхронной обработки:

* Перед выполнением работы неободимо согласовать с преподавателем набор прецедентов, в реализации которых целесообразно использование асинхронного распределённого выполнения задач. Если таких прецедентов использования в имеющейся бизнес-процесса нет, нужно согласовать реализацию новых прецедентов, доработав таким образом модель бизнес-процесса из лабораторной работы #1.
* Асинхронное выполнение задач должно использовать модель доставки "очередь сообщений".
* В качестве провайдера сервиса асинхронного обмена сообщениями необходимо использовать очередь сообщений на базе RabbitMQ.
* Для отправки сообщений необходимо использовать протокол MQTT. Библиотеку для реализации отправки сообщений можно взять любую на выбор студента.
* Для получения сообщений необходимо использовать JMS API.

Требования к реализации распределённой обработки:

* Обработка сообщений должна осуществляться на двух независимых друг от друга узлах сервера приложений.
* Если логика сценария распределённой обработки предполагает транзакционность выполняемых операций, они должны быть включены в состав распределённой транзакции.

Требования к реализации запуска периодических задач по расписанию:

* Согласовать с преподавателем прецедент или прецеденты, в рамках которых выглядит целесообразным использовать планировщик задач. Если такие прецеденты отсутствуют -- согласовать с преподавателем новые и добавить их в модель автоматизируемого бизнес-процесса.
* Реализовать утверждённые прецеденты с использованием планировщика задач Quartz.
* Правила выполнения работы:

* Все изменения, внесённые в реализуемый бизнес-процесс, должны быть учтены в описывающей его модели, REST API и наборе скриптов для тестирования публичных интерфейсов модуля.
* Доработанное приложение необходимо либо развернуть на сервере helios, либо продемонстрировать его работоспособность на собственной инфраструктуре обучающегося.

## Вариант №1983

https://wroom.ru

## UML-диаграммы

![uml](./img/UML-класс-блпс2.png "UML-диаграмма")

![uml](./img/blss,%20lab,%20messaging.png "UML-диаграмма классов обмена сообщениями")

## Модель потока управления

![Бизнес процессы](./img/announcemet_scripts.png "Бизнес процессы покупки машины и получения количества моделей")

## Спецификация REST API

{
    "_type": "export",
    "__export_format": 4,
    "__export_date": "2024-05-21T21:02:02.472Z",
    "__export_source": "insomnia.desktop.app:v9.2.0",
    "resources": [
        {
            "_id": "req_5488cce028684e4a92d0903cdf7dd9b3",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1715179736493,
            "created": 1715178368678,
            "url": "localhost:8080/announcement/buy-model",
            "name": "Buy model",
            "description": "",
            "method": "POST",
            "body": {
                "mimeType": "application/json",
                "text": "{\n\t\"id\": 1,\n\t\t\"model\": {\n\t\t\t\"id\": 1,\n\t\t\t\"name\": \"нв® <бЇ®авЁў­ п> ўҐабЁп ¬®¤Ґ«Ё <‹ ¤  ѓа ­в >\",\n\t\t\t\"description\": \"Sport\",\n\t\t\t\"carClass\": {\n\t\t\t\t\"id\": 3,\n\t\t\t\t\"name\": \"Ђўв®¬®ЎЁ«м ¤«п вҐе, Єв® з бв® б®ўҐаи Ґв ¤®«ЈЁҐ Ї®Ґ§¤ЄЁ Ё ­г¦¤ Ґвбп ў ¤®Ї®«­ЁвҐ«м­®¬ Є®¬д®авҐ\",\n\t\t\t\t\"description\": \"‘аҐ¤­Ё© Є« бб\",\n\t\t\t\t\"hibernateLazyInitializer\": {}\n\t\t\t},\n\t\t\t\"country\": {\n\t\t\t\t\"id\": 1,\n\t\t\t\t\"name\": \"Russia\",\n\t\t\t\t\"hibernateLazyInitializer\": {}\n\t\t\t},\n\t\t\t\"lineUp\": {\n\t\t\t\t\"id\": 1,\n\t\t\t\t\"name\": \"Granta\",\n\t\t\t\t\"models\": [],\n\t\t\t\t\"hibernateLazyInitializer\": {}\n\t\t\t},\n\t\t\t\"releaseCount\": 0,\n\t\t\t\"hibernateLazyInitializer\": {}\n\t\t},\n\t\t\"price\": 200,\n\t\t\"relevance\": true\n}"
            },
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "Content-Type",
                    "value": "application/json"
                },
                {
                    "name": "User-Agent",
                    "value": "insomnia/9.0.0"
                }
            ],
            "authentication": {},
            "metaSortKey": -1715178368678,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "parentId": null,
            "modified": 1711436895608,
            "created": 1711436895608,
            "name": "BLLS",
            "description": "",
            "scope": "collection",
            "_type": "workspace"
        },
        {
            "_id": "req_06719ab5149b4a3b8274cc3d047463d9",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1715179056408,
            "created": 1715178355028,
            "url": "localhost:8080/announcement/get-announcements",
            "name": "Get announcements",
            "description": "",
            "method": "GET",
            "body": {},
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/9.0.0"
                }
            ],
            "authentication": {},
            "metaSortKey": -1715178355028,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_2c0df89518ba49269cff07230dc7b9a6",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713962332351,
            "created": 1713648288144,
            "url": "localhost:8080/auth/refresh-access",
            "name": "New tokens",
            "description": "",
            "method": "POST",
            "body": {
                "mimeType": "application/json",
                "text": ""
            },
            "preRequestScript": "",
            "parameters": [
                {
                    "id": "pair_b18e719693674a72aa221071c5afd963",
                    "name": "token",
                    "value": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMjMiLCJpYXQiOjE3MTM5NjE5NDUsImV4cCI6MTcxNDEwNTk0NX0.6F7nJVuH7o6ncxnrPPyl3Sk8BYnsEMAUzWc7i4b1f2k",
                    "description": ""
                }
            ],
            "headers": [
                {
                    "name": "Content-Type",
                    "value": "application/json"
                },
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {
                "type": "bearer",
                "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMjMiLCJpYXQiOjE3MTM5NjE5NDUsImV4cCI6MTcxNDEwNTk0NX0.6F7nJVuH7o6ncxnrPPyl3Sk8BYnsEMAUzWc7i4b1f2k"
            },
            "metaSortKey": -1713648288144,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_16bf89e519f54e349e54cff4c8bb4917",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713961966762,
            "created": 1713617933255,
            "url": "localhost:8080/auth/get-admin",
            "name": "Give admin role",
            "description": "",
            "method": "GET",
            "body": {},
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1",
                    "id": "pair_7a5394ca573543e4b3a3a1f6a60cf552"
                }
            ],
            "authentication": {
                "type": "bearer",
                "token": "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiUk9MRV9VU0VSIiwiaWQiOjM4LCJzdWIiOiJ1c2VyMjMiLCJpYXQiOjE3MTM5NjE5NDUsImV4cCI6MTcxMzk2MjA0NX0.LUAuDANmM7ZefSzRdZx1uHNAEqrWEJ5L3EzAP0zGeSg",
                "prefix": "",
                "disabled": false
            },
            "metaSortKey": -1713617933255,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_8da7124835014dbd949f8a5016d9b02c",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713961943477,
            "created": 1712749022253,
            "url": "localhost:8080/auth/sign-up",
            "name": "Sign up",
            "description": "",
            "method": "POST",
            "body": {
                "mimeType": "application/json",
                "text": "{\n\t\"username\": \"user23\",\n\t\"password\": \"password\"\n}"
            },
            "preRequestScript": "",
            "parameters": [
                {
                    "id": "pair_ff0573f515914fbebe8bc49d9d9f73fb",
                    "name": "",
                    "value": "",
                    "description": ""
                }
            ],
            "headers": [
                {
                    "name": "Content-Type",
                    "value": "application/json"
                },
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {
                "type": "bearer",
                "token": ""
            },
            "metaSortKey": -1712749022253,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_eb337053e3dd4e75ba9ce2f2560fbed1",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713908348948,
            "created": 1712749010834,
            "url": "localhost:8080/auth/sign-in",
            "name": "Sign in",
            "description": "",
            "method": "POST",
            "body": {
                "mimeType": "application/json",
                "text": "{\n\t\"username\": \"user20\",\n\t\"password\": \"password\"\n}"
            },
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "Content-Type",
                    "value": "application/json"
                },
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {},
            "metaSortKey": -1712749010834,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_db52329fa45646f4b0b8557917df1ab4",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713961974435,
            "created": 1711490730423,
            "url": "localhost:8080/admin/add/country",
            "name": "Save country",
            "description": "",
            "method": "POST",
            "body": {
                "mimeType": "application/json",
                "text": "{\n\t\"name\": \"Israel\"\n}"
            },
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "Content-Type",
                    "value": "application/json"
                },
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {
                "type": "bearer",
                "token": "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiUk9MRV9VU0VSIiwiaWQiOjM4LCJzdWIiOiJ1c2VyMjMiLCJpYXQiOjE3MTM5NjE5NDUsImV4cCI6MTcxMzk2MjA0NX0.LUAuDANmM7ZefSzRdZx1uHNAEqrWEJ5L3EzAP0zGeSg"
            },
            "metaSortKey": -1711490730423,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_2c464139e4054546b18efc4efb9831f7",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713647623792,
            "created": 1711491705250,
            "url": "localhost:8080/admin/add/class",
            "name": "Save class",
            "description": "",
            "method": "POST",
            "body": {
                "mimeType": "application/json",
                "text": "{\n\t\"name\": \"Минивен\",\n\t\"description\": \"Семейные автомобили повышенной вместимости\"\n}"
            },
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "Content-Type",
                    "value": "application/json"
                },
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {},
            "metaSortKey": -1711142246591.5,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_f5733e7c71714aada4d2754187fa63d5",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713647630930,
            "created": 1711491696543,
            "url": "localhost:8080/admin/add/brand",
            "name": "Save brand",
            "description": "",
            "method": "POST",
            "body": {
                "mimeType": "application/json",
                "text": "{\n\t\"name\": \"MAN\",\n\t\"country\": {\n\t\t\"id\": 52\n\t},\n\t\"lineups\": []\n}"
            },
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "Content-Type",
                    "value": "application/json"
                },
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {},
            "metaSortKey": -1710793762760,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_8ddcdf4c4c7c49d4a3ca13f3bb60dca6",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713647646715,
            "created": 1709134216788,
            "url": "localhost:8080/cars/filter",
            "name": "Get by filter",
            "description": "",
            "method": "POST",
            "body": {},
            "preRequestScript": "",
            "parameters": [
                {
                    "id": "pair_0654fbd3d74144229806f4d04fc3abaf",
                    "name": "country",
                    "value": "1",
                    "description": ""
                },
                {
                    "id": "pair_17877b02a590441a896d9321c983a321",
                    "name": "lineup",
                    "value": "1",
                    "description": ""
                }
            ],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {},
            "metaSortKey": -1709134216788,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_88b59915d10b46d6af164e03ea8c97db",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713647655159,
            "created": 1709133587259,
            "url": "localhost:8080/cars/models",
            "name": "Get models",
            "description": "",
            "method": "GET",
            "body": {},
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {
                "type": "bearer",
                "token": ""
            },
            "metaSortKey": -1709133587259,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_3e285d98ff9e4dedb348611e246c3b3a",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713647660779,
            "created": 1709133434158,
            "url": "localhost:8080/cars/country",
            "name": "Get countries",
            "description": "",
            "method": "GET",
            "body": {},
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {
                "type": "bearer",
                "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTcxMzYxNDkzMCwicm9sZXMiOiJVU0VSIn0.78So0iX7FxFocmOJima-jTde4F8BXnfJxddcD775bszLF9lUFEDcDgBmUEpjzeZlkaMehdSFu6x_IQj9W9ivAQ"
            },
            "metaSortKey": -1709133434158,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_7da8d67e84654e4fa75e09debf25a06a",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713647673823,
            "created": 1709133357582,
            "url": "localhost:5432/cars/country/1",
            "name": "Get brands by country",
            "description": "",
            "method": "POST",
            "body": {},
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {},
            "metaSortKey": -1709133357582,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_6280e52212f046f5be302aec93430294",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713647680217,
            "created": 1709133244078,
            "url": "localhost:8080/cars/class",
            "name": "Get classes",
            "description": "",
            "method": "GET",
            "body": {},
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1"
                }
            ],
            "authentication": {},
            "metaSortKey": -1709133244078,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "req_57897fe12a9246589851a8b293b28992",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713647686467,
            "created": 1709123418438,
            "url": "localhost:8080/cars/",
            "name": "Get brands",
            "description": "",
            "method": "GET",
            "body": {},
            "preRequestScript": "",
            "parameters": [],
            "headers": [
                {
                    "name": "User-Agent",
                    "value": "insomnia/8.6.1",
                    "id": "pair_34bbe5e4bd594b3fa2b355ef6f8b8f27"
                }
            ],
            "authentication": {},
            "metaSortKey": -1709123418438,
            "isPrivate": false,
            "pathParameters": [],
            "settingStoreCookies": true,
            "settingSendCookies": true,
            "settingDisableRenderRequestBody": false,
            "settingEncodeUrl": true,
            "settingRebuildPath": true,
            "settingFollowRedirects": "global",
            "_type": "request"
        },
        {
            "_id": "env_94842ae06f69b45e338d9ed5dc6c194be90c14c9",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1711436895616,
            "created": 1711436895616,
            "name": "Base Environment",
            "data": {},
            "dataPropertyOrder": null,
            "color": null,
            "isPrivate": false,
            "metaSortKey": 1711436895616,
            "_type": "environment"
        },
        {
            "_id": "jar_94842ae06f69b45e338d9ed5dc6c194be90c14c9",
            "parentId": "wrk_ca1cdf940fc44a2f9aa43bd552a2a79c",
            "modified": 1713962043460,
            "created": 1711436895621,
            "name": "Default Jar",
            "cookies": [
                {
                    "key": "JSESSIONID",
                    "value": "1E6094EC9D87C30EBE7A6734DC159E70",
                    "domain": "localhost",
                    "path": "/",
                    "httpOnly": true,
                    "hostOnly": true,
                    "creation": "2024-03-26T21:48:22.269Z",
                    "lastAccessed": "2024-04-24T12:34:03.459Z",
                    "id": "7938be46-017c-4f81-a7f7-e9d6e1dc6395"
                }
            ],
            "_type": "cookie_jar"
        }
    ]
}

## Выводы по работе

Quortz представляет собой удобный и гибкий планировщик, поддерживающий запуск огромного числа задач, транзакционное выполнение и разбиение на кластеры. Использование протокола MQTT и конкретно его реализации Eclipse Paho обеспечивают 
удобный интерфейс обмена сообщениями между сервисами по принципу издатель-подписчик. RabbitMQ представляет собой удобный
брокер сообщений, имеющий набор плагинов для поддержки различных протоколов передачи сообщений или пользовательского интерфейса.   

Выполнили Аллаяров Игорь Олегович и Пушкин Антон Сергеевич

# Лабораторная работа №4

## Текст задания

Переработать программу, созданную в результате выполнения лабораторной работы #3, следующим образом:

* Для управления бизнес-процессом использовать BPM-движок Camunda.
* Заменить всю "статическую" бизнес-логику на "динамическую" на базе BPMS. 
* Весь бизнес-процесс, реализованный в ходе выполнения предыдущих лабораторных работ (включая разграничение доступа по ролям, управление транзакциями, асинхронную обработку и периодические задачи), должен быть сохранён!.
* BPM-движок должен быть встроен в веб-приложение (embedded mode).
* Для описания бизнес-процесса необходимо использовать онлайн-сервис BPMN.io.
* Пользовательский интерфейс приложения должен быть сгенерирован с помощью генератора форм Camunda.
* Итоговая сборка должно быть развёрнута на сервере helios под управление сервера приложений WildFly.

Правила выполнения работы:

* Описание бизнес-процесса необходимо реализовать на языке BPMN 2.0.
* Необходимо интегрировать в состав процесса, управляемого BPMS, всё, что в принципе возможно в него интегрировать. Если какой-то из компонентов архитектуры приложения (например, асинхронный обмен сообщениями с помощью JMS) не поддерживается, необходимо использовать для интеграции с этой подсистемой соответствующие API и адаптеры.
* Распределённую обработку задач и распределённые транзакции на BPM-движок переносить не требуется.

## Вариант №95312

## Модель потоков управления

## Блок-схема архитектуры приложения

## Вывод