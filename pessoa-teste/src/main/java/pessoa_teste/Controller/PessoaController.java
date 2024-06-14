package pessoa_teste.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pessoa_teste.Model.Pessoa;
import pessoa_teste.Model.Endereco;
import pessoa_teste.Repository.PessoaRepository;
import pessoa_teste.Repository.EnderecoRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public PessoaController(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping
    public List<Pessoa> all() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public Pessoa newPessoa(@RequestBody Pessoa newPessoa) {
        return pessoaRepository.save(newPessoa);
    }

    @GetMapping("/{id}")
    public Pessoa one(@PathVariable Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Pessoa replacePessoa(@RequestBody Pessoa newPessoa, @PathVariable Long id) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setName(newPessoa.getName());
                    pessoa.setAge(newPessoa.getAge());
                    pessoa.setWeight(newPessoa.getWeight());
                    pessoa.setHeight(newPessoa.getHeight());
                    return pessoaRepository.save(pessoa);
                })
                .orElseGet(() -> {
                    newPessoa.setId(id);
                    return pessoaRepository.save(newPessoa);
                });
    }

    @DeleteMapping("/{id}")
    public void deletePessoa(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }

    @GetMapping("/{id}/enderecos")
    public List<Endereco> getEnderecos(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(Pessoa::getEnderecos).orElse(null);
    }

    @PostMapping("/{id}/enderecos")
    public Endereco addEndereco(@PathVariable Long id, @RequestBody Endereco newEndereco) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    newEndereco.setPessoa(pessoa);
                    return enderecoRepository.save(newEndereco);
                })
                .orElse(null);
    }
}
