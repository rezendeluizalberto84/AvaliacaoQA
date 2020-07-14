package br.mg.cadastro.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Component
@Table(name = "cadastro")
public class CadastroInsert implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome_usuario", nullable = false)
	private String nome;

	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "email_usuario", nullable = false)
	private String email;

	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "senha_usuario", nullable = true)
	private String senha;

	@Column(name = "confirmacaoSenha_usuario", nullable = true)
	private String confirmacaoSenha;

	public CadastroInsert() {

	}

	public CadastroInsert(Long id, String nome, String email, String senha, String confirmacaoSenha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public String getNomeUsuario() {
		return nome;
	}

	public void setNomeUsuario(String nome) {
		this.nome = nome;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getsenha() {
		return senha;
	}

	public void setsenha(String senha) {
		this.senha = senha;
	}
	
	public String getconfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setconfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", senha=" + senha + ", confirmacaoSenha=" + confirmacaoSenha + "]";
	}

}
