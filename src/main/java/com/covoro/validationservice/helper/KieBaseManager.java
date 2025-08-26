package com.covoro.validationservice.helper;

import com.covoro.validationservice.constant.ValidationServiceError;
import com.covoro.validationservice.exception.ValidationServiceException;
import com.covoro.validationservice.logging.Logger;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.internal.utils.KieHelper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class KieBaseManager {

    private final Logger logger;
    private final Map<String, KieBase> kieBaseMap = new ConcurrentHashMap<>();
    private final ResourceLoader resourceLoader;

    public KieBaseManager(Logger logger, ResourceLoader resourceLoader) {
        this.logger = logger;
        this.resourceLoader = resourceLoader;
    }

    public KieBase get(String id){
        return this.kieBaseMap.computeIfAbsent(id, this::loadKieBase);
    }

    private KieBase loadKieBase(String id) {
        Resource resource = resourceLoader.getResource("classpath:Rule/" + id + ".drl");
        InputStream ruleInputStream = null;
        String drl = null;
        try {
            ruleInputStream = resource.getInputStream();
            drl = new String(ruleInputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.trace("IOException While Loading KieBase for Id: " + id, e);
            throw new ValidationServiceException(ValidationServiceError.VALIDATION_SERVICE_EXCEPTION, e.getMessage());

        }
        return new KieHelper().addContent(drl, ResourceType.DRL).build();
    }

}
