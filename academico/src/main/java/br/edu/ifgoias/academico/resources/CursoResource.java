package br.edu.ifgoias.academico.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.services.CursoService;

@RestController
@RequestMapping(value="/cursos")
public class CursoResource {

	private CursoService service;
	@GetMapping
	public ResponseEntity<ResponseEntity<List<Curso>> findAll(){
		List<Curso> lista = service.findall();
		return ResponseEntity.ok().body(lista);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Curso> findByid(@PathVariable Integer id){
		Curso curso = service.findById(id);
		return ResponseEntity.ok(curso);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Curso> insert(@RequestBody Curso curso){
		curso = service.insert(curso);
		return ResponseEntity.ok().body(curso);
	}
	
	@DeleteMapping(value= "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@DeleteMapping(value= "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody Curso curso) {
		service.delete(id);
	}
	
}
