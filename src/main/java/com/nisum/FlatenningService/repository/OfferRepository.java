package com.nisum.FlatenningService.repository;

import com.nisum.FlatenningService.model.OfferResponse;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "offerflatenning")
public interface OfferRepository extends IgniteRepository<OfferResponse, Integer> {
}
