package gui;
import model.Caixa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMovimento extends JFrame implements ActionListener {
    private Label lblValor, lblSaldo;

    private TextField txtValor, txtSaldo;

    private Button cmdEntrada, cmdRetirada, cmdConsulta, cmdSair;

    private TextArea txtMsg;

    private Dimension dFrame, dLabel, dTextField, dTextArea, dButton;

    private Caixa caixa;

    public TelaMovimento() {
        caixa = new Caixa();
        dLabel = new Dimension(40,20) ;
        dFrame = new Dimension(350,400);
        dTextField = new Dimension(150,20);
        dButton = new Dimension(95,20);
        dTextArea = new Dimension(300,140);

        setTitle("Controle de Caixa");
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(dFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lblValor = new Label("Valor");
        lblValor.setSize(dLabel);
        lblValor.setLocation(25,50);
        add(lblValor);

        lblSaldo = new Label("Saldo");
        lblSaldo.setSize(dLabel);
        lblSaldo.setLocation(25,80);
        add(lblSaldo);

        txtValor = new TextField(null);
        txtValor.setSize(dTextField);
        txtValor.setLocation(75,50);
        add(txtValor);

        txtSaldo = new TextField(null);
        txtSaldo.setSize(dTextField);
        txtSaldo.setLocation(75,80);
        add(txtSaldo);

        cmdEntrada = new Button("Entrada");
        cmdEntrada.setSize(dButton);
        cmdEntrada.setLocation(25,150);
        cmdEntrada.addActionListener(this);
        add(cmdEntrada);

        cmdRetirada = new Button("Retirada");
        cmdRetirada.setSize(dButton);
        cmdRetirada.setLocation(225,150);
        cmdRetirada.addActionListener(this);
        add(cmdRetirada);

        cmdConsulta = new Button("Consulta");
        cmdConsulta.setSize(dButton);
        cmdConsulta.setLocation(25,185);
        cmdConsulta.addActionListener(this);
        add(cmdConsulta);

        cmdSair = new Button("Sair");
        cmdSair.setSize(dButton);
        cmdSair.setLocation(225,185);
        cmdSair.addActionListener(this);
        add(cmdSair);

        txtMsg = new TextArea(null);
        txtMsg.setSize(dTextArea);
        txtMsg.setLocation(25,220);
        add(txtMsg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cmdEntrada){
            double valor = Double.parseDouble(txtValor.getText());
            String retorno = caixa.depositar(valor);
            txtMsg.append(retorno);
            txtMsg.append("\n");
            txtValor.setText(null);
            txtValor.requestFocus();
        }
        if(e.getSource()==cmdSair){
            System.exit(0);
        }
        if(e.getSource()==cmdRetirada){
            double valor = Double.parseDouble(txtValor.getText());
            String retorno = caixa.sacar(valor);
            txtMsg.append(retorno);
            txtMsg.append("\n");
            txtValor.setText(null);
            txtValor.requestFocus();
        }

        if(e.getSource()==cmdConsulta){
            txtSaldo.setText(Double.toString(caixa.getSaldo()));
            txtMsg.append("Saldo consultado no momento R$");
            txtMsg.append(txtSaldo.getText() + "\n");
        }
    }
}
