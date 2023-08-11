## Ready To Start   ##

The aim of this project is to provide a valid scaffold from a:
- MVC pattern
- Reactive programming
- Micronaut framework, with netty server 
- Language Kotlin ( With interfaces)
- Junit v5 testing each layer


### Description

 We have 2 simple endpoints in the controller that do calls to the same service
This Service pass the request and enrich the response, calling to a connector layer,
 each method connects to a version of the high and low level implementation of Micronaut Client's API
Each connector set up a parameter in the request, and add a value on top of the response. 

The message is sent back to the controller to be served back as a Json, with a generic error controller advice to handle unexpected issues


Test cases has been developed with mock calls and tests for each component 
( Currently they do not cover all the code, just developed as an example)


### Valid urls
- http://localhost:8080/readytostart/low
- http://localhost:8080/readytostart/high


### Third party response at the time of the development:

```

{
"args": {
"param": "returned"
},
"headers": {
"Accept": "text/html,application/xhtml+xml,application/xml;q=0.0,image/avif,image/webp,image/apng,*/*;q=0.0,application/signed-exchange;v=b3;q=0.0",
"Accept-Encoding": "gzip, deflate, br",
"Accept-Language": "es-ES,es;q=0.0,en-GB;q=0.0,en;q=0.0",
"Cache-Control": "max-age=0",
"Dnt": "1",
"Host": "httpbin.org",
"Sec-Ch-Ua": "\"Not/A)Brand\";v=\"99\", \"Google Chrome\";v=\"1xx\",
"Sec-Ch-Ua-Mobile": "?0",
"Sec-Ch-Ua-Platform": "\"Windows\"",
"Sec-Fetch-Dest": "document",
"Sec-Fetch-Mode": "navigate",
"Sec-Fetch-Site": "none",
"Sec-Fetch-User": "?1",
"Upgrade-Insecure-Requests": "1",
"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64)"
},
"origin": "1.111.111.211",
"url": "https://httpbin.org/get?param=returned"
}
```

## Micronaut 3.9.4 Documentation

- [User Guide](https://docs.micronaut.io/3.9.4/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.9.4/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.9.4/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
## Feature swagger-ui documentation

- [Micronaut Swagger UI documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://swagger.io/tools/swagger-ui/](https://swagger.io/tools/swagger-ui/)


## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)

###
https://guides.micronaut.io/latest/micronaut-http-client-maven-kotlin.html


