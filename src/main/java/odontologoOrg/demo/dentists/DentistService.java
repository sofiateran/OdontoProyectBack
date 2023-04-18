package odontologoOrg.demo.dentists;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DentistService {
    private final DentistRepository repository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public void save(Dentist dentist) throws ResourceNotFoundException {
        dentist.setPassword(bCryptPasswordEncoder.encode(dentist.getPassword()));
        repository.save(dentist);

    }

    public List<Dentist> findAll()  {
        return repository.findAll();
    }

    public void modify(Dentist dentist){
        repository.save(dentist);
    }

    public void delete(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El odontologo con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Optional<Dentist> getById (int id){
        return repository.findById(id);
    }

    public void changePassword(ChangePasswordDTO changePasswordDTO) throws ResourceNotFoundException {
        Dentist dentist = repository.findById(changePasswordDTO.id()).orElseThrow(() -> new ResourceNotFoundException("El odontologo con id: " + changePasswordDTO.id() + " no existe en la base de datos"));

        // verifica que el dentista está autorizado para cambiar su contraseña
        // puedes implementar tu lógica de autenticación aquí
//        if (!isAuthorizedToChangePassword(dentist)) {
//            throw new UnauthorizedException("No está autorizado para cambiar la contraseña del odontólogo con id: " + id);
//        }// CUANDO IMPLEMENTE SECURITY HARE ESTA PARTE.

        // actualiza la contraseña del dentista y guarda los cambios
        dentist.setPassword(changePasswordDTO.newPassword());
        repository.save(dentist);
    }


}
