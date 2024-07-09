# Product-Fetcher-Service
This is a simple Spring Boot application that provides REST APIs for managing and getting products with product metadata.
The application uses JPA for database interactions and supports auto-generated entities.

## Features
* Persist new products with auto-generated IDs.
* Update product metadata.
* Retrieve products based by category.
* Retreive premium products.
* Use Jakarta Persistence (JPA) for database operations.

## Configuration
* Simply replace the below properties with your own database URL and credentials in the application.properties file.
* By default the configuration uses postgresSQL as the DB
```
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=localuser
spring.datasource.password=12345
```
* Replace the application port if you need the app to start in a custom port.
```
server.port=8081
```
## Product Endpoints
### Create Product API
```
POST [api/product]
Request Parameters: N/A
Remarks: creates a new product by cross checking with existing categories.
Sample Request Body: 
{
    "name": "Product 1",
    "description": "A sample product",
    "price": 600,
    "category": "electronics"
}
Sample Response:
success [201 Created]
```
### Update Product by Id API
```
PATCH [/api/products/{2}]
Remarks: Updates the product metadata for an existing product.
Sample Request Body: 
{
    "name": "Updated Product",
    "description": "An updated sample product",
    "price": 700,
    "category": "kitchenware"
}
Sample Response:
success [200 OK]
```

### Delete Product by Id API
```
DELETE [/api/products/{2}]
Remarks: Soft deletes an existing product by setting the product status to 'D'.
Sample Response:
success [200 OK]
```

### Get Premium Products API
```
GET [/api/products/premium]
Remarks: Retrieves products that are price 500 or more(premium products) with meta data.
Sample Response:
[
    {
        "id": 1,
        "name": "Product1",
        "description": "A sample product",
        "price": 600.00,
        "productCategory": {
            "id": 1,
            "name": "electronics",
            "description": "Electronics"
        },
        "productComments": [],
        "status": "A",
        "launchDate": "2024-07-09"
    }
]
```
### Get Products by category API
```
GET [/api/products/category/kitchen?limit=20]
Request Params: limit (optional) default size is 10
Remarks: Retrieves products that belong to a specific category.
Sample Response:
[
    {
        "id": 1,
        "name": "Test Product 1",
        "description": "A sample test product",
        "price": 500.00,
        "productCategory": {
            "id": 1,
            "name": "kitchen",
            "description": "kitchen ware"
        },
        "productComments": [],
        "status": "A",
        "launchDate": "2024-07-09"
    },
    {
        "id": 2,
        "name": "Test Product 2",
        "description": "A sample test product",
        "price": 500.00,
        "productCategory": {
            "id": 1,
            "name": "kitchen",
            "description": "kitchen ware"
        },
        "productComments": [],
        "status": "A",
        "launchDate": "2024-07-09"
    }
]
```


## Category Endpoint
### Create New category
```
POST [/api/category]
Remarks: Adds a new category to be used with product creation.
Sample Request Body:
{
    "name": "kitchen",
    "description": "kitchen ware"
}
```

### Usage
Once the application is running, you can interact with it using tools like curl, Postman, or your preferred HTTP client.
