/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.ListChat;
import java.util.List;

public interface ListChatController {
    public List<ListChat> Lista(int idChat);
    public boolean salvar(ListChat c);
    public int idPrincial(int id, int i);
    
}
