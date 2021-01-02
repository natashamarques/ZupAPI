package br.com.zup.ZupAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.ZupAPI.models.Pessoa;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> { }