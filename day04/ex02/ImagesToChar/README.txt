#Clean directory
rm -rf target lib

#Create directory
mkdir -p target lib

#Get library
curl -s -o lib/jcommander-1.82.jar  https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar
curl -s -o lib/JCDP-4.0.2.jar  https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.2/JCDP-4.0.2.jar

#Extract library
jar xf lib/jcommander-1.82.jar
jar xf lib/JCDP-4.0.2.jar

#Delete garbage
rm -rf META-INF

#Move library
mv com target/

#Compile class files
javac -d target -classpath lib/jcommander-1.82.jar:lib/JCDP-4.0.2.jar src/java/edu/school21/printer/*/*.java

#Create jar file
jar cfm target/images-to-chars-printer.jar  src/manifest.txt  -C target .

#Launch jar file
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN

