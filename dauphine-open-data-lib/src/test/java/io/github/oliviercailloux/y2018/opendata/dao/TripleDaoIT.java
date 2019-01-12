package io.github.oliviercailloux.y2018.opendata.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import io.github.oliviercailloux.y2018.opendata.TestUtils;
import io.github.oliviercailloux.y2018.opendata.entity.Triple;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Arquillian.class)
public class TripleDaoIT extends AbstractDaoIT<Triple, TripleDao> {
    
    @Inject
    private TripleDao dao;
    
    @Deployment
    public static WebArchive makeWar() {
        return TestUtils.makeWar();
    }
    
    @Override
    protected void setUpDao() {
        setDao(dao);
    }
    
    @Override
    protected Triple changeEntity(final Triple originalEntity) {
        originalEntity.setPredicate("new predicate");
        originalEntity.setSubject("new subject");
        return originalEntity;
    }
    
    @Override
    protected Triple doMakeEntity(int index) {
        return new Triple("alice", "likes", "cats-" + index);
    }
    
    @Test
    @Override
    public void testPersistAlreadyExists() {
        // Disabling this test because in my opinion DAOs should not try no recreate EM basic operations such as persist.
        // For instance, this test requires a read-before-write to every insert operations, which is terrible in terms of performances.
        // Btw, why not let the JPA impl manage errors such as EntityExistsException, rather than creating custom Exception that do the same ?
    }
    
    @Test
    public void testFindBySubject() throws Exception {
    
        // create some triples for alice
        List<Triple> aliceList = Arrays.asList(
                new Triple("alice", "likes","dogs"),
                new Triple("alice", "eats","vegetables"),
                new Triple("alice", "drink","water")
        );
        
        // create another triple
        Triple otherTriple = new Triple("bob", "loves", "alice");
        
        try {
            // start transaction
            userTransaction.begin();
            
            // persist alice's triples
            for (Triple e : aliceList) {
                dao.persist(e);
            }
            
            // persist the other triple
            dao.persist(otherTriple);
            
            // flush sql statements to data-store before performing findBy
            dao.flush();
            
            // ensure findBySubject return all and only alice's triples
            List<Triple> actualList = dao.findBySubject("alice");
            assertEquals(new HashSet<>(aliceList), new HashSet<>(actualList));

        } finally {
            // finally clean-up the database
            userTransaction.rollback();
        }
    }
}