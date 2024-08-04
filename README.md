# Franchise API

## Descripción

Este proyecto es una aplicación para gestionar franquicias, sucursales y productos utilizando **Spring Boot** y **programación reactiva**. La aplicación está empaquetada con Docker y se conecta a una base de datos PostgreSQL en la nube. 

## Estructura del Proyecto

- **Database**: Contiene los archivos SQL necesarios para crear la base de datos, las tablas y poblar datos de prueba.
- **Diagrams**: Incluye los modelos entidad-relación y el diagrama de despliegue del proyecto en AWS.
- **Source**: Código fuente del desarrollo.
- **README.md**: Documentación adicional sobre cómo desplegar la aplicación desde un entorno local.

## Endpoints Disponibles

La API proporciona los siguientes endpoints:

1. **Agregar una nueva franquicia**
   - Método: `POST`
   - Ruta: `/api/franchises`
   - Cuerpo: `{ "name": "nombre_franchise" }`

2. **Agregar una nueva sucursal a una franquicia**
   - Método: `POST`
   - Ruta: `/api/branches`
   - Cuerpo: `{ "name": "nombre_branch", "franchiseId": 1 }`

3. **Agregar un nuevo producto a una sucursal**
   - Método: `POST`
   - Ruta: `/api/products`
   - Cuerpo: `{ "name": "nombre_producto", "branchId": 1, "stock": 100 }`

4. **Eliminar un producto de una sucursal**
   - Método: `DELETE`
   - Ruta: `/api/products/{productId}`

5. **Modificar el stock de un producto**
   - Método: `PUT`
   - Ruta: `/api/products/{productId}`
   - Cuerpo: `{ "stock": 150 }`

6. **Mostrar el producto con más stock por sucursal para una franquicia puntual**
   - Método: `GET`
   - Ruta: `/api/franchises/{franchiseId}/top-products`
   - Respuesta: Lista de productos con el mayor stock y su sucursal asociada.

7. **Actualizar el nombre de una franquicia**
   - Método: `PUT`
   - Ruta: `/api/franchises/{franchiseId}`
   - Cuerpo: `{ "name": "nuevo_nombre_franchise" }`

8. **Actualizar el nombre de una sucursal**
   - Método: `PUT`
   - Ruta: `/api/branches/{branchId}`
   - Cuerpo: `{ "name": "nuevo_nombre_branch" }`

9. **Actualizar el nombre de un producto**
   - Método: `PUT`
   - Ruta: `/api/products/{productId}`
   - Cuerpo: `{ "name": "nuevo_nombre_producto" }`

## Información Adicional

- **Desarrollo**: El proyecto está desarrollado en Spring Boot con programación reactiva.
- **Persistencia de Datos**: Se utiliza PostgreSQL en la nube.
- **Empaquetado**: La aplicación está empaquetada con Docker. Puedes encontrar la imagen en [Docker Hub](https://hub.docker.com/r/temp2010/franchise-api).
- **Documentación Local**: Para detalles sobre el despliegue local, consulta el archivo `README.md` dentro de la carpeta `Source`.
