# ForgeRock OpenAm

## What is forgeRock? 
Es una herramienta de gestión de acceso que se utiliza para la autenticación y autorización de usuarios. Es un producto de la plataforma de software ForgeRock, que se especializa en la gestión de identidad y acceso (IAM). 
ForgeRock OpenAM ofrece diferentes tipos de autenticación de usuarios. Las organizaciones pueden utilizarla para gestionar el acceso de los empleados a diversas plataformas en línea. 
ForgeRock también ofrece una oferta de suscripción comercial que incluye soporte, mantenimiento y capacitación. 

# OpenaM - Docker
1. Descargar la imagen de OpenAM sitio https://hub.docker.com/r/openidentityplatform/openam o en el promt de comandos ejecutar lo siguiente
```sh
docker pull openidentityplatform/openam
```

2. Ejecutar el contenedor OpenAM con la siguiente configuración
```sh
docker run -h openam-01.domain.com -p 8080:8080 --name openam-01 openidentityplatform/openam
```

3. Acceder a OpenAM
Una vez que el contenedor esté corriendo, puedes acceder a la interfaz de administración de OpenAM a través de un navegador web en 
http://localhost:8080/openam/config/options.htm Ahí podrás seguir el proceso de configuración y empezar a probarlo.

3.1 Configuración predeterminada:
- Descripción:
Esta opción te configura rápidamente OpenAM con los valores predeterminados. Sólo necesitas ingresar las contraseñas para el administrador predeterminado y el mecanismo de acceso del agente. Es ideal para entornos de evaluación o desarrollo donde no necesitas personalizar todos los detalles.
¿Cuándo usarla? Si sólo estás probando o desarrollando y no necesitas una configuración compleja, esta es la opción más rápida.
Configuración personalizada:

3.2 Configuración personalizada: (Elegimos esta)
- Descripción:
Esta opción te permite personalizar completamente la configuración de OpenAM, incluyendo el tipo de almacén de datos, las propiedades de cifrado, y otros parámetros avanzados. Es más flexible y adecuada para un entorno de producción.
¿Cuándo usarla? Si necesitas tener un control completo sobre cómo se configura OpenAM (por ejemplo, integrarlo con una base de datos específica, configurar el cifrado, etc.), selecciona esta opción.
Recomendación:
Si estás probando OpenAM y no te importa usar la configuración predeterminada, te sugiero elegir "Configuración predeterminada" para facilitar la instalación. Solo tendrás que proporcionar las contraseñas necesarias para completar la configuración.

Si prefieres personalizar todos los parámetros de configuración (o si estás planeando usar OpenAM en un entorno de producción), selecciona "Configuración personalizada".

4. Parar y eliminar el contenedor (si es necesario)
Si en algún momento necesitas parar y eliminar el contenedor, puedes hacerlo con los siguientes comandos:

```sh
docker stop openam-01
docker rm openam-01
```

## OpenAM Configuration
***Configuración Personalizada***

***Paso 1: General ***
Introduzca la contraseña del usuario predeterminado, amAdmin. La contraseña debe tener una longitud mínima de 8 caracteres. Si esta configuración va a formar parte de una implementación existente, la contraseña introducida debe coincidir con la de la implementación original.

Usuario predeterminado: 
Contraseña: *admin2025*
Contraseña (confirmar): *admin2025*


***Paso 2: Configuración del servidor***
Confirme la siguiente configuración que se utilizará para el servidor.

* Indica un campo obligatorio

Preferencias del servidor
* URL del servidor	
http://localhost:8080
Dominio de cookies	
localhost
 help
* Idioma de plataforma	
en_US
* Directorio de configuración	
/usr/openam/config


***Paso 3: Configuración del almacén de datos de configuración***
Si no existe ninguna otra instancia de OpenAM en el entorno, elija la primera instancia. 
Si existen una o más instancias de OpenAM en el entorno, seleccione Agregar a implementación existente.

 Primera instancia  ¿Desea agregarla a una implementación existente?
*  Indica un campo obligatorio

Detalles del almacén de configuración
Almacén de datos de configuración	 OpenAM  OpenDJ
*  SSL habilitado	
*  Nombre de host	
localhost
*  Puerto	
50389
*  Admin Port	
4444
*  JMX Port	
1689
*  Clave de cifrado	
cTIWTSCE1VI+OJYHLjiA0vyLweIPsIe/
*  Sufijo raíz	
dc=openam,dc=openidentityplatform,dc=org


***Paso 4: Configuración del almacén de usuario***
Puede utilizar el almacén de datos incluido con el almacén de datos de configuración de OpenAM, o bien utilizar un almacén de datos de usuario diferente. Un procedimiento recomendado para configurar entornos de producción consiste en utilizar un almacén de datos de usuario externo diferente al almacén de datos de usuario de OpenAM. Tenga en cuenta que el servicio de directivas y el módulo de autenticación de LDAP estarán configurados para utilizar el ND del administrador de directorios y la contraseña facilitadas aquí.

Almacén de datos de usuario de OpenAM** (elegimos esta opción)

***Paso 5: Configuración del sitioinfo
¿Se implementará esta instancia detrás de un equilibrador de carga como parte de la configuración del sitio? (elegimos no)

***Paso 6: Usuario de agente de directivas predeterminado***
Esta configuración la utilizan los agentes de directivas de OpenAM para recuperar las propiedades del agente de directivas.

Contraseña: *user2025*
Contreaseña (confirmar):  *user2025*


**Login 
Cuando accedas a la página de inicio de sesión de OpenAM en http://localhost:8080/openam/XUI/#login/, ingresa estos valores en los campos correspondientes:

Usuario: amAdmin
Contraseña: *admin2025*

### Configurar Cliente Oatuh2 

Nuevo OAuth 2.0/OpenID Connect Client
Nombre: testAdmin
Campo obligatorio Contraseña: testAdmin+
Campo obligatorio Confirmar: testAdmin+

# Java Implementation 


# Captures
