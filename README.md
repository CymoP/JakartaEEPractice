# JakartaEEPractice
Test project for learning Jakarta EE

## Setup

```
Run ./scripts/setup-payara.ps1
```

## Redeploy

```
asadmin stop-domain
asadmin start-domain
asadmin ping-connection-pool catalogPool
mvn clean package
asadmin undeploy jakarta-practice   
asadmin deploy target\jakarta-practice.war
```

## Manual Test

```
Invoke-WebRequest http://localhost:8080/jakarta-practice/api/catalog
asadmin ping-connection-pool catalogPool
```

## TODO

```
Unit Tests
PUT Endpoint
```