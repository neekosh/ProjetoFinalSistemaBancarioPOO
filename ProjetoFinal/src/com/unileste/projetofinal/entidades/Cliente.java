package com.unileste.projetofinal.entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private List<Conta> contas;

    public Cliente(String nome, String cpf, String endereco, List<Conta> contas) {
        if((this.nome == null)||(this.nome.equals(""))){
            JOptionPane.showMessageDialog(null,"Nome não pode ser vazio. Digite um nome válido");
        } else{
            this.nome = nome;
        }
        if((this.cpf == null)||(this.cpf.equals(""))){
            JOptionPane.showMessageDialog(null,"CPF não pode ser vazio. Digite um valor válido");
        } else{
            this.cpf = cpf;
        }
        this.endereco = endereco;
        this.contas = new ArrayList<Conta>();
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public List<Conta> getContas() {
        return contas;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void AdicionarConta(Conta conta){
        if (conta != null){
            contas.add(conta);
        }else{
            JOptionPane.showMessageDialog(null,"Não é possível adicionar uma conta nula ao cliente");
        }
    }
    @Override
    public boolean equals(Object o){
       if (this == o){
           return true;
       }
       if(!(o instanceof Cliente)){
           return false;
       }
       Cliente outro = (Cliente) o;
       return this.cpf.equals(outro.cpf);
    }

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }
    
    @Override
    public String toString(){
        return "Cliente{" +
                "nome='" +nome+ '\''+
                ", cpf='" +cpf+ '\''+
                ",endereço'" +endereco+ '\''+
                ", qtdContas=" +contas.size()+
                '}';
    }
}
