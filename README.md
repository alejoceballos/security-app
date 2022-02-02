# Security 

- Based on "**[Amigoscode's Spring Security | FULL COURSE](https://www.youtube.com/watch?v=her_7pa0vrg)**".

#### Infrastructure: 
- **Java**: OpenJDK 11.
- **Gradle**: 7.3.3.
- **OS**: Windows Subsystem for Linux - WSL2 (Ubuntu 20.04).
- **IDE**: IntelliJ IDEA (Ultimate Edition).

## Create a Web Application

- Goto "**[start.spring.io](https://start.spring.io/)**".

### Project settings

- **Project**: Gradle Project
- **Language**: Java
- **Spring Boot**: 2.6.3
- **Project Metadata**: 
  - **Group**: com.ceballos
  - **Artifact**: security-app
  - **Name**: Security Application
  - **Description**: Security Application Module
  - **Package name**: com.ceballos.securityapp
  - **Packaging**: Jar

### Add Dependencies...

- Select **Spring Web**

### Generate the Project files

1. Click "**Generate CTRL + ↩**".
2. Save the generated zip file to your project's folder.
3. Unzip the file.

## IDE setup

1. Start IntelliJ at "Welcome to IntelliJ IDEA" screen.
2. Click the "Open" button.
3. Select the "build.gradle" file inside the unzipped "security-app" directory.
4. On the "Open Project" pop-up, select "Open as Project".
5. When the pop-up appears asking to "Trust and Open Project security-app?". Click "Trust Project".

Some issues may rise in case your Windows Java Version and WSL's differ. In that case:

Possible message shown by the IDE (versions and directories may differ):
```
Gradle JVM option is incorrect: 'C:/Program Files/Java/jdk-13'.
The project is located on WSL(Ubuntu - '\\wsl$\Ubuntu\').
Use the JDK installed on the same WSL distribution.
```

#### Setting the right JVM

1. Click "File > Project Structure".
2. In the "Project Structure" window, go to "Project Settings > Project".
3. Click on the "SDK" dropdown and wait for IntelliJ to detect all your Java VMs.
4. Select the WSL version, i.e. "11 (WSL) version 11.0.13".
5. Set the "Language Level" to your version, i.e. "11 - Local variable syntax for lambda parameters".
6. Click "Ok"

#### Setting the right Gradle

1. Click "File > Settings".
2. In the "Settings" window, go to "Build, Execution, Deployment > Build Tools > Gradle".
3. Check that the "General Settings" are correctly set.
  - Grade user home: /home/\<username\>/.gradle
  - Gradle projects: security-app.
  - Download external annotations for dependencies: checked.
  - Build and run using: Gradle (default).
  - Run tests using: Gradle (default).
  - Gradle JVM: WSL version, i.e. "11 (WSL) version 11.0.13"

### Building the project so far

1. Click on the Gradle's right-top tab (or somehow open the "Gradle" pane).
2. In the "Gradle" pane, click in the project name and the click in the reload button.
3. The Gradle / IDE integration will start to download all dependencies declared in the "build.gradle" file and build the application.
4. After this process, the project's tasks and dependencies must be displayed in the "Gradle" pane.

## 3rd Party libraries

- [Lombok](https://projectlombok.org/setup/gradle), so be sure that "IntelliJ Lombok plugin" is activated.

---

Goto "[Building an API](README.files/01/build-an-api.md)"
