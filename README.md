# covid19-restapi-bridge
This application's goal is to consume the REST services from:
https://rapidapi.com/Gramzivi/api/covid-19-data

In order to succesfully build and compile this project follow the steps:
1. In command line run sbt clean compile
2. In command line run sbt run
3. Open the browser in localhost:9000 and Swagger will be displayed
4. In order to retrieve the information of the covid country data by country and date add to the previous url: /country?date=2020-04-01&code=it

