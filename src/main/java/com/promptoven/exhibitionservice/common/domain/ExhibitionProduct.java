package com.promptoven.exhibitionservice.common.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExhibitionProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exhibition_product_id")
    private Long exhibitionProductId;

    @Comment("기획전 ID")
    @Column(name = "exhibition_id")
    private Long exhibitionId;

    @Comment("상품 ID")
    @Column(name = "product_id")
    private Long productId;

    @Builder
    public ExhibitionProduct(Long exhibitionId, Long productId) {
        this.exhibitionId = exhibitionId;
        this.productId = productId;
    }
}
