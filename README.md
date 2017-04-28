# Toy Robot Simulator

`Scala`

## Introduction
This application simulates a toy robot moving on a 5 x 5 table.

```
-----------------------------------------
|       |       |       |       |       |
| (0,4) | (1,4) | (2,4) | (3,4) | (4,4) |
|       |       |       |       |       |
-----------------------------------------
|       |       |       |       |       |
| (0,3) | (1,3) | (2,3) | (3,3) | (4,3) |
|       |       |       |       |       |
-----------------------------------------
|       |       |       |       |       |
| (0,2) | (1,2) | (2,2) | (3,2) | (4,2) |
|       |       |       |       |       |
-----------------------------------------
|       |       |       |       |       |
| (0,1) | (1,1) | (2,1) | (3,1) | (4,1) |
|       |       |       |       |       |
-----------------------------------------
|       |       |       |       |       |
| (0,0) | (1,0) | (2,0) | (3,0) | (4,0) |
|       |       |       |       |       |
-----------------------------------------
```

## How to run the program
```
$ sbt run
```

Commands are:
- PLACE X,Y,F &ndash; places a robot on the table at position X, Y facing the direction F
- MOVE &ndash; moves the robot forward one unit in the direction it is facing
- LEFT &ndash; turns the robot 90&deg; to the left
- RIGHT &ndash; turns the robot 90&deg; to the right
- REPORT &ndash; prints the position and direction of the robot to standard output

MOVE, LEFT, RIGHT and REPORT only take effect if there is a robot on the table.

Attempts to PLACE or MOVE a robot outside the table will be ignored.

More information can be found in **PROBLEM.md**.

## How to run the tests

### Unit tests
```
$ sbt test
```

### Test input files
Test input files have been provided in `./test-inputs/`.

The name of each test file has the form **output-_X_,_Y_,_DIRECTION_.txt**, where **_X_,_Y_,_DIRECTION_** is the string printed to standard output as a result of running (for example):

```
$ sbt run < test-inputs/output-1,1,NORTH.txt
```

which should output

```
1,1,NORTH
```

at the end of the run.
