package analisadorlexico;

import java.io.StringReader;
import javax.swing.JTextArea;

public class Interface extends javax.swing.JFrame {
    
    public JTextArea jText;
    
    public void execute() throws Exception {

        int count = 1;

        jText = jTextArea1;
        String aux;

        aux = (String)jText.getText();
        Lexico lexico = new Lexico(new StringReader(aux));
        
			
	String resultado="";

        while (true) {
            Token tokens = lexico.yylex();
            if (tokens == null) {

                jTextArea2.setText(resultado);

                return;
            }
            
            switch (tokens) {

                case LINHA:
                    count++;
                    break;
                
                case PALAVRA_RESERVADA:
                    resultado = resultado + "Linha: " + count + " PALAVRA_RESERVADA " + lexico.lexeme + "\n";
                    break;

                case IDENTIFICADOR:
                    resultado = resultado + "Linha: " + count + " IDENTIFICADOR " + lexico.lexeme + "\n";
                    break;

                case NUMERO_INTEIRO:
                    resultado = resultado + "Linha: " + count + " NUMERO_INTEIRO " + lexico.lexeme + "\n";
                    break;

                case NUMERO_REAL:
                    resultado = resultado + "Linha: " + count + " NUMERO_REAL " + lexico.lexeme + "\n";
                    break;

                case DELIMITADORES:
                    resultado = resultado + "Linha: " + count + " DELIMITADORES " + lexico.lexeme + "\n";
                    break;

                case ATRIBUICAO:
                    resultado = resultado + "Linha: " + count + " ATRIBUICAO " + lexico.lexeme + "\n";
                    break;

                case RELACIONAL:
                    resultado = resultado + "Linha: " + count + " RELACIONAL " + lexico.lexeme + "\n";
                    break;

                case ADITIVO:
                    resultado = resultado + "Linha: " + count + " ADITIVO " + lexico.lexeme + "\n";
                    break;

                case MULTIPLICATIVO:
                    resultado = resultado + "Linha: " + count + " MULTIPLICATIVO " + lexico.lexeme + "\n";
                    break;

                case ERROR:
                    resultado = resultado + "erro na Linha: " + count + " simbolo não pertece a linguagem \n";
                    break;

                default:
                    resultado = resultado + "Linha: " + count + "<" + lexico.lexeme + ">" + count++;
                    break; 
            }
        }
}

    public Interface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Analisar = new javax.swing.JButton();
        Limpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Analisar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Analisar.setText("Analisar");
        Analisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalisarActionPerformed(evt);
            }
        });

        Limpar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Limpar.setText("Limpar");
        Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Analisar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Limpar)
                        .addGap(0, 190, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Analisar)
                    .addComponent(Limpar))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalisarActionPerformed
        try {
            execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_AnalisarActionPerformed

    private void LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparActionPerformed
        jTextArea1.setText("");
        jTextArea2.setText("");
    }//GEN-LAST:event_LimparActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Analisar;
    private javax.swing.JButton Limpar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
