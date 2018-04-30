# war
Challenge: decrypt coordinates

### How to run the service
Clone the repository:
```
> git clone https://github.com/limavi2015/war.git
```
Run the service:
```
> sbt run
```

### Usage

Coordinate entity:
```
case class Coordinate(
    galaxy: String,
    quadrant: String,
    starSystem: String,
    starSecondSystem: String,
    planet: String
)
```

### Decrypt coordinates
You can download the postman collection ```Decrypt.postman_collection.json``` that is at the root of the project Or execute the following:

Request:
```
curl -v -H "Content-Type: application/json" \
	 -X POST http://localhost:8081/decrypt \
	 -d '[
	{
	  "galaxy": "2952410b",
	  "quadrant":  "0a94",
	  "starSystem": "446b",
	  "starSecondSystem": "8bcb",
	  "planet":  "448dc6e30b08"
	},
	{
	  "galaxy": "6f9c15fa",
	  "quadrant":  "ef51",
	  "starSystem": "4415",
	  "starSecondSystem": "afab",
	  "planet":  "36218d76c2d9"
	},
	{
	  "galaxy": "2ab81c9b",
	  "quadrant":  "1719",
	  "starSystem": "400c",
	  "starSecondSystem": "a676",
	  "planet":  "bdba976150eb"
	}
    ]'
```
Response if the question has been created:
```
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 8081 (#0)
> POST /decrypt HTTP/1.1
> Host: localhost:8081
> User-Agent: curl/7.47.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 408
> 
* upload completely sent off: 408 out of 408 bytes
< HTTP/1.1 200 OK
< Server: akka-http/10.1.1
< Date: Mon, 30 Apr 2018 04:35:32 GMT
< Content-Type: application/json
< Content-Length: 196
< 
* Connection #0 to host localhost left intact
[{"galaxy":"34","quadrant":"10","star":"42","planet":"edcb86430"},
{"galaxy":"73","quadrant":"15","star":"46","planet":"dc9876321"},
{"galaxy":"64","quadrant":"9","star":"35","planet":"edba976510"}]
```
