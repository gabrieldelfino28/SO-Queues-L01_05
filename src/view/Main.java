package view;

import controller.FIlaController;
import model.Cliente;
import model.Queue;

import javax.swing.*;

public class Main {
    // Chamada Simulação
    // Tabelas de Espalhamento?
    public static void main(String[] args) {

        FIlaController fc = new FIlaController();
        Queue<Cliente> fila = new Queue<>();
        Queue<Cliente> filaPrioritaria = new Queue<>();
        String menu = "";

        //Passwords start:
        // 1 - 10 normal
        // 10 - etc - prioritario

        do {
            menu = JOptionPane.showInputDialog("Simulador de Fila e Senhas\n1- Inserir\n2- Chamado\n3- Listar Fila\n9- Fim");
            try {
                switch (menu) {
                    case "1":
                        fc.Inserir(fila, filaPrioritaria);
                        break;
                    case "2":
                        fc.Chamada(fila, filaPrioritaria);
                        break;
                    case "3":
                        fc.Listar(fila, filaPrioritaria);
                        break;
                    case "9":
                        ConfirmDialog();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Valor inválido");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (true);

    }

    private static void ConfirmDialog() {
        String confirm = JOptionPane.showInputDialog("Deseja mesmo sair?\n1- Sim\n2- Não");
        switch (confirm) {
            case "1" -> System.exit(1);
            case "2" -> JOptionPane.showMessageDialog(null, "Retornando");
        }
    }

}
