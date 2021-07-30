package br.com.generation.lojaGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.lojaGames.model.Categoria;
import br.com.generation.lojaGames.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	private ResponseEntity<List<Categoria>> getAll() {
		// tipo ResponseEntity retorna um objeto do tipo Categoria, chamado getAll

		return ResponseEntity.ok(categoriaRepository.findAll());
		// está dando uma resposta do tipo ResponseEntity, onde essa resposta será um OK
		// findAll é um método padrão, herdado na Repository
	}

	@GetMapping("/{id}")
	private ResponseEntity<Categoria> getById(@PathVariable long id) {
		// Faz praticamente a mesma coisa da anterior, porem precisamos pegar o caminho
		// e o Id passado pelo usuário -> @Path

		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp)) // resp recebe o resultado do
																						// método, caso seja uma
																						// resposta não nula, responde
																						// ok
				.orElse(ResponseEntity.notFound().build());// Caso seja numa, responde um NotFound
	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>> GetByTipo(@PathVariable String tipo) {
		return ResponseEntity.ok(categoriaRepository.findAllByTipoContainingIgnoreCase(tipo));
	}

	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}

	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria Categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(Categoria));
	}

	@DeleteMapping("/{id}")
	public void deleteId(@PathVariable long id) {
		categoriaRepository.deleteById(id);
	}
}
