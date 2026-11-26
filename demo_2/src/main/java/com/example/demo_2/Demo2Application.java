package com.example.demo_2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

}

//1. Create (POST)
//curl -X POST http://localhost:8081/mobile -H "Content-Type: application/json" -d "{\"name\":\"Samsung\",\"model\":\"S24\",\"osystem\":\"Android\"}"
//curl -X POST http://localhost:8081/mobile -H "Content-Type: application/json" -d "{\"name\":\"Apple\",\"model\":\"iPhone 15\",\"osystem\":\"iOS\"}"
//2. Read all (GET)
//curl http://localhost:8081/mobile
//3. Read one (GET by id)
//curl -i http://localhost:8081/mobile/1
//4. Record not found (error handling)
//curl -i http://localhost:8081/mobile/99
//
//Returns HTTP/1.1 404.
//
//5. Update (PUT, must include the id)
//curl -X PUT http://localhost:8081/mobile -H "Content-Type: application/json" -d "{\"id\":1,\"name\":\"Samsung\",\"model\":\"S24 Ultra\",\"osystem\":\"Android\"}"
//curl http://localhost:8081/mobile/1
//6. Delete (DELETE)
//curl -i -X DELETE http://localhost:8081/mobile/2
//
//Returns 200.
//
//7. Delete again (not found)
//curl -i -X DELETE http://localhost:8081/mobile/2
//
//Returns 404.
//
//8. Final check
//curl http://localhost:8081/mobile