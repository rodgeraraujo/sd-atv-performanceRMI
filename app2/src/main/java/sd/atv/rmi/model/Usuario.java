package sd.atv.rmi.model;

import com.sun.org.apache.bcel.internal.generic.LineNumberGen;
import sun.rmi.runtime.Log;

public class Usuario {

    private Long id;
    private String nome;
    private boolean atualizado;
    private boolean deletado;

    public Usuario(){

    }

    public Usuario(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Usuario(Long id, String nome, boolean atualizado, boolean deletado) {
        this.id = id;
        this.nome = nome;
        this.atualizado = atualizado;
        this.deletado = deletado;
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

    public boolean isAtualizado() {
        return atualizado;
    }

    public void setAtualizado(boolean atualizado) {
        this.atualizado = atualizado;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", atualizado=" + atualizado +
                ", deletado=" + deletado +
                '}';
    }
}
