#Create directory
mkdir -p target

#Compile class files
javac -d target src/java/edu/school21/printer/*/*.java

#Create jar file
jar cfvm target/images-to-chars-printer.jar  src/manifest.txt  -C target edu -C src resources

#Launch jar file
java -jar target/images-to-chars-printer.jar . 0

