1.Download gradle and set the environment path.
2.Download MySQL and create database `inventory` and run the script in the file “CREATE_TABLE_stored_procedure”.
3.Import this gradle project in to Eclipse.
4.Configure database user/password in your hibernate code.
5.Using command prompt go to the root directory of the java project.
6.Run gradle clean build and it will create WAR file in directory project root directory/build/lib.
7.Deploy WAR file in Tomcat and run the URL “http://localhost:8080/angular-spring-1/toy-store/home”.