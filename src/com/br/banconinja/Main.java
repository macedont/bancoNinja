package com.br.banconinja;

import com.br.banconinja.Contas.Corrente;
import com.br.banconinja.Contas.Poupanca;

import java.util.Scanner;

public class Main {
    //TODO refatorar a chamada das classes para remover os ifs
    public static void main(String[] args) {
        int operacao, tpConta = 0;
        double saldo, valor, limite, saque;
        String nome;

        Poupanca poupanca = new Poupanca();
        Corrente corrente = new Corrente();
        Scanner leitura = new Scanner(System.in);
        do {
            System.out.println("+------------------------------------------------------+");
            System.out.println("|               ABERTURA DE CONTA BANCÁRIA             |");
            System.out.println("|------------------------------------------------------|");
            System.out.println("|    1 - Abrir Conta       |    2 - Visualizar Dados   |");
            System.out.println("|------------------------------------------------------|");
            System.out.println("|                   OPERAÇÕES DA CONTA                 |");
            System.out.println("|------------------------------------------------------|");
            System.out.println("|    3 - Depositar         |    4 - Sacar              |");
            System.out.println("|------------------------------------------------------|");
            System.out.println("|    5 - Emitir Extrato    |    0 - Finalizar          |");
            System.out.println("+------------------------------------------------------+");
            leitura.nextLine();
            operacao = leitura.nextInt();

            switch (operacao) {
                case 1:
                    System.out.println("Informe seu Nome: ");
                    nome = leitura.next();

                    System.out.println("Informe o Saldo Inicial: ");
                    saldo = leitura.nextDouble();

                    System.out.println("Informe o Limite Desejado: ");
                    limite = leitura.nextDouble();

                    System.out.println("Informe o Tipo da Conta: 1 - Poupança | 2 - Corrente");
                    tpConta = leitura.nextInt();
                    if(tpConta == 1){
                        poupanca.insertData(nome, saldo, limite, "Poupança");
                    }else{
                        corrente.insertData(nome, saldo, limite, "Corrente");
                    }

                    break;
                case 2:
                    if(tpConta == 1){
                        poupanca.getDados();
                    }else{
                        corrente.getDados();
                    }
                    break;
                case 3:
                    System.out.println("Informe o valor de depósito: ");
                    valor = leitura.nextDouble();

                    System.out.println("O valor de R$ " + valor + " foi depositado em sua conta");
                    if (tpConta == 1){
                        poupanca.deposita(valor);
                    }else{
                        corrente.deposita(valor);
                    }
                    break;
                case 4:
                    System.out.println("Informe o Valor que deseja sacar: ");
                    saque = leitura.nextDouble();
                    boolean rs;
                    if(tpConta == 1){
                        rs = poupanca.saca(saque);
                    }else{
                        rs = corrente.saca(saque);
                    }
                    if (!rs) {
                        System.out.println("Valor não disponível.");
                    } else {
                        System.out.println("Saque realizado");
                    }
                    break;
                case 5:
                    if(tpConta == 1){
                        poupanca.getExtratoSaldo();
                    }else{
                        corrente.getExtratoSaldo();
                    }

                    break;
            }
        } while (operacao != 0);
    }
}
