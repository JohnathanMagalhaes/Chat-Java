package Model;

public class Pessoa extends Usuario {

    public Pessoa() {

    }

    public Pessoa(String nome, String email, String senha, String biografia, String sexo, byte[] imagem) {
        super(nome, email, senha, biografia, sexo, imagem);
    }

    public Pessoa(int id, String nome, String email, String senha, String biografia, String sexo, byte[] imagem) {
        super(id, nome, email, senha, biografia, sexo, imagem);
    }

}
