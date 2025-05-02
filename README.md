# This is a practice project for my revision

### How find the openAPi Swagger:
Goto the browser: http://localhost:8088/api/v1/swagger-ui/index.html

### OpenAPi Documentation:
- Copy the raw file and create repostory in frontend: in src folder:
- create file name openapi.json and paste all data in here
- formate the document

### How to create the openapi services in angular
 - goto here: https://www.npmjs.com/package/ng-openapi-gen
 - install this package in fronend: npm i ng-openapi-gen
 - Now goto the package.json
 - paste it in script: "api-gen": "ng-openapi-gen --input ./src/openapi/openapi.json --output ./src/app/services"
 in 
 - now give this command: npm run api-gen


 ## You need to create tokenService manually

 ## You need to install JWT helper library

 - npm install @auth0/angular-jwt



