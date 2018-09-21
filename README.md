
# Phone Bill Calculation
service to calculate the phone bill

## How to run the service
Clone the repository:
```
> git clone https://github.com/ditoaforero/prueba-tecnica-stratio.git
```
Run the service:
```
> mvn clean install 
> java -jar ./target/phonebill-0.0.1-SNAPSHOT.jar
```

### Usage
```
URL: http://localhost:8080/bill/{{fileName}}
Method: GET 
parameters: 
    in: path
    name: fileName
    required: true
    description: Is the name of the file without extension.
```
example url: http://localhost:8080/bill/prueba 

Note: The file must be in the root of the project and must be in 'txt' format.

### Success Response:
```
{
    "code": "Success",
    "message": "Proceso exitoso",
    "bill": {
        "totalValue": 1800,
        "callRegistrySummary": [
            {
                "number": "400-234-090",
                "durationSeconds": 734,
                "value": 0
            },
            {
                "number": "701-080-080",
                "durationSeconds": 602,
                "value": 1800
            }
        ],
        "callRegistryDetail": [
            {
                "number": "400-234-090",
                "durationSeconds": 67,
                "value": 201
            },
            {
                "number": "701-080-080",
                "durationSeconds": 301,
                "value": 900
            },
            {
                "number": "400-234-090",
                "durationSeconds": 300,
                "value": 750
            },
            {
                "number": "400-234-090",
                "durationSeconds": 67,
                "value": 201
            },
            {
                "number": "701-080-080",
                "durationSeconds": 301,
                "value": 900
            },
            {
                "number": "400-234-090",
                "durationSeconds": 300,
                "value": 750
            }
        ]
    }
}
```

### Error Response:
```
{
    "code": "Failed",
    "message": "prueba01.txt (El sistema no puede encontrar el archivo especificado)",
    "bill": {
        "totalValue": 0,
        "callRegistrySummary": [],
        "callRegistryDetail": []
    }
}
```

## Docker Version


### Prerequirements
You must have docker installed. 

### Steps
1. Clone the repository.
```
> git clone https://github.com/ditoaforero/prueba-tecnica-stratio.git
```
2. Be located in the cloned repository folder `prueba-tecnica-stratio` of first step.

3. Execute `docker-compose up -d` command.
This command will create a folder called "bills" where you must put the bills files in "txt" format to be processed.

4. Finally, you can execute the service of these ways:
   * http://localhost:8080/bill/{nombreBill} 
   * http://127.0.0.1:8080/bill/{nombreBill}





