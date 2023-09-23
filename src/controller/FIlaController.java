package controller;

import model.Cliente;
import model.Queue;

import javax.swing.*;

public class FIlaController {
    /*
        Cliente c1 = new Cliente(1,"Jefferson");
        Cliente c2 = new Cliente(2,"Gabriel");
        Cliente c3 = new Cliente(3,"Steve");
        Cliente c4 = new Cliente(10,"Cleyton");
        Cliente c5 = new Cliente(11,"Roberto");
        Cliente c6 = new Cliente(12,"Jose");
     */
    public void Inserir(Queue<Cliente> fila, Queue<Cliente> filaPrioritaria) {
        Cliente cliente = new Cliente();
        cliente.nome = JOptionPane.showInputDialog("Informe o nome do cliente");
        String choice = JOptionPane.showInputDialog("Gerar senhar para fila normal ou prioritaria?\n1- Normal\n2- Prioritária");

        switch (choice) {
            case "1" -> GerarSenhaNormal(cliente, fila);
            case "2" -> GerarSenhaPrioritario(cliente, filaPrioritaria);
            default -> JOptionPane.showMessageDialog(null, "Valor inválido.");
        }
    }


    // Pos 0 = senha original
    // Pos 1 = senha incrementada
    int[] senha = {1, 1};
    int[] senhaP = {100, 100};

    private void GerarSenhaNormal(Cliente cliente, Queue<Cliente> fila) {
        //Senhas normais 1 - 99;

        cliente.numero = senha[1];
        senha[1] += 1;
        fila.insert(cliente);
    }

    private void GerarSenhaPrioritario(Cliente cliente, Queue<Cliente> filaPrioritaria) {
        //Senhas priotarias 100 - 999;
        cliente.numero = senhaP[1];
        senhaP[1] += 1;
        filaPrioritaria.insert(cliente);
    }

    int contChamadas = 1;

    public void Chamada(Queue<Cliente> fila, Queue<Cliente> filaPrioritaria) throws Exception {

        if (contChamadas <= 3) {
            if (filaPrioritaria != null) {
                ChamadaPrioritaria(filaPrioritaria);
            } else{
                ChamadaNormal(fila);
                contChamadas=1;
            }
        } else {
            if (fila != null) {
                ChamadaNormal(fila);
                contChamadas=1;
            } else {
                ChamadaPrioritaria(filaPrioritaria);
            }
        }

        contChamadas += 1;
    }


    private void ChamadaNormal(Queue<Cliente> fila) throws Exception {
        JOptionPane.showMessageDialog(null, "Senha chamada: " + senha[0]);
        senha[0]++;
        JOptionPane.showMessageDialog(null, "Pessoa chamada: " + fila.remove());
    }

    private void ChamadaPrioritaria(Queue<Cliente> filaPrioritaria) throws Exception {
        JOptionPane.showMessageDialog(null, "Senha Prioritaria chamada: " + senhaP[0]);
        senhaP[0]++;
        JOptionPane.showMessageDialog(null, "Pessoa Prioritaria chamada: " + filaPrioritaria.remove());
    }

    public void Listar(Queue<Cliente> fila, Queue<Cliente> filaPrioritaria) throws Exception {
        String choice = JOptionPane.showInputDialog("Qual Fila deseja listar?\n1- Fila normal\n2- Fila prioritária");
        switch (choice) {
            case "1" -> fila.list();
            case "2" -> filaPrioritaria.list();
            default -> JOptionPane.showMessageDialog(null, "Valor inválido");
        }
    }
}
