package br.com.fiap.checkpoint1.model;

import javax.persistence.*;

@Entity
@Table(name = "TAB_FUNCIONARIO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_funcionario", discriminatorType = DiscriminatorType.STRING)
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "horas_trabalhadas")
    private int horasTrabalhadas;

    @Column(name = "valor_por_hora")
    private double valorPorHora;

    public Funcionario() {
    }

    public Funcionario(String nome, int horasTrabalhadas, double valorPorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    public Funcionario(int i, String carlos, int i1, double v) {
    }

    public double calcularSalario() {
        return horasTrabalhadas * valorPorHora;
    }

    public void imprimirInformacao() {
        System.out.println("Funcionário: " + nome);
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por Hora: R$" + valorPorHora);
        System.out.println("Salário Final: R$" + calcularSalario());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }
}
