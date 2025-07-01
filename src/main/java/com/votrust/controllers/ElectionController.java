package com.votrust.controllers;

import com.votrust.dto.CandidateDTO;
import com.votrust.dto.ElectionDTO;
import com.votrust.response.ApiResponse;
import com.votrust.service.CandidateService;
import com.votrust.service.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/election")
public class ElectionController extends BaseController {

    private final ElectionService electionService;
    private final CandidateService candidateService;


    @PostMapping
    public ApiResponse createElection(@RequestBody ElectionDTO electionDTO) {
       return doSuccessResponse(electionService.createElection(electionDTO));
    }

    @PostMapping("/{electionId}/candidates")
    public ApiResponse addCandidate(@PathVariable Long electionId, @RequestBody CandidateDTO dto) {
        dto.setElectionId(electionId);
        return null; //candidateService.createCandidate(dto);
    }

    @GetMapping("/{electionId}/candidates")
    public List<CandidateDTO> getCandidates(@PathVariable Long electionId) {
        return null; //candidateService.getCandidatesByElection(electionId);
    }
}
