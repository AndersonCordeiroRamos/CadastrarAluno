package contracts;

import java.util.List;
import models.Aluno;

public interface iAlunoRepository {
   void adicionar(Aluno aluno);
   void remover(Aluno aluno);
   Aluno buscar(String nome);
   List<Aluno> listar();
}







