javadoc -d .\make\ -sourcepath .\src\main\java -subpackages ru.nsu.kgurin

javac -d .\make\bin\ -sourcepath .\src\main\java .\src\main\java\ru\nsu\kgurin\Heapsort.java

mkdir .\make\jar
jar cf .\make\jar\Heapsort.jar -C .\make\bin .

java -classpath .\make\jar\Heapsort.jar ru.nsu.kgurin.Heapsort