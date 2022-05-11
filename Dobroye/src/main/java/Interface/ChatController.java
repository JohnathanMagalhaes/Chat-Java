/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.Chat;

/**
 *
 * @author Johnathan
 */
public interface ChatController {

    public boolean salvar(Chat c);

    public Chat consulta(int p, int s);
    
    public boolean verificarExiste(int p, int s);
}
