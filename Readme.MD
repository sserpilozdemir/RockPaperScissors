# Rock | Paper | Scissors Interactive Game 🪨📜✂️

This is a simple implementation of the classic paper-rock-scissors game in Java using the Swing library. In this game, you can play against a computer opponent and select your move by clicking a button in a graphical user interface (GUI) window.

## ℹ️ How to Play

-  Run the game by commands below. [See: How to Run]
-  A GUI window will appear, typing your name and entering how many rounds play the game then prompting you to make your move.
-  Click on one of the options: Paper, Rock, or Scissors.
-  The computer will randomly select its move.
-  The result of the round will be displayed in the GUI, indicating whether you won, lost, or tied.
-  The game keeps track of your score.
-  When the selected game round is over, the total score will be announced and the final winner will be announced in the GUI.


## ℹ️ Game Rules
*   Paper beats Rock.
*   Rock beats Scissors.
*   Scissors beats Paper.
*   If both players choose the same move, the round is a tie.


## Dependencies
+ Java SE Development Kit (JDK)
+ Swing Library (included in Java standard libraries)
+ Junit
+ Maven

## Libraries
**[Swing](https://www.npmjs.com/package/winston):**  Graphical user interface (GUI) toolkit that is included as part of the Java Standard Library.
The use of the Swing library in this project is advantageous because Swing is an integral part of the Java Standard Library, ensuring that it is readily available without the need for additional installations or dependencies. Swing offers a cross-platform solution, enabling the game to run seamlessly on various operating systems while providing a comprehensive set of GUI components for creating an interactive and user-friendly interface. Additionally, Swing's event-driven programming model simplifies the development process by allowing for easy handling of user interactions, making it an excellent choice for building graphical applications in Java


**[Junit](https://www.npmjs.com/package/winston):**  JUnit is a widely-used testing framework in the Java ecosystem that is specifically designed for unit testing.
JUnit is employed in this Java project to facilitate robust and automated testing. As a widely-adopted testing framework, it allows for the creation of automated test cases, ensuring the reliability and correctness of code. With the ability to support Test-Driven Development, perform regression testing, and seamlessly integrate with popular Java IDEs and continuous integration pipelines, JUnit serves as an indispensable tool for maintaining code quality and preventing bugs.


### How to Run

* Go to project directory
```console
$ cd path/RPS_serpil_ozdemir
```

* Clean and compile the project
```console
$ mvn clean compile
```

* Run project
```console
$ mvn exec:java -Dexec.mainClass="org.game.Main"
```

### How to Run Unit Test

* Go to project directory
 ```console
$ cd path/RPS_serpil_ozdemir
```
* Clean and compile the project
```console
$ mvn clean compile
```
* Run test
```console
$ mvn test
```

❗ During test for some checks, GUI may request like entering round number or select paper | rock | scissors for game. Please select | input and observe.