package io.github.oliviercailloux.y2018.opendata.dao;

import javax.inject.Inject;

import io.github.oliviercailloux.y2018.opendata.TestUtils;
import io.github.oliviercailloux.y2018.opendata.entity.Triple;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

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
    protected Triple doMakeEntity() {
        return new Triple("alice", "likes", "cats");
    }
}