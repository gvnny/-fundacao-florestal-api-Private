# fundacao-florestal
Fundação Florestal

# Compile
```shell
mvn compile
```

# Run database container
```shell
podman run --rm --name mysql -e MYSQL_DATABASE=Fundacao_Florestal -e MYSQL_ROOT_PASSWORD=123 --net=host docker.io/mysql
```

# Connecting to database
Information is stored in file application.properties

host=localhost
port="3306"
database="Fundacao_Florestal"
username="root"
password="123"

# Run adminer (to manage database)
Adminer listen to port 8080

```shell
podman run --rm --name adminer --net=host docker.io/adminer
```

# Run application
App listen to port 8081

```shell
mvn spring-boot:run
```

# Run tests
App must be running

```shell
mvn test
```

# API
GET     /usuarios       "List all users"
POST    /usuarios       "Create a new user"
GET     /usuarios/{id}  "Get user by ID"
PUT     /usuarios/{id}  "Update user by ID"
DELETE  /usuarios/{id}  "Delete user by ID"

# Test API via curl
```shell
# Get all users
curl -X GET http://localhost:8081/usuarios

# Create a user
curl -X POST -H "Content-Type: application/json" --data '{"nome":"Joao da Silva", "login":"joao", "senha":"123"}' http://localhost:8081/usuarios

# Get user with ID=1
curl -X GET http://localhost:8081/usuarios/1

# Update user with ID=1
curl -X PUT -H "Content-Type: application/json" --data '{"nome":"Joao da Silva", "login":"joao", "senha":"890"}' http://localhost:8081/usuarios/1

# Delete user with ID=1
curl -X DELETE http://localhost:8081/usuarios/1


```

# TODO
- tratar barra como opcional no final dos caminhos HTTP
- tratar erro 500 quando o JSON nas requisicoes HTTP POST nao contem todos os campos obrigatorios (PropertyValueException)
- tratar erro 500 quando um novo modelo for criado com uma coluna unica que ja existe (SQLIntegrityConstraintViolationException)
- escrever testes
- criptografia de senha