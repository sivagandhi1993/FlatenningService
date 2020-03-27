package com.nisum.FlatenningService.config;

import com.nisum.FlatenningService.model.OfferResponse;
import com.nisum.FlatenningService.repository.OfferRepository;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteAtomicLong;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.DataRegionConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata20.repository.config.EnableIgniteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableIgniteRepositories(basePackageClasses = OfferRepository.class)
@ComponentScan(basePackages = "com.nisum.FlatenningService.repository")
public class IgniteConfig {


    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration config = new IgniteConfiguration();
        config.setSqlSchemas("customschema");
        CacheConfiguration cache = new CacheConfiguration("customschema");
        cache.setIndexedTypes(Integer.class, OfferResponse.class);
        config.setCacheConfiguration(cache);
        // Ignite persistence configuration.
        DataStorageConfiguration storageCfg = new DataStorageConfiguration();
        DataRegionConfiguration dataRegionConfiguration = new DataRegionConfiguration();
        dataRegionConfiguration.setPersistenceEnabled(Boolean.TRUE);
        // Enabling the persistence.
        storageCfg.setDefaultDataRegionConfiguration(dataRegionConfiguration);
        // Applying settings.
        config.setDataStorageConfiguration(storageCfg);
        // This will start own cluster( how to avoid this)
        Ignite ignite = Ignition.start(config);
        ignite.cluster().active(true);
        return ignite;
    }

    @Bean
    public IgniteAtomicLong personIdGenerator(@Autowired Ignite igniteInstance) {
        return igniteInstance.atomicLong("OFFER_ID_GEN", 0, true);
    }

}
