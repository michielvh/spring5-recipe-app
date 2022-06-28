package guru.springframework.repositories;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.UnitOfMeasure;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest    // brings up embedded database  &  configure spring data API
public class UnitOfMeasureRepositoryIT {

    //dependency injection -> Spring context will start up and we get an instance of the repo en injects
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() throws  Exception{

        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        //.get() gets the class UnitOfMeasure instead of the optional  ->  normally isPresent() -check
        assertEquals("Teaspoon", unitOfMeasureOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() throws  Exception{

        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");

        //.get() gets the class UnitOfMeasure instead of the optional  ->  normally isPresent() -check
        assertEquals("Cup", unitOfMeasureOptional.get().getDescription());
    }
}