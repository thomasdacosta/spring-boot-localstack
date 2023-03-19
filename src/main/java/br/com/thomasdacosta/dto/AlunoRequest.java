package br.com.thomasdacosta.dto;

import br.com.thomasdacosta.utils.DataDeserializer;
import br.com.thomasdacosta.utils.DataSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

@JsonPropertyOrder({"idAluno", "nome", "cpf", "rg", "data_nascimento", "endereco", "cep", "cidade", "estado", "curso"})
public class AlunoRequest {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id_aluno")
    private Integer idAluno;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("curso")
    private CursoRequest curso;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("nome")
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("cpf")
    private String cpf;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("rg")
    private String rg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data_nascimento")
    @JsonDeserialize(using = DataDeserializer.class)
    @JsonSerialize(using = DataSerializer.class)
    private Instant dataNascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("endereco")
    private String endereco;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("cep")
    private String cep;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("cidade")
    private String cidade;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("estado")
    private String estado;

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public CursoRequest getCurso() {
        return curso;
    }

    public void setCurso(CursoRequest curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Instant getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Instant dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
