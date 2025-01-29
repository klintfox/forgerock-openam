FROM openjdk:11-jdk

# Descargar el archivo WAR de OpenAM desde el repositorio oficial
ADD https://github.com/ForgeRock/openam/releases/download/AM-7.1.2/openam-7.1.2.war /opt/openam.war

# Crear un directorio para OpenAM
RUN mkdir -p /opt/openam

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar OpenAM
CMD ["java", "-jar", "/opt/openam.war"]
