package io.github.oliviercailloux.y2018.opendata.dao;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import io.github.oliviercailloux.y2018.opendata.entity.Triple;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link AbstractDao} for {@link Triple}
 *
 * @author barthelemy delemotte
 */
public class TripleDao extends AbstractDao<Triple> {
    
    /**
     * This constructor expects both managed entity manager.
     *
     * @param entityManager A managed entity manager
     */
    public TripleDao(final EntityManager entityManager) {
        super(entityManager, Triple.class, "Triple");
    }
    
    @Override
    public List<Triple> findAll() {
        return entityManager.createQuery("SELECT t FROM " + entityName + " t", entityClass).getResultList();
    }
    
    @Override
    public Optional<Triple> findOne(Long id) {
        Preconditions.checkNotNull(id, "cannot find an entity with a null id");
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }
    
    @Override
    public Triple persist(Triple entity) throws EntityAlreadyExistsDaoException {
        Preconditions.checkNotNull(entity, "entity is null");
        entityManager.persist(entity);
        return entity;
    }
    
    @Override
    public Triple merge(Triple entity) {
        Preconditions.checkNotNull(entity, "entity is null");
        return entityManager.merge(entity);
    }
    
    @Override
    public void remove(Long id) throws EntityDoesNotExistDaoException {
        Preconditions.checkNotNull(id, "cannot remove an entity with a null id");
    
        final Optional<Triple> entityOpt = findOne(id);
        if (!entityOpt.isPresent()) {
            final String errorMessage = "entity with id [" + id + "] does not exist";
            throw new EntityDoesNotExistDaoException(errorMessage);
        }
        entityManager.remove(entityOpt.get());
    }
    
    /**
     * Find all triple attached to a given subject
     * @param subject a subject literal value. <br/> Null subjects are converted to empty strings.
     * @return the list of Triple matching the given subject
     */
    public List<Triple> findBySubject(final String subject) {
        return entityManager
                .createQuery("SELECT t FROM  Triple t WHERE t.subject = :subject", entityClass)
                .setParameter("subject", Strings.nullToEmpty(subject))
                .getResultList();
    }
}
