package com.jackalcode.resident_management_system.care_interaction;

import com.jackalcode.resident_management_system.resident.Resident;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "care_interactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CareInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    //private Resident resident;

    @Column(name = "recorded_on")
    private LocalDate recordedOn;

    @Column(name = "recorded_at")
    private Instant recordedAt;

    @Enumerated(EnumType.STRING)
    private CareInteractionType type;

    @Lob
    private String description;
}
