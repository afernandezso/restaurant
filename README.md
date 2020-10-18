# restaurant

#### Run Proyecto
`mvn spring-boot:run`

#### Login 
Crear token <br> Post  <br> `http://localhost:8080/login`  <br> Body:  
`{"username":"username",
"password":"password"}`

###Flujo para consumir API Restaurant

Se utilizó JWT para la sesión por lo que al llamar a los endpoint se debe ingresar un token valido
<br> Ejemplo: 
`eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2MDMwNTIwNTQsImlzcyI6IiIsInN1YiI6InVzZXJuYW1lIiwiZXhwIjoxNjAzMDUzODU0fQ._69yZq3Ffph5g-H7fcm3DEwuyJ_nBq4_uA_RiBJ7Ogy9PK4HMj4MOZWFA_FzhzesweHNcgTT_rej1Rfhlznf-Q`
<br>

- agregar una venta Post
`http://localhost:8080/sale/new`  <br>
body :
`{
    "seller": "afernandez",
    "price":1
}` <br>
- ventas del día Get `http://localhost:8080/sale/day`
 <br>
 <br>
 ### swagger API Restaurant  
 <br>
[swagger restaurant](http://localhost:8080/swagger-ui.html#!)
