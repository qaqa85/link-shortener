package dev.program.linkshortener.link.api;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkEntity {
    @Id
    private String id;
    private String email;
    private String targetUrl;
    private LocalDate expirationDate;
    private int visits;

    public static LinkEntity fromDto(LinkDto linkDto) {
        return new LinkEntity(
                linkDto.getId(),
                linkDto.email,
                linkDto.getTargetUrl(),
                linkDto.getExpirationDate(),
                linkDto.getVisits());
    }

    public LinkDto toDto() {
        return LinkDto.builder()
                .id(id)
                .email(email)
                .targetUrl(targetUrl)
                .expirationDate(expirationDate)
                .visits(visits)
                .build();
    }
}
