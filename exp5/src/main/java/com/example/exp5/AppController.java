package com.example.exp5;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@Autowired
	public MobileManager manager;
	
	@GetMapping("/mobiles")
	public List<Mobile> getAllMobile(){
		return manager.getAllMobile();
	}
	
	@GetMapping("/mobiles/{id}")
	public ResponseEntity<Mobile> getMobile(@PathVariable Long id){
		Mobile mobile = manager.getMobileById(id);
		try {
			return new ResponseEntity<Mobile>(mobile, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Mobile>(mobile, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/mobiles")
	public void saveMobile(@RequestBody Mobile mobile) {
		manager.saveMobile(mobile);
	}
	
	@PutMapping("/mobile")
	public void updateMobile(@RequestBody Mobile mobile) {
		manager.saveMobile(mobile);
	}
	@DeleteMapping("/mobiles/{id}")
	public ResponseEntity<Mobile> deleteMobile(@PathVariable Long id){
		if(manager.exists(id)) {
			manager.deleteMobile(id);
			return new ResponseEntity<Mobile>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Mobile>(HttpStatus.NOT_FOUND);
		}
	}  
}

//curl -X POST http://localhost:8081/mobiles -H "Content-Type: application/json" -d "{\"name\":\"Samsung\",\"model\":\"S24\",\"osystem\":\"Android\"}"
//curl -X POST http://localhost:8081/mobiles -H "Content-Type: application/json" -d "{\"name\":\"Apple\",\"model\":\"iPhone 15\",\"osystem\":\"iOS\"}"
//curl http://localhost:8081/mobiles
//curl -i http://localhost:8081/mobiles/1
//curl -i http://localhost:8081/mobiles/99
//curl -X PUT http://localhost:8081/mobiles -H "Content-Type: application/json" -d "{\"id\":1,\"name\":\"Samsung\",\"model\":\"S24 Ultra\",\"osystem\":\"Android\"}"
//curl http://localhost:8081/mobiles/1
//curl -i -X DELETE http://localhost:8081/mobiles/2
//curl -i -X DELETE http://localhost:8081/mobiles/2
//curl http://localhost:8081/mobiles