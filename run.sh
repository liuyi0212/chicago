gradle clean build -x test; java -Dspring.profiles.active=$1 -jar build/libs/chicago-1.0.jar
