import java.util.List;

import contracts.iAlunoRepository;
import exceptions.AlunoNaoEncontrado;
import exceptions.MatriculaInvalida;
import models.Aluno;
import repositories.ArrayListAlunoRepository;

public class App {
    public static void main(String[] args) {
        iAlunoRepository alunoRepository = new ArrayListAlunoRepository();

        alunoRepository.adicionar(new Aluno("João", "1234567890"));
        alunoRepository.adicionar(new Aluno("Lucas", "0987654321"));
        alunoRepository.adicionar(new Aluno("Anderson", "1466411466"));
        alunoRepository.adicionar(new Aluno("Pedro", "8907635411"));
        alunoRepository.adicionar(new Aluno("Maria", "1254151112"));

        System.out.println("Lista de Alunos:");
        List<Aluno> alunos = alunoRepository.listar();
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        System.out.println();

        try {

            for (Aluno aluno : alunos) {
                if (aluno.getMatricula().length() != 10) {
                    throw new MatriculaInvalida(
                            "Matricula invalida: " + aluno.getNome() + ", " + aluno.getMatricula());
                }
            }

            Aluno alunoBuscado = alunoRepository.buscar("Maria");
            

            System.out.println("Aluno buscado e removido: " + alunoBuscado);
            alunoRepository.remover(alunoBuscado);
        } catch (AlunoNaoEncontrado e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        } catch (MatriculaInvalida e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        System.out.println();

        System.out.println("Lista de Alunos após remoção:");
        alunos = alunoRepository.listar();
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}












