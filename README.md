# Getting Started

## Prerequisites
- Java 16
- InteliJ Ultimate

## Setting up the Spring project
After you are done with configuring Apache Kafka server please
use the following steps to get your Spring application up and running:
1. Set up your Java SDK version to 16 if needed (File -> project Structure -> Project SDK)
2. Run a Maven clean install either from the configuration in the top right corner of the IDE
   or from terminal by running the following command:
>mvn clean install -DskipTests
3. Run the application by selecting the springboot configuration and hitting the "play" button in the top right corner
   of the IDE
4. Done, your application should be up and running

## Using the application
To use the Application APIs please navigate to the following URL in your browser
after running the application:
>http://localhost:8080/swagger-ui/index.html
<P>To use the APIs you will first need to authenticate by using the <b><i>/authenticate</i></b> endpoint.
Execute the request with the following request body:</P>

```json
{
  "user": "admin",
  "password": "admin"
}
```
<p>Click the <b>Authorize</b> button in the top right corner and paste the JWT value.
Then you can use the other endpoints to execute the requests</p>
