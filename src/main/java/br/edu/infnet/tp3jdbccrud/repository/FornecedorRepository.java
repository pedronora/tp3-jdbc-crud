package br.edu.infnet.tp3jdbccrud.repository;

import br.edu.infnet.tp3jdbccrud.model.Fornecedor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FornecedorRepository {

    private final JdbcTemplate jdbcTemplate;

    public FornecedorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Fornecedor save(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedores (id, nome, cnpj, email) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, fornecedor.getId(), fornecedor.getNome(), fornecedor.getCnpj(), fornecedor.getEmail());
        return fornecedor;
    }

    public Fornecedor findById(Long id) {
        String sql = "SELECT * FROM fornecedores WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Fornecedor(rs.getLong("id"), rs.getString("nome"), rs.getString("cnpj"), rs.getString("email")));
    }

    public List<Fornecedor> findAll() {
        String sql = "SELECT * FROM fornecedores";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Fornecedor(rs.getLong("id"), rs.getString("nome"), rs.getString("cnpj"), rs.getString("email")));
    }

    public Fornecedor update(Fornecedor fornecedor) {
        String sql = "UPDATE fornecedores SET nome = ?, cnpj = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, fornecedor.getNome(), fornecedor.getCnpj(), fornecedor.getEmail(), fornecedor.getId());
        return fornecedor;
    }


    public int deleteById(Long id) {
        String sql = "DELETE FROM fornecedores WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
