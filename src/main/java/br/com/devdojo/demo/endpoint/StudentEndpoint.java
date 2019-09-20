package br.com.devdojo.demo.endpoint;


import br.com.devdojo.demo.error.ResourceNotFoundException;
import br.com.devdojo.demo.model.Student;
import br.com.devdojo.demo.repository.StudentyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentEndpoint {
    private final StudentyRepository studentDao;
    @Autowired
    public StudentEndpoint(StudentyRepository studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(studentDao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentsById(@PathVariable("id") Long id) {
        Optional<Student> student = studentDao.findById(id);
        verifyStudentsExists(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findStudentsByName(@PathVariable String name){
        return new ResponseEntity<>(studentDao.findByNameBefore(name),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
        studentDao.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyStudentsExists(id);
        studentDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        verifyStudentsExists(student.getId());
        studentDao.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    private void verifyStudentsExists(Long id){
        if (!studentDao.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Studant not found for ID:" + id);
        }

    }
}