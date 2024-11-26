package project.blobus.Backend.mypage.custom.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.blobus.Backend.member.basic.dto.PageRequestDTO;
import project.blobus.Backend.member.basic.dto.PageResponseDTO;
import project.blobus.Backend.mypage.custom.dto.CustomDTO;
import project.blobus.Backend.mypage.doc.dto.DocumentdDTO;
import project.blobus.Backend.temp.entity.CommunityFreeBoard;
import project.blobus.Backend.temp.entity.CommunitySuggestBoard;
import project.blobus.Backend.temp.entity.YouthFinancialPolicy;
import project.blobus.Backend.temp.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class CustomeService {
    private final YouthEmploymentPolicyRepository youthEmploymentPolicyRepository;
    private final YouthJobPostingRepository youthJobPostingRepository;
    private final YouthHousingPolicyRepository youthHousingPolicyRepository;
    private final YouthFinancialPolicyRepository youthFinancialPolicyRepository;
    private final YouthEducationPolicyRepository youthEducationPolicyRepository;
    private final YouthStartupPolicyRepository youthStartupPolicyRepository;
    private final ResourceCultureRepository resourceCultureRepository;
    private final ResourceSupportRepository resourceSupportRepository;

//    public  PageResponseDTO<CustomDTO> getList(PageRequestDTO requestDTO,)
}
