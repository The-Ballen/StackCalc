# StackCalc
A scanner/parser and a simple “interpreter” for a fictional language, “StackCalc”, which is based on Reverse Polish Notation (RPN).

## Usage

#### Compile:
```sh
javac src/com/StackCalc/*.java -Werror -verbose -encoding UTF-8 -d ./bin/

jar cfe builds\StackCalc.jar com.StackCalc.Main -C bin .
```

#### Run:
```sh
java -jar ./builds/StackCalc.jar
```
