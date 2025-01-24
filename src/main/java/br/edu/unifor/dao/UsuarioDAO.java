package br.edu.unifor.dao;

import br.edu.unifor.dto.AlunoDTO;
import br.edu.unifor.dto.UsuarioDTO;
import br.edu.unifor.model.Aluno;
import br.edu.unifor.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UsuarioDAO implements PanacheRepository<Usuario> {

    public List<Usuario> findAllAlunos() {

        PanacheQuery<Usuario> usuarios = findAll();

        return usuarios.list();
    }


    public Usuario findUsuarioById(Long id) {

        return findById(id);
    }

    @Transactional
    public void inserir(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario(usuarioDTO.getId(),
                usuarioDTO.getNome(),
                usuarioDTO.getCpf(),
                usuarioDTO.getFone(),
                true);

        persist(usuario);

    }

    @Transactional
    public Usuario atualizar(Long matricula, UsuarioDTO usuarioDTO) {

        Usuario usuario = findById(matricula);

        if (null != usuario) {

            usuario.setNome(usuarioDTO.getNome());
            usuario.setFone(usuarioDTO.getFone());
            persist(usuario);
        }
        return usuario;
    }


    @Transactional
    public void excluir(Long id) {

        Usuario usuario = findById(id);

        if (null != usuario) {
            delete(usuario);
        }
    }

}
