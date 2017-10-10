## FRONTEND - Test Plan

### REGISTRATION FLOW

-	Enter all valid data
-	Leave name field blank
-	Leave lastname field blank
-	Leave document (CPF) field blank
-	Enter an invalid document (CPF)
-	Enter an incomplete document (CPF)
-	Leave birthdate field blank
-	Enter an invalid birthdate 
-	Enter birthdate with a wrong date format MM/DD/YYYY
-	Enter an incomplete birthdate
-	Enter a valid birthdate with the current year (The user should be over 18)
-	Leave phone field blank
-	Enter an incomplete phone
-	Leave email field blank
-	Enter email with a wrong format
-	Enter a valid email with spaces in the end
-	Leave repeatEmail field blank
-	Enter repeatEmail with a wrong format
-	Enter a valid repeatEmail with spaces in the end
-	Enter email and repeatEmail with different values
-	Leave password field blank
-	Enter password with less than 6 long characters
-	Enter password with 6 long characters
-	Enter password with more than 6 long characters
-	Enter password with special characters 


### ADDRESS (HOME PAGE)

-	Enter a valid full address that is out of area
-	Enter a valid full address that is within the area
-	Enter a non-existent address
-	Enter an incomplete address
-	Leave number field blank
-	Enter letters in number field
-	Enter special characters in number field
-	Leave complemento field blank
-	Enter letters in complemento field
-	Enter special characters in complemento field
-	Validate if the displayed map in the screen corresponds to the address => Should be validated manually in frontend


### PLACE ORDER (PRODUCT PAGE)

-	Validate if the category in dropdown is set “Todos” as default

-	Validate the characteristics of each product in screen, should have:
o	Description
o	Image
o	Price
o	Subtract button
o	Text field in which has the quantity of products ordered
o	Add button  

-	Validate “Add” button in which should update the total price in the footer when clicked (increase the price)

-	Validate “Subtract” button in which should update the total price in the footer when clicked (decrease the price)

-	Click on “Subtract” button when does not have any order for this product 

-	Validate the Text field (number of products ordered) in the product card when clicking on “Add” button => should increase in 1 by 1 the quantity of products ordered

-	Validate the Text field (number of products ordered) in the product card when clicking on “Subtract” button => should decrease in 1 by 1 the quantity of products ordered

-	Click on “FECHA A CONTA, ZÉ” when total price is less then R$35,00

-	Click on “FECHA A CONTA, ZÉ” when total price is R$35,00

-	Click on “FECHA A CONTA, ZÉ” when total price is R$35,01

-	Place order in all categories, follows the categories:
o	Todos 
o	Balas & Doces
o	Cervejas
o	Cervejas Especiais & Importadas
o	Cervejas Retornáveis.
o	Destaques & Promoções
o	Kits & Promoções
o	Não Alcóolicos
o	Para festas & churrascos
o	Para matar a fome
o	Refrigerantes

-	Click on “FECHA A CONTA, ZÉ” containing products ordered regarding one category only

-	Click on “FECHA A CONTA, ZÉ” containing products ordered regarding two categories only

-	Click on “FECHA A CONTA, ZÉ” containing products ordered regarding four categories only

-	Click on “FECHA A CONTA, ZÉ” containing products ordered regarding five categories only

-	Click on “FECHA A CONTA, ZÉ” containing products ordered regarding six categories only

-	Click on “FECHA A CONTA, ZÉ” containing products ordered regarding seven categories only

-	Click on “FECHA A CONTA, ZÉ” containing products ordered regarding eight categories only

-	Click on “FECHA A CONTA, ZÉ” containing products ordered regarding nine categories only

-	Click on “FECHA A CONTA, ZÉ” containing products ordered regarding teen categories only

-	Click on “FECHA A CONTA, ZÉ” containing products ordered regarding all categories

-	Validate total price in the footer.

### TECHNOLOGIES (Frontend Automation):
-	Programming Language: Java
-	Frameworks: Junit, Selenium-webdriver, Hamcrest
-	Structure: Maven Project, Page Objects

In addition, there are other frameworks may be used such as, cucumber (BDD) and TestNG.

## BACKEND - Test Plan

#### Body sctructure - Use in POST request:

{
  "pdvs": [ 
    {
        "id": 1, 
        "tradingName": "Adega da Cerveja - Pinheiros",
        "ownerName": "Zé da Silva",
        "document": "1432132123891/0001", //CNPJ
        "coverageArea": { 
          "type": "MultiPolygon", 
          "coordinates": [
            [[[30, 20], [45, 40], [10, 40], [30, 20]]], 
            [[[15, 5], [40, 10], [10, 20], [5, 10], [15, 5]]]
          ]
        }, //Área de Cobertura
        "address": { 
          "type": "Point",
          "coordinates": [-46.57421, -21.785741]
        }, // Localização do PDV
    }
  ]
}

### API REST – POST (Create a new resource)

-	Perform a POST request passing all valid data. 
-	Perform a POST request without “id”
-	Perform a POST request without “tradingName”
-	Perform a POST request without “ownerName”
-	Perform a POST request without “document”
-	Perform a POST request passing an invalid “document”
-	Perform a POST request without “coverageArea”
-	Perform a POST request without “type” in “coverageArea” root
-	Perform a POST request without “coordinates”
-	Perform a POST request passing invalid “coordinates” in “coverageArea” root
-	Perform a POST request without “address”
-	Perform a POST request without “type” in “address” root
-	Perform a POST request without “coordinates” in “address” root
-	Perform a POST request passing invalid “coordinates” in “address” root

### API REST – GET (Search by id)

-	Perform a GET request passing an existent id
-	Perform a GET request passing a non-existent id
-	Perform a GET request passing alphanumeric value (letters) in id

### API REST – GET (Search by PDV-location) => should bring the closest place

-	Perform a GET request passing a valid lng and lat

### TECHNOLOGIES (Backend Automation):
-	Programming Language: Ruby
-	Frameworks: Httparty, Cucumber (BDD)

## QA-MOBILE

### Platforms: Android and iOS

Product Owner or Business Analyst needs to define which type of mobiles should be supported, for instance:
(Escope of the project)
-	Which APIs?
-	Which Screen Resolution?
-	Which Versions?

### Android: 
-	Test execution using physical devices 
-	Test execution using several virtual devices. In this case, it is possible to use Android Studio to create virtual devices

### iOS: 
-	Test execution using physical devices 
-	Test execution using several virtual devices. In this case, it is possible to use XCode to create simulators

### TECHNOLOGIES (Frontend Automation):
-	Programming Language: Java or Ruby
-	Frameworks: Selenium-webdriver, Appium
-	Structure: Page Objects
