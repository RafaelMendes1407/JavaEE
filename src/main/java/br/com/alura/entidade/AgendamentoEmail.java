package br.com.alura.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agendamentoemail")
public class AgendamentoEmail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String mensagem;
	private String assunto;
	private Boolean agendado;
	
	public AgendamentoEmail() {}
	
	public AgendamentoEmail(String email, String mensagem, String assunto) {
		this.email = email;
		this.mensagem = mensagem;
		this.assunto = assunto;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public void setAgendado(Boolean agendado) {
		this.agendado = agendado;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getAssunto() {
		return assunto;
	}

	public Boolean getAgendado() {
		return agendado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendado == null) ? 0 : agendado.hashCode());
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mensagem == null) ? 0 : mensagem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendamentoEmail other = (AgendamentoEmail) obj;
		if (agendado == null) {
			if (other.agendado != null)
				return false;
		} else if (!agendado.equals(other.agendado))
			return false;
		if (assunto == null) {
			if (other.assunto != null)
				return false;
		} else if (!assunto.equals(other.assunto))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		return true;
	}
	
	
	
}
