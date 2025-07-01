package com.votrust.service;

import com.votrust.dto.CandidateDTO;
import com.votrust.entity.Candidate;
import com.votrust.repositories.CandidateRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@Slf4j
public class CandidateService extends BasicService<Candidate, CandidateDTO>{

    public CandidateService(CandidateRepository candidateRepository) {
        super(Candidate.class, CandidateDTO.class, candidateRepository);
    }

}
