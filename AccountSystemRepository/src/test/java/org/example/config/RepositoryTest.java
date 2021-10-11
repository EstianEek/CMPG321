package org.example.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.domain.dto.AccountTypeDto;
import org.example.domain.persistence.AccountType;
import org.example.config.RepositoryTestConfig;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class})
public class RepositoryTest {
    @Autowired
    YourRepository repository;
    @Before
    public void setUp() throws Exception {
// What happens before each test
    }
    @After
    public void tearDown() throws Exception {
// What happens after each test
    }
    @Test
    public void test() {
// Write a test here
    }
}