package com.stechlabs.Fraud;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckResponse isFraudulent( Integer customerId ){

        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId( customerId )
                        .createdAt( LocalDateTime.now() )
                        .isFraudster( false )
                        .build()
        );
        return new FraudCheckResponse( false );
    }
}
