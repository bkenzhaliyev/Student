package com.geek.dao;

import com.geek.models.Student;
import com.geek.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    @Override
    public Student findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Student.class, id);
    }

    @Override
    public void save(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = (List<Student>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Student").list();
        return students;
    }
}
