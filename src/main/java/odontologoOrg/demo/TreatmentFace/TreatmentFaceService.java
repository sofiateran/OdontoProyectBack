package odontologoOrg.demo.TreatmentFace;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class TreatmentFaceService {
    private final TreatmentFaceRepository repository;

    public void save(TreatmentFace treatment) throws ResourceNotFoundException {
        repository.save(treatment);

    }

    public List<TreatmentFace> findAll()  {
        return repository.findAll();
    }

    public void modify(TreatmentFace treatment){
        repository.save(treatment);
    }

    public void delete(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("La cara del diente con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Optional<TreatmentFace> getById (int id){
        return repository.findById(id);
    }
}
