# mdh-api-canvas
Komponent för att lyssna på Canvas-händelser.

## Bygga
```
mvn clean package
```

## Köra lokalt
Utan autentisering
```
java -Dspring.profiles.active=mdh-dev,nosecurity -Dserver.ssl.enabled=false -jar target/xxx.jar
```
Med autentisering
```
java -Dspring.profiles.active=mdh-dev -Dserver.ssl.enabled=false -jar target/xxx.jar
```

För att köra med säkerhet behöver man även bifoga en JWT från Canvas
i Bearer-headern på requestet. 