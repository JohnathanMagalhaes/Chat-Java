package View;

import Dao.ChatDao;
import Dao.ListChatDao;
import Model.ListChat;
import Interface.ChatController;
import Interface.ListChatController;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Mensagem extends javax.swing.JFrame {

    final ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor();

    public Mensagem() {
        initComponents();
        txtNome.setText(Index.UsuarioSegundario.getNome());

        Callable<Void> task = new Callable() {
            @Override
            public Void call() {
                try {
                    CarregarMensagem();
                } finally {
                    // Schedule same task to run again (even if processing fails).
                    execService.schedule(this, 1, TimeUnit.SECONDS);
                }
                return null;
            }
        };

        try {
            task.call();
        } catch (Exception ex) {
            Logger.getLogger(Mensagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listMensagem = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        panel1 = new java.awt.Panel();
        txtNome = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(listMensagem);

        txtTexto.setColumns(20);
        txtTexto.setRows(2);
        jScrollPane2.setViewportView(txtTexto);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        txtNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNome.setText("Nome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(txtNome)
                .addGap(38, 38, 38))
        );

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    DefaultListModel dlm = new DefaultListModel();

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int p = Login.usuarioLogado.getIdUsuario();
        int s = Index.UsuarioSegundario.getIdUsuario();

        ChatController chat = new ChatDao();
        Model.Chat c = new Model.Chat() {
        };

        c.setIdUsuarioP(p);
        c.setIdUsuarioS(s);

        if (chat.verificarExiste(p, s) == true) {
            Model.Chat ch = chat.consulta(p, s);

            ListChatController lista = new ListChatDao();
            ListChat list = new ListChat() {
            };
            list.setIdChat(ch.getId());
            list.setTextp(txtTexto.getText());
            Date data = new Date(System.currentTimeMillis());
            list.setData(data);
            list.setIdUsuario(p);

            lista.salvar(list);

            CarregarMensagem();
            txtTexto.setText("");
        } else {
            boolean resultado = chat.salvar(c);

            if (resultado == true) {
                Model.Chat ch = chat.consulta(p, s);

                ListChatController lista = new ListChatDao();
                ListChat list = new ListChat() {
                };
                list.setIdChat(ch.getId());
                list.setTextp(txtTexto.getText());
                Date data = new Date(System.currentTimeMillis());
                list.setData(data);
                list.setIdUsuario(p);

                lista.salvar(list);

                CarregarMensagem();
                txtTexto.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao enviar a Mensagem!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void CarregarMensagem() {

        int p = Login.usuarioLogado.getIdUsuario();
        int s = Index.UsuarioSegundario.getIdUsuario();
        String nomeP = Login.usuarioLogado.getNome();
        String nomeS = Index.UsuarioSegundario.getNome();

        ChatController chat = new ChatDao();

        Model.Chat ch = chat.consulta(p, s);

        DefaultListModel list = new DefaultListModel();
        ListChatController usu = new ListChatDao();
        List<ListChat> Listmsg = usu.Lista(ch.getId());

        Iterator<ListChat> it = Listmsg.iterator();
        while (it.hasNext()) {
            ListChat x = it.next();
            if (usu.idPrincial(x.getIdUsuario(), ch.getId()) == p) {
                list.addElement(nomeP + ": " + x.getTextp());
            } else {
                list.addElement(nomeS + ": " + x.getTextp());
            }
        }

        listMensagem.setModel(list);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mensagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mensagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mensagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mensagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mensagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listMensagem;
    private java.awt.Panel panel1;
    private javax.swing.JLabel txtNome;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}
