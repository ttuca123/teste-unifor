package br.edu.unifor.service;

import br.edu.unifor.dao.UsuarioDAO;
import br.edu.unifor.dto.UsuarioDTO;
import br.edu.unifor.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    /**
     * @param usuarioDAO     *
     */
    @Inject
    public UsuarioService(
            UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public List<UsuarioDTO> getUsuarios() {

        return usuarioDAO.findAllAlunos().stream().map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getNome(),
                usuario.getCpf(), usuario.getFone(), usuario.getAtivo())).collect(Collectors.toList());
    }


    public UsuarioDTO getUsuarioById(Long matricula) {

        Usuario usuario = usuarioDAO.findUsuarioById(matricula);

        return new UsuarioDTO(usuario.getId(), usuario.getNome(),
                usuario.getCpf(), usuario.getFone(), usuario.getAtivo());
    }




    public void inserirUsuario(UsuarioDTO usuarioDTO) {

        if (null == usuarioDTO.getId()) {

            usuarioDAO.inserir(usuarioDTO);
        }

    }

    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioDTO) {

        Usuario usuario;

        if (null != id) {

            usuario = usuarioDAO.atualizar(id, usuarioDTO);
            usuarioDTO = new UsuarioDTO(id, usuario.getNome(), usuario.getCpf(), usuario.getFone(), usuario.getAtivo());
        }

        return usuarioDTO;

    }

    public void excluirUsuario(Long id) {

        if (null != id) {

            usuarioDAO.excluir(id);
        }

    }

}
