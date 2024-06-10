package pessoa_teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pessoa_teste.Model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

}
