
FROM amazoncorreto:11-alpine-jdk
maintainer Facundo-Comercio
copy PortfolioAP-0.0.1-SNAPSHOT.jar PortfolioAP.jar
entrypoint ["java", "-jar","/PortfolioAP.jar"]