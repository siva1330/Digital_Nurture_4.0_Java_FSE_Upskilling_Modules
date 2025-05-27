@echo off
echo Compiling the query program...
javac -cp ".;sqlite-jdbc-3.45.1.0.jar;slf4j-api-2.0.9.jar" QueryStudent.java
if errorlevel 1 (
    echo Compilation failed!
    pause
    exit /b 1
)
echo Running the query program...
java -cp ".;sqlite-jdbc-3.45.1.0.jar;slf4j-api-2.0.9.jar" QueryStudent
pause 