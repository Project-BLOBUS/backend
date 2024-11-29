package project.blobus.Backend.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookmarkDTO {
    private Long id;
    private String title;
    private String content;
    private String address;
    private String mainCategory;
    private String subCategory;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime atTime;
}