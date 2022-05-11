package Model;

public abstract class Usuario {

    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String biografia;
    private String sexo;
    private byte[] imagem;

    public Usuario() {

    }

    public Usuario(String nome, String email, String senha, String biografia, String sexo, byte[] imagem) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.biografia = biografia;
        this.sexo = sexo;
        this.imagem = imagem;
    }

    public Usuario(int id, String nome, String email, String senha, String biografia, String sexo, byte[] imagem) {
        this.idUsuario = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.biografia = biografia;
        this.sexo = sexo;
        this.imagem = imagem;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
