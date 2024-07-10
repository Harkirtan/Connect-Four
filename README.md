# Technical Test Ovarro - Connect Four Game
## Applicant Name : Harkirtan Singh

### Programming Language: Java
I chose Java for this project due to its robustness, object-oriented nature, and widespread use. Additionally, as I am comfortable working in Java, I wanted to showcase that via this test. With simplicity in mind, I only created 3 classes and attempted to keep them as minimalistic as possible. 

### GUI: Java Swing (Optional)
For the optional GUI component, I opted to use Swing, a part of the Java Foundation Classes (JFC). Swing is lightweight and therefore allowed me to develop a coherent solution to this test where I developed 2 windows (JFrames), one for the initial settings and one for the gameplay.

### Build Tool: Maven
Maven was chosen as the build tool to manage project dependencies, build processes, and plugins. It simplifies the project setup and ensures consistent project builds across different environments. 

### Testing Framework: JUnit
JUnit was chosen for its simplicity, ease of integration with Maven, and the ability to write and run automated tests. Automated tests are crucial for verifying the functionality of the game logic and ensuring the robustness of the application.

## Instructions to run the game

- In an IDE: Run StartFrame.java
- Using Maven
- Using JAR executable located in the out folder or [JAR LOCATION](ConnectFour\out\artifacts\ConnectFour_jar)


## Features Implemented
### Configurable Grid Size and Winning Row Length:
- The player can set the size of the grid and the number of tokens in a row needed to win.

### Game Grid Initialization:
- The game initializes a new grid based on the player's configuration.

### Add Tokens:
- Players can add Red or Yellow tokens to a specified column in the grid, denoted by the letters "R" and "Y".

### Game State Display:
- The current state of the game grid is displayed in the GUI.

### Next Player Indicator:
- The application shows whose turn it is to play next via the text atop the JFrame but also via a coloured border.

### Winner Display:
- The application announces the winner via a popup when the game ends.
