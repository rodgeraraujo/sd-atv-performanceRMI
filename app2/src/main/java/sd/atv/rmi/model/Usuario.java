package sd.atv.rmi.model;

public class Usuario {

    private int id;
    private String nome;
    private boolean atualizado;
    private boolean deletado;

    public Usuario() {

    }

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Usuario(int id, String nome, boolean atualizado, boolean deletado) {
        this.id = id;
        this.nome = nome;
        this.atualizado = atualizado;
        this.deletado = deletado;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
