package Cadastros;

import java.util.ArrayList;
import java.util.List;

public class PessoaDao extends Dao{
	
	public void incluirPessoa(Pessoa pessoa) throws Exception{
		open();
		stmt = con.prepareStatement("INSERT INTO pessoa VALUES(?, ?, ?)");
		stmt.setInt(1, pessoa.getIdPessoa());
		stmt.setString(2, pessoa.getNomePessoa());
		stmt.setString(3, pessoa.getEmail());
		stmt.execute();
		close();
	}
	
	public void alterarPessoa(Pessoa pessoa) throws Exception{
		open();
		stmt = con.prepareStatement("UPDATE pessoa SET nomepessoa = ?, email = ? WHERE idpessoa = ?");
		stmt.setString(1, pessoa.getNomePessoa());
		stmt.setString(2, pessoa.getEmail());
		stmt.setInt(3, pessoa.getIdPessoa());
		stmt.execute();
		close();
	}
	
	public void excluirPessoa(Pessoa pessoa) throws Exception{
		open();
		stmt = con.prepareStatement("DELETE FROM pessoa WHERE idpessoa = ?");
		stmt.setInt(1, pessoa.getIdPessoa());
		stmt.execute();
		close();
	}
	
	public Pessoa consultarPessoaPorId(int cod) throws Exception{
		open();
		stmt = con.prepareStatement("SELECT * FROM pessoa WHERE idpessoa = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		Pessoa pessoa = null;
		if (rs.next()) {
			pessoa = new Pessoa();
			pessoa.setIdPessoa(rs.getInt("idPessoa"));
			pessoa.setNomePessoa(rs.getString("nomePessoa"));
			pessoa.setEmail(rs.getString("email"));
		} else {
			System.out.println("Registro não encontrado.");
		}
		close();
		return pessoa;
	}
	
	public List<Pessoa> listarPessoas() throws Exception{
		open();
		stmt = con.prepareStatement("SELECT * FROM pessoa ORDER BY idpessoa");
		rs = stmt.executeQuery();
		List<Pessoa> listaPessoas = new ArrayList<>();
		
		while(rs.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(rs.getInt("idPessoa"));
			pessoa.setNomePessoa(rs.getString("nomePessoa"));
			pessoa.setEmail(rs.getString("email"));
			listaPessoas.add(pessoa);
		}
		
		close();
		return listaPessoas;
	}
	
}
