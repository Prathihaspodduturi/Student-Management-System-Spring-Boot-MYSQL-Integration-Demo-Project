package com.luv2code.curddemo.dao;

import com.luv2code.curddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Repository annotation supports component scanning and translated JDBC exceptions
@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;


    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // imolement save method
    @Override
    @Transactional
    // ovveriding the save method in StudentDAO
    public void save(Student theStudent) {
        entityManager.persist((theStudent));
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        // the first parameter has Student and lastName which is java's entity name not students table column name
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName = :theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return query results
        return theQuery.getResultList();
    }

    // updating the student details
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    // deleting the student from database
    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(theStudent);
    }


    // deleting all students from the database
    @Override
    @Transactional
    public int deleteAll() {

        int numberOfRowsDeleted = entityManager.createQuery("DELETE from Student").executeUpdate();

        return numberOfRowsDeleted;
    }
}
