package br.mg.cadastro.dtos;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class CadastroDTO implements Serializable {

	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;

	private String nome;

	private String email;

	private String senha;

	private String confirmacaoSenha;

	public void CadastroDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "O campo Nome é obrigatório")
	@Length(min = 1, max = 40, message = "Nome deve estar entre 1 e 40 caracteres")
	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	@NotNull(message = "O campo e-mail é obrigatório")
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	@NotNull(message = "O campo Senha é obrigatório")
	@Length(min = 6, max = 40, message = "A senha deve ter no mínimo 6 caracteres")
	public String getsenha() {
		return senha;
	}

	public void setsenha(String senha) {
		this.senha = senha;
	}

	@NotNull(message = "O campo Confirmação é obrigatório")
	@Length(min = 6, max = 40, message = "A senha deve ter no mínimo 6 caracteres")
	public String getconfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setconfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	@Override
	public String toString() {
		return "CadastroDto [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", senha=" + senha + ", confirmacaoSenha=" + confirmacaoSenha + "]";
	}
}
