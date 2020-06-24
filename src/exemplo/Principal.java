package exemplo;

import java.util.List;

public class Principal {
	

	public static void main(String[] args) {
		
		DatabaseAccess db = new DatabaseAccess();
		       
        // Inserir pessoas
		Pessoa p1 = new Pessoa(1, "Maria", 50);
        System.out.println("Inserindo Pessoa 1: " + p1);
        db.inserePessoa(p1);
        
        Pessoa p2 = new Pessoa(2, "José", 36);
        System.out.println("Inserindo Pessoa 2: " + p2);
        db.inserePessoa(p2);
        
      
        // faz um SELECT no banco----------------------------------
        List<Pessoa> pessoas = db.getAllPessoas();
        
        imprimePessoas(pessoas);
        
        // -----------------------------------------
        // atualiza pessoa
        p1.setNome("Mariano");
        p1.setIdade(20);
        
        db.updatePessoa(p1);
        
        // remove pessoa ---------------------------------------
        System.out.println("Removendo pessoa 2");
        db.deletePessoa(2);
        
        // lista todas as pessoas
        pessoas = db.getAllPessoas();
        
        imprimePessoas(pessoas);
	}

	private static void imprimePessoas(List<Pessoa> pessoas) {
		System.out.println("Lista de pessoas:");
        for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}
}
