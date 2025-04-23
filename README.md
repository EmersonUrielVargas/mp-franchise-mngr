<h1 align="center">📝 MarketPlace Franchise API</h1>

<p align="center">
  API RESTful para la gestión de un marketplace con franquicias con <b>Java 21</b>, <b>Spring Boot</b>y <b>WebFlux</b> utilizando <b>MongoDb Database</b>. 
  Ideal para gestionar las franquicias de un marketplace con un CRUD completo.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=Java">
  <img src="https://img.shields.io/badge/Spring%20Boot-MongoDb-green?style=for-the-badge">
  <img src="https://img.shields.io/badge/WebFlux-Lombok-bluelightgreen?style=for-the-badge&logo=api">
  <img src="https://img.shields.io/badge/RESTful-API-bluegreen?style=for-the-badge&logo=api">
</p>

---

## 📌 **Características**

✅ **Operaciones CRUD** para crear, leer, actualizar y eliminar Productos, Sucursales y Franquicias.  
✅ Implementación de **WebFlux** con **MongoDb Database**.  
✅ **Programacion Reactiva**.

---
## 🚀 **Requisitos Previos**

Antes de comenzar, asegúrate de tener instalados los siguientes elementos:

- **Java 21** → [Descargar](https://jdk.java.net/21/)
- **Maven** → [Descargar](https://maven.apache.org/download.cgi)
- **MongoDb** → [MongoDB Atlas](https://www.mongodb.com/cloud/atlas) o [MongoDB local](https://www.mongodb.com/try/download/community)
- **Visual Studio Code** o **IntelliJ IDEA** (opcional)
- **Git** (para clonar el repositorio)


---

## 📥 **Instalación**

1️⃣ **Clonar el repositorio**:

```bash
git clone https://github.com/EmersonUrielVargas/mp-franchise-mngr.git
cd marketplace-franchise
```
2️⃣ **Compilar el proyecto:**:

```bash
mvn clean install
```

3️⃣ **Ejecutar la aplicación:**:

```bash
mvn spring-boot:run
```

4️⃣ **La API estara disponible en**:

```bash
➡️ http://localhost:8080/
```
---
## 📊 Verifica la conexion con mongoDB

Hay que asegurarse de que el archivo `application.properties` esté configurado con la url de tu base de datos:

```properties
spring.data.mongodb.uri=URL_DE_TU_CONEXION_CON_MONG0DB
```

En tu base de datos debes tener creadas 3 colecciones:
- **branch_offices**
- **franchises**
- **products** 


## 📬 Endpoints disponibles

| Método | Endpoint                                        | Descripción                                                                     |
|--------|-------------------------------------------------|---------------------------------------------------------------------------------|
| GET    | `/franchise`                                    | Obtener todas las franquicias                                                   |
| GET    | `/franchise/{name}`                             | Buscar franquicia por nombre                                                    |
| POST   | `/franchise`                                    | Crear una nueva franquicia                                                      |
| PATCH  | `/franchise/{id}`                               | Actualiza nombre de una franquicia existente                                    |
| GET    | `/branch-office`                                | Obtener todas las sucursales                                                    |
| GET    | `/branch-office/{name}`                         | Buscar sucursal por nombre                                                      |
| POST   | `/branch-office/{idFranchise}`                  | Crear una nueva sucursal asociada a una franquicia                              |
| PATCH  | `/branch-office/{id}`                           | Actualiza nombre de una sucursal existente                                      |
| GET    | `/branch-office/top-products-by-branch-offices/{idFranchise}` | Obteniene el producto con mayor stock de cada sucursal asociada a la franquicia |
| GET    | `/product`                                      | Obtener todos los productos                                                     |
| GET    | `/product/{name}`                               | Buscar producto por nombre                                                      |
| POST   | `/product/{idBranchOffice}`                     | Crear un nuevo producto asociado a una sucursal                                 |
| PATCH  | `/product/{id}`                               | Actualizar tanto el nombre como el stock de un producto existente               |
| DELETE | `/product/{id}`                               | Elimina un producto                                                             |
---

### 🛠️ En desarrollo

- Validación de entrada con anotaciones (`@Valid`, `@NotNull`, etc.)
- Configuración de variables de entorno para entornos productivos
- Despliegue en AWS (Fargate(ECS) + DocumentDB)
- Autenticación JWT
- Test unitarios y de integración con JUnit 5 y Mockito
- Documentación de API con Swagger/OpenAPI


## 📧 **Contacto**

- Autor: Emerson Vargas
- GitHub: [@emersonurielvargas](https://github.com/EmersonUrielVargas)
- Email: emrvargaitaz@gmail.com

---
