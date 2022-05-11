package Model;

import java.sql.Date;

public class ListChat{

    private int id;
    private int idChat;
    private String texto;
    private Date data;
    private int idUsuario;

    public ListChat() {

    }

    public ListChat(int c, String t, Date d, int u) {
        this.idChat = c;
        this.texto = t;
        this.data = d;
        this.idUsuario = u;
    }

    public ListChat(int id, int c, String t, Date d, int u) {
        this.id = id;
        this.idChat = c;
        this.texto = t;
        this.data = d;
        this.idUsuario = u;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public String getTextp() {
        return texto;
    }

    public void setTextp(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
