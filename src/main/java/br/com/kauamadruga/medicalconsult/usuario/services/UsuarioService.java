package br.com.kauamadruga.medicalconsult.usuario.services;

import br.com.kauamadruga.medicalconsult.usuario.repository.UsuarioRepository;
import br.com.kauamadruga.medicalconsult.usuario.domain.Usuario;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado pelo Id: ", id));
    }

    public Usuario atualizarUsuarioPorId(Usuario usuario, Long id) {
        if (usuarioRepository.existsById(id)) {
            usuario.setIdUsuario(id);
            return usuarioRepository.save(usuario);

        } else {
            throw new ObjectNotFoundException("Usuário nao encontrado pelo id ", id);
        }
    }

    public void  deletarUsuarioPorId(Long id){
        usuarioRepository.deleteById(id);
    }
}
