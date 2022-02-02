# Building an API

The purpose of this pat is simply to create a REST api that will be secured later.

### Create a person entity/DTO/model/whatever...

```java
package com.ceballos.securityapp.person.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person {

    private final Integer id;
    private final String name;

}
```

### Create a person controller
```java
package com.ceballos.securityapp.person;

import com.ceballos.securityapp.person.Person.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private List<Person> people = Arrays.asList(
            new Person(1, "John Doe"),
            new Person(2, "Jane Doe"),
            new Person(3, "G. I. Joe"),
            new Person(4, "G. I. Jane Doe")
    );

    @GetMapping(path = "{personId}")
    public Person getPerson(@PathVariable("personId") Integer personId) {
        return people.stream()
                .filter(person -> personId.equals(person.getId()))
                .findFirst()
                .orElse(null);
    }

}
```
### Run the application

`./gradlew bootRun`

```
``.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::                (v2.6.3)

2022-02-01 22:54:02.073  INFO 31571 --- [           main] c.c.securityapp.SecurityApplication      : Starting SecurityApplication using Java 11.0.13 on <MACHINE> with PID 31571 (/home/<username>/Projects/security-app/build/classes/java/main started by <username> in /home/<username>/Projects/security-app)
2022-02-01 22:54:02.074  INFO 31571 --- [           main] c.c.securityapp.SecurityApplication      : No active profile set, falling back to default profiles: default
2022-02-01 22:54:02.701  INFO 31571 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-02-01 22:54:02.707  INFO 31571 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-02-01 22:54:02.708  INFO 31571 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.56]
2022-02-01 22:54:02.752  INFO 31571 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-02-01 22:54:02.753  INFO 31571 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 647 ms
2022-02-01 22:54:02.962  INFO 31571 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-02-01 22:54:02.971  INFO 31571 --- [           main] c.c.securityapp.SecurityApplication      : Started SecurityApplication in 1.159 seconds (JVM running for 1.638)
2022-02-01 22:54:15.299  INFO 31571 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-02-01 22:54:15.300  INFO 31571 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-02-01 22:54:15.301  INFO 31571 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
```
You can access the api using WSL terminal:
```shell
curl localhost:8080/api/v1/people/1
```

And the result should be:
```
{"id":1,"name":"John Doe"}
```

Note that to access the API using the browser you need to use the IP that is shown when running `ip address` or `ifconfig` (if installed).

Example:
```
http://192.11.221.148:8080/api/v1/people/1
```
