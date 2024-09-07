package br.com.kauamadruga.medicalconsult.usuario.resources;

import br.com.kauamadruga.medicalconsult.usuario.domain.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.kauamadruga.medicalconsult.usuario.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RequestMapping(value = "/usuario")
@RestController
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok().body(usuario);
    }

    @PutMapping(value = "atualizar/{id}")
    public ResponseEntity<Usuario> atualizarUsuarioViaId(@RequestBody Usuario usuario, @PathVariable Long id) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuarioPorId(usuario, id);
        return ResponseEntity.ok().body(usuarioAtualizado);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deletarUsuarioPorId(@PathVariable Long id) {
        usuarioService.deletarUsuarioPorId(id);
        return ResponseEntity.noContent().build();
    }
}
