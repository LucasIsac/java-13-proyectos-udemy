# ✅ Sistema de Tareas con Java Swing y Spring Boot  

## 🖍️ Descripción  
Este proyecto es una **aplicación de escritorio para la gestión de tareas**, desarrollada con **Java Swing y Spring Boot**. Permite **crear, editar, eliminar y organizar tareas** según su estado y prioridad, utilizando **MySQL** para la persistencia de datos.  

Forma parte de un curso práctico de Java, donde se exploran tecnologías modernas para la creación de sistemas de gestión eficientes y escalables.  

## 🛠️ Tecnologías Usadas  
- **Lenguaje:** Java 13 o superior.  
- **Interfaz gráfica:** Java Swing.  
- **Framework:** Spring Boot.  
- **Persistencia de Datos:** JPA (Java Persistence API) con Hibernate.  
- **Base de Datos:** MySQL.  
- **Herramientas:** IntelliJ IDEA / NetBeans / Eclipse (cualquier IDE compatible con Java).  

## 🔥 Características  
- Aplicación de escritorio con una interfaz gráfica intuitiva basada en Java Swing.  
- Permite gestionar tareas con funcionalidades de **agregar, modificar, eliminar y visualizar**.  
- Organización de tareas por **estado** (pendiente, en progreso, completada).  
- Uso de **Spring Boot y JPA** para la gestión y persistencia de datos en **MySQL**.  
- Arquitectura basada en **MVC (Modelo-Vista-Controlador)** para mejorar la organización del código.  

## 🚀 Instrucciones de Instalación  
1. **Clona el repositorio** en tu máquina local:  
   ```bash
   git clone https://github.com/tu-usuario/java-13-proyectos-udemy.git
   cd java-13-proyectos-udemy/3-Desktop-Apps/day-8-task-manager
   ```
2. Abrir el proyecto en un IDE compatible con Java (IntelliJ, NetBeans, Eclipse).
   _ Asegúrate de tener MySQL instalado y en ejecución.
   _ La base de datos tareas_db se creará automáticamente si no existe.
   
4. Verificar que SQLite esté configurado correctamente en el proyecto.
   # Configuración de la conexión a MySQL  
   spring.datasource.url=jdbc:mysql://localhost:3306/tareas_db?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   # Configuración de JPA y Hibernate  
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

   # Desactivar servidor web de Spring Boot  
   spring.main.web-application-type=none

  
6. Ejecutar la aplicación desde la clase principal TareasApplication.java.
