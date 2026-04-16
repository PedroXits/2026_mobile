package br.com.senac.pi.taskManager.datasource.repositories;

import br.com.senac.pi.taskManager.domain.entities.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class TaskRepositoryCustomImpl implements TaskRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Task> findByTitleCriteria(String title) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> query = builder.createQuery(Task.class);
        Root<Task> root = query.from((Task.class));
        Predicate titulo = builder.equal(root.get("title"), title);

        query.select(root)
                .where(titulo);

        return this.entityManager.createQuery(query).getResultList();
    }


}
