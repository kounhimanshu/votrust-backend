package com.votrust.service;

import com.votrust.dto.ElectionDTO;
import com.votrust.entity.Election;
import com.votrust.exceptions.CommonExceptions;
import com.votrust.repositories.ElectionRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Getter
@Setter
@Slf4j
public class ElectionService extends BasicService<Election, ElectionDTO> {

    private final ElectionRepository electionRepository;

    public ElectionService(ElectionRepository electionRepository) {
        super(Election.class, ElectionDTO.class, electionRepository);
        this.electionRepository = electionRepository;
    }

    public ElectionDTO createElection(ElectionDTO electionDTO) {
        Election electionUsingElectionCode = electionRepository.findElectionByElectionCode(electionDTO.getElectionCode());
        if(Objects.isNull(electionUsingElectionCode)) {
            throw new CommonExceptions.ResourceAlreadyExistException("Election already exists using this Election code " + electionDTO.getElectionCode());
        }
        ElectionDTO savedElection = saveOrUpdate(electionDTO);
        return savedElection;
    }

}
