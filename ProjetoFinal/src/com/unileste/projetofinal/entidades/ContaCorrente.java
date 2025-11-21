package com.unileste.projetofinal.entidades;

import com.unileste.projetofinal.utilitarios.SaldoInsuficienteException;
import javax.swing.JOptionPane;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String numero, Cliente proprietario, double limiteChequeEspecial) {
        super(numero, proprietario);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
    
    @Override
    public void depositar(double valor){
        if (valor <= 0){
            JOptionPane.showMessageDialog(null,"Valor de depósito inválido. Use um valor maior que zero");
        } else {
            saldo += valor;
        }
        adicionarTransacao("Déposito de R$ "+valor);
    }
    
    @Override
    public void sacar(double valor)throws SaldoInsuficienteException{
        if (valor <= 0){
            JOptionPane.showMessageDialog(null,"Valor de saque inválido. Use um valor maior que zero");
            return;
        }
        double limiteDisponivel = saldo + limiteChequeEspecial;
        if (valor > limiteDisponivel){
            JOptionPane.showMessageDialog(null,"Valor de saque insuficiente. Limite disponível: "+limiteDisponivel);
        } else {
            saldo -= valor;
            adicionarTransacao("Saque de R$ "+valor);
        }
    }
    
    @Override
    public void transferir(Conta destino, double valor)throws SaldoInsuficienteException{
        if (destino == null){
            JOptionPane.showMessageDialog(null,"Conta destino não encontrada");
            return;
        }
        if (valor <= 0.0){
            JOptionPane.showMessageDialog(null,"Valor de transferência inválido. Use um valor maior que zero");
            return;
        } 
    }
}
