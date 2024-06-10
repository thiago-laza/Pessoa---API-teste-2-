package pessoa_teste.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pessoa_teste.Model.Pessoa;
import pessoa_teste.Repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaRepository repository;

    @Autowired
    public PessoaController(PessoaRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Pessoa> all(){
        return repository.findAll();
    }

    @PostMapping
    public Pessoa newPessoa(@RequestBody Pessoa newPessoa){
        return repository.save(newPessoa);
    }

    @GetMapping("/{id}")
    public Pessoa one(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Pessoa replacePessoa(@RequestBody Pessoa newPessoa, @PathVariable Long id){
        return repository.findById(id)
                .map(pessoa -> {
                    pessoa.setName(newPessoa.getName());
                    pessoa.setAge(newPessoa.getAge());
                    pessoa.setHeight(newPessoa.getHeight());
                    pessoa.setHeight(newPessoa.getHeight());
                    return repository.save(pessoa);
                })
                .orElseGet(() -> {
                    newPessoa.setId(id);
                    return repository.save(newPessoa);
                });
    }

    @DeleteMapping("/{id}")
    public void deletePessoa(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

