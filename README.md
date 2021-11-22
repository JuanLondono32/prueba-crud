# demo-spring
Application demo usando Spring boot y maven como herramienta de build

__Para compilar:__
_mvn compile_

__Para ejecutar Tests:__
_mvn test_

__Para crear artefacto de despliegue (.jar)__
_mvn package_

__Para ejecutar usando spring pluging__ _mvn spring-boot:run_ y luego acceder a [http://localhost:8080/greeting](http://localhost:8080/greeting)

__Para ejecutar usando el artefacto generado__ _java -jar target/demo-spring-0.0.1-SNAPSHOT.jar_ y luego acceder a [http://localhost:8080/greeting](http://localhost:8080/greeting)




__Create:__
_POST [http://localhost:8080/register?name=nombre](http://localhost:8080/register?name=nombre)_

__Read:__
_GET [http://localhost:8080/view?name=nombre](http://localhost:8080/view?name=nombre)_

__Read:__
_GET [http://localhost:8080/viewall](http://localhost:8080/viewall)_

__Update:__
_PATCH [http://localhost:8080/user/id?nombre=nuevo_nombre](http://localhost:8080/user/id?nombre=nuevo_nombre)_

__Delete:__
_DELETE [http://localhost:8080/delete?name=nombre](http://localhost:8080/delete?name=nombre)_