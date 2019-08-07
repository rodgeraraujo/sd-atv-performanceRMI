package sd.atv.rmi;

import sd.atv.rmi.dao.UsuarioDAO;
import sd.atv.rmi.interfaces.Identity;
import sd.atv.rmi.model.Usuario;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
//import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class App1 {
    private static String APP_NAME;
    private static int TAMANHO_DA_FILA;
    private static int EXECUCOES = 0;
    private static volatile int QUANTIDADE = 0;

    public static void main(String[] args) throws InterruptedException, IOException, NotBoundException, SQLException {


        APP_NAME = "app1";
        TAMANHO_DA_FILA = 10;

        System.out.println("Executando cliente " + APP_NAME);

        final UsuarioDAO dao = new UsuarioDAO();

        // buscar por um novo registro
        Registry registry = LocateRegistry.getRegistry();

        // Retorna uma referência remota para o nome especificado nesse registro - espcificado no servidor
        Identity identity = (Identity) registry.lookup("identity");

        // "busca" um novo identificador unico no metodo do identity manager
        int contador = identity.getIdentity(APP_NAME);

        // Limite max de inserçoes, atualizaçoes e remoçoes
        final int limite = 1000;

        // Salva o tempo inicil, para calculo posterior
        final long tempoInicial = System.currentTimeMillis();

        // Cria uma instancia das filas compartilhadas, para inserir, atualizar e remover
//        final BlockingQueue<Integer> inserir = new ArrayBlockingQueue<Integer>(TAMANHO_DA_FILA);
        final BlockingQueue<Integer> inserir = new LinkedBlockingQueue<Integer>(TAMANHO_DA_FILA);
        final BlockingQueue<Integer> atualizar = new LinkedBlockingQueue<Integer>(TAMANHO_DA_FILA);
        final BlockingQueue<Integer> deletar = new LinkedBlockingQueue<Integer>(TAMANHO_DA_FILA);

        while (EXECUCOES <= limite) {

            EXECUCOES++;

            inserir.put(contador);

            // Criaçao de tres threads, cada uma com uma funçao especifica

            //inserir usuario na tabela do banco de dados
            Runnable inserirUsuario = new Runnable() {
                public void run() {
                    try {
                        Integer identificador = inserir.take();
                        Usuario user = new Usuario(identificador, "Usuario " + identificador);
                        dao.inserir(user);
                        atualizar.put(identificador);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            //atualizar usuario na tabela do banco de dados
            Runnable atualizarUsuario = new Runnable() {
                public void run() {
                    try {
                        Integer identificador = atualizar.take();
                        dao.atualizar(identificador);
                        deletar.put(identificador);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            //deletar usuario na tabela do banco de dados
            Runnable deletarUsuario = new Runnable() {
                public void run() {
                    try {
                        Integer identificador = deletar.take();
                        dao.deletar(identificador);
                        QUANTIDADE++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            // Cria e inicia cada thread
            Thread thread1 = new Thread(inserirUsuario);
            Thread thread2 = new Thread(atualizarUsuario);
            Thread thread3 = new Thread(deletarUsuario);

            thread1.start();
            thread2.start();
            thread3.start();

            // "busca" um novo identificador
            contador = identity.getIdentity(APP_NAME);

        }

        // Calcula a duraçao total, das tres chamadas (inserir, atualizar e deletar) "pegando" um id no servidor
        while (true) {
            if (EXECUCOES == QUANTIDADE) {
                long tempoFinal = System.currentTimeMillis();
                long tempoTotal = tempoFinal - tempoInicial;
                System.out.println(APP_NAME + " teve duraçao de " + tempoTotal + "ms");
                break;
            }
        }
    }

}