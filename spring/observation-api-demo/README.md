# Observation API Demo

This repository contains a simple demo of the building blocks of the micrometer observation api.

# About the project

## Components:

- [ObservationLifecycleDemoApplication](OBSERVATION_LIFECYCLE_CLASS): a java main program that explains the different lifecycle phases of an
  `Observation`.
- [ObservationHandlerDemoApplication](OBSERVATION_API_BUILDING_BLOCKS_CLASS): a java main program that explains how `Observation`, `ObservationRegistry`,
  and `ObservationHandler` work together.

# Getting Started

- Install JDK 17 and set environment variable `JAVA_HOME`
- Run the java main program:
  - [ObservationHandlerDemoApplication]():  ```bash ./mvnw clean compile exec:java -Dexec.mainClass='com.soufianeroui.tutorials.observation.demo.ObservationLifecycleDemoApplication'```
  - [ObservationLifecycleDemoApplication](): ```bash ./mvnw clean compile exec:java -Dexec.mainClass='com.soufianeroui.tutorials.observation.demo.ObservationHandlerDemoApplication'```

[OBSERVATION_LIFECYCLE_CLASS]: src/main/java/com/soufianeroui/tutorials/observation/demo/ObservationLifecycleDemoApplication.java
[OBSERVATION_API_BUILDING_BLOCKS_CLASS]: src/main/java/com/soufianeroui/tutorials/observation/demo/ObservationHandlerDemoApplication.java