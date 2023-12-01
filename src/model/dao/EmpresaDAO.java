package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Empresa;



public class EmpresaDAO {
    
        public void create(Empresa e){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO empresa (rs, cnpj, email, senha) VALUES (?, ?, ?, ?)");
            stmt.setString(1, e.getRs());
            stmt.setString(2, e.getCnpj());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
            public boolean checkLogin(String email, String senha) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM empresa WHERE email = ? and senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                    
                check = true;
                
            } 
            
        } catch (SQLException ex) {
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }
}
