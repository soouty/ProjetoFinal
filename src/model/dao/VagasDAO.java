package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Vagas;





public class VagasDAO {
    
        public void create(Vagas v){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO vagas (empresa, vaga, descricao) VALUES (?, ?, ?)");
            stmt.setString(1, v.getEmpresa());
            stmt.setString(2, v.getVaga());
            stmt.setString(3, v.getDesc());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
        public List<Vagas> read() {
        
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Vagas> vaga = new ArrayList<>();
            
            try {
                
                stmt = con.prepareStatement("SELECT * FROM vagas");
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                
                    Vagas vagas = new Vagas();
                    vagas.setEmpresa(rs.getString("empresa"));
                    vagas.setVaga(rs.getString("vaga"));
                    vagas.setDesc(rs.getString("descricao"));
                    vaga.add(vagas);
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(VagasDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            
            return vaga;
        } 
    
}
