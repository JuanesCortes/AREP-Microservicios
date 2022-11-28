### Tarea Microservicios - AREP

### Estudiantes:
- **Juan Esteban Cortes**
- **David Otalora**
- **Natalia Orjuela**

### Tarea

1. En grupos de máximo 3.
2. Diseñe un API y cree un monolito  Web en Spark que permita a los usuarios hacer posts de 140 caracteres e ir registrandolos en un stream único de posts (a la Twitter). Piense en tres entidades Usuario, hilo(stream), posts.
3. Cree un aplicación JS para usar el servicio. Depliegue la aplicación en S3. Asegúrese que esté disponible sobre internet.
4. Pruebe la aplicación Web
5. Agregue seguridad usando JWT con el servicio cognito de AWS.
6. Separe el monolito en tres microservicios independientes.
7. Despliegue el seervicio en AWS con EC2 y realice pruebas (Puede usar docker o 3 máquinas AWS)
8. Entregue el código desarrollado en Github, un reporte de la arquitectura, un reporte de las pruebas, y un video con el experimento funcionando y bien configurado (Todo en el README).

### Arquitectura

![arquitecturaArep](https://user-images.githubusercontent.com/54339107/204366557-6f94073d-4c92-4e9f-9619-563df4f514c1.png)

### Reporte Arquitectura

Se instancian 3 maquinas en EC2 , una sera para el servicio de login, otra para el back y otra para el front,se utiliza spark en java para el manejo de las entradas y salidas, la instancia que contiene el front se conectara dcon el back y con el servicio de login. 

### Reporte Pruebas

Se crearon dos usuarios en la base de datos de Mongo para ingresar al twitter

![image](https://user-images.githubusercontent.com/54339107/204367206-533ddec9-f5a4-4e2e-953b-74918bd2966b.png)

Se alamacenan los tweets generados por cada usuario

![image](https://user-images.githubusercontent.com/54339107/204367407-085ff825-3005-4828-be40-c236ec711006.png)

![image](https://user-images.githubusercontent.com/54339107/204367438-3eb0ad73-dd69-486f-8223-6886a37eb34b.png)

Como se puede observar en el siguiente video, se observa que cambia el nombre del usuario correspondiente a cada usuario, se actualiza el tweet con su fecha actual. 

### Video

[TallerMicroservicios](https://www.youtube.com/watch?v=mwogMmYHCbE "TallerMicroservicios")
