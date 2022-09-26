mkdir target

javac -d target src/java/edu/school21/printer/*/*.java

java -classpath target edu.school21.printer.app.Program . 0 it.bmp

