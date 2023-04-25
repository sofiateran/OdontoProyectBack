package odontologoOrg.demo.TreatmentPiece;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TreatmentPieceService {
    private final TreatmentPieceRepository repository;

    public void save(TreatmentPiece treatment) throws ResourceNotFoundException {
        repository.save(treatment);

    }

    public List<TreatmentPiece> findAll()  {
        return repository.findAll();
    }

    public void modify(TreatmentPiece treatment){
        repository.save(treatment);
    }

    public void delete(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("La pieza con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Optional<TreatmentPiece> getById (int id){
        return repository.findById(id);
    }
}
