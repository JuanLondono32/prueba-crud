# Juan Camilo Londoño Jaimes - 2172006
# Laura Daniela Serrano Villanova - 2162113

# demo-spring
Application demo usando Spring boot y maven como herramienta de build

__Para compilar:__
_mvn compile_

__Para ejecutar Tests:__
_mvn test_

__Para crear artefacto de despliegue (.jar)__
_mvn package_

__Para ejecutar usando spring pluging__ _mvn spring-boot:run_

__Para ejecutar usando el artefacto generado__ _java -jar target/demo-spring-0.0.1-SNAPSHOT.jar_




__Post:__
_POST [http://localhost:8090/register?title=title&author=author&lang=lang&genre=genre&pages=pages](http://localhost:8090/register?title=title&author=author&lang=lang&genre=genre&pages=pages)_

__Get:__
_GET [http://localhost:8090/get/id](http://localhost:8090/get/id)_

__Get:__
_GET [http://localhost:8090/getall](http://localhost:8090/getall)_

__Update:__
_PATCH [http://localhost:8090/update/id?title=newTitle](http://localhost:8090/user/id?title=newTitle)_

__Delete:__
_DELETE [http://localhost:8090/delete?title=title](http://localhost:8090/delete?title=title)_