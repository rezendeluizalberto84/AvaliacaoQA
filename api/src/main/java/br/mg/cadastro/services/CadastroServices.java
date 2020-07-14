package br.mg.cadastro.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mg.cadastro.dtos.CadastroDTO;
import br.mg.cadastro.entities.CadastroInsert;
import br.mg.cadastro.gerenciador.dtos.CadastroDto;
import br.mg.cadastro.gerenciador.entities.Cadastro;
import br.mg.cadastro.gerenciador.repositories.cadastroRepository;
import br.mg.cadastro.gerenciador.services.exceptions.CadastroServiceException;
import br.mg.cadastro.repository.CadastroRepository;

@Service
public class CadastroServices {

	@Autowired
	private CadastroRepository cadastroRepository;

	public List<CadastroInsert> listar() {
		return cadastroRepository.findAll();
	}

	public CadastroInsert salvar(CadastroDTO CadastroDto) {

		CadastroInsert cadastro = new CadastroInsert();

		cadastro.setNomeUsuario(CadastroDto.getnome());
		cadastro.setemail(CadastroDto.getemail());
		cadastro.setsenha(CadastroDto.getsenha());
		cadastro.setconfirmacaoSenha(CadastroDto.getconfirmacaoSenha());
		return cadastroRepository.save(cadastro);
	}

	public CadastroInsert buscar(Long id) throws Exception {
		CadastroInsert cadastro = cadastroRepository.findOne(id);

		if (cadastro == null) {
			throw new Exception("Não existe este usuário cadastrado");
		}
		return cadastro;
	}
}
