package exemplo;

import java.util.List;

import exemplo.dao.DatabaseAccess;
import exemplo.dao.PessoaDao;
import exemplo.modelo.Pessoa;

public class Principal {
	

	public static void main(String[] args) {
		
		PessoaDao pDao = new PessoaDao();
		       
        // Inserir pessoas
		Pessoa p1 = new Pessoa(1, "Maria", 50);
        System.out.println("Inserindo Pessoa 1: " + p1);
        pDao.inserePessoa(p1);
        
        Pessoa p2 = new Pessoa(2, "José", 36);
        System.out.println("Inserindo Pessoa 2: " + p2);
        pDao.inserePessoa(p2);
        
      
        // faz um SELECT no banco----------------------------------
        List<Pessoa> pessoas = pDao.getAllPessoas();
        
        imprimePessoas(pessoas);
        
        // -----------------------------------------
        // atualiza pessoa
        p1.setNome("Mariano");
        p1.setIdade(20);
        
        pDao.updatePessoa(p1);
        
        // remove pessoa ---------------------------------------
        System.out.println("Removendo pessoa 2");
        pDao.deletePessoa(p2.getId());
        
        // lista todas as pessoas
        pessoas = pDao.getAllPessoas();
        
        imprimePessoas(pessoas);
	}

	private static void imprimePessoas(List<Pessoa> pessoas) {
		System.out.println("Lista de pessoas:");
        for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}
}
