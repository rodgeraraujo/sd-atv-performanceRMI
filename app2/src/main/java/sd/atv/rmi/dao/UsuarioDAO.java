package sd.atv.rmi.dao;

import sd.atv.rmi.database.ConFactory;
import sd.atv.rmi.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection con;

    public UsuarioDAO() throws SQLException {
        this.con= ConFactory.getConnection();
    }

    public void inserir (Usuario usuario) {
        String sql = "insert into usuario (id, nome, atualizado, deletado) values (?,?,?,?)";
        try {
            PreparedStatement statement = null;
            statement = con.prepareStatement(sql);
            statement.setLong(1, usuario.getId());
            statement.setString(2, usuario.getNome() + usuario.getId());
            statement.setBoolean(3, false);
            statement.setBoolean(4, false);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nao possivel salvar o usuario no banco de dados: ");
            e.printStackTrace();
        }
    }

    public void atualizar (Long id) {
        String sql = "update usuario set atualizado=? where id=?";
        try {
            PreparedStatement statement = null;
            statement = con.prepareStatement(sql);
            statement.setBoolean(1, true);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nao possivel atualizar o usuario no banco de dados: ");
            e.printStackTrace();
        }
    }

    public void deletar (Long id) {
        try {
            String sql = "update usuario set deletado=? where id=?";
            PreparedStatement statement = null;
            statement = con.prepareStatement(sql);
            statement.setBoolean(1, true);
            statement.setLong(2, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
