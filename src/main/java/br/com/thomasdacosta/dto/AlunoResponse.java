package br.com.thomasdacosta.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"idAluno", "nome", "cpf", "rg", "data_nascimento", "endereco", "cep", "cidade", "estado", "curso"})
public class AlunoResponse extends AlunoRequest {

}
