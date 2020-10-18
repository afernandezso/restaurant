# restaurant

#### Run Proyecto
`mvn spring-boot:run`


#### Login
username = username
password = password
`curl --location --request POST 'http://localhost:8080/login' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=98A2720F21F15FDA1915BADDC3CDCF24' \
--data-raw '{ "username": "username", "password": "password"}'`


#### JWT 

Se ocupa JWT para la sesión por lo que al llamar a los endpoint de new y day se tiene que agregar el token 

#### crear una venta

`curl --location --request POST 'http://localhost:8080/sale/new' \
 --header 'token: eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2MDI4OTQwMzYsImlzcyI6IiIsInN1YiI6InVzZXJuYW1lIiwiZXhwIjoxNjAyODk1ODM2fQ.RATZwl2GV7Gx2q1CfhTWcu3-D1UCJV6pUgLNhujcwBWl5T1YdLoADdYMwTD3eQEdCDki_BnTy2QhOpxduX0eaQ' \
 --header 'Content-Type: application/json' \
 --header 'Cookie: JSESSIONID=98A2720F21F15FDA1915BADDC3CDCF24' \
 --data-raw '{
     "seller": "alfredo",
     "price":10000
 }'`
 
#### obtener las venta del dia 

`curl --location --request GET 'http://localhost:8080/sale/day' \
 --header 'token: eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2MDI4OTQwMzYsImlzcyI6IiIsInN1YiI6InVzZXJuYW1lIiwiZXhwIjoxNjAyODk1ODM2fQ.RATZwl2GV7Gx2q1CfhTWcu3-D1UCJV6pUgLNhujcwBWl5T1YdLoADdYMwTD3eQEdCDki_BnTy2QhOpxduX0eaQ' \
 --header 'Cookie: JSESSIONID=98A2720F21F15FDA1915BADDC3CDCF24'`

[swagger restaurant](http://localhost:8080/swagger-ui.html#!)
