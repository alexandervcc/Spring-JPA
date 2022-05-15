package acc.spring.jpa.jpapractice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acc.spring.jpa.jpapractice.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    //Query creation with Spring Dialect languaje
    public List<Student> findByName(String name);

    public List<Student> findByNameContaining(String name);

    public List<Student> findByGuardianName(String guardianname);
 
    public Student findByNameAndLastname(String name, String lastname);

    //For customed Query annotation, use the Class atribute name, not the table nor column name 
    @Query(value = "select s from Student s where s.email = ?1")
    List<Student> getStudentByEmailAddress(String email);
}
