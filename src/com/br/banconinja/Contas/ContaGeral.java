package com.br.banconinja.Contas;

import java.util.Random;

public class ContaGeral {
    private int numero;
    public int operacao;
    private String cliente;
    private double saldo;
    private double limite;
    private double valorSacado;
    private String tipoConta;

    public ContaGeral(){
        this.setNumero(0);
        this.setCliente(" ");
        this.setSaldo(0);
        this.setLimite(0);
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public boolean saca(double qtd) {
        if(qtd > this.saldo) {
            return false;
        }else{
            this.saldo = this.saldo - qtd;
            this.valorSacado = qtd;
        }

        return true;
    }

    public void deposita(double qtd) {
        this.saldo += qtd;
    }

    public void insertData(String cliente, double saldo, double limite, String tipoConta){
        Random rand = new Random();
        this.cliente = cliente;
        this.numero = rand.nextInt(1200);
        this.saldo = saldo;
        this.limite = limite;
        this.tipoConta = tipoConta;
    }

    String getTipoConta(){
        return this.tipoConta;
    }

    public void getDados(){
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|               DADOS DA CONTA BANCÁRIA                 |");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|Cliente da conta: " + this.getCliente());
        System.out.println("|Tipo da conta: " + this.getTipoConta());
        System.out.println("|Numero da conta: " + this.getNumero());
        System.out.println("|Saldo atual: R$ " + this.getSaldo());
        System.out.println("|Limite Inicial: R$ " + this.getLimite());
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|                     BANCO NINJA                       |");
        System.out.println("|-------------------------------------------------------|");
    }

    public void getExtratoSaldo(){
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|               DADOS DA CONTA BANCÁRIA                 |");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|Cliente da conta: " + this.getCliente());
        System.out.println("|Numero da conta: " + this.getNumero());
        System.out.println("|Valor Sacado: " + this.valorSacado);
        System.out.println("|Saldo Atual: " + this.getSaldo());
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|                     BANCO NINJA                       |");
        System.out.println("|-------------------------------------------------------|");
    }


}
