#### Request 

1. A GET request to see the list of TODO tasks  

curl http://localhost:8080/todo

2. A POST request to create a new todo task

curl -H "Content-Type: application/json" -X POST -d '{
    "name": "Buy orange juice"
}'  http://localhost:8080/todo


#### H2 console

Use "h2.console.enabled" property to enable/disable h2 console.
Web console listening on port 8082. 