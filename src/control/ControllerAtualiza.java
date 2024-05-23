/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Bitcoin;
import model.Ethereum;
import model.Investidor;
import model.Ripple;
import view.Atualizacao;

// Esse controller ele atualiza os valores das cotacoes na view.
// ele pega os valores da carteira do usuario e com a funcao de atualizar cotacao
// ele consegue alterar os valores e altera na carteira tambem.

public class ControllerAtualiza {
    private Atualizacao view;
    private Investidor investidor;

    public ControllerAtualiza(Atualizacao view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void atualizaLabels(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                Bitcoin bt = investidor.getCarteira().getSaldoBitcoin();
                bt.atualizarCotacao();
                view.getBitcoin().setText(String.valueOf(bt.getCotacao()));
                Ethereum et = investidor.getCarteira().getSaldoEthereum();
                et.atualizarCotacao();
                view.getEthereum().setText(String.valueOf(et.getCotacao()));
                Ripple rp = investidor.getCarteira().getSaldoRipple();
                rp.atualizarCotacao();
                view.getRipple().setText(String.valueOf(rp.getCotacao()));
            }
        }catch (SQLException e){
        
        }
    }
}
