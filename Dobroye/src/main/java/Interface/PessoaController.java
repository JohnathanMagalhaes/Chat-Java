package Interface;

import Model.Pessoa;
import java.util.List;

public interface PessoaController 
{
    public boolean salvar(Pessoa pessoa);
    public boolean login(String e, String s);
    public Pessoa consultaEmail(String e);
    public Pessoa consultaNome(String n);
    public List<Pessoa> Lista(String nome);
    public boolean Atualizar(Pessoa pessoa);
    public Pessoa consultaID(int id);
    public boolean VerificarEmailExiste(String email);
}
