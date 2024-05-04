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

Выполнили Аллаяров Игорь Олегович и Пушкин Антон Сергеевич