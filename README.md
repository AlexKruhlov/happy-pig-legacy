# HAPPY PIG
The main aim of the project is to provide users the opportunity to control their own budget

## TECHNOLOGIES
1. Java (JDK version 1.8.0_152) - need to install
2. Maven (version 3.3.9) - need to install
3. Tomcat (version 8.5.31)
4. Spring Boot (version 2.0.3.RELEASE)
5. Spring Data JPA (version 2.0.3.RELEASE)
6. Liquibase (version 3.5.5)
7. H2 database (version 1.4.197 with console)
8. Git (current version) - need to install

## BUILD AND RUN PROJECT 
1. Clone the project:
`git clone https://github.com/AlexKruhlov/happy-pig.git`    

2. Build and run the project:
`mvn spring-boot:run`

3. Build project only:
`mvn clean install`

## PROJECT DATABASE
Project uses H2 database to contain the data. Developers can access the data through the console:
`http://localhost:8080/h2-console`

After running this reference there will be displayed the window "Login" with such settings:
<table>
<tr><td>Field name</td><td>Value</td></tr>
<tr><td>Saved Settings</td><td>Generic H2 (Embedded)</td></tr>

<tr><td>Saved Name    </td><td>Generic H2 (Embedded)</td></tr>
<tr><td>Driver Class  </td><td>org.h2.Driver        </td></tr>
<tr><td>JDBC URL      </td><td>jdbc:h2:~/test       </td></tr>
<tr><td>User Name     </td><td>sa                   </td></tr>
<tr><td>Password      </td><td>                     </td></tr>
</table>

Click "Connect" button to get the database access.
