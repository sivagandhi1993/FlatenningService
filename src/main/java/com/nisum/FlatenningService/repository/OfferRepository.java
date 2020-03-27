package com.nisum.FlatenningService.repository;

import com.nisum.FlatenningService.model.OfferResponse;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;

import java.util.List;

@RepositoryConfig(cacheName = "customschema")
public interface OfferRepository extends IgniteRepository<OfferResponse, Integer> {

  /*  @Query("SELECT * FROM OFFERRESPONSE WHERE offerId = ?")
    List<OfferResponse> getById(long offerId);*/
}
