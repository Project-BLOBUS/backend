package project.blobus.Backend.youth.welfare;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class WelfareService {

    private final WelfareRepository welfareRepository;

    // 페이징된 정책 목록 가져오기
    public Page<WelfareDTO> getPagedPolicies(String keyword, String progress, String category, Pageable pageable) {
        LocalDate currentDate = LocalDate.now();
        if (keyword == null || keyword.trim().isEmpty()) {
            keyword = "";
        }
        if (category == null || category.trim().isEmpty()) {
            category = "유형전체";
        }
        if (progress == null || progress.trim().isEmpty()) {
            progress = "상태전체";
        }
        return welfareRepository.findByCategoryAndProgress(keyword, category, progress, currentDate, pageable)
                .map(WelfareDTO::new);

        //        return welfareRepositoryTest.findAll(pageable)
        //                .map(WelfareDTOTest::new); // Page<Entity> -> Page<DTO>로 변환
    }

    // 모든 정책 가져오기
    public List<WelfareDTO> getAllPolicies() {
        List<WelfareDTO> policies = welfareRepository.findAll()
                .stream()
                .map(WelfareDTO::new)
                .collect(Collectors.toList());
        System.out.println("Retrieved " + policies.size() + " policies");
        return policies;
    }

    // 특정 ID의 정책 가져오기
    public WelfareDTO getPolicyById(Integer id) {
        return welfareRepository.findById(id)
                .map(WelfareDTO::new)
                .orElseThrow(() -> new RuntimeException("Policy not found for ID: " + id));
    }

    // 특정 ID의 정책 게시글 수정(관리자)
    public void modify(WelfareDTO welfareDTO) {
        Optional<WelfareEntity> result = welfareRepository.findById(welfareDTO.getPolicyId());

        WelfareEntity welfareEntity = result.orElseThrow();

        welfareEntity.change(
                welfareDTO.getPolicyName(),
                welfareDTO.getPolicyOverview(),
                welfareDTO.getPolicyContent1(),
                welfareDTO.getSupportScale(),
                welfareDTO.getPolicyOperatePeriod(),
                welfareDTO.getPolicyDateType(),
                welfareDTO.getPolicyApplicationStartPeriod(),
                welfareDTO.getPolicyApplicationEndPeriod(),
                welfareDTO.getPolicyApplicationPeriod(),
                welfareDTO.getAgeRequirement(),
                welfareDTO.getProposerRequirement(),
                welfareDTO.getAcademicBackground(),
                welfareDTO.getMajorIn(),
                welfareDTO.getEmploymentStatus(),
                welfareDTO.getAdditionalRequirement(),
                welfareDTO.getParticipationRestriction(),
                welfareDTO.getApplicationProcedure(),
                welfareDTO.getJudgingPresentation(),
                welfareDTO.getApplicationSite(),
                welfareDTO.getSubmitionDocument(),
                welfareDTO.getHostOrganization(),
                welfareDTO.getHstOrgManagerName(),
                welfareDTO.getHstOrgManagerPhone(),
                welfareDTO.getOperatingAgency(),
                welfareDTO.getOperAgenManagerName(),
                welfareDTO.getOperAgenManagerPhone(),
                welfareDTO.getReferenceSite1(),
                welfareDTO.getReferenceSite2(),
                welfareDTO.getEtc()
        );

        welfareRepository.save(welfareEntity);
    }

    @Transactional
    public void remove(Integer id) {
        welfareRepository.updateToDelete(id, true);
    }

}
