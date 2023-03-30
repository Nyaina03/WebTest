@echo off
rem Préparation du répertoire de travail
md D:\S4\INF209-Mr Naina\Project\WEB-INF\classes\
md C:\Program Files (x86)\Apache Software Foundation\Tomcat 10.0\webapps\PROCESSREQUEST\WEB-INF\lib\

rem Compilation du framework
javac -cp D:\S4\INF209-Mr Naina\Project\WEB-INF\lib\framework.jar -d D:\S4\INF209-Mr Naina\Project\WEB-INF\classes\ D:\S4\INF209-Mr Naina\Project\src\*.java

rem Création du fichier jar
jar cvf D:\S4\INF209-Mr Naina\Project\WEB-INF\lib\myFramework.jar -C D:\S4\INF209-Mr Naina\Project\WEB-INF\classes\ .

rem Copie du fichier dans le répertoire de lib
copy D:\S4\INF209-Mr Naina\Project\myFile.jar C:\Program Files (x86)\Apache Software Foundation\Tomcat 10.0\webapps\PROCESSREQUEST\WEB-INF\lib\

rem Copie des fichiers XML dans le répertoire WEB-INF
copy D:\S4\INF209-Mr Naina\Project\*.xml C:\Program Files (x86)\Apache Software Foundation\Tomcat 10.0\webapps\PROCESSREQUEST\WEB-INF\

rem Création du fichier WAR
cd D:\S4\INF209-Mr Naina\
jar cvf PROCESSREQUEST.war Project\*
move PROCESSREQUEST.war "C:\Program Files (x86)\Apache Software Foundation\Tomcat 10.0\webapps\"
