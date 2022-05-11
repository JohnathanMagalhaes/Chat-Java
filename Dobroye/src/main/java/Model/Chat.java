package Model;

public class Chat {

    private int id;
    private int idUsuarioP;
    private int idUsuarioS;

    public Chat() {

    }

    public Chat(int p, int s) {
        this.idUsuarioP = p;
        this.idUsuarioS = s;
    }

    public Chat(int id, int p, int s) {
        this.id = id;
        this.idUsuarioP = p;
        this.idUsuarioS = s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuarioP() {
        return idUsuarioP;
    }

    public void setIdUsuarioP(int idUsuarioP) {
        this.idUsuarioP = idUsuarioP;
    }

    public int getIdUsuarioS() {
        return idUsuarioS;
    }

    public void setIdUsuarioS(int idUsuarioS) {
        this.idUsuarioS = idUsuarioS;
    }
}
