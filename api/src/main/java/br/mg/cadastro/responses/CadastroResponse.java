package br.mg.cadastro.responses;

import java.util.ArrayList;
import java.util.List;

public class CadastroResponse<T> {

	private T nome;
	private List<String> errors;

	public T getnome() {
		return nome;
	}

	public void setnome(T nome) {
		this.nome = nome;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public CadastroResponse() {
	}
}
