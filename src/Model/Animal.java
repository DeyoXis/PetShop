/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rafael
 */
public class Animal {
    String Raca, Cor, Tamanho, Nascimento, Nome, Obs;
    int id;

    public Animal(String Raca, String Cor, String Tamanho, String Nascimento, String Nome, String Obs, int id) {
        this.Raca = Raca;
        this.Cor = Cor;
        this.Tamanho = Tamanho;
        this.Nascimento = Nascimento;
        this.Nome = Nome;
        this.Obs = Obs;
        this.id = id;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String Raca) {
        this.Raca = Raca;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String Tamanho) {
        this.Tamanho = Tamanho;
    }

    public String getNascimento() {
        return Nascimento;
    }

    public void setNascimento(String Nascimento) {
        this.Nascimento = Nascimento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
