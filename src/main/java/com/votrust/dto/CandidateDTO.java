package com.votrust.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDTO extends BaseDTO {
    private String party;
    private String symbol;
    private Long electionId;
    private Long userId;
}

