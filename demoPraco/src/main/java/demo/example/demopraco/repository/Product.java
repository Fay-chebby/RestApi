package demo.example.demopraco.repository;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "products", schema = "ecommerce", uniqueConstraints = {
        @UniqueConstraint(
                name = "sku_unique",
                columnNames = "sku"
        )
}

)

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_Sequence_name",
            allocationSize = 1
    )
    private Long id;
    @Column( name = "stock_keeping-unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;

    private String description;
    private BigDecimal price;
    private  boolean active;
    private  String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


}
