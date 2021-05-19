# Tutorial de OpemKM

Enlace simbolico

ln -s /home/amartinez/public_html/syscode/addocadea/openkm/target/OpenKM/ OpenKM

##  Configurar Base de Datos

Servers/server.xml

Configurar Base de datos MySql

```xml
<!-- <Resource name="jdbc/OpenKMDS" auth="Container" type="javax.sql.DataSource"
    maxTotal="100" maxIdle="30" maxWaitMillis="10000" validationQuery="select 1"
    username="root" password="ares2308" driverClassName="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/okm_db_63_sw?useSSL=false&amp;autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=UTF8&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC"/> -->
```

Configurar Base de datos MariaDB

```xml
<Resource name="jdbc/OpenKMDS" auth="Container" type="javax.sql.DataSource"
    maxActive="100" maxIdle="30" maxWait="10000" validationQuery="select 1"
    username="root" password="ares2308" driverClassName="org.mariadb.jdbc.Driver"
    url="jdbc:mariadb://localhost:3306/okm_db_63_sw?useSSL=false&amp;autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=UTF8"/>
```

Modificar el archivo OpenKM.cfg

/home/amartinez/programs/tomcat-8.5.34-openkm-6.3-mysql-sw/OpenKM.cfg

```bash
# OpenKM Hibernate configuration values
#hibernate.dialect=org.hibernate.dialect.H2Dialect
#hibernate.dialect=org.hibernate.dialect.HSQLDialect
#hibernate.dialect=org.hibernate.dialect.Oracle10gDialect
#hibernate.dialect=org.hibernate.dialect.SQLServerDialect
#hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
hibernate.hbm2ddl=none

# Logback configuration file
logback.config=logback.xml
```

## Configurar correo electronico

Servers/server.xml

```xml
<Resource auth="Container" 
mail.debug="true" mail.smtp.auth="true" 
mail.smtp.from="gruposhock.test@gmail.com" 
mail.smtp.host="smtp.gmail.com" 
mail.smtp.port="587" 
mail.smtp.quitwait="false" 
mail.smtp.socketFactory.class="javax.net.ssl.SSLSocketFactory" 
mail.smtp.starttls.enable="true" 
mail.smtp.user="gruposhock.test@gmail.com" 
mail.transport.protocol="smtp" 
name="mail/OpenKM" 
password="cdwinxoedzfgznum" 
type="javax.mail.Session"/>
```

Administración/Configuration

```java
application.url	String	http://localhost:8080/OpenKM/index.jsp
```

Para enviar correo seleccione el PDF despues template.pdf despues

Archivo/Enviar documento adjunto


## Archivos de configuracion de crontab

```java
sssalud.csv.path	        String	/home/amartinez/import/sssalud/sssalud.csv
sssalud.dat.path	        String	/home/amartinez/import/sssalud/lote/INDEX.DAT
sssalud.lotes	            List	865_88774
                                    865_88775
sssalud.openkm.path	        String	/okm:root/SISTEMA ÚNICO DE REINTEGROS
sssalud.server.move.path	String	/home/amartinez/import/sssalud/lote/importado
sssalud.server.path	        String	/home/amartinez/import/sssalud/lote
```