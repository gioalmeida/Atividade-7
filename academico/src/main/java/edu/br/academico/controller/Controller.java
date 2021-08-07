package edu.br.academico.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Controller {

	@RestController
	@RequestMapping({"/aluno"})
	public class ContactController {

	   private alunoRepository repository;

	   ContactController(alunoRepository alunoRepository) {
	       this.repository = alunoRepository;
	   }
	   
	   @GetMapping
	   public List findAll(){
	      return repository.findAll();
	   }
	   
	   @GetMapping(path = {"/{id}"})
	   public ResponseEntity findById(@PathVariable long id){
	      return repository.findById(id)
	              .map(record -> ResponseEntity.ok().body(record))
	              .orElse(ResponseEntity.notFound().build());
	   }
	   
	   @DeleteMapping(path ={"/{id}"})
	   public ResponseEntity <?> delete(@PathVariable long id) {
	      return repository.findById(id)
	              .map(record -> {
	                  repository.deleteById(id);
	                  return ResponseEntity.ok().build();
	              }).orElse(ResponseEntity.notFound().build());
	   }
	   
	}
}
