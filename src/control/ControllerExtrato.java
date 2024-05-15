//package control;
//
//import DAO.Conexao;
//import DAO.PessoaDAO;
//import java.security.Timestamp;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import model.Investidor;
//import view.Extrato;
//import model.Pessoa;
//
//public class ControllerExtrato {
//    private Extrato view;
//    private Investidor investidor;
//
//    public ControllerExtrato(Extrato view, Investidor investidor) {
//        this.view = view;
//        this.investidor = investidor;
//    }
//    
////    public void mostrarExtrato(){
//////        Conexao conexao = new Conexao();
//////        try{
//////            Connection conn = conexao.getConnection();
//////            PessoaDAO dao = new PessoaDAO(conn);
//////            ResultSet res = dao.consultar(investidor);
//////            //ResultSet res2 = dao.consultarID();
//////            if(res.next()){
//////                double id = res.getDouble("id");
//////                double id_pessoa = res.getDouble("id_pessoa");
//////                System.out.println(id_pessoa);
//////                System.out.println("a");
//////            }   
//////        }catch (SQLException e){
//////        }
////
////    }
////}
//
//    public void mostrarExtrato() {
//        Conexao conexao = new Conexao();
//        try {
//            Connection conn = conexao.getConnection();
//            PessoaDAO dao = new PessoaDAO(conn);
//            Pessoa pessoa = new Pessoa();
//            double idPessoa = Double.parseDouble(pessoa.getId()); 
//            ResultSet res = dao.consultarExtrato(idPessoa);
//            StringBuilder extrato = new StringBuilder();
//            while (res.next()) {
//                int id = res.getInt("id");
//                java.sql.Timestamp data = res.getTimestamp("data");
//                boolean tipo = res.getBoolean("tipo");
//                double valor = res.getDouble("valor");
//                double cotacao = res.getDouble("cotacao");
//                String nomeMoeda = res.getString("nome_moeda");
//                double real = res.getDouble("real");
//                double bitcoin = res.getDouble("bitcoin");
//                double ethereum = res.getDouble("ethereum");
//                double ripple = res.getDouble("ripple");
//
//                extrato.append("ID: ").append(id).append("\n")
//                       .append("Data: ").append(data).append("\n")
//                       .append("Tipo: ").append(tipo).append("\n")
//                       .append("Valor: ").append(valor).append("\n")
//                       .append("Cotacao: ").append(cotacao).append("\n")
//                       .append("Moeda: ").append(nomeMoeda).append("\n")
//                       .append("Real: ").append(real).append("\n")
//                       .append("Bitcoin: ").append(bitcoin).append("\n")
//                       .append("Ethereum: ").append(ethereum).append("\n")
//                       .append("Ripple: ").append(ripple).append("\n\n");
//            }
//            view.getTextarea().setText(extrato.toString());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }}
