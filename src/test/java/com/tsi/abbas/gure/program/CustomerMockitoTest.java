package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.ActorPackage.ActorRepository;
import com.tsi.abbas.gure.program.Controllers.ActorController;
import com.tsi.abbas.gure.program.Controllers.customerController;
import com.tsi.abbas.gure.program.CustomerPackage.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
public class CustomerMockitoTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApp;
    @MockBean
    private CustomerRepository customerRepository;

    @InjectMocks
    private customerController customerController;






}
