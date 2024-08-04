# Instrucciones para Desplegar la Aplicación
Este documento proporciona instrucciones para descargar el código fuente, empaquetar la aplicación, crear y subir la imagen Docker, y desplegar la aplicación en AWS.

## 1. Descargar el Código Fuente y Empaquetar
1. **Clonar el Repositorio**:
   ```bash
   git clone https://github.com/your-repo/franchise-api.git
   cd franchise-api
2. **Empaquetar la Aplicación con Maven:**
Tener Maven instalado. Ejecuta el siguiente comando para compilar y empaquetar la aplicación:
   ```bash
   mvn clean package
Esto generará un archivo JAR en la carpeta target con el nombre franchise-api-1.1.jar.
## 2. **Crear la Imagen Docker**
1. **Crear un Dockerfile**:
Tener el siguiente contenido en Dockerfile:
   ```bash
   FROM openjdk:21-slim
   WORKDIR /app
   COPY target/franchise-api-1.1.jar /app.jar
   EXPOSE 8080
   
   ENV DB_HOST=host.docker.internal
   ENV DB_PORT=5432
   ENV DB_NAME=franchise
   ENV DB_USERNAME=franchise
   
   ENTRYPOINT ["java", "-jar", "/app.jar"]
2. **Construir la Imagen Docker**
Tener Maven instalado. Ejecuta el siguiente comando para compilar y empaquetar la aplicación:
   ```bash
   docker build -t franchise-api:latest .
## 3. Subir la Imagen a AWS ECR
1. Autenticar Docker
2. Crear un Repositorio
3. Etiquetar la Imagen
4. Subir la Imagen
## 4. Configuración de Red
1. Crear una VPC
2. Configurar Seguridad
## 5. Crear la Base de Datos PostgreSQL
1. Crear una Instancia
2. Configurar la Instancia
3. Iniciar la Instancia con la Estructura de Datos
## 6. Desplegar el Contenedor
1. Crear un Cluster
2. Definir una Tarea 
3. Ejecutar el Contenedor
4. Configurar el Balanceador de Carga (opcional)

![get](https://github.com/user-attachments/assets/8b3f8b71-803e-41df-8eac-9265a1d21bb3)
