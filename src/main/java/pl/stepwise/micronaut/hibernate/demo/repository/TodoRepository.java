package pl.stepwise.micronaut.hibernate.demo.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import java.util.List;

import pl.stepwise.micronaut.hibernate.demo.model.Todo;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

@Singleton
public class TodoRepository {

    @Inject
    private SessionFactory sessionFactory;

    public void save(Todo todo) {
        sessionFactory.getCurrentSession().saveOrUpdate(todo);
    }

    public List<Todo> findAll() {
        final Query query = sessionFactory.getCurrentSession().createQuery("SELECT t FROM Todo t");
        return query.getResultList();
    }
}
