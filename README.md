# Implementación de Microservicios

**Enunciado:**
Implementar un microservicio para un sistema de gestión de eventos. Debe permitir crear, actualizar, eliminar eventos y consultar por fecha.

Estoy utilizando *Arquitectura hexagonal*, también conocida como arquitectura de puertos y adaptadores. La principal idea es separar las preocupaciones
y dependencias externas del núcleo de la aplicación. 

**¡IMPORTANTE!** El microservicio se ha documentado con JavaDoc para intentar dejarlo lo más claro posible. 

El fin de este documento es hacer un pequeño manual de lo que nos devuelve *Postman*. 

En proyecto está dividido en los siguientes módulos:
* **Domain**: Tenemos la entidad de negocio con anotaciones de *lombok* para ahorrar código. En este módulo también tenemos el repository que vamos a usar juntos con los casos de uso.
* **Application**: Aquí tenemos la implementación de los casos de uso declarado en la capa *domain*. Tenemos la anotación **@Component** para indicar que es un componente de Spring. 
* **Infrastructure**: En este capa tenemos todo lo relacionado con la base de datos. Tenemos una entidad con anotaciones **JPA**, contiene también el repository que extiende de JPA, junto con la clase que lo implementa y las clases necesarias para realizar el mapeo.
* **Boot**: En este módulo tenemos la clase *main* para poder arrancar la aplicación. 

***

## Manual para Postman 

1. Vamos a probar que nos devuelva la lista con todos los eventos en la Base de datos.
   http://localhost:8080/evento
   ![img.png](img/img.png)
2. Ahora vamos a probar el método para crear un evento nuevo. En este caso no se añade **id** ya que lo genera automáticamente
![img_1.png](img/img_1.png)

En la base de datos nos aparece así:
![img_2.png](img/img_2.png)

3. Vamos a modificar el precio de un Evento. En este caso hay que pasar el **id** del evento que queremos modificar. 
![img_3.png](img/img_3.png)

En la base de datos nos aparece con el nuevo precio. 
![img_4.png](img/img_4.png)

4. Ahora vamos a consultar por fecha un evento.
![img_5.png](img/img_5.png)
5. Por ultimo, vamos a eliminar el evento con el id 3.
![img_6.png](img/img_6.png)

En la base de datos ya no nos aparece. 
![img_7.png](img/img_7.png)
