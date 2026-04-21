package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por estabelecer a conexão com a base de dados MySQL.
 * Contém os dados de acesso ao servidor e métodos para obter e testar
 * a ligação à base de dados.
 *
 * @author Leonardo
 */
public class ConexaoBD {

    // ================= CONFIGURAÇÕES DO SERVIDOR =================

    // Endereço do servidor MySQL
    private static final String HOST = "62.28.39.135";

    // Porta padrão do MySQL
    private static final String PORT = "3306";

    // Nome da base de dados
    private static final String DATABASE = "efa0125_06_GestaoDeReservas";

    // ================= CREDENCIAIS DE ACESSO =================

    // Utilizador da base de dados
    private static final String USER = "efa0125";

    // Palavra-passe do utilizador
    private static final String PASSWORD = "123.Abc";

    // ================= STRING DE CONEXÃO =================

    // URL completa de conexão JDBC com parâmetros adicionais
    // useSSL=false → desativa SSL
    // allowPublicKeyRetrieval=true → permite recuperação de chave pública
    // serverTimezone=UTC → define fuso horário
    // characterEncoding=utf8 → define codificação
    private static final String URL =
            "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE +
            "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC" +
            "&characterEncoding=utf8";

    /**
     * Abre e retorna uma conexão com o MySQL.
     *
     * @return Connection ativa com a base de dados
     * @throws SQLException caso ocorra erro na ligação
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Método auxiliar para testar rapidamente a conexão.
     *
     * @return true se a conexão for estabelecida com sucesso,
     *         false caso ocorra erro
     */
    public static boolean testarConexao() {
        try (Connection conn = getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao MySQL: " + e.getMessage());
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}