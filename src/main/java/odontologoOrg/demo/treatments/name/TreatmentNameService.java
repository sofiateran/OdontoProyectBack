package odontologoOrg.demo.treatments.name;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import odontologoOrg.demo.treatments.piece.TreatmentPiece;
import odontologoOrg.demo.treatments.piece.TreatmentPieceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TreatmentNameService {
    private final TreatmentNameRepository repository;

    public void save(TreatmentName treatment) throws ResourceNotFoundException {
        repository.save(treatment);
    }

    public List<TreatmentName> findAll()  {
        return repository.findAll();
    }

    public void modify(TreatmentName treatment){
        repository.save(treatment);
    }

    public void delete(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El nombre del tratamiento con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Optional<TreatmentName> getById (int id){
        return repository.findById(id);
    }
}
