package ru.hogwarts.school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.models.FacultyDTO;
import ru.hogwarts.school.models.Student;
import ru.hogwarts.school.models.StudentDTO;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.List;

@Service

public class HouseService {
    @Autowired
    private final FacultyRepository facultyRepository;

    public HouseService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty addHouse(Faculty newFaculty) {
        return facultyRepository.save(newFaculty);
    }

    public FacultyDTO getHouseByID(long id) {
        Faculty faculty = facultyRepository.findById(id).orElse(null);
        return FacultyDTO.fromFaculty(faculty);
    }

    public List<FacultyDTO> getAllHouses() {
        List<Faculty> houses = facultyRepository.findAll();
        List<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (Faculty f : houses) {
            FacultyDTO facultyDTO = FacultyDTO.fromFaculty(f);
            facultyDTOS.add(facultyDTO);
        }
        return facultyDTOS;
    }


    public Faculty updateHouse(Faculty updatedFaculty) {
        return facultyRepository.save(updatedFaculty);
    }

    public void deleteHouse(Faculty updatedFaculty) {
        facultyRepository.delete(updatedFaculty);
    }

    public List<Faculty> findByColor(String findColor) {
        return facultyRepository.findByColor(findColor);
    }

    public List<Faculty> findByName(String name) {
        return facultyRepository.findByNameIgnoreCase(name);
    }


}
