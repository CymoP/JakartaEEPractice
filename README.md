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

## Get Products

```
Invoke-WebRequest http://localhost:8080/jakarta-practice/api/catalog
```

## Add Product

```
Invoke-WebRequest `
  -Uri "http://localhost:8080/jakarta-practice/api/catalog" `
  -Method POST `
  -ContentType "application/json" `
  -Body '{"name":"Pokemon Pack","price":4.29}'
```

## TODO

```
Unit Tests
PUT Endpoint
```