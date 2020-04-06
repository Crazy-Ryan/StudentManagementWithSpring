## Description
This is a student information management system built with SpringBoot

It is a pure backend project and all communications are done through HTTP request

It is recommended to send Http request with *Postman*

## How to use it

The Http request for different functions have been listed as follows

1. Add a new student

```
POST /add HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: bc58d71e-933a-09e0-cb67-96e5e92ab931

{
	"name": "王五",
	"gender": "女",
	"classId":"3-1"}
```

2. query all students

```
GET /all HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 088a3d0a-639f-78aa-dc11-01127577a742
```

3. find student by name

```
POST /find HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: c627aec9-a758-15c9-504c-ec2943bad4d4

张三
```

4. remove student by name

```
POST /remove HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 7362c0d2-6473-3780-a27e-cb25a78e433d

张三
```