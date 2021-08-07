package br.edu.ifgoias.academico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import br.edu.ifgoias.academico.entities.Curso;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;
	
	public List<Curso>,findAll(){
		
		return repository.findall();
		
	}
	
	public Curso findById(Integer id) {
		repository.findById(id).orElseThrow(() -> new ResponseStatusExeption(httpStatus.NOT_FOUND));
	}
	
	public Curso insert(Curso curso) {
		
		return repository.save(curso);
		
	}
	
	public void delete (Integer id) {
		repository.findByID(id).map(
				curso -> repository.delete(cuso)
				return Void.TYPE;
	}).orElseThrow(()-> new ResponseStatusExeption(httpStatus.NOT_FOUND));
		
	}

	public void update(Integer id, Curso obj) {
	
		repository.findById(id).map(curso -> { curso.setNomecurso(obj.getNomecurso));
		return repository.save(curso);
		}).orElseThrow(() -> new ResponseStatusExeption(httpStatus.NOT_FOUND));
	}
	
	}
	
}
