# TeaGenerator
This program by default generates 2000 randomized and shuffled tea products and tea companies. 
It can be used as a template to generate and insert random inputs 
to your table. 

The program uses `Jdbi` connection and `Tomcat Datasource` while demonstrating `Multithreading` to optimize performance. 

``Log4j2`` is used to generate logs into file and console. 

To easily get all required dependencies, building the app in `Maven` is highly recommended.

## Requirements
1. JDK 8
2. Maven
3. MySQL (MariaDB)
4. Any Java IDE (Preferably Eclipse)

## Steps to Run
### DB (Do this first)
1. Create a `test` database in MySQL
2. Import ``test.sql`` inside db -> `mysql -u user_name -p database_name < test.sql`
### App
1. `git clone https://github.com/donnald1/TeaGenerator.git`
2. `cd TeaGenerator`
3. `mvn clean package install`
4. Copy `TeaBrand.txt` and `TeaType.txt` to newly made `target` folder
5. `java -jar DbTest-0.0.1-SNAPSHOT`
