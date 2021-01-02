package br.com.zup.ZupAPI.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.ZupAPI.models.Pessoa;
import br.com.zup.ZupAPI.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll() {
		List<Pessoa> list = repository.findAll();
		return  list;
	}
	
	public Pessoa insert(Pessoa pessoa) {
		List<Pessoa> pessoas = findAll(); 

		for(Pessoa pessoaRegistrada: pessoas) { 
			if (pessoaRegistrada.getCpf().contains(pessoa.getCpf())) {			
				return null;
			}
		}
		return repository.save(pessoa);
	}
}
