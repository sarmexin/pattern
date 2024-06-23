package com.example.restapi.controller;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.Greeting;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GreetingController {
	
	// получение по имени
	@GetMapping("greeting")
	public Greeting greetingGet(@RequestParam(value = "name", defaultValue = "World") String name) {
		log.info("получение объекта по имени " + name);
		return new Greeting(99L, "Greeting");
	}
	
	// получение по id
	@GetMapping("greeting/get/{id}")
	public Greeting greetingGet(@PathVariable Long id) {
		log.info("получение объекта по id = " + id);
		return new Greeting(id, "Greeting");
	}

	// создание с получением объекта и ответом OK
	@PostMapping("greeting/post")
	public ResponseEntity<Greeting> greetingPost(@RequestBody Greeting greeting) {
		log.info("создание объекта из приходящего и ответом OK" + greeting.getId());
		return ResponseEntity.of(Optional.of(new Greeting(55L, "Greeting")));
	}
	
	// создание с получением объекта и ответом JSONом
	@PostMapping("greeting/post2")
	public Greeting greetingPost2(@RequestBody Greeting greeting) {
		log.info("создание объекта из приходящего ответом JSONом" + greeting.getId());
		return new Greeting(100L, "сообщение");
	}
	
	// изменение объекта по id с получением нового объекта
	@PutMapping("/greeting/put/{id}")
	public Greeting greetingPut(@RequestBody Greeting greeting, @PathVariable Long id) {
		log.info("изменение объекта " + greeting.getId() + " по id = " + id);
		return null;
	}
	
	// удаление объукта по id
	@DeleteMapping("/greeting/delete/{id}")
	public void greetingDelete(@PathVariable Long id) {
		log.info("удаление объекта greeting " + id);
	}
	
}
