javadoc -d .\make\ -sourcepath .\src\main\java -subpackages ru.nsu.kgurin

javac -d .\make\bin\ -sourcepath .\src\main\java .\src\main\java\ru\nsu\kgurin\Node.java
javac -d .\make\bin\ -sourcepath .\src\main\java\ru\nsu\kgurin\BreadthFirstSearchIterator.java
javac -d .\make\bin\ -sourcepath .\src\main\java\ru\nsu\kgurin\DepthFirstSearchIterator.java

mkdir .\make\jar
jar cf .\make\jar\Node.jar -C .\make\bin .
jar cf .\make\jar\BreadthFirstSearchIterator.jar -C .\make\bin .
jar cf .\make\jar\DepthFirstSearchIterator.jar -C .\make\bin .

java -classpath .\make\jar\Node.jar ru.nsu.kgurin.Node
java -classpath .\make\jar\BreadthFirstSearchIterator.jar ru.nsu.kgurin.BreadthFirstSearchIterator
java -classpath .\make\jar\DepthFirstSearchIterator.jar ru.nsu.kgurin.DepthFirstSearchIterator