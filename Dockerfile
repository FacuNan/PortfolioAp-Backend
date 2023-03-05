FROM amazoncorretto:11-alpine-jdk
maintainer Facundo-Comercio
copy target/PortfolioAP-0.0.1-SNAPSHOT.jar PortfolioAP-APP.jar
entrypoint ["java", "-jar","/PortfolioAP.jar"]