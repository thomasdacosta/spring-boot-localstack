package br.com.thomasdacosta.utils;

import br.com.thomasdacosta.dto.AlunoRequest;
import br.com.thomasdacosta.dto.AlunoResponse;
import br.com.thomasdacosta.entity.Aluno;

public class AlunoConverter {

    public static AlunoResponse toAlunoResponse(Aluno aluno) {
        AlunoResponse alunoResponse = new AlunoResponse();

        alunoResponse.setIdAluno(aluno.getId());
        alunoResponse.setNome(aluno.getNome());
        alunoResponse.setCpf(aluno.getCpf());
        alunoResponse.setRg(aluno.getRg());
        alunoResponse.setDataNascimento(aluno.getDataNascimento());
        alunoResponse.setEndereco(aluno.getEndereco());
        alunoResponse.setCep(aluno.getCep());
        alunoResponse.setCidade(aluno.getCidade());
        alunoResponse.setEstado(aluno.getEstado());

        return alunoResponse;
    }

    public static AlunoRequest toAlunoRequest(Aluno aluno) {
        AlunoRequest alunoRequest = new AlunoRequest();

        alunoRequest.setNome(aluno.getNome());
        alunoRequest.setCpf(aluno.getCpf());
        alunoRequest.setRg(aluno.getRg());
        alunoRequest.setDataNascimento(aluno.getDataNascimento());
        alunoRequest.setEndereco(aluno.getEndereco());
        alunoRequest.setCep(aluno.getCep());
        alunoRequest.setCidade(aluno.getCidade());
        alunoRequest.setEstado(aluno.getEstado());

        return alunoRequest;
    }

    public static Aluno toAluno(AlunoRequest alunoRequest) {
        Aluno aluno = new Aluno();

        aluno.setId(alunoRequest.getIdAluno());
        aluno.setNome(alunoRequest.getNome());
        aluno.setCpf(alunoRequest.getCpf());
        aluno.setRg(alunoRequest.getRg());
        aluno.setDataNascimento(alunoRequest.getDataNascimento());
        aluno.setEndereco(alunoRequest.getEndereco());
        aluno.setCep(alunoRequest.getCep());
        aluno.setCidade(alunoRequest.getCidade());
        aluno.setEstado(alunoRequest.getEstado());

        return aluno;
    }

}
