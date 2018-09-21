# Phone bill calculation
service to calculate the phone bill

### How to run the service
Clone the repository:
```
> git clone https://github.com/ditoaforero/prueba-tecnica-stratio.git
```
Run the service:
```
> mvn clean install 
> java -jar ./target/
```

### Usage

GET http://localhost:8080/bill/{{fileName}}

fileName: is the name of the file without extension
example url: http://localhost:8080/bill/prueba 



Response successful:
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


Response failed:
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



