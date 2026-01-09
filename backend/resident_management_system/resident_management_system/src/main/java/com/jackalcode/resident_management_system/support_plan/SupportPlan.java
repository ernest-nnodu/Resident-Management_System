package com.jackalcode.resident_management_system.support_plan;

import com.jackalcode.resident_management_system.resident.Resident;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "support_plans")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SupportPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id", nullable = false)
    private Resident resident;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SupportPlanDomain domain;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SupportPlanStatus status;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(name = "start_date", nullable = false, updatable = false)
    private LocalDate startDate;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(nullable = false)
    private boolean archived = false;

    @PrePersist
    protected void onCreate() {
        this.createAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }
}
