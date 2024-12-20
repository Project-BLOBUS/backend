package project.blobus.Backend.member.role.business.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.blobus.Backend.member.role.business.dto.BusinessDTO;
import project.blobus.Backend.member.role.business.entity.BusinessMember;
import project.blobus.Backend.member.role.business.repository.BusinessRepository;
import project.blobus.Backend.member.role.util.MemberMapper;

import java.time.LocalDate;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class BusinessService {
    private final BusinessRepository repository;
    private final PasswordEncoder passwordEncoder;

    // 기업계정 회원가입
    public Long register(BusinessDTO dto) {
        log.info("Business Register");

        BusinessMember member = MemberMapper.businessDtoToEntity(dto);
        member.setUserPw(passwordEncoder.encode(dto.getUserPw()));
        member.setJoinDate(LocalDate.now());
        repository.save(member);

        return member.getId();
    }

    // 기업계정 회원가입 - 중복 확인
    public boolean duplicate(String userId) {
        log.info("Business Duplicate");

        return repository.findByUserId(userId).isPresent();
    }
}
