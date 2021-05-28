package com.jdbc.dao;

import com.jdbc.bean.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *Pseudo DAO (Data Access Objetc) para realizar as operações de CRUD -
 * expressão em língua Inglesa Create, Retrieve, Update e Delete.
 * <h1>ATENÇÃO! Para simplificar o entendimento, não foi aplicada o real pattern
 * DAO!!!!</h1>
 * 
 * @author owzi
 */
public class AlunoDAO {
    private Connection conn;
    
    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void create(Aluno aluno) throws SQLException {
        if (this.valida(aluno)) {
            String sql = "INSERT INTO aluno(matricula, nome, dtIngresso)" +
                    " VALUES (NEXTVAL('SEQALUNO'), ?, ?)";
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            java.sql.Date dtSQL = new java.sql.Date(aluno.getDtIngresso().getTime());
            pst.setDate(2, dtSQL);
            pst.executeUpdate();
            
            Statement st = this.conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT CURRVAL('SEQALUNO') FROM ALUNO");
             if (rs.next()) {
                aluno.setMatricula(rs.getInt(1));
            }
            rs.close();
            st.close();
            pst.close();
        }
    }
    
    public Aluno retrieve(Aluno aluno) throws SQLException {
        Aluno alunoRet = null;
        String sql = "SELECT * FROM aluno WHERE matricula=?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        pst.setInt(1, aluno.getMatricula());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            alunoRet = new Aluno();
            alunoRet.setMatricula(rs.getInt("matricula"));
            alunoRet.setNome(rs.getString("nome"));
            alunoRet.setDtIngresso(rs.getDate("dtingresso"));
        }
        rs.close();
        pst.close();
        return alunoRet;
    }
    
    public void update(Aluno aluno) throws SQLException {
        if (this.valida(aluno)) {
            String sql = "UPDATE Aluno SET nome=? , dtingresso=? WHERE matricula=?";
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            pst.setDate(2, new java.sql.Date(aluno.getDtIngresso().getTime()));
            pst.setInt(3, aluno.getMatricula());
            pst.executeUpdate();
            pst.close();
        }
    }
    
    public void delete(Aluno aluno) throws SQLException {
        String sql = "DELETE FROM ALUNO WHERE matricula=?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        pst.setInt(1, aluno.getMatricula());
        pst.executeUpdate();
        pst.close();
    }
    
    public List<Aluno> listaTodos() throws SQLException {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluno ORDER BY matricula";
        try (Statement st = this.conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getInt("matricula"), rs.getString("nome"), rs.getDate("dtingresso"));
                lista.add(aluno);
            }
        }
        return lista;
    }
    
    public boolean valida(Aluno aluno) {
        boolean ret = false;
        if (aluno != null) {
            ret = true;
        }
        return ret;
    }
}
