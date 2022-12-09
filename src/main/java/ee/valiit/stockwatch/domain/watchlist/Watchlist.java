package ee.valiit.stockwatch.domain.watchlist;

import ee.valiit.stockwatch.domain.instrument.instrument.Instrument;
import ee.valiit.stockwatch.domain.user.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "watchlist")
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instrument_id", nullable = false)
    private Instrument instrument;

    @Column(name = "price_higher", precision = 6, scale = 2)
    private BigDecimal priceHigher;

    @Column(name = "price_lower", precision = 6, scale = 2)
    private BigDecimal priceLower;

    @Size(max = 255)
    @Column(name = "user_comment")
    private String userComment;

    @NotNull
    @Column(name = "price_at_addition", nullable = false, precision = 6, scale = 2)
    private BigDecimal priceAtAddition;

    @NotNull
    @Column(name = "addition_date", nullable = false)
    private LocalDate additionDate;
}
