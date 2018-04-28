package com.sap.broker.dummy.impl;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.sap.broker.dummy.configuration.ApplicationConfiguration;
import com.sap.broker.dummy.domain.Catalog;
import com.sap.broker.dummy.domain.ServiceInstance;
import com.sap.broker.dummy.exception.NotFoundException;

@Component
public class ServiceBroker {

    private ApplicationConfiguration configuration;
    private Map<UUID, ServiceInstance> serviceInstances = new HashMap<>();

    @Inject
    public ServiceBroker(ApplicationConfiguration configuration) {
        this.configuration = configuration;
    }

    public Catalog getCatalog() {
        return configuration.getCatalog();
    }

    public Collection<ServiceInstance> getAll() {
        return serviceInstances.values();
    }

    public ServiceInstance get(UUID id) {
        return get(id, true);
    }

    public ServiceInstance get(UUID id, boolean required) {
        ServiceInstance serviceInstance = serviceInstances.get(id);
        if (serviceInstance == null && required) {
            throw new NotFoundException(MessageFormat.format("Service instance \"{0}\" not found!", id));
        }
        return serviceInstance;
    }

    public void create(ServiceInstance serviceInstance) {
        serviceInstances.put(serviceInstance.getId(), serviceInstance);
    }

}
