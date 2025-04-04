package order.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateDTO {

    private Long orderNumber;

    private LocalDate date;

    private String status;

    private List<ProductCreateDTO> products = new ArrayList<>();
    
}
