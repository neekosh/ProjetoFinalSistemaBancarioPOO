package com.unileste.projetofinal.entidades;

import com.unileste.projetofinal.utilitarios.SaldoInsuficienteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public abstract class Conta {
    private String numero;
    protected double saldo;
    private Cliente proprietario;
    private List<String> historicoTransacoes;

    public Conta(String numero, Cliente proprietario) {
        if ((this.numero == null)||(this.numero.equals(""))){
            JOptionPane.showMessageDialog(null,"Número não pode ser nulo ou vazio. Digite um número válido");
        } else{
            this.numero = numero;
        }
        if ((this.proprietario == null)||(this.proprietario.equals(""))){
            JOptionPane.showMessageDialog(null,"Número não pode ser nulo ou vazio. Digite um número válido");
        } else{
            this.proprietario = proprietario;
        }
        proprietario.AdicionarConta(this);
        this.saldo = 0.0;
        this.historicoTransacoes = new ArrayList<String>();
    }

    public String getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public Cliente getProprietario() {
        return proprietario;
    }
    public List<String> getHistoricoTransacoes() {
        return historicoTransacoes;
    }
    
    protected void adicionarTransacao(String descricao){
        if (descricao != null && descricao.equals("")){
            historicoTransacoes.add(descricao);
        } else {
            JOptionPane.showMessageDialog(null,"Descrição de transação vazia ou nula");
        }
    }
    
    public abstract void depositar(double valor);
    public abstract void sacar(double valor) throws SaldoInsuficienteException;
    public abstract void transferir(Conta destino, double valor) throws SaldoInsuficienteException;
    
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta outra = (Conta) o;
        return numero.equals(outra.numero);
    }
    @Override
    public int hashCode(){
        return numero.hashCode();
    }
    @Override
    public String toString(){
        return "Conta{" +
                "numero='" +numero+ '\'' +
                ",saldo" + String.format("%.2f", saldo) +
                ",proprietario=" + (proprietario != null ? proprietario.getNome() : "Sem Cliente") +
                '}';
    }
}
