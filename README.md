# Neo4j-Log4j2 Sample

Reporduction case for broken log4j2 integration together with Neo4j 4.2.x  (Issue [neo4j/neo4j#12655](../../../../neo4j/neo4j/issues/12655)).
Note: `JAVA_HOME` has to point to a JDK 11 installation.

## Case 1: Logging works with Neo4j 4.1.5
Run test:
```shell
./mvnw clean test -Dneo4j.version='4.1.5'
```
Output:
```shell
[INFO] Running com.example.neo4j.log4j2.LoggingTest
2021-01-12 16:36:18,023 [main] INFO  com.example.neo4j.log4j2.LoggingTest - Hello World.
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.805 s - in com.example.neo4j.log4j2.LoggingTest
```

## Case 2: Logging broken with Neo4j 4.2.2
Run test:
```shell
./mvnw clean test -Dneo4j.version='4.2.2'
```
Output:
```shell
[INFO] Running com.example.neo4j.log4j2.LoggingTest
ERROR StatusLogger Unrecognized format specifier [d]
ERROR StatusLogger Unrecognized conversion specifier [d] starting at position 16 in conversion pattern.
ERROR StatusLogger Unrecognized format specifier [thread]
ERROR StatusLogger Unrecognized conversion specifier [thread] starting at position 25 in conversion pattern.
ERROR StatusLogger Unrecognized format specifier [level]
ERROR StatusLogger Unrecognized conversion specifier [level] starting at position 35 in conversion pattern.
ERROR StatusLogger Unrecognized format specifier [logger]
ERROR StatusLogger Unrecognized conversion specifier [logger] starting at position 47 in conversion pattern.
ERROR StatusLogger Unrecognized format specifier [msg]
ERROR StatusLogger Unrecognized conversion specifier [msg] starting at position 54 in conversion pattern.
ERROR StatusLogger Unrecognized format specifier [n]
ERROR StatusLogger Unrecognized conversion specifier [n] starting at position 56 in conversion pattern.
ERROR StatusLogger Unrecognized format specifier [d]
ERROR StatusLogger Unrecognized conversion specifier [d] starting at position 16 in conversion pattern.
ERROR StatusLogger Unrecognized format specifier [thread]
ERROR StatusLogger Unrecognized conversion specifier [thread] starting at position 25 in conversion pattern.
ERROR StatusLogger Unrecognized format specifier [level]
ERROR StatusLogger Unrecognized conversion specifier [level] starting at position 35 in conversion pattern.
ERROR StatusLogger Unrecognized format specifier [logger]
ERROR StatusLogger Unrecognized conversion specifier [logger] starting at position 47 in conversion pattern.
ERROR StatusLogger Unrecognized format specifier [msg]
ERROR StatusLogger Unrecognized conversion specifier [msg] starting at position 54 in conversion pattern.
ERROR StatusLogger Unrecognized format specifier [n]
ERROR StatusLogger Unrecognized conversion specifier [n] starting at position 56 in conversion pattern.
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.359 s - in com.example.neo4j.log4j2.LoggingTest
```
