package odontologoOrg.demo.treatments.piece;

import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import odontologoOrg.demo.treatments.Treatment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreatmentPieceService {
    private TreatmentPieceRepository repository;

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
